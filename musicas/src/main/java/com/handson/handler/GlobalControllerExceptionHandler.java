package com.handson.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.handson.commons.dto.ApplicationErrorDTO;
import com.handson.commons.dto.ResponseDTO;
import com.handson.commons.rest.ResponseBuilder;
import com.handson.commons.rest.ResponseObject;
import com.handson.commons.rest.ResponseObject.ResponseError;
import com.handson.exceptions.BusinessException;

@ControllerAdvice
@PropertySource("classpath:/error_messages.properties")
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

	private static final String REQUEST = "Request: ";
	
	@Autowired
    private Environment env;
	
	private static final Logger LOG = Logger.getLogger(GlobalControllerExceptionHandler.class);
	
	/**
	 * Retorno de erro quando é um problema de regra de négocio ou validação sendo
	 * um response de HttpStatus.BAD_REQUEST [400]
	 *
	 * @param exception
	 *            - BusinessException com o properties referente ao erro a mostrar
	 *            em tela
	 * @return
	 */
	@ExceptionHandler(BusinessException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseObject<Object> handleSystemException(BusinessException e, HttpServletRequest req) {
        ResponseError error = new ResponseError();
        error.setCode(e.getCode());
        error.setDescription(String.format(env.getProperty(e.getCode(), e.getMessage()), e.getParams()));
        return new ResponseBuilder<>().withError(error).build();
    }

	/**
	 * Create mensagem de resposta de error
	 *
	 * @param code
	 * @param mensagem
	 * @return
	 */
	private ResponseEntity<ResponseDTO> createResponseError(String code, String mensagem, HttpStatus http) {
		return new ResponseEntity<>(criaErrorDTO(code, mensagem), http);
	}

	/**
	 * Retorno de erro quando é um problema de regra de négocio sendo um response de
	 * HttpStatus.BAD_REQUEST [400]
	 *
	 * @param listError
	 *            - Lista de ErrorDTO que tiveram erros.
	 * @return
	 */
	private ResponseEntity<Object> createResponseErrorList(List<ApplicationErrorDTO> listError) {
		return new ResponseEntity<>(new ResponseDTO(listError), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Retorno de erro quando é erros desconhecidos, internos do servidor. Sendo um
	 * response de HttpStatus.INTERNAL_SERVER_ERROR [500]
	 *
	 * @param exception
	 *            - Exception com o properties referente ao erro a mostrar em tela
	 * @return
	 */
	private ResponseEntity<ResponseDTO> responseError(Exception exception) {
		return createResponseError(StringUtils.EMPTY, exception.getCause().toString(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Criação do objeto de Erro.
	 *
	 * @param code
	 *            - Código de erro
	 * @param message
	 *            - Mensagem de erro
	 * @return
	 */
	private ResponseDTO criaErrorDTO(String code, String message) {
		return new ResponseDTO(new ApplicationErrorDTO(code, message));
	}

	/**
	 * Obtendo informações do request
	 *
	 * @param req
	 * @return
	 */
	private String getRequest(WebRequest req) {
		return REQUEST + req.getDescription(false);
	}

	/**
	 * Retorno mensagem Exception handler Exception
	 *
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> messageExceptionHandler(Exception exception, WebRequest req) {
		LOG.error(getRequest(req), exception);
		return responseError(exception);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		BindingResult result = ex.getBindingResult();
		List<ApplicationErrorDTO> listError = new ArrayList<>();

		for (FieldError field : result.getFieldErrors()) {
			listError.add(new ApplicationErrorDTO(field.getCode(), field.getDefaultMessage(), field.getField(),
					field.getRejectedValue()));
		}

		LOG.error(getRequest(request), ex);
		return createResponseErrorList(listError);
	}
}
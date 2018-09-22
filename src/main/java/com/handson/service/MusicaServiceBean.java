package com.handson.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handson.model.Musica;
import com.handson.repository.MusicasRepository;

@Service
public class MusicaServiceBean implements MusicaService {
	
	private static final Logger LOG = Logger.getLogger(MusicaServiceBean.class);

	@Autowired
	private MusicasRepository musicaRepository;

	public List<Musica> listarMusicas(String filtro) {
		
		LOG.info("Iniciando busca de músicas");
		
		if(StringUtils.isBlank(filtro)) {
			LOG.info("Nenhum filtro foi informando, buscando todas as músicas...");
			return musicaRepository.findAll();
		}
		
		return musicaRepository.findAllByArtistName(filtro);
	}

}

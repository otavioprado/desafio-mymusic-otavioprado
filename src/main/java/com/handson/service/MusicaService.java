package com.handson.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.handson.model.Musica;

@Validated
public interface MusicaService {

    List<Musica> listarMusicas(@Valid @Size(min = 3, max = 200) String filtro);

}

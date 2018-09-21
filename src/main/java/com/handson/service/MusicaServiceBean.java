package com.handson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handson.model.Musicas;
import com.handson.repository.MusicasRepository;

@Service
public class MusicaServiceBean implements MusicaService {
	
	@Autowired
	private MusicasRepository musicaRepository;
    
    public List<Musicas> listarMusicas(String filtro){
    	return musicaRepository.findAll2();
    }

}

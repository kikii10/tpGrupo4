package com.unla.tpGrupo4.services.implementation;

import org.springframework.stereotype.Service;

import com.unla.tpGrupo4.repositories.IloteRepository;
@Service("loteService")
public class LoteService {
	private IloteRepository loteRepository;

	public  LoteService(IloteRepository loteRepository) {
		this.loteRepository = loteRepository;
	}
}

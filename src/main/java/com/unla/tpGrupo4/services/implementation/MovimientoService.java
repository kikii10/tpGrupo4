package com.unla.tpGrupo4.services.implementation;

import org.springframework.stereotype.Service;

import com.unla.tpGrupo4.repositories.IMovimientoRepository;

@Service("MovimientoService")
public class MovimientoService {
	private IMovimientoRepository movimientoRepository;

	public  MovimientoService(IMovimientoRepository movimientoRepository) {
		this.movimientoRepository = movimientoRepository;
	}
}

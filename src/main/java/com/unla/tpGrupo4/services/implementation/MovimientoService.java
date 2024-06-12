package com.unla.tpGrupo4.services.implementation;

import org.springframework.stereotype.Service;

import com.unla.tpGrupo4.entities.Stock;
import com.unla.tpGrupo4.repositories.IMovimientoRepository;
import com.unla.tpGrupo4.repositories.IStockRepository;

@Service("MovimientoService")
public class MovimientoService {
	private IMovimientoRepository movimientoRepository;
	 private IStockRepository stockRepository;

	public  MovimientoService(IMovimientoRepository movimientoRepository) {
		this.movimientoRepository = movimientoRepository;
	}
	

}

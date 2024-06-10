package com.unla.tpGrupo4.services.implementation;

import org.springframework.stereotype.Service;


import com.unla.tpGrupo4.repositories.IProductoRepository;

@Service("ProductoService")
public class ProductoService {
	private IProductoRepository productoRepository;

	public  ProductoService(IProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
}

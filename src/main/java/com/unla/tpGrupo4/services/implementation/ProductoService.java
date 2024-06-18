package com.unla.tpGrupo4.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.tpGrupo4.dtos.ProductoDTO;
import com.unla.tpGrupo4.entities.Producto;
import com.unla.tpGrupo4.repositories.IProductoRepository;

@Service("ProductoService")
public class ProductoService implements IProductoService {
	private IProductoRepository productoRepository;

	@Autowired
	public ProductoService(IProductoRepository productoRepository) {
		this.productoRepository = productoRepository;

	}

	private ModelMapper modelMapper = new ModelMapper();

	public List<Producto> verProductos() {
		return productoRepository.findAll();
	}
	
	public List<Producto> productosAReabastecer() {
		return productoRepository.productosAReabastecer();
	}
	
	public void crearProducto(Producto producto) {
		if((producto.getPrecio() > 0) && (producto.getStock() > 0) && (producto.getStock() > 0)) {
			producto.setActivo(true);
			productoRepository.save(producto);
		}
		

	}

	public boolean existeProductoCodigo(int codigo) {

		Optional<Producto> esta = productoRepository.findByCodigo(codigo);

		return esta.isPresent();
	}

	public void borrarProducto(int id) {

		Producto p = productoRepository.findById(id).orElse(null);
		
		p.setActivo(false);
		
		productoRepository.save(p);

	}

	public Producto buscarProducto(int id) {
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	public Producto insertOrUpdate(Producto p) {
		if((p.getPrecio() > 0) && (p.getStock() > 0) && (p.getStock() > 0)) {
			return productoRepository.save(p);
		}else {
			return null;
		}
	}

	@Override
	//devuelve una lista de productoDtos
	public List<ProductoDTO> getAll() {
		return productoRepository.findAll().stream().map(producto -> modelMapper.map(producto, ProductoDTO.class))
				.collect(Collectors.toList());
	}

}

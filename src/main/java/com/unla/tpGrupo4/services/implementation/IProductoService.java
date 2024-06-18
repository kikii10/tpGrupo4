package com.unla.tpGrupo4.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unla.tpGrupo4.dtos.ProductoDTO;
import com.unla.tpGrupo4.entities.Producto;

@Service
public interface IProductoService {

	public List<Producto> verProductos();
	public List<ProductoDTO> getAll();
	public void crearProducto(Producto producto);
	public void borrarProducto(int id);
	public Producto buscarProducto(int id);
	public void ModificarProducto(int id, Producto p);
	public boolean existeProductoCodigo(int codigo);
	public Producto insertOrUpdate(Producto p);
	public List<Producto> productosAReabastecer();
	 
}

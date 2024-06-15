package com.unla.tpGrupo4.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.unla.tpGrupo4.entities.Producto;
import com.unla.tpGrupo4.repositories.IProductoRepository;

@Service("ProductoService")
public class ProductoService implements IProductoService{
	private IProductoRepository productoRepository;
	
	 @Autowired
	    public ProductoService(IProductoRepository productoRepository) {
	        this.productoRepository = productoRepository;
	        
	    }
	public List<Producto> verProductos() {
        return productoRepository.findAll();
    }

    public void crearProducto(Producto producto) {
    	

        productoRepository.save(producto);
        
        
    }
    
    public boolean	existeProductoCodigo(int  codigo	) {
   
    		
    	Optional<Producto> esta = productoRepository.findByCodigo(codigo);
    	
    	return esta.isPresent();
    }		

    public void borrarProducto(int id) {
    	
        productoRepository.deleteById(id);
       
        
    }

    public Producto buscarProducto(int id) {
        return productoRepository.findById(id).orElse(null);
    }
    
    
    @Override
	public void ModificarProducto(int id, Producto p) { 
    	   Producto productoExistente = productoRepository.findById(id).orElse(null);

			    if (productoExistente != null) {
			    	productoExistente.setCodigo(p.getCodigo());
			    	productoExistente.setPrecio(p.getPrecio());
			    	productoExistente.setNombre(p.getNombre());

			    	productoRepository.save(productoExistente);
			    }
			
	}
    
    
    	
}
	
	


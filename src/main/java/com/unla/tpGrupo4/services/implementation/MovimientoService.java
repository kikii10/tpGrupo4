package com.unla.tpGrupo4.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.tpGrupo4.entities.Movimiento;
import com.unla.tpGrupo4.entities.Producto;
import com.unla.tpGrupo4.repositories.IMovimientoRepository;
import com.unla.tpGrupo4.repositories.IProductoRepository;

import jakarta.transaction.Transactional;

@Service("MovimientoService")
public class MovimientoService implements IMovimientoService {
	
	 @Autowired
	    private IMovimientoRepository movimientoRepository;
	 @Autowired
	 private IProductoService productoService;
	 @Autowired
	 private IProductoRepository productoRepository;
       
     	
	    public MovimientoService(IMovimientoRepository movimientoRepository) {
	        this.movimientoRepository = movimientoRepository;
	        
	    }
	    
       public List<Movimiento> verMovimientos() {
	        return movimientoRepository.findAll();
	    }
	   
       @Transactional
	    public void crearMovimiento(Movimiento m) {
    	   Producto producto = m.getProducto();
           if (producto != null) {
               Producto productoActualizado = productoService.buscarProducto(producto.getIdProducto());
               if (productoActualizado != null) {
                   productoActualizado.setStock(productoActualizado.getStock() + m.getCantidad());
                   productoService.ModificarProducto(productoActualizado.getIdProducto(), productoActualizado);
                   movimientoRepository.save(m);
               }
           }
       }
	    	
	    
	   
	    public void borrarMovimiento(int id) {
	        movimientoRepository.deleteById(id);
	    }

	  
	    public Movimiento buscarMovimiento(int id) {
	        
	        return movimientoRepository.findById(id).orElse(null);
	    }

	   
	    public void modificarMovimiento(int id, Movimiento movimiento) {
	        Movimiento movimientoExistente = movimientoRepository.findById(id).orElse(null);
	        if (movimientoExistente != null) {
	            movimientoExistente.setTipo(movimiento.getTipo());
	            movimientoExistente.setFecha(movimiento.getFecha());
	            movimientoRepository.save(movimientoExistente);
	        }
	    }
	    
	    public List<Movimiento> findMovimientos() {
	        return movimientoRepository.findMovimientos();
	    }
	}

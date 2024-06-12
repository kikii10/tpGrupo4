package com.unla.tpGrupo4.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.tpGrupo4.entities.Movimiento;
import com.unla.tpGrupo4.entities.Producto;
import com.unla.tpGrupo4.entities.Stock;
import com.unla.tpGrupo4.repositories.IMovimientoRepository;
import com.unla.tpGrupo4.repositories.IProductoRepository;
import com.unla.tpGrupo4.repositories.IStockRepository;

@Service("MovimientoService")
public class MovimientoService implements IMovimientoService {
	
	 @Autowired
	    private IMovimientoRepository movimientoRepository;
	 @Autowired
	 private IProductoService productoService;
       private IStockService stockService;
         @Autowired
	    public MovimientoService(IMovimientoRepository movimientoRepository, IStockService stockService) {
	        this.movimientoRepository = movimientoRepository;
	        this.stockService = stockService;
	    }
	    
       public List<Movimiento> verMovimientos() {
	        return movimientoRepository.findAll();
	    }

	   
	    public void crearMovimiento(Movimiento movimiento) {
	        if ("compra".equalsIgnoreCase(movimiento.getTipo())) {
	        	movimientoRepository.save(movimiento);
	            for (Producto producto : movimiento.getProductos()) {
	                producto.setMovimiento(movimiento);
	                productoService.crearProducto(producto);
	            }
	            
	            movimientoRepository.save(movimiento);
	        } else if ("venta".equalsIgnoreCase(movimiento.getTipo())) {
	        	movimientoRepository.save(movimiento);
	            for (Producto producto : movimiento.getProductos()) {
	                productoService.borrarProducto(producto.getIdProducto());
	            }
	            movimientoRepository.save(movimiento);
	        } else {
	            throw new IllegalArgumentException("Tipo de movimiento no válido: " + movimiento.getTipo());
	        }
	      stockService.agregarMovimiento(stockService.buscarStock(1), movimiento);
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
	}

package com.unla.tpGrupo4.services.implementation;

import java.time.LocalDate;
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
                   productoService.insertOrUpdate( productoActualizado);
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
	            movimientoExistente.setProveedor(movimiento.getProveedor());
	            movimientoExistente.setFecha(movimiento.getFecha());
	            movimientoRepository.save(movimientoExistente);
	        }
	    }
	    public Movimiento insertOrUpdate(Movimiento m) {
	    	return movimientoRepository.save(m);
	    }
	    public List<Movimiento> findMovimientos() {
	        return movimientoRepository.findMovimientos();
	    }
        public List<Movimiento> buscarMovimientosEntreFechas(LocalDate startDate, LocalDate endDate) {
	        
	    	return movimientoRepository.findAllByFechaBetween(startDate, endDate);
	    }
	    public List<Movimiento> buscarMovimientosPorProducto(int productId) {
	        return movimientoRepository.findAllByProductoId(productId);
	    }
	    public List<Movimiento> findMovimientosFinalizados(){
	    	return movimientoRepository.findMovimientosFinalizados();
	    };
	    public List<Movimiento> findMovimientosNoFinalizados(){
	    	return movimientoRepository.findMovimientosNoFinalizados();
	    };

		public Producto findProductoMasComprado() {

			Producto p = movimientoRepository.findProductoMasComprado().get(0);
			return p;
		};

	    public void finalizar(Movimiento m) {
	    	m.setFinalizado(true);
	    	insertOrUpdate(m);	
	    }
	    
	    public void reabastecer(Producto producto, int cantidad) {
	    	
	    	producto.setStock(producto.getStock()+cantidad);
                   Movimiento movimiento_reabastecer = new Movimiento("Central de reabastecimiento", producto, LocalDate.now(), cantidad, false, (double)producto.getPrecio()*cantidad);
                  productoService.insertOrUpdate(movimiento_reabastecer.getProducto());
                   movimientoRepository.save(movimiento_reabastecer);
	    }
	    
	}

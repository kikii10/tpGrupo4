package com.unla.tpGrupo4.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.unla.tpGrupo4.entities.Movimiento;
import com.unla.tpGrupo4.entities.Producto;
import com.unla.tpGrupo4.entities.Stock;
import com.unla.tpGrupo4.repositories.IStockRepository;

@Service
public class StockService {
	@Autowired
    private IStockRepository stockRepository;
	public void agregarProducto(Stock stock,Producto producto) {
        
		
		stock.getProductos().add(producto);
		stockRepository.save(stock);
    }

    public void agregarMovimiento(Stock stock,Movimiento movimiento) {
        stock.getMovimientos().add(movimiento);
        stockRepository.save(stock);
    }
    public void eliminarMovimiento(Stock stock,Movimiento movimiento) {
        stock.getMovimientos().remove(movimiento);
        stockRepository.save(stock);
    }
public void eliminarProducto(Stock stock,Producto producto) {
		stock.getProductos().remove(producto);
		stockRepository.save(stock);
    }


    
}

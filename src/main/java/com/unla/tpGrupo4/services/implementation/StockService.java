package com.unla.tpGrupo4.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.unla.tpGrupo4.entities.Movimiento;
import com.unla.tpGrupo4.entities.Producto;
import com.unla.tpGrupo4.entities.Stock;
import com.unla.tpGrupo4.repositories.IStockRepository;

import jakarta.transaction.Transactional;

@Service
public class StockService implements IStockService{

	@Autowired
    private IStockRepository stockRepository;

    public List<Stock> listarStocks() {
        return stockRepository.findAll();
    }

 
    @Transactional
    public Stock crearStock(Stock stock) {
        return stockRepository.save(stock);
    }


    @Transactional
    public void borrarStock(int id) {
        stockRepository.deleteById(id);
    }

  
    public Stock buscarStock(int id) {
    	
    return stockRepository.findById(id).orElse(null);
    }

    @Transactional
    public void modificarStock(int id, Stock stock) {
        Stock stockExistente = buscarStock(id);
        if (stockExistente != null) {
            stockExistente.setProductos(stock.getProductos());
            stockExistente.setMovimientos(stock.getMovimientos());
            stockRepository.save(stockExistente);
        }
        
    }

	public void agregarProducto(Stock stock,Producto producto) {
        
		
		stock.getProductos().add(producto);
		stockRepository.save(stock);
    }

    public void agregarMovimiento(Stock stock,Movimiento movimiento) {
        stock.getMovimientos().add(movimiento);
        stockRepository.save(stock);
    }
   /*public void eliminarMovimiento(Stock stock,Movimiento movimiento) {
        stock.getMovimientos().remove(movimiento);
        stockRepository.save(stock);
    }
public void eliminarProducto(Stock stock,Producto producto) {
		stock.getProductos().remove(producto);
		stockRepository.save(stock);
    }
*/

    
}

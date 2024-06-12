package com.unla.tpGrupo4.services.implementation;

import com.unla.tpGrupo4.entities.Movimiento;
import com.unla.tpGrupo4.entities.Producto;
import com.unla.tpGrupo4.entities.Stock;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IStockService {

    List<Stock> listarStocks();

    Stock crearStock(Stock stock);

    void borrarStock(int id);

    Stock buscarStock(int id);

    void modificarStock(int id, Stock stock);
    
public void agregarProducto(Stock stock,Producto producto);

    public void agregarMovimiento(Stock stock,Movimiento movimiento);
    
    
    /*public void eliminarMovimiento(Stock stock,Movimiento movimiento);
    public void eliminarProducto(Stock stock,Producto producto);
*/
}
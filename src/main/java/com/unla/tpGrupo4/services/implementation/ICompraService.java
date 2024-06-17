
package com.unla.tpGrupo4.services.implementation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.unla.tpGrupo4.entities.Compra;
import com.unla.tpGrupo4.entities.Movimiento;

@Service
public interface ICompraService {
	public List<Compra> verCompras();
    public void crearCompra(Compra compra, int id);
    public void borrarCompra(int id);
    public Compra buscarCompra(int id);
    public void modificarCompra(int id, Compra compra);
    public List<Compra> findCompras();
    public List<Compra> buscarComprasPorProducto(int productId);
    public List<Compra> buscarComprasEntreFechas(LocalDate fechaInicio,LocalDate fechaFin);
}
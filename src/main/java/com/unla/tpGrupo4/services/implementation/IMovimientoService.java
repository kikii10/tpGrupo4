package com.unla.tpGrupo4.services.implementation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.unla.tpGrupo4.entities.Movimiento;
import com.unla.tpGrupo4.entities.Producto;

@Service
public interface IMovimientoService {
	
	public List<Movimiento> verMovimientos();
    public void crearMovimiento(Movimiento movimiento);
    public void borrarMovimiento(int id);
    public Movimiento buscarMovimiento(int id);
    public void modificarMovimiento(int id, Movimiento movimiento);
    public List<Movimiento> findMovimientos();
    public Movimiento insertOrUpdate(Movimiento m);
    public void finalizar(Movimiento m);
    public List<Movimiento> buscarMovimientosPorProducto(int productId);
    public List<Movimiento> buscarMovimientosEntreFechas(LocalDate fechaInicio,LocalDate fechaFin);
    public List<Movimiento> findMovimientosFinalizados();
    public List<Movimiento> findMovimientosNoFinalizados();
<<<<<<< HEAD
    public void reabastecer(Producto producto, int cantidad);
=======
    public Producto findProductoMasComprado();
>>>>>>> b958850812200b166c7a73d8920c283eb5f70f1a
}

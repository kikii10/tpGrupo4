package com.unla.tpGrupo4.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unla.tpGrupo4.entities.Movimiento;

@Service
public interface IMovimientoService {
	
	public List<Movimiento> verMovimientos();
    public void crearMovimiento(Movimiento movimiento);
    public void borrarMovimiento(int id);
    public Movimiento buscarMovimiento(int id);
    public void modificarMovimiento(int id, Movimiento movimiento);



}

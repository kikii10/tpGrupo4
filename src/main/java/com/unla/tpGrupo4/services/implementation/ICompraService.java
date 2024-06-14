package com.unla.tpGrupo4.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unla.tpGrupo4.entities.Compra;

@Service
public interface ICompraService {
	public List<Compra> verCompra();
    public void crearCompra(Compra compra);
    public void borrarCompra(int id);
    public Compra buscarCompra(int id);
    public void modificarCompra(int id, Compra compra);
    public List<Compra> findCompra();
}

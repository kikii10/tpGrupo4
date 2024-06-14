package com.unla.tpGrupo4.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.tpGrupo4.entities.Compra;
import com.unla.tpGrupo4.entities.Producto;

@Repository("compraRepository")
public interface ICompraRepository extends JpaRepository<Compra, Serializable> {

	
}
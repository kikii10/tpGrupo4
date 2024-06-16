package com.unla.tpGrupo4.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.tpGrupo4.entities.Compra;
import com.unla.tpGrupo4.entities.Producto;

@Repository("compraRepository")
public interface ICompraRepository extends JpaRepository<Compra, Serializable> {

	@Query("SELECT c FROM Compra c JOIN FETCH c.producto JOIN FETCH c.user")
	public List<Compra> findCompras();
}
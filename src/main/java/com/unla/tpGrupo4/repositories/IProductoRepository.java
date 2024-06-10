package com.unla.tpGrupo4.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.tpGrupo4.entities.Producto;
import com.unla.tpGrupo4.entities.User;


@Repository("productoRepository")
public interface IProductoRepository extends JpaRepository<Producto, Serializable> {

	
}

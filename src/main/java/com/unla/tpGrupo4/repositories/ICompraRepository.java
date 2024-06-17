package com.unla.tpGrupo4.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.tpGrupo4.entities.Compra;
import com.unla.tpGrupo4.entities.Movimiento;
import com.unla.tpGrupo4.entities.Producto;

@Repository("compraRepository")
public interface ICompraRepository extends JpaRepository<Compra, Serializable> {

	@Query("SELECT c FROM Compra c JOIN FETCH c.producto JOIN FETCH c.user")
	public List<Compra> findCompras();
	
	@Query("SELECT c FROM Compra c WHERE c.fecha BETWEEN :fechaInicio AND :fechaFin")
    List<Compra> findAllByFechaBetween(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);

	
	 @Query("SELECT c FROM Compra c WHERE c.producto.idProducto = :productId")
	   List<Compra> findAllByProductoId(@Param("productId") int productId);
}
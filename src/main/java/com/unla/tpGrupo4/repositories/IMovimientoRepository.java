
package com.unla.tpGrupo4.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.tpGrupo4.entities.Movimiento;
import com.unla.tpGrupo4.entities.Producto;
import com.unla.tpGrupo4.entities.User;

@Repository("movimientoRepository")
public interface IMovimientoRepository extends JpaRepository<Movimiento, Serializable> {
	Movimiento findFirstByProducto_IdProducto(int idProducto);
	@Query("SELECT m FROM Movimiento m JOIN FETCH m.producto")
    public List<Movimiento> findMovimientos();


    @Query("SELECT m FROM Movimiento m WHERE m.fecha BETWEEN :fechaInicio AND :fechaFin")
    List<Movimiento> findAllByFechaBetween(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);


     @Query("SELECT m FROM Movimiento m WHERE m.producto.idProducto = :productId")
       List<Movimiento> findAllByProductoId(@Param("productId") int productId);


     @Query("SELECT m FROM Movimiento m JOIN FETCH m.producto WHERE m.finalizado = true")
        List<Movimiento> findMovimientosFinalizados();

        @Query("SELECT m FROM Movimiento m JOIN FETCH m.producto WHERE m.finalizado = false")
        List<Movimiento> findMovimientosNoFinalizados();

        @Query("SELECT m.producto " + "FROM Movimiento m " +"GROUP BY m.producto " + "ORDER BY SUM(m.cantidad) DESC")
            Producto findProductoMasComprado();

}
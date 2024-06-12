package com.unla.tpGrupo4.entities;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    
    @Column(name="nombre", nullable=false)
    private String nombre;
    
    @Column(name="codigo", nullable=false)
    private int codigo;

    @Column(name="precio", nullable=false)
    private double precio;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMovimiento")
    private Movimiento movimiento;

    public Producto(int codigo, String nombre, double precio,Movimiento movimiento) {
        super();
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
        this.movimiento = movimiento;
    }   
}
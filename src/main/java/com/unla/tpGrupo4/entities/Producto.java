package com.unla.tpGrupo4.entities;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter @Setter @NoArgsConstructor
public class Producto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	
	@Column(name="producto", nullable=false, length=60)
	private String producto;

	@Column(name="precio", nullable=false, length=60)
	private double precio;

	public Producto( String producto, double precio) {
		super();
		this.producto = producto;
		this.precio = precio;
	}
	
	
}

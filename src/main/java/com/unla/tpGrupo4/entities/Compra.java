package com.unla.tpGrupo4.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCompra;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iduser")
	private User user;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idproducto")
	private Producto producto;

	@Column(name = "fecha", nullable = false)
	private LocalDate fecha;

	@Column(name = "cantidad", nullable = false)
	private int cantidad;
	
	@Column(name = "precioFinal", nullable = false)
	private int precioFinal;

}
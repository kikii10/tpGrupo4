package com.unla.tpGrupo4.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter @Setter @NoArgsConstructor
public class Movimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMovimiento;
	
	@Column(name="tipo", unique=true, nullable=false, length=45)
	private String tipo;
	

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name = "idMovimiento")
	private Set<Producto> lotes = new HashSet<>();
	
    @Column(name = "fecha", nullable = false)
	    private LocalDate fecha;

}

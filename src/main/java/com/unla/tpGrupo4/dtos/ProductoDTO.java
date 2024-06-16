package com.unla.tpGrupo4.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ProductoDTO {
	
	private int idProducto;
	
	private String nombre;
	
	private double precio;
	
	private String linkImagen;
	
	private boolean activo;

	public ProductoDTO(int idProducto, String nombre, double precio, String linkImagen, boolean activo) {
		this.setIdProducto(idProducto);
		this.nombre = nombre;
		this.precio = precio;
		this.linkImagen = linkImagen;
		this.activo = activo;
	}
		
}

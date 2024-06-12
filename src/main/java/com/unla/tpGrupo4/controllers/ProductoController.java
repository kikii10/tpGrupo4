package com.unla.tpGrupo4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.tpGrupo4.entities.Producto;
import com.unla.tpGrupo4.services.implementation.IProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    
    @PostMapping("/guardar")
    public ResponseEntity<String> guardarProducto(@RequestBody Producto producto) {
        productoService.crearProducto(producto);
        return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
    }
}

package com.unla.tpGrupo4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.tpGrupo4.entities.Movimiento;
import com.unla.tpGrupo4.entities.Producto;
import com.unla.tpGrupo4.services.implementation.IMovimientoService;
import com.unla.tpGrupo4.services.implementation.IProductoService;
@Controller
@RequestMapping("/movimiento")

public class MovimientoController {
	@Autowired
    private IMovimientoService movimientoService;
@PostMapping("/guardar")
    public ResponseEntity<String> guardarMovimiento(@RequestBody Movimiento movimiento) {
       movimientoService.crearMovimiento(movimiento);
        return new ResponseEntity<>("movimiento creado exitosamente", HttpStatus.CREATED);
    }
}



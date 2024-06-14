package com.unla.tpGrupo4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.tpGrupo4.entities.Movimiento;
import com.unla.tpGrupo4.helpers.ViewRouteHelper;
import com.unla.tpGrupo4.services.implementation.IMovimientoService;
import com.unla.tpGrupo4.services.implementation.IProductoService;

@Controller

public class MovimientoController {
	@Autowired
	private IMovimientoService movimientoService;

	@PostMapping("/guardarM")
	public ResponseEntity<String> guardarMovimiento(@RequestBody Movimiento movimiento) {
		movimientoService.crearMovimiento(movimiento);
		return new ResponseEntity<>("movimiento creado exitosamente", HttpStatus.CREATED);
	}

	@GetMapping("/movimiento")
	public ModelAndView movimiento() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.MOVIMIENTO);

		List<Movimiento> lista = movimientoService.findMovimientos();
		modelAndView.addObject("movimientos", lista);

		return modelAndView;
	}
}

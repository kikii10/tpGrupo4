package com.unla.tpGrupo4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


import com.unla.tpGrupo4.entities.Producto;
import com.unla.tpGrupo4.helpers.ViewRouteHelper;
import com.unla.tpGrupo4.services.implementation.IProductoService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class Stock {

    @Autowired
    private IProductoService productoService;
    
    @GetMapping("/stock")
	public ModelAndView stock() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.STOCK);
		
		//tiene q recibir los productos para reabastecer
		List<Producto> lista = productoService.verProductos();
		modelAndView.addObject("productos", lista);
		
		return modelAndView;
	}
}
	
package com.unla.tpGrupo4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.unla.tpGrupo4.entities.Producto;
import com.unla.tpGrupo4.helpers.ViewRouteHelper;
import com.unla.tpGrupo4.services.implementation.IMovimientoService;
import com.unla.tpGrupo4.services.implementation.IProductoService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class Stock {

    @Autowired
    private IProductoService productoService;
    @Autowired
    private IMovimientoService movimientoService;
    
    @GetMapping("/stock")
	public ModelAndView stock() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.STOCK);
		
		//tiene q recibir los productos para reabastecer
		List<Producto> lista = productoService.productosAReabastecer();
		modelAndView.addObject("productos", lista);
		
		return modelAndView;
	}
    @PostMapping("/reabastecer-producto/{id}")
    public String mostrarFormularioModificarProducto(@PathVariable int id,@RequestParam("cantidad")int cantidad) {
        
        Producto producto = productoService.buscarProducto(id);
        movimientoService.reabastecer(producto, cantidad);
       
        return "redirect:/stock";
    }
    
}
	
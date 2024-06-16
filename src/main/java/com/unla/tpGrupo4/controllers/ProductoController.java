package com.unla.tpGrupo4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.unla.tpGrupo4.entities.Producto;
import com.unla.tpGrupo4.helpers.ViewRouteHelper;
import com.unla.tpGrupo4.services.implementation.IProductoService;

@Controller

public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @PostMapping("/guardarProducto")
    public ModelAndView guardarProducto(@ModelAttribute Producto producto) {
    		
        productoService.crearProducto(producto);
       
        return new ModelAndView("redirect:/producto"); // Redirige a la lista de productos después de guardar
    }
    @GetMapping("/formulario-modificar-producto/{id}")
    public ModelAndView mostrarFormularioModificarProducto(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.FORMULARIO_P_ACTUALIZAR);
        Producto producto = productoService.buscarProducto(id);
        modelAndView.addObject("producto", producto);
        return modelAndView;
    }
    @PostMapping("/modificarProducto")
    public ModelAndView modificarProducto(@ModelAttribute Producto producto) {
        productoService.ModificarProducto(producto.getIdProducto(), producto);
        return new ModelAndView("redirect:/producto");
    }
    
    @PostMapping("/borrarProducto/{id}")
    public ModelAndView borrarProducto(@PathVariable int id) {
        productoService.borrarProducto(id);
        return new ModelAndView("redirect:/producto");
    }	
    
    
    @GetMapping("/formulario-producto")
    public ModelAndView mostrarFormularioProducto() {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.FORMULARIO_P);
        
        modelAndView.addObject("producto", new Producto()); // Objeto vacío para binding con el formulario
        return modelAndView;
    }
    
    
    @GetMapping("/producto")
	public ModelAndView producto() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.PRODUCTO);
		
		List<Producto> lista = productoService.verProductos();
		modelAndView.addObject("productos", lista);
		
		return modelAndView;
	}
}
	
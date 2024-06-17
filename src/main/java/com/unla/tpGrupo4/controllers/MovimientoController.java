package com.unla.tpGrupo4.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unla.tpGrupo4.entities.Compra;
import com.unla.tpGrupo4.entities.Movimiento;
import com.unla.tpGrupo4.entities.Producto;
import com.unla.tpGrupo4.helpers.ViewRouteHelper;
import com.unla.tpGrupo4.services.implementation.ICompraService;
import com.unla.tpGrupo4.services.implementation.IMovimientoService;
import com.unla.tpGrupo4.services.implementation.IProductoService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")

public class MovimientoController {
	@Autowired
	private IMovimientoService movimientoService;
	@Autowired
	 private IProductoService productoService;
	@Autowired
	private ICompraService compraService;
	 @PostMapping("/guardarMovimiento")
	    public ModelAndView guardarMovimiento(@ModelAttribute Movimiento movimiento) {
		 
	    		
		 movimientoService.crearMovimiento(movimiento);
	       
	        return new ModelAndView("redirect:/movimiento"); // Redirige a la lista de productos después de guardar
	    }
	 @GetMapping("/formulario-movimiento")
	    public ModelAndView mostrarFormularioProducto() {
	        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.FORMULARIO_M);
	        List<Producto> productos = productoService.verProductos();
	        modelAndView.addObject("movimiento", new Movimiento()); // Objeto vacío para binding con el formulario
	        modelAndView.addObject("productos", productos);
	        return modelAndView;
	    }

	@GetMapping("/movimiento")
	public ModelAndView movimiento() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.MOVIMIENTO);

		List<Movimiento> listaFin= movimientoService.findMovimientosFinalizados();
		List<Movimiento> lista = movimientoService.findMovimientosNoFinalizados();
		
		
		modelAndView.addObject("movimientosFin", listaFin);
		modelAndView.addObject("movimientos", lista);
		


		return modelAndView;
	}
	
	
	@GetMapping("/finalizar_movimiento/{id}")
	 public ModelAndView finalizar_movimiento(@PathVariable int id) {
		 
		
		movimientoService.finalizar(movimientoService.buscarMovimiento(id));
	       
	        return new ModelAndView("redirect:/movimiento"); // Redirige a la lista de productos después de guardar
	    }
}
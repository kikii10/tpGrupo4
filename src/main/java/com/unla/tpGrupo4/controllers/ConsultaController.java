package com.unla.tpGrupo4.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unla.tpGrupo4.entities.Compra;
import com.unla.tpGrupo4.entities.Movimiento;
import com.unla.tpGrupo4.helpers.ViewRouteHelper;
import com.unla.tpGrupo4.services.implementation.ICompraService;
import com.unla.tpGrupo4.services.implementation.IMovimientoService;
import com.unla.tpGrupo4.services.implementation.IProductoService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class ConsultaController {

	@Autowired
	private IMovimientoService movimientoService;
	@Autowired
	 private IProductoService productoService;
	@Autowired
	private ICompraService compraService;
	
	
	@GetMapping("/movimientos")
    public ModelAndView getMovimientosEntreFechas(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.CONSULTAS);
        List<Movimiento> lista = movimientoService.buscarMovimientosEntreFechas(fechaInicio, fechaFin);
        List<Compra> lista2 = compraService.buscarComprasEntreFechas(fechaInicio, fechaFin);
        
       double balancePedidos = 0;
       for (Movimiento m : lista) {
    	   balancePedidos = balancePedidos + m.getPrecioCompra();
    	}
       double balanceCompra = 0;
       for (Compra c : lista2) {
    	   balanceCompra = balanceCompra + c.getPrecioFinal();
       	}
       
       Double balanceFinal = balanceCompra - balancePedidos;
        
        modelAndView.addObject("movimientos", lista);
        modelAndView.addObject("compras", lista2);
        modelAndView.addObject("balancePedidos", balancePedidos);
        modelAndView.addObject("balanceCompra", balanceCompra);
        modelAndView.addObject("balanceFinal", balanceFinal);

        return modelAndView;
    }

    @GetMapping("/movimientosPorProducto")
    public ModelAndView getMovimientosPorProducto(@RequestParam("productId") int productId) {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.CONSULTAS);
        List<Movimiento> lista = movimientoService.buscarMovimientosPorProducto(productId);
        List<Compra> lista2 = compraService.buscarComprasPorProducto(productId);
        
        double balancePedidos = 0;
        for (Movimiento m : lista) {
     	   balancePedidos = balancePedidos + m.getPrecioCompra();
     	}
        double balanceCompra = 0;
        for (Compra c : lista2) {
     	   balanceCompra = balanceCompra + c.getPrecioFinal();
        	}
        
        Double balanceFinal = balanceCompra - balancePedidos;
         
         modelAndView.addObject("movimientos", lista);
         modelAndView.addObject("compras", lista2);
         modelAndView.addObject("balancePedidos", balancePedidos);
         modelAndView.addObject("balanceCompra", balanceCompra);
         modelAndView.addObject("balanceFinal", balanceFinal);
         
       
        
       
        
        return modelAndView;
    }


    @GetMapping("/consultas")
    public String consultas(Model model) {
       
        return ViewRouteHelper.CONSULTAS;
    }
}

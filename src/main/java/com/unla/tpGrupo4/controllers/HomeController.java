package com.unla.tpGrupo4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.tpGrupo4.dtos.ProductoDTO;
import com.unla.tpGrupo4.entities.Producto;
import com.unla.tpGrupo4.entities.User;
import com.unla.tpGrupo4.helpers.ViewRouteHelper;
import com.unla.tpGrupo4.services.implementation.IProductoService;
import com.unla.tpGrupo4.services.implementation.UserService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
    private IProductoService productoService;
	
	@Autowired
	private UserService userService;

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.INDEX);
		
		List<ProductoDTO> lista = productoService.getAll();
		modelAndView.addObject("productos", lista);
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDetails userDetails = userService.loadUserByUsername(username);

		boolean isAdmin = userDetails.getAuthorities().stream()
				.anyMatch(role -> "ROLE_ADMIN".equals(role.getAuthority()));
		
		modelAndView.addObject("admin", isAdmin);
		
		return modelAndView;
	}

	@GetMapping("/hello/{name}")
	public ModelAndView helloParams2(@PathVariable("name") String name) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.HELLO);
		mV.addObject("name", name);
		return mV;
	}

	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView(ViewRouteHelper.ROUTE);
	}

}

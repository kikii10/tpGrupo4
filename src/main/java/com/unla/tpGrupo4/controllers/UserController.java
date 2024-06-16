package com.unla.tpGrupo4.controllers;

import java.util.Iterator;
import java.util.Set;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.tpGrupo4.entities.User;
import com.unla.tpGrupo4.entities.UserRole;
import com.unla.tpGrupo4.helpers.ViewRouteHelper;
import com.unla.tpGrupo4.services.implementation.UserService;


@Controller
public class UserController {
	private final UserService userService;
	 
	public UserController(UserService userService) {
	        this.userService = userService;
	    }

	@GetMapping("/login")
	public String login(Model model,
						@RequestParam(name="error",required=false) String error,
						@RequestParam(name="logout", required=false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return ViewRouteHelper.USER_LOGIN;
	}

	@GetMapping("/logout")
	public String logout(Model model) {
		return ViewRouteHelper.USER_LOGOUT;
	}

	@GetMapping("/loginsuccess")
	public RedirectView loginCheck() {
		
		 String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDetails userDetails = userService.loadUserByUsername(username);
	        
		boolean isAdmin = userDetails.getAuthorities().stream()
                .anyMatch(role -> "ROLE_ADMIN".equals(role.getAuthority()));
		if (isAdmin) {
			
			return new RedirectView(ViewRouteHelper.ADMIN);
		}else {
			return new RedirectView(ViewRouteHelper.ROUTE);
		}
		
		
	}
	
	
	@GetMapping("/admin")
	public String admin(Model model) {
		return ViewRouteHelper.USER_ADMIN;
	}


}

package com.example.tpGrupo4.RestController;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HolaMundoController {

    @GetMapping("/hola")
    public String holaMundo(Model model) {
        model.addAttribute("mensaje", "porfavor funciona");
        return "hola";
    }
}
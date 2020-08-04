package com.example.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariblesRutaController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("titulo", "Enviar parametros de la ruta");
        return "variables/index";
    }

    @GetMapping("/string/{texto}")
    public String variables(@PathVariable String texto, Model model) {
        model.addAttribute("titulo", "Recibir parametros (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado es :" + texto);
        return "variables/ver";
    }

    @GetMapping("/string/{texto}/{numero}")
    public String variables(@PathVariable String texto, @PathVariable int numero, Model model) {
        model.addAttribute("titulo", "Recibir parametros (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado es :" + texto + "y el numero es : " + numero);
        return "variables/ver";
    }
}

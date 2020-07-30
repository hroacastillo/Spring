package com.example.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/params")
public class EjemploParamsController {

    @RequestMapping(value = "/string")
    public String param(@RequestParam(required = false) String texto, Model model) {
        model.addAttribute("resultado", "El parametro enviado es " + texto);
        return "ver";
    }

    @RequestMapping(value = "/mix-params")
    public String param(@RequestParam(required = false) String texto, @RequestParam(required = false) int numero,  Model model) {
        model.addAttribute("resultado", "El parametro enviado es " + texto + "y el numero es " + numero);
        return "ver";
    }

    @RequestMapping(value = "/mix-params-request")
    public String param(HttpServletRequest request, Model model) {
        String texto = request.getParameter("texto");
        int numero = 0;

        try {
             numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        model.addAttribute("resultado", "El parametro enviado es " + texto + "y el numero es " + numero);
        return "ver";
    }

    @RequestMapping(value = "/")
    public String ruta() {
        return "ruta";
    }
}

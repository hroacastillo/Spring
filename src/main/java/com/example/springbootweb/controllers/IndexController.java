package com.example.springbootweb.controllers;

import com.example.springbootweb.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("titulo", "Hola SpringFramework prueba");

        return "index";
    }

    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public String perfil(Model model) {
        Usuario u = new Usuario();
        u.setNombre("Hector");
        u.setApellido("Roa");
        u.setEmail("hector@gmail.com");

        model.addAttribute("usuario", u);
        model.addAttribute("titulo", u.getNombre() + u.getApellido());

        return "perfil";
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Hector", "Roa", "hector@gmail.com"));
        usuarios.add(new Usuario("Gonzalo", "Roa", "gonzalo@gmail.com"));
        usuarios.add(new Usuario("Christian", "Roa", "christian@gmail.com"));
        usuarios.add(new Usuario("Diego", "Roa", "diego@gmail.com"));
        model.addAttribute("titulo", "Listado de usuarios");
        model.addAttribute("usuarios", usuarios);

        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Hector", "Roa", "hector@gmail.com"));
        usuarios.add(new Usuario("Gonzalo", "Roa", "gonzalo@gmail.com"));
        usuarios.add(new Usuario("Christian", "Roa", "christian@gmail.com"));
        usuarios.add(new Usuario("Diego", "Roa", "diego@gmail.com"));

        return usuarios;
    }

}

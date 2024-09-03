package com.proyecto.encuesta.infrastructure.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class incioControllers {

    @GetMapping("/home")
    public String home(Model model){
        return "index";
    }
    
    @GetMapping("/gestion")
    public String gestion(Model model){
        return "gestion";
    }

    @GetMapping("/test")
    public String test(Model model){
        return "test";
    }
    @GetMapping("/users")
    public String users(Model model){
        return "users";
    }

}
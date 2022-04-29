package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/")
    public String login(){
        return "index";
    }
    @RequestMapping("/inicio")
    public String Inicio() {
        return "login";
    }
    @RequestMapping("/registro")
    public String Registro() {
        return "registro";
    }
}

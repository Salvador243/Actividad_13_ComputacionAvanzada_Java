package com.example.demo.controllers;

import java.util.ArrayList;

import com.example.demo.models.UsuarioModel;
import com.example.demo.servicies.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    private UsuarioService servicio;

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

    @RequestMapping(value="/guardar", method = {RequestMethod.POST, RequestMethod.TRACE})
    public String guardado(@ModelAttribute("UsuarioModel") UsuarioModel usuario, 
        BindingResult resultado, ModelMap modelmap){
        
        if(resultado.hasErrors())
            return "registro";

        servicio.guardarUsuario(usuario);
        modelmap.addAttribute("nick", usuario.getId());

        return "login";
    }

    @RequestMapping(value="/inicio", method = {RequestMethod.POST, RequestMethod.TRACE})
    public String inicio(@ModelAttribute("UsuarioModel") UsuarioModel usuario, 
        BindingResult resultado, ModelMap modelmap){
        
        if(resultado.hasErrors())
            return "registro";
        String nombreusuario = usuario.getNombreusuario();
        String password = usuario.getPassword();

        ArrayList<UsuarioModel> listado = servicio.obtenerPorNick(nombreusuario);
        String pass = "";
        for (UsuarioModel usuarioModel : listado) pass = usuarioModel.getPassword();
        if(password.equals(pass))
            return "Calculo";

        return "registro";
    }

}

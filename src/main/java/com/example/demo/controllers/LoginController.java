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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UsuarioService servicio;

    @RequestMapping(value="/")
    public String login(HttpServletRequest request,
                        HttpSession session){
        if (!session.isNew()) {
            session.removeAttribute("error");
        }
        return "index";
    }
    @RequestMapping("/log")
    public String Inicio(HttpServletRequest request,
                         HttpSession session) {
        return "login";
    }

    @RequestMapping("/registro")
    public String Registro() {
        return "registro";
    }

    @RequestMapping("/calculo")
    public String Calculo() {
        return "Calculo";
    }

    @RequestMapping(value="/guardar", method = {RequestMethod.POST, RequestMethod.TRACE})
    public String guardado(@ModelAttribute("UsuarioModel") UsuarioModel usuario, 
                           BindingResult resultado,
                           ModelMap modelmap,
                           HttpServletRequest request,
                           HttpSession session){
        HttpSession sesion = request.getSession();
        if(resultado.hasErrors()) {
            session.setAttribute("error", 1);
            return "redirect:/registro";
        }
        ArrayList<UsuarioModel> isExiste = servicio.obtenerPorNick(usuario.getNombreusuario());
        if(!isExiste.isEmpty()){
            session.setAttribute("error", 1);
            return "redirect:/registro";
        }

        servicio.guardarUsuario(usuario);
        session.setAttribute("idUser", usuario.getId());
        return "redirect:/calculo";
    }

    @RequestMapping(value="/inicio", method = {RequestMethod.POST, RequestMethod.TRACE})
    public String inicio(@ModelAttribute("UsuarioModel") UsuarioModel usuario, 
                         BindingResult resultado,
                         ModelMap modelmap,
                         HttpServletRequest request,
                         HttpSession session){
        
        if(resultado.hasErrors()) {
            modelmap.addAttribute("error", 1);
            return "redirect:/login";
        }

        if (!session.isNew()) {
            session.invalidate();
        }
        HttpSession sesion = request.getSession();

        String nombreusuario = usuario.getNombreusuario();
        String password = usuario.getPassword();

        ArrayList<UsuarioModel> listado = servicio.obtenerPorNick(nombreusuario);
        String pass = "";

        for (UsuarioModel usuarioModel : listado) pass = usuarioModel.getPassword();
        if(password.equals(pass) && !password.equals("")) {
            modelmap.addAttribute("id", usuario.getId());
            sesion.setAttribute("id", usuario.getId());
            return "Calculo";
        }
        sesion.setAttribute("error", 1);
        return "redirect:/log";
    }

}

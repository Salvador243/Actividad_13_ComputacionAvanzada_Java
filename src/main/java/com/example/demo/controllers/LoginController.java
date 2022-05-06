package com.example.demo.controllers;

import java.util.ArrayList;

import com.example.demo.models.ImcModel;
import com.example.demo.models.UsuarioModel;
import com.example.demo.servicies.ImcService;
import com.example.demo.servicies.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UsuarioService servicio;

    @Autowired
    private ImcService servicioImc;

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
    public String Calculo(@ModelAttribute("ImcModel") ImcModel imcmodel, 
                BindingResult error,
                ModelMap modelmap,
                HttpServletRequest request,
                HttpSession session) {

        ArrayList<ImcModel> listaImc = servicioImc.obtenerPorIdusuario((Long) session.getAttribute("id"));
        session.setAttribute("listaImc", listaImc);
        return "Calculo";
    }

    @RequestMapping(value="/guardar", method = {RequestMethod.POST, RequestMethod.TRACE})
    public String guardado(@ModelAttribute("UsuarioModel") UsuarioModel usuario, 
                           BindingResult resultado,
                           ModelMap modelmap,
                           HttpServletRequest request,
                           HttpSession session){
        if(resultado.hasErrors()) {
            session.setAttribute("errorRegistto", 1);
            return "redirect:/registro";
        }
        ArrayList<UsuarioModel> isExiste = servicio.obtenerPorNick(usuario.getNombreusuario());
        if(!isExiste.isEmpty()){
            session.setAttribute("errorRegistto", 1);
            return "redirect:/registro";
        }

        servicio.guardarUsuario(usuario);
        session.removeAttribute("errorRegistto");
        session.setAttribute("id", usuario.getId());
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

        String nombreusuario = usuario.getNombreusuario();
        String password = usuario.getPassword();
        Long id_usuario = null;

        ArrayList<UsuarioModel> listado = servicio.obtenerPorNick(nombreusuario);
        String pass = "";

        for (UsuarioModel usuarioModel : listado) {
            pass = usuarioModel.getPassword();
            id_usuario = usuarioModel.getId();
        }
        if(password.equals(pass) && !password.equals("")) {
            session.setAttribute("id", id_usuario);
            return "redirect:/calculo";
        }
        session.setAttribute("error", 1);
        return "redirect:/log";
    }

    @RequestMapping("/calcularImc")
    public String doImc(@ModelAttribute("ImcModel") 
                ImcModel imcmodel, 
                BindingResult errores, 
                ModelMap modelmap, 
                HttpServletRequest request, 
                HttpSession session){
        if(errores.hasErrors()){
            session.setAttribute("errorCalculo", 1);
            return("redirect:/calculo");
        }
        imcmodel.setImc(imcmodel.getPeso(), imcmodel.getEstatura());
        servicioImc.guardarImc(imcmodel);
        session.removeAttribute("errorCalculo");
        return("redirect:/calculo");
    }

}

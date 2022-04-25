package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UsuarioModel;
import com.example.demo.servicies.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PutMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping( path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping("/nombre")
    public ArrayList<UsuarioModel> obtenerUsuarioPorNombre(@RequestParam("nombre") String nombre){
        return this.usuarioService.obtenerPorNombre(nombre);
    }

    @GetMapping("/apellido")
    public ArrayList<UsuarioModel> obtenerUsuarioPorApellido(@RequestParam("apellido") String apellidos){
        return this.usuarioService.obtenerPorApellido(apellidos);
    }

    @GetMapping("/imc")  
    public ArrayList<UsuarioModel> obtenerUsuarioPorImc(@RequestParam("imc") Float imc){
        return this.usuarioService.obtenerPorImc(imc);
    }

    @GetMapping("/edad")  
    public ArrayList<UsuarioModel> obtenerUsuarioPorEdad(@RequestParam("edad") Integer edad){
        return this.usuarioService.obtenerPorEdad(edad);
    }

    @GetMapping("/sexo")  
    public ArrayList<UsuarioModel> obtenerUsuarioPorSexo(@RequestParam("sexo") String sexo){
        return this.usuarioService.obtenerPorSexo(sexo);
    }

    @GetMapping("/estatura")  
    public ArrayList<UsuarioModel> obtenerUsuarioPorEstatura(@RequestParam("estatura") Float estatura){
        return this.usuarioService.obtenerPorEstatura(estatura);
    }

    @GetMapping("/peso")  
    public ArrayList<UsuarioModel> obtenerUsuarioPorPeso(@RequestParam("peso") Float peso){
        return this.usuarioService.obtenerPorPeso(peso);
    }

    @GetMapping("/fecha")  
    public ArrayList<UsuarioModel> obtenerUsuarioPorFecha(@RequestParam("fecha") Float imc){
        return this.usuarioService.obtenerPorImc(imc);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }
}

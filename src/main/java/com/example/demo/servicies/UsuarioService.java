package com.example.demo.servicies;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }


    public ArrayList<UsuarioModel> obtenerPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }


    public ArrayList<UsuarioModel>  obtenerPorEdad(Float edad) {
        return usuarioRepository.findByEdad(edad);
    }

    public ArrayList<UsuarioModel>  obtenerPorSexo(String sexo) {
        return usuarioRepository.findBySexo(sexo);
    }

    public ArrayList<UsuarioModel>  obtenerPorPassword(String password) {
        return usuarioRepository.findByPassword(password);
    }

    public ArrayList<UsuarioModel>  obtenerPorNick(String nombreusuario) {
        return usuarioRepository.findByNombreusuario(nombreusuario);
    }

    public boolean eliminarUsuario(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}
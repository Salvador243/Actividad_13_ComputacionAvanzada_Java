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

    public ArrayList<UsuarioModel> obtenerPorApellido(String apellido) {
        return usuarioRepository.findByApellido(apellido);
    }

    public ArrayList<UsuarioModel>  obtenerPorEdad(Integer edad) {
        return usuarioRepository.findByEdad(edad);
    }

    public ArrayList<UsuarioModel>  obtenerPorSexo(String sexo) {
        return usuarioRepository.findBySexo(sexo);
    }

    public ArrayList<UsuarioModel>  obtenerPorEstatura(Float estatura) {
        return usuarioRepository.findByEstatura(estatura);
    }

    public ArrayList<UsuarioModel>  obtenerPorPeso(Float peso) {
        return usuarioRepository.findByPeso(peso);
    }

    public ArrayList<UsuarioModel>  obtenerPorImc(Float imc) {
        return usuarioRepository.findByImc(imc);
    }

    public ArrayList<UsuarioModel>  obtenerPorFecha(String fecha) {
        return usuarioRepository.findByFecha(fecha);
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
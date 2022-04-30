package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.UsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{

    public abstract ArrayList<UsuarioModel> findByNombre(String nombre);
    public abstract ArrayList<UsuarioModel> findByEdad(Float edad);
    public abstract ArrayList<UsuarioModel> findBySexo(String sexo);
    public abstract ArrayList<UsuarioModel> findByPassword(String password);
    public abstract ArrayList<UsuarioModel> findByNombreusuario(String nombreusuario);
}

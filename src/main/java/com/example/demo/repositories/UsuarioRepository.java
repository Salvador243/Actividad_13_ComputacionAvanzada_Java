package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.UsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{

    public abstract ArrayList<UsuarioModel> findByNombre(String nombre);
    public abstract ArrayList<UsuarioModel> findByApellido(String apellido);
    public abstract ArrayList<UsuarioModel> findByEdad(Integer edad);
    public abstract ArrayList<UsuarioModel> findBySexo(String sexo);
    public abstract ArrayList<UsuarioModel> findByEstatura(Float estatura);
    public abstract ArrayList<UsuarioModel> findByPeso(Float peso);
    public abstract ArrayList<UsuarioModel> findByImc(Float imc);
    public abstract ArrayList<UsuarioModel> findByFecha(String fecha);
    
}

package com.example.demo.servicies;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ImcModel;
import com.example.demo.repositories.ImcRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImcService {
    @Autowired
    ImcRepository imcRepository;

    public ArrayList<ImcModel> obtenerUsuarios(){
        return (ArrayList<ImcModel>) imcRepository.findAll();
    }

    public ImcModel guardarImc(ImcModel usuario){
        return imcRepository.save(usuario);
    }

    public Optional<ImcModel> obtenerPorId(Long id){
        return imcRepository.findById(id);
    }

    public ArrayList<ImcModel> obtenerPorIdusuario(Long Idusuario) {
        return imcRepository.findByIdusuario(Idusuario);
    }
}

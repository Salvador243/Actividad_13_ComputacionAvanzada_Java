package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.ImcModel;

import org.springframework.data.repository.CrudRepository;

public interface ImcRepository extends CrudRepository<ImcModel, Long> {
    public abstract ArrayList<ImcModel> findByIdusuario(Long Idusuario);
}

package com.example.demo.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="imc")
public class ImcModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private Long idusuario;
    private Float peso;
    private Float estatura;
    @CreationTimestamp
    private Timestamp fecha;
    private Float imc;
    public Long getId() {
        return id;
    }
    public Float getImc() {
        return imc;
    }
    public void setImc(Float peso, Float estatura) {
        this.imc = (peso / (estatura * estatura));
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getIdusuario() {
        return idusuario;
    }
    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }
    public Float getPeso() {
        return peso;
    }
    public void setPeso(Float peso) {
        this.peso = peso;
    }
    public Float getEstatura() {
        return estatura;
    }
    public void setEstatura(Float estatura) {
        this.estatura = estatura;
    }
    public Timestamp getFecha() {
        return fecha;
    }
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
     
}

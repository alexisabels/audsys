package com.alexisabel.course.departamento;

import com.alexisabel.course.auditoria.Auditoria;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String responsable;
    @OneToMany(mappedBy = "departamento")
    @JsonIgnore
    private List<Auditoria> auditorias;

    public Departamento(Long id, String nombre, String responsable) {
        this.id = id;
        this.nombre = nombre;
        this.responsable = responsable;
    }

    public Departamento(String nombre, String responsable) {
        this.nombre = nombre;
        this.responsable = responsable;
    }

    public Departamento() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", responsable='" + responsable + '\'' +
                '}';
    }
}
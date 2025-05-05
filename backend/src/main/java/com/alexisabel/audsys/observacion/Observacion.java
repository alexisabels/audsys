package com.alexisabel.audsys.observacion;

import com.alexisabel.audsys.auditoria.Auditoria;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table
public class Observacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private Criticidad criticidad;
    @ManyToOne
    @JoinColumn(name = "auditoria_id")
    @JsonBackReference
    private Auditoria auditoria;


    public Observacion() {}

    public Observacion(String descripcion, Criticidad criticidad, Auditoria auditoria) {
        this.descripcion = descripcion;
        this.criticidad = criticidad;
        this.auditoria = auditoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Criticidad getCriticidad() {
        return criticidad;
    }

    public void setCriticidad(Criticidad criticidad) {
        this.criticidad = criticidad;
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    @Override
    public String toString() {
        return "Observacion{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", criticidad=" + criticidad +
                ", auditoriaId=" + (auditoria != null ? auditoria.getId() : "null") +
                '}';
    }
}

package com.alexisabel.audsys.planAccion;

import com.alexisabel.audsys.auditoria.Auditoria;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "plan_accion")
public class PlanAccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private EstadoPlan estado;

    @ManyToOne
    @JoinColumn(name = "auditoria_id")
    @JsonBackReference
    private Auditoria auditoria;

    public PlanAccion(){}

    public PlanAccion(String descripcion, EstadoPlan estado, Auditoria auditoria) {
        this.descripcion = descripcion;
        this.estado = estado;
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

    public EstadoPlan getEstado() {
        return estado;
    }

    public void setEstado(EstadoPlan estado) {
        this.estado = estado;
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }
}

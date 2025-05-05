package com.alexisabel.audsys.auditoria;

import com.alexisabel.audsys.departamento.Departamento;
import com.alexisabel.audsys.auditor.Auditor;
import com.alexisabel.audsys.observacion.Observacion;

import com.alexisabel.audsys.planAccion.PlanAccion;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private TipoAuditoria tipo;

    @ElementCollection(targetClass = CategoriaAuditoria.class)
    @Enumerated(EnumType.STRING)
    private Set<CategoriaAuditoria> categorias;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "auditor_id")
    private Auditor auditor;

    @OneToMany(mappedBy = "auditoria", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Observacion> observaciones;


    @OneToMany(mappedBy = "auditoria", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PlanAccion> planesAccion;



    public Auditoria(LocalDate fecha, TipoAuditoria tipo, Set<CategoriaAuditoria> categorias, Departamento departamento, Auditor auditor) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.categorias = categorias;
        this.departamento = departamento;
        this.auditor = auditor;
    }

    // hago un constructor con y sin observaciones, por si se crea de una forma u otra
    public Auditoria(LocalDate fecha, TipoAuditoria tipo, Set<CategoriaAuditoria> categorias, Departamento departamento, Auditor auditor, List<Observacion> observaciones) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.categorias = categorias;
        this.departamento = departamento;
        this.auditor = auditor;
        this.observaciones = observaciones;
    }

    public Auditoria() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public TipoAuditoria getTipo() {
        return tipo;
    }

    public void setTipo(TipoAuditoria tipo) {
        this.tipo = tipo;
    }

    public Set<CategoriaAuditoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<CategoriaAuditoria> categorias) {
        this.categorias = categorias;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Auditor getAuditor() {
        return auditor;
    }

    public void setAuditor(Auditor auditor) {
        this.auditor = auditor;
    }

    public List<Observacion> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<Observacion> observaciones) {
        this.observaciones = observaciones;
    }
}

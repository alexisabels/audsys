package com.alexisabel.course.auditoria;

import com.alexisabel.course.auditor.Auditor;
import com.alexisabel.course.departamento.Departamento;
import jakarta.persistence.*;

import java.time.LocalDate;
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

    public Auditoria(){}

    public Auditoria(LocalDate fecha, TipoAuditoria tipo, Set<CategoriaAuditoria> categorias, Departamento departamento, Auditor auditor) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.categorias = categorias;
        this.departamento = departamento;
        this.auditor = auditor;
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

    @Override
    public String toString() {
        return "Auditoria{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", tipo=" + tipo +
                ", categorias=" + categorias +
                ", departamento=" + departamento +
                ", auditor=" + auditor +
                '}';
    }
}

package com.alexisabel.course.auditoria;


import java.time.LocalDate;
import java.util.Set;

public class AuditoriaDTO {
    public AuditoriaDTO(LocalDate fecha, TipoAuditoria tipo, Set<CategoriaAuditoria> categorias, Long auditorId, Long departamentoId) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.categorias = categorias;
        this.auditorId = auditorId;
        this.departamentoId = departamentoId;
    }
    public AuditoriaDTO() {}

    private LocalDate fecha;

    private TipoAuditoria tipo;

    private Set<CategoriaAuditoria> categorias;

    private Long auditorId;

    private Long departamentoId;

    // Getters y Setters

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

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
    }

    public Long getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Long departamentoId) {
        this.departamentoId = departamentoId;
    }
}

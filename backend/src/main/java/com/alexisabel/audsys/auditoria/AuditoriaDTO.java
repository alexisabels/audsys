package com.alexisabel.audsys.auditoria;


import com.alexisabel.audsys.observacion.ObservacionDTO;
import com.alexisabel.audsys.planAccion.PlanAccionDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class AuditoriaDTO {
    public AuditoriaDTO(LocalDate fecha, TipoAuditoria tipo, Set<CategoriaAuditoria> categorias, Long auditorId, Long departamentoId, List<ObservacionDTO> observaciones, List<PlanAccionDTO> planesAccion) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.categorias = categorias;
        this.auditorId = auditorId;
        this.departamentoId = departamentoId;
        this.observaciones = observaciones;
        this.planesAccion = planesAccion;
    }

    public AuditoriaDTO() {
    }

    private LocalDate fecha;

    private TipoAuditoria tipo;

    private Set<CategoriaAuditoria> categorias;

    private Long auditorId;

    private Long departamentoId;
    private List<ObservacionDTO> observaciones;

    private List<PlanAccionDTO> planesAccion;

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

    public List<PlanAccionDTO> getPlanesAccion() {
        return planesAccion;
    }

    public void setPlanesAccion(List<PlanAccionDTO> planesAccion) {
        this.planesAccion = planesAccion;
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

    public List<ObservacionDTO> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<ObservacionDTO> observaciones) {
        this.observaciones = observaciones;
    }
}

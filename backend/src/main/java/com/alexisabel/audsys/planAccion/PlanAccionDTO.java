package com.alexisabel.audsys.planAccion;

public class PlanAccionDTO {
    private Long id;
    private String descripcion;
    private EstadoPlan estado;
    private Long auditoriaId;

    public PlanAccionDTO(Long id, String descripcion, EstadoPlan estado, Long auditoriaId) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.auditoriaId = auditoriaId;
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

    public Long getAuditoriaId() {
        return auditoriaId;
    }

    public void setAuditoriaId(Long auditoriaId) {
        this.auditoriaId = auditoriaId;
    }
}

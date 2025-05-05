package com.alexisabel.audsys.planAccion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PlanAccionDTO {
    private Long id;
        @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;
        @NotNull(message = "El estado es obligatorio")

    private EstadoPlan estado;
        @NotNull(message = "El ID de auditoría es obligatorio")

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

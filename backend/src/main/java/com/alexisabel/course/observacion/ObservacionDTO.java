package com.alexisabel.course.observacion;

public class ObservacionDTO {

    private Long id;
    private String descripcion;
    private Criticidad criticidad;
    private Long auditoriaId;

    public ObservacionDTO() {}

    public ObservacionDTO(Long id, String descripcion, Criticidad criticidad, Long auditoriaId) {
        this.id = id;
        this.descripcion = descripcion;
        this.criticidad = criticidad;
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

    public Criticidad getCriticidad() {
        return criticidad;
    }

    public void setCriticidad(Criticidad criticidad) {
        this.criticidad = criticidad;
    }

    public Long getAuditoriaId() {
        return auditoriaId;
    }

    public void setAuditoriaId(Long auditoriaId) {
        this.auditoriaId = auditoriaId;
    }
}

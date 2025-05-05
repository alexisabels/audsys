package com.alexisabel.audsys.departamento;

public class DepartamentoDTO {
    private String nombre;
    private String responsable;

    public DepartamentoDTO() {}

    public DepartamentoDTO(String nombre, String responsable) {
        this.nombre = nombre;
        this.responsable = responsable;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }
}

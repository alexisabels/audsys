package com.alexisabel.audsys.planAccion;

public enum EstadoPlan {
    PENDIENTE("Pendiente"),
    EN_CURSO("En curso"),
    COMPLETADO("Completado"),
    CANCELADO("Cancelado"),
    RECHAZADO("Rechazado"),
    APLAZADO("Aplazado"),
    EN_REVISION("En revisión"),
    APROBADO("Aprobado"),
    CERRADO("Cerrado");

    private final String descripcion;

    EstadoPlan(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

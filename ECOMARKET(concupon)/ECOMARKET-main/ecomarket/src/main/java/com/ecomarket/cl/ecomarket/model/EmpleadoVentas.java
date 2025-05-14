package com.ecomarket.cl.ecomarket.model;

import jakarta.persistence.Entity;

@Entity
public class EmpleadoVentas extends Usuario {

    private String turno;
    private int ventasRealizadas;

    public EmpleadoVentas() {}

    public EmpleadoVentas(String rut, String nombre, String correo, String direccion, String telefono, String turno, int ventasRealizadas) {
        super(rut, nombre, correo, direccion, telefono);
        this.turno = turno;
        this.ventasRealizadas = ventasRealizadas;
    }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }

    public int getVentasRealizadas() { return ventasRealizadas; }
    public void setVentasRealizadas(int ventasRealizadas) { this.ventasRealizadas = ventasRealizadas; }
}

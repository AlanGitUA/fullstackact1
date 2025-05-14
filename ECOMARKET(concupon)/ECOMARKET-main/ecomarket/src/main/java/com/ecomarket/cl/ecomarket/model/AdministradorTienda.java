package com.ecomarket.cl.ecomarket.model;

import jakarta.persistence.Entity;

@Entity
public class AdministradorTienda extends Usuario {

    private String tiendaAsignada;
    private boolean accesoTotal;

    public AdministradorTienda() {}

    public AdministradorTienda(String rut, String nombre, String correo, String direccion, String telefono, String tiendaAsignada, boolean accesoTotal) {
        super(rut, nombre, correo, direccion, telefono);
        this.tiendaAsignada = tiendaAsignada;
        this.accesoTotal = accesoTotal;
    }

    public String getTiendaAsignada() {
        return tiendaAsignada;
    }

    public void setTiendaAsignada(String tiendaAsignada) {
        this.tiendaAsignada = tiendaAsignada;
    }

    public boolean isAccesoTotal() {
        return accesoTotal;
    }

    public void setAccesoTotal(boolean accesoTotal) {
        this.accesoTotal = accesoTotal;
    }
}

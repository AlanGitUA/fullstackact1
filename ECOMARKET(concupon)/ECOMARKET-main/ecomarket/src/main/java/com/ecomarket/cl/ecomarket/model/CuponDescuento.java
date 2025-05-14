package com.ecomarket.cl.ecomarket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CuponDescuento {

    @Id
    private String codigo;
    private double descuento;
    private boolean utilizado;

    public CuponDescuento() {}

    public CuponDescuento(String codigo, double descuento) {
        this.codigo = codigo;
        this.descuento = descuento;
        this.utilizado = false;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public double getDescuento() { return descuento; }
    public void setDescuento(double descuento) { this.descuento = descuento; }

    public boolean isUtilizado() { return utilizado; }
    public void setUtilizado(boolean utilizado) { this.utilizado = utilizado; }
}

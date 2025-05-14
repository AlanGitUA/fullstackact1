package com.ecomarket.cl.ecomarket.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class CarritoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
        name = "carrito_producto",
        joinColumns = @JoinColumn(name = "carrito_id"),
        inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> productos;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private double totalCarro;  

    // Nuevo campo para almacenar el cupón
    private String cuponCodigo;

    public CarritoCompra() {}

    public CarritoCompra(Cliente cliente) {
        this.cliente = cliente;
        this.totalCarro = 0.0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
        calcularTotal(); 
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotalCarro() {
        return totalCarro;
    }

    public void setTotalCarro(double totalCarro) {
        this.totalCarro = totalCarro;
    }

    public String getCuponCodigo() {
        return cuponCodigo;
    }

    public void setCuponCodigo(String cuponCodigo) {
        this.cuponCodigo = cuponCodigo;
    }

    private void calcularTotal() {
        totalCarro = 0.0;
        for (Producto producto : productos) {
            totalCarro += producto.getPrecio();
        }
    }

    public void aplicarDescuento(double porcentajeDescuento) {
        double descuento = totalCarro * (porcentajeDescuento / 100);
        totalCarro -= descuento;
    }

    // Método para aplicar un cupón de descuento
    public boolean aplicarCupon(String cuponCodigo, double descuento) {
        if (this.cuponCodigo == null || this.cuponCodigo.isEmpty()) {
            this.cuponCodigo = cuponCodigo;
            aplicarDescuento(descuento);
            return true;
        }
        return false;  // Si ya tiene un cupón, no se puede aplicar otro
    }
}

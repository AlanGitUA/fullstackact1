package com.ecomarket.cl.ecomarket.model;

import jakarta.persistence.*;

@Entity
public class Cliente extends Usuario {

    private String direccionEnvio;
    private boolean cuponDescuentoAplicado;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private CarritoCompra carrito;

    public Cliente() {
        super();
        this.carrito = new CarritoCompra(this);
    }

    public Cliente(String rut, String nombre, String correo, String direccion, String telefono, 
                   String direccionEnvio, boolean carritoActivo, boolean cuponDescuentoAplicado) {
        super(rut, nombre, correo, direccion, telefono);
        this.direccionEnvio = direccionEnvio;
        this.cuponDescuentoAplicado = cuponDescuentoAplicado;
        this.carrito = new CarritoCompra(this);
        
    }

    

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    
    

    public boolean isCuponDescuentoAplicado() {
        return cuponDescuentoAplicado;
    }

    public void setCuponDescuentoAplicado(boolean cuponDescuentoAplicado) {
        this.cuponDescuentoAplicado = cuponDescuentoAplicado;
    }

    public CarritoCompra getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoCompra carrito) {
        this.carrito = carrito;
    }



    public void getDetallesCliente() {
        System.out.println("Detalles del Cliente: " + getNombre() + ", " + getCorreo() + ", " + getTelefono() + ", Dirección: " + getDireccion());
    }

    public void actualizarDireccion(String nuevaDireccion) {
        setDireccionEnvio(nuevaDireccion);
        System.out.println("Dirección de envío actualizada a: " + nuevaDireccion);
    }

    public void verCarrito() {
        System.out.println("Mostrando productos en el carrito...");
    }

    public void agregarAlCarrito(String producto) {
        System.out.println("Producto '" + producto + "' agregado al carrito.");
    }

    public void realizarPedido() {
        System.out.println("Pedido realizado exitosamente.");
        
    }

    public void verHistorialCompras() {
        System.out.println("Mostrando historial de compras...");
    }

    public void aplicarCuponDescuento(String cupon) {
        if (cuponDescuentoAplicado) {
            System.out.println("El cupón ya ha sido aplicado.");
        } else {
            setCuponDescuentoAplicado(true);
            System.out.println("Cupón de descuento aplicado: " + cupon);
        }
    }
}

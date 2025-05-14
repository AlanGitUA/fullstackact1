package com.ecomarket.cl.ecomarket.service;

import com.ecomarket.cl.ecomarket.model.Cliente;
import com.ecomarket.cl.ecomarket.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    
    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

   
    public Optional<Cliente> obtenerPorRut(String rut) {
        return clienteRepository.findById(rut);
    }

   
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

   
    public void eliminar(String rut) {
        clienteRepository.deleteById(rut);
    }

    
    public void getDetallesCliente(String rut) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(rut);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            System.out.println("Detalles del Cliente: " + cliente.getNombre() + ", " 
                + cliente.getCorreo() + ", " + cliente.getTelefono() 
                + ", Dirección: " + cliente.getDireccion());
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    
    public void actualizarDireccion(String rut, String nuevaDireccion) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(rut);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            cliente.setDireccionEnvio(nuevaDireccion);
            clienteRepository.save(cliente);
            System.out.println("Dirección de envío actualizada a: " + nuevaDireccion);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

   
    public void verCarrito(String rut) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(rut);
        if (clienteOptional.isPresent()) {
            System.out.println("Mostrando productos en el carrito...");
            
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    
    public void agregarAlCarrito(String rut, String producto) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(rut);
        if (clienteOptional.isPresent()) {
           
            System.out.println("Producto '" + producto + "' agregado al carrito.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

   
    public void realizarPedido(String rut) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(rut);
        if (clienteOptional.isPresent()) {
            System.out.println("Pedido realizado exitosamente.");
            
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    
    public void verHistorialCompras(String rut) {
        System.out.println("Mostrando historial de compras de cliente con rut: " + rut);
        
    }

    
    public void aplicarCuponDescuento(String rut, String cupon) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(rut);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            if (cliente.isCuponDescuentoAplicado()) {
                System.out.println("El cupón ya ha sido aplicado.");
            } else {
                cliente.setCuponDescuentoAplicado(true);
                clienteRepository.save(cliente);
                System.out.println("Cupón de descuento aplicado: " + cupon);
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
}


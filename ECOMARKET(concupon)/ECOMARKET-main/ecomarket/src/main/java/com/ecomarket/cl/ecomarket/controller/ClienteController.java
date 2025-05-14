package com.ecomarket.cl.ecomarket.controller;

import com.ecomarket.cl.ecomarket.model.Cliente;
import com.ecomarket.cl.ecomarket.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    
    @GetMapping
    public List<Cliente> listar() {
        return clienteService.obtenerTodos();
    }

    
    @GetMapping("/{rut}")
    public Optional<Cliente> obtener(@PathVariable String rut) {
        return clienteService.obtenerPorRut(rut);
    }

    
    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    
    @PutMapping("/{rut}")
    public Cliente actualizar(@PathVariable String rut, @RequestBody Cliente cliente) {
        cliente.setRut(rut); 
        return clienteService.guardar(cliente);
    }

    
    @DeleteMapping("/{rut}")
    public void eliminar(@PathVariable String rut) {
        clienteService.eliminar(rut);
    }

    
    @PutMapping("/{rut}/direccion")
    public void actualizarDireccion(@PathVariable String rut, @RequestParam String nuevaDireccion) {
        clienteService.actualizarDireccion(rut, nuevaDireccion);
    }

    
    @GetMapping("/{rut}/detalles")
    public void getDetallesCliente(@PathVariable String rut) {
        clienteService.getDetallesCliente(rut);
    }

    
    @GetMapping("/{rut}/carrito")
    public void verCarrito(@PathVariable String rut) {
        clienteService.verCarrito(rut);
    }

   
    @PostMapping("/{rut}/carrito")
    public void agregarAlCarrito(@PathVariable String rut, @RequestParam String producto) {
        clienteService.agregarAlCarrito(rut, producto);
    }

    
    @PostMapping("/{rut}/pedido")
    public void realizarPedido(@PathVariable String rut) {
        clienteService.realizarPedido(rut);
    }

   
    @GetMapping("/{rut}/historial")
    public void verHistorialCompras(@PathVariable String rut) {
        clienteService.verHistorialCompras(rut);
    }

    
    @PostMapping("/{rut}/cupon")
    public void aplicarCuponDescuento(@PathVariable String rut, @RequestParam String cupon) {
        clienteService.aplicarCuponDescuento(rut, cupon);
    }
}
//
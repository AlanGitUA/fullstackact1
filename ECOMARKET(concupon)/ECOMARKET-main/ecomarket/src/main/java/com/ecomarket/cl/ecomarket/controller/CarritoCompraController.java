package com.ecomarket.cl.ecomarket.controller;

import com.ecomarket.cl.ecomarket.model.CarritoCompra;
import com.ecomarket.cl.ecomarket.model.Producto;
import com.ecomarket.cl.ecomarket.service.CarritoCompraService;
import com.ecomarket.cl.ecomarket.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carritos")
public class CarritoCompraController {

    @Autowired
    private CarritoCompraService carritoCompraService;

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<CarritoCompra> listar() {
        return carritoCompraService.obtenerTodos();
    }

    
    @GetMapping("/{rut}")
    public Optional<CarritoCompra> obtener(@PathVariable String rut) {
        return carritoCompraService.obtenerPorId(rut);
    }

    @PostMapping
    public CarritoCompra crear(@RequestBody CarritoCompra carrito) {
        return carritoCompraService.guardar(carrito);
    }

    @PutMapping("/{rut}")
    public CarritoCompra actualizar(@PathVariable String rut, @RequestBody CarritoCompra carrito) {
        
        return carritoCompraService.guardar(carrito);
    }

    @DeleteMapping("/{rut}")
    public void eliminar(@PathVariable String rut) {
        carritoCompraService.eliminar(rut);
    }

   
    @PostMapping("/{clienteRut}/productos/{productoId}")
    public CarritoCompra agregarProducto(@PathVariable String clienteRut, @PathVariable Long productoId) {
        Optional<Producto> productoOpt = productoService.obtenerPorId(productoId);

        if (productoOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
        }

        return carritoCompraService.agregarProducto(clienteRut, productoId);
    }

    @PostMapping("/{rut}/cupon")
    public String aplicarCupon(@PathVariable String rut, @RequestParam String cuponCodigo) {
        boolean exito = carritoCompraService.aplicarCupon(rut, cuponCodigo);
        if (exito) {
            return "Cupón aplicado con éxito.";
        } else {
            return "El cupón es inválido o ya se ha aplicado.";
        }
    }

    
}

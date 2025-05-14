package com.ecomarket.cl.ecomarket.controller;

import com.ecomarket.cl.ecomarket.model.Producto;
import com.ecomarket.cl.ecomarket.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> listar() { return productoService.obtenerTodos(); }

    @GetMapping("/{id}")
    public Optional<Producto> obtener(@PathVariable Long id) { return productoService.obtenerPorId(id); }

    @PostMapping
    public Producto crear(@RequestBody Producto producto) { return productoService.guardar(producto); }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        producto.setId(id);
        return productoService.guardar(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { productoService.eliminar(id); }
}

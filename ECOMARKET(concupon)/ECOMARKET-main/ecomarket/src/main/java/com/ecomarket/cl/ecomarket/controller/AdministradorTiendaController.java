package com.ecomarket.cl.ecomarket.controller;

import com.ecomarket.cl.ecomarket.model.AdministradorTienda;
import com.ecomarket.cl.ecomarket.service.AdministradorTiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/administrador-tienda")
public class AdministradorTiendaController {

    @Autowired
    private AdministradorTiendaService administradorTiendaService;

    @GetMapping
    public List<AdministradorTienda> listar() {
        return administradorTiendaService.obtenerTodos();
    }

    @GetMapping("/{rut}")
    public Optional<AdministradorTienda> obtener(@PathVariable String rut) {
        return administradorTiendaService.obtenerPorRut(rut);
    }

    @PostMapping
    public AdministradorTienda crear(@RequestBody AdministradorTienda administradorTienda) {
        return administradorTiendaService.guardar(administradorTienda);
    }

    @PutMapping("/{rut}")
    public AdministradorTienda actualizar(@PathVariable String rut, @RequestBody AdministradorTienda administradorTienda) {
        administradorTienda.setRut(rut);
        return administradorTiendaService.guardar(administradorTienda);
    }

    @DeleteMapping("/{rut}")
    public void eliminar(@PathVariable String rut) {
        administradorTiendaService.eliminar(rut);
    }
}

package com.ecomarket.cl.ecomarket.controller;

import com.ecomarket.cl.ecomarket.model.CuponDescuento;
import com.ecomarket.cl.ecomarket.model.EmpleadoVentas;
import com.ecomarket.cl.ecomarket.service.EmpleadoVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empleado-ventas")
public class EmpleadoVentasController {

    @Autowired
    private EmpleadoVentasService empleadoVentasService;

    @GetMapping
    public List<EmpleadoVentas> listar() {
        return empleadoVentasService.obtenerTodos();
    }

    @GetMapping("/{rut}")
    public Optional<EmpleadoVentas> obtener(@PathVariable String rut) {
        return empleadoVentasService.obtenerPorRut(rut);
    }

    @PostMapping
    public EmpleadoVentas crear(@RequestBody EmpleadoVentas empleadoVentas) {
        return empleadoVentasService.guardar(empleadoVentas);
    }

    @PutMapping("/{rut}")
    public EmpleadoVentas actualizar(@PathVariable String rut, @RequestBody EmpleadoVentas empleadoVentas) {
        empleadoVentas.setRut(rut);
        return empleadoVentasService.guardar(empleadoVentas);
    }

    @DeleteMapping("/{rut}")
    public void eliminar(@PathVariable String rut) {
        empleadoVentasService.eliminar(rut);
    }

    //pa crear cupones
    @PostMapping("/{rut}/generar-cupon")
    public CuponDescuento generarCupon(@PathVariable String rut, @RequestParam String codigo, @RequestParam double descuento) {
        
        

        
        return empleadoVentasService.generarCupon(codigo, descuento);
    }
}

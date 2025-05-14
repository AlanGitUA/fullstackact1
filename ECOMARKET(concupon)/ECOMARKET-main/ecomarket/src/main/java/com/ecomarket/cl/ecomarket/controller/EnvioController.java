package com.ecomarket.cl.ecomarket.controller;

import com.ecomarket.cl.ecomarket.model.Envio;
import com.ecomarket.cl.ecomarket.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {
    @Autowired
    private EnvioService envioService;

    @GetMapping
    public List<Envio> listar() { return envioService.obtenerTodos(); }

    @GetMapping("/{id}")
    public Optional<Envio> obtener(@PathVariable Long id) { return envioService.obtenerPorId(id); }

    @PostMapping
    public Envio crear(@RequestBody Envio envio) { return envioService.guardar(envio); }

    @PutMapping("/{id}")
    public Envio actualizar(@PathVariable Long id, @RequestBody Envio envio) {
        envio.setId(id);
        return envioService.guardar(envio);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { envioService.eliminar(id); }
}

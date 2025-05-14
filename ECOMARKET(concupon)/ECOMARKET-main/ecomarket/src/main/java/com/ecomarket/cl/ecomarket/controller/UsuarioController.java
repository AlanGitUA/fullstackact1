package com.ecomarket.cl.ecomarket.controller;

import com.ecomarket.cl.ecomarket.model.Usuario;
import com.ecomarket.cl.ecomarket.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listar() { return usuarioService.obtenerTodos(); }

    @GetMapping("/{rut}")
    public Optional<Usuario> obtener(@PathVariable String rut) {
        return usuarioService.obtenerPorRut(rut);
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) { return usuarioService.guardar(usuario); }

    @PutMapping("/{rut}")
public Usuario actualizar(@PathVariable String rut, @RequestBody Usuario usuario) {
    usuario.setRut(rut); // le asignamos el RUT que viene en la URL
    return usuarioService.guardar(usuario);
}



    @DeleteMapping("/{rut}")
    public void eliminar(@PathVariable String rut) {
        usuarioService.eliminar(rut);
    }
}

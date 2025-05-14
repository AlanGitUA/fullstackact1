package com.ecomarket.cl.ecomarket.service;

import com.ecomarket.cl.ecomarket.model.Usuario;
import com.ecomarket.cl.ecomarket.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodos() { return usuarioRepository.findAll(); }
    public Optional<Usuario> obtenerPorRut(String rut) { return usuarioRepository.findById(rut);}
    public Usuario guardar(Usuario usuario) { return usuarioRepository.save(usuario); }
    public void eliminar(String rut) { usuarioRepository.deleteById(rut);}
}

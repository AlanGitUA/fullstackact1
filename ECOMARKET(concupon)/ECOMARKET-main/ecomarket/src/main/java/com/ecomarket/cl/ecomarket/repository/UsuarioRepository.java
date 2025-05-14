package com.ecomarket.cl.ecomarket.repository;

import com.ecomarket.cl.ecomarket.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}

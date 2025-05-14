package com.ecomarket.cl.ecomarket.repository;

import com.ecomarket.cl.ecomarket.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
    Optional<Cliente> findByRut(String rut);  
}

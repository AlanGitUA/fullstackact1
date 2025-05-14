package com.ecomarket.cl.ecomarket.service;

import com.ecomarket.cl.ecomarket.model.AdministradorTienda;
import com.ecomarket.cl.ecomarket.repository.AdministradorTiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdministradorTiendaService {

    @Autowired
    private AdministradorTiendaRepository administradorTiendaRepository;

    public List<AdministradorTienda> obtenerTodos() {
        return administradorTiendaRepository.findAll();
    }

    public Optional<AdministradorTienda> obtenerPorRut(String rut) {
        return administradorTiendaRepository.findById(rut);
    }

    public AdministradorTienda guardar(AdministradorTienda administradorTienda) {
        return administradorTiendaRepository.save(administradorTienda);
    }

    public void eliminar(String rut) {
        administradorTiendaRepository.deleteById(rut);
    }
}

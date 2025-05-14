package com.ecomarket.cl.ecomarket.service;

import com.ecomarket.cl.ecomarket.model.Envio;
import com.ecomarket.cl.ecomarket.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    public List<Envio> obtenerTodos() {
        return envioRepository.findAll();
    }

    public Optional<Envio> obtenerPorId(Long id) {
        return envioRepository.findById(id);
    }

    public Envio guardar(Envio envio) {
        return envioRepository.save(envio);
    }

    public void eliminar(Long id) {
        envioRepository.deleteById(id);
    }
}


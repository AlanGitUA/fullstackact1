package com.ecomarket.cl.ecomarket.service;

import com.ecomarket.cl.ecomarket.model.CuponDescuento;
import com.ecomarket.cl.ecomarket.repository.CuponDescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuponDescuentoService {

    @Autowired
    private CuponDescuentoRepository cuponDescuentoRepository;

    
    public Optional<CuponDescuento> obtenerPorCodigo(String codigo) {
        return cuponDescuentoRepository.findById(codigo);
    }

    public CuponDescuento guardar(CuponDescuento cupon) {
        return cuponDescuentoRepository.save(cupon);
    }

   
    public void eliminar(String codigo) {
        cuponDescuentoRepository.deleteById(codigo);
    }
}

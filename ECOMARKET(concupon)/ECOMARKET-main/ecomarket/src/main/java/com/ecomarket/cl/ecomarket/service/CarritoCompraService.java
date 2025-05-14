package com.ecomarket.cl.ecomarket.service;

import com.ecomarket.cl.ecomarket.model.CarritoCompra;
import com.ecomarket.cl.ecomarket.model.Cliente;
import com.ecomarket.cl.ecomarket.model.Producto;  
import com.ecomarket.cl.ecomarket.repository.CarritoCompraRepository;
import com.ecomarket.cl.ecomarket.repository.ClienteRepository;
import com.ecomarket.cl.ecomarket.repository.ProductoRepository;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarritoCompraService {

    @Autowired
    private CarritoCompraRepository carritoCompraRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;  

    @Autowired
    private CuponDescuentoRepository cuponDescuentoRepository;

    public List<CarritoCompra> obtenerTodos() {
        return carritoCompraRepository.findAll();
    }

    
    public Optional<CarritoCompra> obtenerPorId(String rut) {
        return carritoCompraRepository.findByClienteRut(rut);
    }

    
    public CarritoCompra guardar(CarritoCompra carrito) {
        return carritoCompraRepository.save(carrito);
    }

   
    public void eliminar(String rut) {
        carritoCompraRepository.deleteByClienteRut(rut);
    }

    
    public CarritoCompra agregarProducto(String clienteRut, Long productoId) {
        Optional<Cliente> clienteOpt = clienteRepository.findByRut(clienteRut);
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            CarritoCompra carrito = cliente.getCarrito();

          
            if (carrito == null) {
                carrito = new CarritoCompra(cliente); 
                cliente.setCarrito(carrito); 
            }

            Optional<Producto> productoOpt = productoRepository.findById(productoId); 
            if (productoOpt.isPresent()) {
                Producto producto = productoOpt.get();

               
                if (producto.getStock() > 0) {
                    
                    producto.setStock(producto.getStock() - 1);

                    
                    carrito.getProductos().add(producto);

                    
                    carritoCompraRepository.save(carrito);

                    
                    productoRepository.save(producto);

                    return carrito;
                } else {
                    System.out.println("No hay stock disponible para el producto: " + producto.getNombre());
                    return null;
                }
            } else {
                System.out.println("Producto no encontrado.");
                return null;
            }
        }
        return null;  
    }

    public boolean aplicarCupon(String rut, String cuponCodigo) {
        Optional<CarritoCompra> carritoOpt = obtenerPorCliente(rut);
        if (carritoOpt.isPresent()) {
            CarritoCompra carrito = carritoOpt.get();

           
            Optional<CuponDescuento> cuponOpt = cuponDescuentoRepository.findByCodigo(cuponCodigo);
            if (cuponOpt.isPresent()) {
                CuponDescuento cupon = cuponOpt.get();
                double descuento = cupon.getDescuento();

               
                return carrito.aplicarCupon(cuponCodigo, descuento);
            }
        }
        return false; 
    }
}

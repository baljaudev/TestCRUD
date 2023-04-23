package com.company.PruebaCRUD.service;

import com.company.PruebaCRUD.model.Producto;
import com.company.PruebaCRUD.repository.ProductoRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServiceImplementacion implements ProductoService {

    // Inyección de dependencias de ProductoRepository para poder utilizar sus métodos
    private final ProductoRepository productoRepository;
    @Override
    public void saveProducto(Producto producto) {
        if (producto.getNombre() != null && producto.getPrecio() != null && producto.getDescripcion() != null) {
            productoRepository.save(producto);
        }
    }

    @Override
    public List<Producto> findAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findProductoById(Long id) {
        if (productoRepository.findById(id).isPresent()) {
            return productoRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public Producto updateProductoById(Long id, Producto producto) {
        Producto productoEncontrado = productoRepository.findById(producto.getId()).orElse(null);
        if (productoEncontrado != null) {
            productoEncontrado.setPrecio(producto.getPrecio());
            productoEncontrado.setDescripcion(producto.getDescripcion());
            productoRepository.save(productoEncontrado);
            return productoEncontrado;
        } else {
            return null;
        }
    }

    @Override
    public Producto deleteProductoById(Long id) {
        Producto productoEncontrado = productoRepository.findById(id).orElse(null);
        if (productoEncontrado != null) {
            productoRepository.delete(productoEncontrado);
            return productoEncontrado;
        } else {
            return null;
        }
    }

    @Override
    public List<Producto> deleteAllProductos() {
        productoRepository.deleteAll();
        return productoRepository.findAll();
    }

}

package com.company.PruebaCRUD.service;

import com.company.PruebaCRUD.model.Producto;

import java.util.List;


public interface ProductoService {

    //Post
    void saveProducto(Producto producto);

    //Get todos
    List<Producto> findAllProductos();

    //Get by id
    Producto findProductoById(Long id);

    //Put by id
    Producto updateProductoById(Long id, Producto producto);

    //Delete by id
    Producto deleteProductoById(Long id);

    //Delete all
    List<Producto> deleteAllProductos();

}

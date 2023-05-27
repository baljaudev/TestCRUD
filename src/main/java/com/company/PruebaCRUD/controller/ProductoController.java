package com.company.PruebaCRUD.controller;

import com.company.PruebaCRUD.model.Producto;
import com.company.PruebaCRUD.service.ProductoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@AllArgsConstructor
public class ProductoController {

    @Autowired
    private final ProductoService productoService;

    // http://localhost:8080/producto/
    @GetMapping("/")
    public String index() {
        return "Bienvenido a la API de productos";
    }

    @PostMapping("/guardar")
    public ResponseEntity<Producto> save(@Valid @RequestBody Producto producto) {
        boolean productoOk = checkProduct(producto);
        if (productoOk) {
            productoService.saveProducto(producto);
            return new ResponseEntity<>(producto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // http://localhost:8080/producto/mostrar
    @GetMapping("/mostrar")
    public ResponseEntity<List<Producto>> findAll() {
        if (productoService.findAllProductos() != null) {
            return new ResponseEntity<>(productoService.findAllProductos(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //http://localhost:8080/producto/mostar/1
    // Podemos pasarle al ResponseEntity un '?' para que acepte cualquier tipo de dato
    // y en @PathVariable, le pasamos por parámetro el tipo de dato que queremos que acepte la variable id (en este caso Long)
    @GetMapping("/mostrar/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        if (productoService.findProductoById(id) != null) {
            return new ResponseEntity<>(productoService.findProductoById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Buscar por id de producto con RequestParam
    // http://localhost:8080/producto/mostrarParam?id=1
    @GetMapping("/mostrarParam")
    public ResponseEntity<?> findByIdRequestParam(@RequestParam("id") Long id) {
        if (productoService.findProductoById(id) != null) {
            return new ResponseEntity<>(productoService.findProductoById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // http://localhost:8080/producto/actualizar/1
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> updateById(@PathVariable Long id, @RequestBody Producto producto) {
        // Si el producto existe y los datos del producto son correctos, actualiza el producto y regresa el producto actualizado
        if (productoService.updateProductoById(id, producto) != null && checkProduct(producto)) {
            return new ResponseEntity<>(productoService.updateProductoById(id, producto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // http://localhost:8080/producto/eliminar/1
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Producto> delete(@PathVariable Long id) {
        // Si el producto existe, lo elimina y regresa el producto eliminado
        if (productoService.deleteProductoById(id) != null) {
            return new ResponseEntity<>(productoService.deleteProductoById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // http://localhost:8080/producto/eliminar
    @DeleteMapping("/eliminar")
    public ResponseEntity<List<Producto>> deleteAll() {
        if (productoService.deleteAllProductos() != null) {
            return new ResponseEntity<>(productoService.deleteAllProductos(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Método para validar que los campos del producto no estén vacíos
    private boolean checkProduct(Producto producto) {
        if (producto.getNombre() == null || producto.getNombre().isEmpty()) {
            throw new RuntimeException("El nombre del producto es requerido");
        } else if (producto.getPrecio() == null || producto.getPrecio().isNaN() || producto.getPrecio() <= 0) {
            throw new RuntimeException("El precio del producto es requerido y debe ser mayor a 0");
        } else if (producto.getDescripcion() == null || producto.getDescripcion().isEmpty()) {
            throw new RuntimeException("La descripción del producto es requerida");
        }else {
            return true;
        }
    }
}

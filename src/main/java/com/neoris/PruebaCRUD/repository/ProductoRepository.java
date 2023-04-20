package com.neoris.PruebaCRUD.repository;

import com.neoris.PruebaCRUD.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface para la tabla Producto de la base de datos
public interface ProductoRepository extends JpaRepository<Producto, Long> {}

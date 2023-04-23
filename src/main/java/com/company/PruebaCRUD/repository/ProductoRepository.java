package com.company.PruebaCRUD.repository;

import com.company.PruebaCRUD.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface para la tabla Producto de la base de datos
public interface ProductoRepository extends JpaRepository<Producto, Long> {}

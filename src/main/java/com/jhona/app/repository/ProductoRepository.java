package com.jhona.app.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.jhona.app.models.Producto;

@Repository
public interface ProductoRepository
    extends ReactiveCrudRepository<Producto, Long> {

}

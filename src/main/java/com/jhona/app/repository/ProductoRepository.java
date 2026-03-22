package com.jhona.app.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.jhona.app.models.Producto;

public interface ProductoRepository
    extends ReactiveCrudRepository<Producto, Long> {

}

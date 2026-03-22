package com.jhona.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.jhona.models.Producto;

public interface ProductoRepository
    extends ReactiveCrudRepository<Producto, Long> {

}

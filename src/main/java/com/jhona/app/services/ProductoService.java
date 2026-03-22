package com.jhona.app.services;

import com.jhona.app.models.Producto;
import com.jhona.app.models.dtos.ProductoDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoService {

  Flux<Producto> obtenerTodos();

  Mono<Producto> guardarProducto(ProductoDTO producto);
}

package com.jhona.app.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhona.app.models.Producto;
import com.jhona.app.models.dtos.ProductoDTO;
import com.jhona.app.services.ProductoService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/productos")
public class ProductoController {

  private final ProductoService service;

  @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Producto> obtenerTodos() {
    return service.obtenerTodos();
  }

  @PostMapping
  public Mono<Producto> guardarProducto(@RequestBody ProductoDTO productoDTO) {
    return service.guardarProducto(productoDTO);
  }
}

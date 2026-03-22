package com.jhona.app.services.impl;

import java.time.Duration;

import org.springframework.stereotype.Service;

import com.jhona.app.models.Producto;
import com.jhona.app.models.dtos.ProductoDTO;
import com.jhona.app.repository.ProductoRepository;
import com.jhona.app.services.ProductoService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductoServiceIMPL
    implements ProductoService {

  private final ProductoRepository productoRepository;

  @Override
  public Mono<Producto> guardarProducto(ProductoDTO productoDTO) {
    Producto productoGuardar = new Producto();
    productoGuardar.setNombre(productoDTO.getNombre());
    productoGuardar.setPrecio(productoDTO.getPrecio());
    return productoRepository.save(productoGuardar);
  }

  @Override
  public Flux<Producto> obtenerTodos() {
    return productoRepository
        .findAll()
        .delayElements(Duration.ofMillis(500)); // retraso para ver el streaming
  }

}

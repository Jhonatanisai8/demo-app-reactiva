package com.jhona.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table("productos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
  @Id
  private Long id;
  private String nombre;
  private Double precio;
}

package com.agroapp.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idProducto;
    private  String descripcion;
    private String nombre;
    private Double precio;
    @Enumerated(EnumType.STRING)
    private Medida medida;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private  String imagen;
        public enum Medida{
        LIBRA, LITRO, KILO, UNIDAD
    };
    public enum Categoria{
        LÁCTEOS, HORTALIZAS, FRUTAS, CONSERVAS, CARNES, GRANOS
    };

}

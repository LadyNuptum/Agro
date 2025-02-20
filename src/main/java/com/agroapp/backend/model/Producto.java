package com.agroapp.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @NotBlank(message = "La descripción es obligatoria")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
    @Column(nullable = false, length = 50)
    private String nombre;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
    @Column(nullable = false)
    private Double precio;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "La medida es obligatoria")
    @Column(nullable = false)
    private Medida medida;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "La categoría es obligatoria")
    @Column(nullable = false)
    private Categoria categoria;

    @NotBlank(message = "La imagen es obligatoria")
    @Column(nullable = false, length = 255)
    private String imagen;

    public enum Medida{
        LIBRA, LITRO, KILO, UNIDAD
    }

    public enum Categoria{
        LÁCTEOS, HORTALIZAS, FRUTAS, CONSERVAS, CARNES, GRANOS
    }
}

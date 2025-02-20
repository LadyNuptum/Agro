package com.agroapp.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    @NotNull(message = "El usuario es obligatorio")
    private Usuario usuario;

    @NotNull(message = "La fecha del pedido es obligatoria")
    @Column(nullable = false)
    private Date fechaPedido;

    @NotNull(message = "El total es obligatorio")
    @DecimalMin(value = "0.01", message = "El total debe ser mayor a 0")
    @Column(nullable = false)
    private Double total;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El estado es obligatorio")
    @Column(nullable = false)
    private Estado estado;

    public enum Estado{
        PENDIENTE, ENTREGADO
    }
}

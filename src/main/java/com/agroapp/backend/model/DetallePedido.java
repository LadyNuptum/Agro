package com.agroapp.backend.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idDetallePedido;
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;
    private Integer cantidad;
    private Double subtotal;

}

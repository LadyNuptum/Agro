package com.agroapp.backend.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idPago;
    private Double monto;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;
    @OneToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;


    public enum Estado{
       APROBADO,  RECHAZADO
    }
    public enum MetodoPago{
        TARJETA, TRANSFERENCIA, EFECTIVO
    }
}

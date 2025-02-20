package com.agroapp.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPago;

    @OneToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    @NotNull(message = "El pedido es obligatorio")
    private Pedido pedido;

    @NotNull(message = "El monto es obligatorio")
    @DecimalMin(value = "0.01", message = "El monto debe ser mayor a 0")
    @Column(nullable = false)
    private Double monto;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El estado es obligatorio")
    @Column(nullable = false)
    private Estado estado;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El método de pago es obligatorio")
    @Column(nullable = false)
    private MetodoPago metodoPago;

    public enum Estado{
       APROBADO,  RECHAZADO
    }
    public enum MetodoPago{
        TARJETA, TRANSFERENCIA, EFECTIVO
    }
}

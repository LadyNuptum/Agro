package com.agroapp.backend.model;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idPedido;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    private Date fechaPedido;
    private Double total;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @OneToMany (mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<DetallePedido> detalles;
    @OneToOne (mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pago pago;
    public enum Estado{
        PENDIENTE, ENTREGADO
    }

}

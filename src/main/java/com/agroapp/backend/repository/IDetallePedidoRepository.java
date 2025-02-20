package com.agroapp.backend.repository;

import com.agroapp.backend.model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {
}

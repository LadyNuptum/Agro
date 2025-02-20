package com.agroapp.backend.repository;

import com.agroapp.backend.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {
}

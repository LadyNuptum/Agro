package com.agroapp.backend.repository;

import com.agroapp.backend.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPagoRepository extends JpaRepository<Pago, Integer> {
}

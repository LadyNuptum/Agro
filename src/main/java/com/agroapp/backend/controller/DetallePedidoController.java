package com.agroapp.backend.controller;

import com.agroapp.backend.model.DetallePedido;
import com.agroapp.backend.service.DetallePedidoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalles-pedido")
public class DetallePedidoController {

    private final DetallePedidoService detallePedidoService;

    public DetallePedidoController(DetallePedidoService detallePedidoService) {
        this.detallePedidoService = detallePedidoService;
    }

    @GetMapping
    public ResponseEntity<List<DetallePedido>> getAll() {
        return ResponseEntity.ok(detallePedidoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> getById(@PathVariable Integer id) {
        return detallePedidoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DetallePedido> create(@Valid @RequestBody DetallePedido detallePedido) {
        return ResponseEntity.ok(detallePedidoService.create(detallePedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePedido> update(@PathVariable Integer id, @Valid @RequestBody DetallePedido detallePedido) {
        DetallePedido updatedDetalle = detallePedidoService.updateById(id, detallePedido);
        return (updatedDetalle != null) ? ResponseEntity.ok(updatedDetalle) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        detallePedidoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

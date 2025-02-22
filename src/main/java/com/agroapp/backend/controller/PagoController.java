package com.agroapp.backend.controller;

import com.agroapp.backend.model.Pago;
import com.agroapp.backend.service.PagoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping
    public ResponseEntity<List<Pago>> getAll() {
        return ResponseEntity.ok(pagoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> getById(@PathVariable Integer id) {
        return pagoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pago> create(@Valid @RequestBody Pago pago) {
        return ResponseEntity.ok(pagoService.create(pago));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        pagoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

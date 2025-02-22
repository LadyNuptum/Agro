package com.agroapp.backend.service;

import com.agroapp.backend.model.Pago;
import com.agroapp.backend.repository.IPagoRepository;
import com.agroapp.backend.service.interfaces.IPagoService;

import java.util.List;
import java.util.Optional;

public class PagoService implements IPagoService {

    private final IPagoRepository pagoRepository;

    public PagoService(IPagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    @Override
    public List<Pago> getAll() {
        return pagoRepository.findAll();
    }

    @Override
    public Optional<Pago> getById(Integer id) {
        return pagoRepository.findById(id);
    }

    @Override
    public Pago create(Pago entity) {
        return pagoRepository.save(entity);
    }

    @Override
    public Pago updateById(Integer id, Pago entity) {
        if (pagoRepository.existsById(id)) {
            entity.setIdPago(id);
            return pagoRepository.save(entity);
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        pagoRepository.deleteById(id);
    }
}

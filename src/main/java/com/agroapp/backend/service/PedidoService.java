package com.agroapp.backend.service;

import com.agroapp.backend.model.Pedido;
import com.agroapp.backend.repository.IPedidoRepository;
import com.agroapp.backend.service.interfaces.IPedidoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService implements IPedidoService {

    private final IPedidoRepository pedidoRepository;

    public PedidoService(IPedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> getAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> getById(Integer id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido create(Pedido entity) {
        return pedidoRepository.save(entity);
    }

    @Override
    public Pedido updateById(Integer id, Pedido entity) {
        if (pedidoRepository.existsById(id)) {
            entity.setIdPedido(id);
            return pedidoRepository.save(entity);
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        pedidoRepository.deleteById(id);
    }
}

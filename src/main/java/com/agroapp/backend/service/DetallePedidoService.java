package com.agroapp.backend.service;

import com.agroapp.backend.model.DetallePedido;
import com.agroapp.backend.repository.IDetallePedidoRepository;
import com.agroapp.backend.service.interfaces.IDetallePedidoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoService implements IDetallePedidoService {

    private final IDetallePedidoRepository detallePedidoRepository;

    public DetallePedidoService(IDetallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    @Override
    public List<DetallePedido> getAll() {
        return detallePedidoRepository.findAll();
    }

    @Override
    public Optional<DetallePedido> getById(Integer id) {
        return detallePedidoRepository.findById(id);
    }

    @Override
    public DetallePedido create(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    @Override
    public DetallePedido updateById(Integer id, DetallePedido detallePedido) {
        if (detallePedidoRepository.existsById(id)) {
            detallePedido.setIdDetallePedido(id);
            return detallePedidoRepository.save(detallePedido);
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        detallePedidoRepository.deleteById(id);
    }
}

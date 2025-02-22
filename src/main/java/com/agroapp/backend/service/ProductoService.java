package com.agroapp.backend.service;

import com.agroapp.backend.model.Producto;
import com.agroapp.backend.repository.IProductoRepository;
import com.agroapp.backend.service.interfaces.IProductoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    IProductoRepository productoRepository;

    public ProductoService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> getById(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto create(Producto entity) {
        return productoRepository.save(entity);
    }

    @Override
    public Producto updateById(Integer id, Producto entity) {
        if (productoRepository.existsById(id)) {
            entity.setIdProducto(id);
            return productoRepository.save(entity);
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        productoRepository.deleteById(id);
    }
}

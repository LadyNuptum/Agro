package com.agroapp.backend.service;

import com.agroapp.backend.model.Usuario;
import com.agroapp.backend.repository.IUsuarioRepository;
import com.agroapp.backend.service.interfaces.IUsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    private final IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> getById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario create(Usuario entity) {
        return usuarioRepository.save(entity);
    }

    @Override
    public Usuario updateById(Integer id, Usuario entity) {
        if (usuarioRepository.existsById(id)) {
            entity.setIdUsuario(id);
            return usuarioRepository.save(entity);
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }
}

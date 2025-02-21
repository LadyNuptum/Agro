package com.agroapp.backend.service;

import com.agroapp.backend.model.Usuario;
import com.agroapp.backend.repository.IUsuarioRepository;
import com.agroapp.backend.service.interfaces.IUsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    private final IUsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(IUsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
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
        // Encripta la contraseña antes de guardar
        entity.setContrasena(passwordEncoder.encode(entity.getContrasena()));
        return usuarioRepository.save(entity);
    }

    @Override
    public Usuario updateById(Integer id, Usuario entity) {
        if (usuarioRepository.existsById(id)) {
            // Encriptar solo si la contraseña se actualiza
            usuarioRepository.findById(id).ifPresent(existingUser -> {
                if (!entity.getContrasena().equals(existingUser.getContrasena())) {
                    entity.setContrasena(passwordEncoder.encode(entity.getContrasena()));
                }
            });
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

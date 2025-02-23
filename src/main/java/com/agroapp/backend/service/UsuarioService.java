package com.agroapp.backend.service;

import com.agroapp.backend.model.Usuario;
import com.agroapp.backend.repository.IUsuarioRepository;
import com.agroapp.backend.service.interfaces.IUsuarioService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public UserDetails loadUserByCorreo(String correo) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByCorreo(correo);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new org.springframework.security.core.userdetails.User(usuario.get().getCorreo(), usuario.get().getContrasena(), new ArrayList<>());
    }

    @Override
    public Usuario create(Usuario entity) {
        Usuario usuario = new Usuario();
        if (usuarioRepository.findByCorreo(entity.getCorreo()).isPresent()) {
            return null;
        }
        usuario.setNombre(entity.getNombre());
        usuario.setApellido(entity.getApellido());
        usuario.setCorreo(entity.getCorreo());
        usuario.setTelefono(entity.getTelefono());
        usuario.setContrasena(passwordEncoder.encode(entity.getContrasena()));
        return usuarioRepository.save(usuario);
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

package com.agroapp.backend.service;

import com.agroapp.backend.model.Usuario;
import com.agroapp.backend.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            return null;
        }
        return usuarios;
    }

    @Override
    public Usuario getUsuarioById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Integer id, Usuario usuario) {
        Usuario existingUsuario = usuarioRepository.findById(id).orElse(null);
        if (existingUsuario != null) {
            existingUsuario.setCorreo(usuario.getCorreo());
            existingUsuario.setContrasena(usuario.getContrasena());
            existingUsuario.setNombre(usuario.getNombre());
            existingUsuario.setApellido(usuario.getApellido());
            existingUsuario.setTelefono(usuario.getTelefono());
            return usuarioRepository.save(existingUsuario);
        }
        return null;
    }

    @Override
    public void deleteUsuario(Integer id) {
        Usuario deletingUsuario = usuarioRepository.findById(id).orElseThrow(null);
        if (deletingUsuario != null) {
            usuarioRepository.deleteById(deletingUsuario.getIdUsuario());
        }
    }
}

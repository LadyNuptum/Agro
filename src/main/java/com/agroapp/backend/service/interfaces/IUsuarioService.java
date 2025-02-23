package com.agroapp.backend.service.interfaces;

import com.agroapp.backend.model.Usuario;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    List<Usuario> getAll();

    Optional<Usuario> getById(Integer id);

    UserDetails loadUserByCorreo(String correo);

    Usuario create(Usuario entity);

    Usuario updateById(Integer id, Usuario entity);

    void deleteById(Integer id);
}

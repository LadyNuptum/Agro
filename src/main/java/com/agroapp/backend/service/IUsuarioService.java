package com.agroapp.backend.service;

import com.agroapp.backend.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> getAllUsuarios();

    Usuario getUsuarioById(Integer id);

    Usuario createUsuario(Usuario usuario);

    Usuario updateUsuario(Integer id, Usuario usuario);

    void deleteUsuario(Integer id);

}

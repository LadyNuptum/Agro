package com.agroapp.backend.controller;

import com.agroapp.backend.component.JwtUtil;
import com.agroapp.backend.dto.UsuarioDTO;
import com.agroapp.backend.model.Usuario;
import com.agroapp.backend.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthController(UsuarioService usuarioService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> create(@Valid @RequestBody Usuario usuario) {
        Map<String, String> response = new HashMap<>();
        if (usuarioService.create(usuario) == null) {
            response.put("message", "El correo ya está registrado");
            return ResponseEntity.badRequest().body(response);
        }
        response.put("message", "Usuario registrado exitosamente");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity <Map<String, String>> login(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        Map<String, String> response = new HashMap<>();
        UserDetails usuario = usuarioService.loadUserByCorreo(usuarioDTO.getCorreo());
        if (usuario == null || !passwordEncoder.matches(usuarioDTO.getContrasena(), usuario.getPassword())) {
            response.put("message", "Correo o contraseña incorrectos");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        String token = jwtUtil.generateToken(usuario.getUsername());
        return ResponseEntity.ok(Map.of("token", token));
    }
}

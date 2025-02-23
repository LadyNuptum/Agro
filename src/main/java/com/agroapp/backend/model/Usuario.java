package com.agroapp.backend.model;

import com.agroapp.backend.repository.IUsuarioRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.agroapp.backend.repository.IUsuarioRepository;

@NoArgsConstructor


@AllArgsConstructor
@Getter
@Setter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Email(message = "El correo debe ser válido")
    @NotBlank(message = "El correo no puede estar vacío")
    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @NotBlank(message = "La contraseña es obligatoria")
    @Column(nullable = false, length = 255) // Se aumenta el tamaño para almacenar la contraseña encriptada
    private String contrasena;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
    @Column(nullable = false, length = 50)
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 50, message = "El apellido no puede superar los 50 caracteres")
    @Column(nullable = false, length = 50)
    private String apellido;

    @NotBlank(message = "El teléfono es obligatorio")
    @Size(max = 15, message = "El teléfono no puede superar los 15 caracteres")
    @Column(nullable = false, length = 15)
    private String telefono;

    @Transient // No se mapea en la BD
    @Autowired
    private transient IUsuarioRepository usuarioRepository;

    @PrePersist
    @PreUpdate
    @Transactional
    private void verificarCorreoUnico() {
        if (usuarioRepository != null && usuarioRepository.existsByCorreo(this.correo)) {
            throw new RuntimeException("El correo ya está registrado");
        }
    }
}

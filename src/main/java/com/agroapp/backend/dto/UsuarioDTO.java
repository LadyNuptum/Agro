package com.agroapp.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {
    @Email(message = "El correo debe ser válido")
    @NotNull(message = "El correo es obligatorio")
    @NotBlank(message = "El correo no puede estar vacío")
    private String correo;


    @NotNull(message = "La contraseña es obligatoria")
    @NotBlank(message = "La contraseña no puede estar vacía")
    private String contrasena;
}

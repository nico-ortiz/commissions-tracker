package com.goldeng.commissionstracker.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
    @NotNull(message = "El nombre no puede ser nulo")
    @NotEmpty(message =  "El nombre no puede ser vacio")
    @Column(nullable = false)
    String firstName,

    @NotNull(message = "El apellido no puede ser nulo")
    @NotEmpty(message =  "El apellido no puede ser vacio")
    @Column(nullable = false)
    String lastName,
    
    @NotNull(message = "El email no puede ser nulo")
    @NotEmpty(message =  "El email no puede ser vacio")
    @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "El formato del email no es válido")
    @Column(unique = true)
    String email,
    
    @NotNull(message = "La contraseña no puede ser nula")
    @NotEmpty(message =  "La contraseña no puede ser vacia")
    @Length(min = 5, max = 20, message = "La contraseña debe contener ente 5 y 20 caracteres")
    @Column(nullable = false)
    String password,
    
    @NotNull(message = "La direccion no puede ser nula")
    @NotEmpty(message =  "La direccion no puede ser vacia")
    String address,
    
    @NotNull(message = "El número de teléfono no puede ser nulo")
    @NotEmpty(message =  "El número de teléfono no puede ser vacio")
    String phoneNumber
) {
    
}
package com.registro.usuarios.servicio;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncriptacionServicioImpl implements EncriptacionServicio {

    private final BCryptPasswordEncoder passwordEncoder;

    public EncriptacionServicioImpl(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encriptarPassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean verificarPassword(String password, String passwordEncriptado) {
        return passwordEncoder.matches(password, passwordEncriptado);
    }
}
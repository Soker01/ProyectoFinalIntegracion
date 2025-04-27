package com.registro.usuarios.servicio;

public interface EncriptacionServicio {
    String encriptarPassword(String password);
    boolean verificarPassword(String password, String passwordEncriptado);
}
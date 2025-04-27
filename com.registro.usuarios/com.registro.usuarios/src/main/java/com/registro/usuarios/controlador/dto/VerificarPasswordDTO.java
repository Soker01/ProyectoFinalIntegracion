package com.registro.usuarios.controlador.dto;

public class VerificarPasswordDTO {
    private String password;
    private String passwordEncriptado;
    
    // Getters y setters
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPasswordEncriptado() {
        return passwordEncriptado;
    }
    
    public void setPasswordEncriptado(String passwordEncriptado) {
        this.passwordEncriptado = passwordEncriptado;
    }
}
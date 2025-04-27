package com.registro.usuarios.controlador.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.registro.usuarios.controlador.dto.PasswordDTO;
import com.registro.usuarios.controlador.dto.VerificarPasswordDTO;
import com.registro.usuarios.servicio.EncriptacionServicio;

@RestController
@RequestMapping("/api/encriptacion")
public class EncriptacionRestController {

    private final EncriptacionServicio encriptacionServicio;
    
    public EncriptacionRestController(EncriptacionServicio encriptacionServicio) {
        this.encriptacionServicio = encriptacionServicio;
    }
    
    @PostMapping("/encriptar")
    public ResponseEntity<String> encriptarPassword(@RequestBody PasswordDTO passwordDTO) {
        String passwordEncriptado = encriptacionServicio.encriptarPassword(passwordDTO.getPassword());
        return ResponseEntity.ok(passwordEncriptado);
    }
    
    @PostMapping("/verificar")
    public ResponseEntity<Boolean> verificarPassword(@RequestBody VerificarPasswordDTO verificarDTO) {
        boolean esValido = encriptacionServicio.verificarPassword(
            verificarDTO.getPassword(), 
            verificarDTO.getPasswordEncriptado()
        );
        return ResponseEntity.ok(esValido);
    }

    
}
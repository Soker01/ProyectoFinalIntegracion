package com.registro.usuarios.controlador.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.servicio.UsuarioServicio;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {

    private final UsuarioServicio usuarioServicio;
    
    public UsuarioRestController(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }
    
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioServicio.listarUsuarios());
    }
    
    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody UsuarioRegistroDTO registroDTO) {
        Usuario nuevoUsuario = usuarioServicio.guardar(registroDTO);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }
    
    @GetMapping("/{email}")
    public ResponseEntity<Usuario> obtenerUsuarioPorEmail(@PathVariable String email) {
        try {
            Usuario usuario = usuarioServicio.obtenerPorEmail(email);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
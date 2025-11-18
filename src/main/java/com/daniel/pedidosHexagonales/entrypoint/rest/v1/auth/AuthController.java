package com.daniel.pedidosHexagonales.entrypoint.rest.v1.auth;

import com.daniel.pedidosHexagonales.core.port.UsuarioServicePort;
import com.daniel.pedidosHexagonales.entrypoint.rest.v1.auth.dto.AuthResponseDTO;
import com.daniel.pedidosHexagonales.entrypoint.rest.v1.auth.dto.LoginRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UsuarioServicePort usuarioService;

    public AuthController(UsuarioServicePort usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {
        // Llamamos a la lógica de negocio que definiste en el Servicio
        String resultado = usuarioService.login(loginRequest.getCorreo(), loginRequest.getPassword());

        // Retornamos respuesta JSON
        return ResponseEntity.ok(new AuthResponseDTO(resultado, "sesion-iniciada-ok"));
    }
}
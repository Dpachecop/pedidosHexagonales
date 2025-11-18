package com.daniel.pedidosHexagonales.entrypoint.rest.v1;

import com.daniel.pedidosHexagonales.core.domain.Usuario;
import com.daniel.pedidosHexagonales.core.port.UsuarioServicePort;
import com.daniel.pedidosHexagonales.entrypoint.rest.v1.dto.UsuarioRequestDTO;
import com.daniel.pedidosHexagonales.entrypoint.rest.v1.dto.UsuarioResponseDTO;
import com.daniel.pedidosHexagonales.entrypoint.rest.v1.mapper.UsuarioRestMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.daniel.pedidosHexagonales.entrypoint.rest.v1.dto.PasswordUpdateRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioServicePort usuarioService;
    private final UsuarioRestMapper mapper;

    public UsuarioController(UsuarioServicePort usuarioService, UsuarioRestMapper mapper) {
        this.usuarioService = usuarioService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(@RequestBody UsuarioRequestDTO dto) {
        Usuario nuevo = mapper.toDomain(dto);
        Usuario creado = usuarioService.crearUsuario(nuevo);
        return ResponseEntity.ok(mapper.toDTO(creado));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios() {
        List<UsuarioResponseDTO> lista = usuarioService.listarUsuarios().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> obtenerUsuario(@PathVariable Long id) {
        Usuario u = usuarioService.obtenerUsuario(id);
        return ResponseEntity.ok(mapper.toDTO(u));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/password")
    public ResponseEntity<Void> actualizarPassword(@PathVariable Long id, @RequestBody PasswordUpdateRequestDTO dto) {
        // Obtenemos el usuario existente para actualizar solo la contraseña
        Usuario usuario = usuarioService.obtenerUsuario(id);
        usuario.setPassword(dto.getNuevaPassword());
        usuarioService.actualizarUsuario(id, usuario); // El método actualizarUsuario ya maneja el guardado
        return ResponseEntity.noContent().build();
    }
}
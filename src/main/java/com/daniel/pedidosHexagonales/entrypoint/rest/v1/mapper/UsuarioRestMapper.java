package com.daniel.pedidosHexagonales.entrypoint.rest.v1.mapper;

import com.daniel.pedidosHexagonales.core.domain.Usuario;
import com.daniel.pedidosHexagonales.entrypoint.rest.v1.dto.UsuarioRequestDTO;
import com.daniel.pedidosHexagonales.entrypoint.rest.v1.dto.UsuarioResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UsuarioRestMapper {

    public Usuario toDomain(UsuarioRequestDTO dto) {
        Usuario u = new Usuario();
        u.setNombre(dto.getNombre());
        u.setApellido(dto.getApellido());
        u.setCorreo(dto.getCorreo());
        u.setPassword(dto.getPassword());
        u.setRol(dto.getRol());
        return u;
    }

    public UsuarioResponseDTO toDTO(Usuario domain) {
        return new UsuarioResponseDTO(
                domain.getId(),
                domain.getNombre(),
                domain.getApellido(),
                domain.getCorreo(),
                domain.getRol()
        );
    }
}
package com.daniel.pedidosHexagonales.adapter.security;

import com.daniel.pedidosHexagonales.core.domain.Usuario;
import com.daniel.pedidosHexagonales.core.port.UsuarioRepositoryPort;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public CustomUserDetailsService(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositoryPort.findByCorreo(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        // Convertimos nuestro dominio Usuario al User de Spring Security
        return User.builder()
                .username(usuario.getCorreo())
                .password(usuario.getPassword()) // Spring espera la contraseña aquí
                .roles(usuario.getRol()) // Ej: "ADMIN", "USER"
                .build();
    }
}
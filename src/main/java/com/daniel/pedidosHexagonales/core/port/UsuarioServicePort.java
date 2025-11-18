package com.daniel.pedidosHexagonales.core.port;

import com.daniel.pedidosHexagonales.core.domain.Usuario;
import java.util.List;

public interface UsuarioServicePort {
    Usuario crearUsuario(Usuario usuario);
    Usuario obtenerUsuario(Long id);
    Usuario obtenerUsuarioPorCorreo(String correo);
    List<Usuario> listarUsuarios();
    Usuario actualizarUsuario(Long id, Usuario usuario);
    void eliminarUsuario(Long id);
    String login(String correo, String password);
}
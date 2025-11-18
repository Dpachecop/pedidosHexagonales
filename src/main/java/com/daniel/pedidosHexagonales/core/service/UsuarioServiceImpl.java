package com.daniel.pedidosHexagonales.core.service;

import com.daniel.pedidosHexagonales.core.domain.Usuario;
import com.daniel.pedidosHexagonales.core.port.UsuarioRepositoryPort;
import com.daniel.pedidosHexagonales.core.port.UsuarioServicePort;
import java.util.List;
import java.util.Optional;

public class UsuarioServiceImpl implements UsuarioServicePort {

    private final UsuarioRepositoryPort usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepositoryPort usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        Optional<Usuario> existente = usuarioRepository.findByCorreo(usuario.getCorreo());
        if (existente.isPresent()) {
            throw new RuntimeException("El usuario con correo " + usuario.getCorreo() + " ya existe.");
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario obtenerUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    @Override
    public Usuario obtenerUsuarioPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con correo: " + correo));
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        Usuario existente = obtenerUsuario(id);
        existente.setNombre(usuario.getNombre());
        existente.setApellido(usuario.getApellido());
        if(usuario.getPassword() != null && !usuario.getPassword().isEmpty()) {
            existente.setPassword(usuario.getPassword());
        }
        return usuarioRepository.update(existente);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public String login(String correo, String password) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(correo);
        if (usuarioOpt.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }
        Usuario usuario = usuarioOpt.get();
        if (!usuario.getPassword().equals(password)) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        return "Login Exitoso para: " + usuario.getCorreo();
    }
}
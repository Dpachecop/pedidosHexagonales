package com.daniel.pedidosHexagonales.adapter.databases.sql;

import com.daniel.pedidosHexagonales.core.domain.Usuario;
import com.daniel.pedidosHexagonales.core.port.UsuarioRepositoryPort;
import com.daniel.pedidosHexagonales.adapter.databases.sql.entity.UsuarioEntity;
import com.daniel.pedidosHexagonales.adapter.databases.sql.mapper.UsuarioDbMapper;
import com.daniel.pedidosHexagonales.adapter.databases.sql.repository.UsuarioJpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository jpaRepository;
    private final UsuarioDbMapper mapper;

    public UsuarioRepositoryAdapter(UsuarioJpaRepository jpaRepository, UsuarioDbMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        UsuarioEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<Usuario> findByCorreo(String correo) {
        return jpaRepository.findByCorreo(correo).map(mapper::toDomain);
    }

    @Override
    public List<Usuario> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Usuario update(Usuario usuario) {
        return save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
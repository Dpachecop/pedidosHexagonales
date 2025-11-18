package com.daniel.pedidosHexagonales.adapter.databases.sql;

import com.daniel.pedidosHexagonales.core.domain.Pedido;
import com.daniel.pedidosHexagonales.core.port.PedidoRepositoryPort;
import com.daniel.pedidosHexagonales.adapter.databases.sql.entity.PedidoEntity;
import com.daniel.pedidosHexagonales.adapter.databases.sql.mapper.PedidoDbMapper;
import com.daniel.pedidosHexagonales.adapter.databases.sql.repository.PedidoJpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {

    private final PedidoJpaRepository jpaRepository;
    private final PedidoDbMapper mapper;

    public PedidoRepositoryAdapter(PedidoJpaRepository jpaRepository, PedidoDbMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Pedido save(Pedido pedido) {
        PedidoEntity entity = mapper.toEntity(pedido);
        PedidoEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Pedido findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Pedido> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Pedido update(Pedido pedido) {
        return save(pedido);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
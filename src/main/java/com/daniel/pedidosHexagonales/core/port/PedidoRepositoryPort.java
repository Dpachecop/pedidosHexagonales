package com.daniel.pedidosHexagonales.core.port;

import com.daniel.pedidosHexagonales.core.domain.Pedido;
import java.util.List;

public interface PedidoRepositoryPort {
    Pedido save(Pedido pedido);
    Pedido findById(Long id);
    List<Pedido> findAll();
    Pedido update(Pedido pedido);
    void deleteById(Long id);
}
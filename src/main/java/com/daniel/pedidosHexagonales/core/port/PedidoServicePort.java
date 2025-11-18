package com.daniel.pedidosHexagonales.core.port;

import com.daniel.pedidosHexagonales.core.domain.Pedido;
import java.util.List;

public interface PedidoServicePort {
    Pedido crearPedido(Pedido pedido);
    Pedido obtenerPedido(Long id);
    List<Pedido> listarPedidos();
    Pedido actualizarPedido(Long id, Pedido pedido);
    void eliminarPedido(Long id);
}
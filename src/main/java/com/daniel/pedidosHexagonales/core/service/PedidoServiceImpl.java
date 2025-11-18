package com.daniel.pedidosHexagonales.core.service;

import com.daniel.pedidosHexagonales.core.domain.Pedido;
import com.daniel.pedidosHexagonales.core.port.PedidoRepositoryPort;
import com.daniel.pedidosHexagonales.core.port.PedidoServicePort;
import java.time.LocalDateTime;
import java.util.List;

public class PedidoServiceImpl implements PedidoServicePort {

    private final PedidoRepositoryPort pedidoRepository;

    public PedidoServiceImpl(PedidoRepositoryPort pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido crearPedido(Pedido pedido) {
        if (pedido.getFecha() == null) {
            pedido.setFecha(LocalDateTime.now());
        }
        if (pedido.getEstado() == null) {
            pedido.setEstado("PENDIENTE");
        }
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido obtenerPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        if (pedido == null) {
            throw new RuntimeException("Pedido no encontrado con ID: " + id);
        }
        return pedido;
    }

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido actualizarPedido(Long id, Pedido pedido) {
        Pedido existente = obtenerPedido(id);
        existente.setEstado(pedido.getEstado());
        existente.setFechaEntrega(pedido.getFechaEntrega());
        existente.setFechaEnvio(pedido.getFechaEnvio());
        return pedidoRepository.update(existente);
    }

    @Override
    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
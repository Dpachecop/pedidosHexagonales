package com.daniel.pedidosHexagonales.adapter.databases.config;

import com.daniel.pedidosHexagonales.core.port.PedidoRepositoryPort;
import com.daniel.pedidosHexagonales.core.port.UsuarioRepositoryPort;
import com.daniel.pedidosHexagonales.core.service.PedidoServiceImpl;
import com.daniel.pedidosHexagonales.core.service.UsuarioServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UsuarioServiceImpl usuarioService(UsuarioRepositoryPort usuarioRepositoryPort) {
        return new UsuarioServiceImpl(usuarioRepositoryPort);
    }

    @Bean
    public PedidoServiceImpl pedidoService(PedidoRepositoryPort pedidoRepositoryPort) {
        return new PedidoServiceImpl(pedidoRepositoryPort);
    }
}
package com.daniel.pedidosHexagonales.entrypoint.rest.v1.mapper;

import com.daniel.pedidosHexagonales.core.domain.Pedido;
import com.daniel.pedidosHexagonales.entrypoint.rest.v1.dto.PedidoRequestDTO;
import com.daniel.pedidosHexagonales.entrypoint.rest.v1.dto.PedidoResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class PedidoRestMapper {

    public Pedido toDomain(PedidoRequestDTO dto) {
        Pedido p = new Pedido();
        p.setCliente(dto.getCliente());
        p.setProveedor(dto.getProveedor());
        p.setValor(dto.getValor());
        p.setPais(dto.getPais());
        p.setDepartamento(dto.getDepartamento());
        p.setCiudad(dto.getCiudad());
        p.setNomenclaturaVivienda(dto.getNomenclaturaVivienda());
        p.setPropina(dto.getPropina());
        return p;
    }

    public PedidoResponseDTO toDTO(Pedido domain) {
        PedidoResponseDTO dto = new PedidoResponseDTO();
        dto.setId(domain.getId());
        dto.setFecha(domain.getFecha());
        dto.setEstado(domain.getEstado());
        dto.setCliente(domain.getCliente());

        // --- NUEVOS CAMPOS ---
        dto.setProveedor(domain.getProveedor());
        dto.setValor(domain.getValor());
        dto.setPropina(domain.getPropina());
        dto.setPais(domain.getPais());
        dto.setDepartamento(domain.getDepartamento());
        dto.setCiudad(domain.getCiudad());
        dto.setNomenclaturaVivienda(domain.getNomenclaturaVivienda());
        // ---------------------

        double total = (domain.getValor() != null ? domain.getValor() : 0) +
                (domain.getPropina() != null ? domain.getPropina() : 0);
        dto.setValorTotal(total);
        return dto;
    }
}
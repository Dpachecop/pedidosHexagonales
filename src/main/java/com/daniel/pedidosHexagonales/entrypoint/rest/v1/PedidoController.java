package com.daniel.pedidosHexagonales.entrypoint.rest.v1;

import com.daniel.pedidosHexagonales.core.domain.Pedido;
import com.daniel.pedidosHexagonales.core.port.PedidoServicePort;
import com.daniel.pedidosHexagonales.entrypoint.rest.v1.dto.PedidoRequestDTO;
import com.daniel.pedidosHexagonales.entrypoint.rest.v1.dto.PedidoResponseDTO;
import com.daniel.pedidosHexagonales.entrypoint.rest.v1.mapper.PedidoRestMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    private final PedidoServicePort pedidoService;
    private final PedidoRestMapper mapper;

    public PedidoController(PedidoServicePort pedidoService, PedidoRestMapper mapper) {
        this.pedidoService = pedidoService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> crearPedido(@RequestBody PedidoRequestDTO dto) {
        Pedido nuevo = mapper.toDomain(dto);
        Pedido creado = pedidoService.crearPedido(nuevo);
        return ResponseEntity.ok(mapper.toDTO(creado));
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> listarPedidos() {
        List<PedidoResponseDTO> lista = pedidoService.listarPedidos().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }
}
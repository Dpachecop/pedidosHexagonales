package com.daniel.pedidosHexagonales.entrypoint.rest.v1.dto;

import java.time.LocalDateTime;

public class PedidoResponseDTO {
    private Long id;
    private LocalDateTime fecha;
    private String estado;
    private String cliente;
    private Double valorTotal; // valor + propina

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }
}
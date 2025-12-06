package com.daniel.pedidosHexagonales.entrypoint.rest.v1.dto;

import java.time.LocalDateTime;

public class PedidoResponseDTO {
    private Long id;
    private LocalDateTime fecha;
    private String estado;
    private String cliente;
    private String proveedor;     // Nuevo
    private Double valor;         // Nuevo
    private Double propina;       // Nuevo
    private Double valorTotal;
    // Dirección
    private String pais;          // Nuevo
    private String departamento;  // Nuevo
    private String ciudad;        // Nuevo
    private String nomenclaturaVivienda; // Nuevo

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getProveedor() { return proveedor; }
    public void setProveedor(String proveedor) { this.proveedor = proveedor; }
    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
    public Double getPropina() { return propina; }
    public void setPropina(Double propina) { this.propina = propina; }

    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public String getNomenclaturaVivienda() { return nomenclaturaVivienda; }
    public void setNomenclaturaVivienda(String nomenclaturaVivienda) { this.nomenclaturaVivienda = nomenclaturaVivienda; }
}
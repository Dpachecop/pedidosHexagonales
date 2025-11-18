package com.daniel.pedidosHexagonales.entrypoint.rest.v1.dto;

import java.time.LocalDateTime;

public class PedidoRequestDTO {
    private String cliente;
    private String proveedor;
    private Double valor;
    private String pais;
    private String departamento;
    private String ciudad;
    private String nomenclaturaVivienda;
    private Double propina;

    // Getters y Setters
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public String getProveedor() { return proveedor; }
    public void setProveedor(String proveedor) { this.proveedor = proveedor; }
    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public String getNomenclaturaVivienda() { return nomenclaturaVivienda; }
    public void setNomenclaturaVivienda(String nomenclaturaVivienda) { this.nomenclaturaVivienda = nomenclaturaVivienda; }
    public Double getPropina() { return propina; }
    public void setPropina(Double propina) { this.propina = propina; }
}
package com.daniel.pedidosHexagonales.entrypoint.rest.v1.dto;

public class PasswordUpdateRequestDTO {
    private String nuevaPassword;

    public String getNuevaPassword() { return nuevaPassword; }
    public void setNuevaPassword(String nuevaPassword) { this.nuevaPassword = nuevaPassword; }
}
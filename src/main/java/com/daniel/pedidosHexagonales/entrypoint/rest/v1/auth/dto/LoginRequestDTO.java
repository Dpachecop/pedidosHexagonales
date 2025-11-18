package com.daniel.pedidosHexagonales.entrypoint.rest.v1.auth.dto;

public class LoginRequestDTO {
    private String correo;
    private String password;

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
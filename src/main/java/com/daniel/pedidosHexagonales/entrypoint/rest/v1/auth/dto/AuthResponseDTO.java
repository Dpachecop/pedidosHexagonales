package com.daniel.pedidosHexagonales.entrypoint.rest.v1.auth.dto;

public class AuthResponseDTO {
    private String mensaje;
    private String token; // Opcional, simulado por ahora

    public AuthResponseDTO(String mensaje, String token) {
        this.mensaje = mensaje;
        this.token = token;
    }

    // Getters y Setters
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}
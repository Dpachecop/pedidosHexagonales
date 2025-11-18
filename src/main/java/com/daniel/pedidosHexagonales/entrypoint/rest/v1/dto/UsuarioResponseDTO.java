package com.daniel.pedidosHexagonales.entrypoint.rest.v1.dto;

public class UsuarioResponseDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String rol;

    // Constructor vacio y completo
    public UsuarioResponseDTO() {}
    public UsuarioResponseDTO(Long id, String nombre, String apellido, String correo, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.rol = rol;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}
package com.dto;

public class User {

    private Long id;

    private String nombre;

    private String apellido;

    public User(long id, String nombre, String apellido) {
     this.id = id;
     this.nombre = nombre;
     this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}

package com.example.ejerciciofirebase1;

public class Contacto {
    private String nombre, email;

    public Contacto(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    public Contacto() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

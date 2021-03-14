package com.example.ejerciciofirebase1;

public class ListElement {
    public String color, nombre, email;

    public ListElement(String color, String nombre, String email) {
        this.color = color;
        this.nombre = nombre;
        this.email = email;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
}

package com.datasoft.proyectoestudiantefx.modelo;

public class Estudiante {

    private String nombres;
    private String apellidos;
    private int edad;
    private String email;

    public Estudiante(String nombres, String apellidos, int edad, String email) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email = email;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }
}

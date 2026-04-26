package com.krakedev.entidades;

public class Maquina {
    private String codigo;
    private String nombreCerveza;
    private String descripcion;
    private double precioPorMl;
    private int cantidadActual;

    public Maquina(String codigo, String nombre, String descripcion, double precio) {
        this.codigo = codigo;
        this.nombreCerveza = nombre;
        this.descripcion = descripcion;
        this.precioPorMl = precio;
        this.cantidadActual = 0;
    }

    public double servirCerveza(int cantidad) {
        this.cantidadActual -= cantidad;
        return cantidad * precioPorMl;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
}
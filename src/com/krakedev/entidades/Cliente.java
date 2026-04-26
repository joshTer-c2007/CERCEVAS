package com.krakedev.entidades;

public class Cliente {
    private String nombre;
    private String cedula;
    private String codigo;
    private double totalConsumido;

    public Cliente(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.totalConsumido = 0;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public String getCedula() { return cedula; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public double getTotalConsumido() { return totalConsumido; }
    public void setTotalConsumido(double totalConsumido) { this.totalConsumido = totalConsumido; }
}
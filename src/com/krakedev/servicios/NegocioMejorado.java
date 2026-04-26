package com.krakedev.servicios;

import java.util.ArrayList;
import com.krakedev.entidades.Maquina;
import com.krakedev.entidades.Cliente;

public class NegocioMejorado {
    private ArrayList<Maquina> maquinas;
    private ArrayList<Cliente> clientes;

    public NegocioMejorado() {
        this.maquinas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public String generarCodigo() {
        int numero = (int) (Math.random() * 100) + 1;
        return "M-" + numero;
    }

    public Maquina recuperarMaquina(String codigo) {
        for (Maquina m : maquinas) {
            if (m.getCodigo().equals(codigo)) {
                return m;
            }
        }
        return null;
    }

    public boolean agregarMaquina(String nombre, String descripcion, double precio) {
        String codigo = generarCodigo();
        if (recuperarMaquina(codigo) == null) {
            Maquina nueva = new Maquina(codigo, nombre, descripcion, precio);
            maquinas.add(nueva);
            return true;
        }
        return false;
    }

    public void registrarCliente(String nombre, String cedula) {
        Cliente nuevo = new Cliente(nombre, cedula);
        clientes.add(nuevo);
    }

    public Cliente buscarClientePorCedula(String cedula) {
        for (Cliente c : clientes) {
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    public Cliente buscarClientePorCodigo(String codigo) {
        for (Cliente c : clientes) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }
    public void consumirCerveza(String codCliente, String codMaquina, int cantidad) {
        Maquina m = recuperarMaquina(codMaquina);
        Cliente c = buscarClientePorCodigo(codCliente);
        
        if (m != null && c != null) {
            double valorConsumido = m.servirCerveza(cantidad);
            registrarConsumo(c, valorConsumido);
        }
    }

    private void registrarConsumo(Cliente cliente, double valor) {
        double totalActual = cliente.getTotalConsumido();
        cliente.setTotalConsumido(totalActual + valor);
    }

    public double consultarValorVendido() {
        double totalVendido = 0;
        for (Cliente c : clientes) {
            totalVendido += c.getTotalConsumido();
        }
        return totalVendido;
    }
    
}
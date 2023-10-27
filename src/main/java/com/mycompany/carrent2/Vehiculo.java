/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrent2;

/**
 *
 * @author Tom
 */
public class Vehiculo {
    private String patente;
    private String marca;
    private String modelo;
    private int anho;
    //Condición puede recibir tres valores: D, A, M
    //D: Disponible
    //A: Arrendado
    //M: Mantención
    private char condicion;
    
    public Vehiculo(String patente, String marca, String modelo, int anho) {
        setPatente(patente);
        setMarca(marca);
        setModelo(modelo);
        setAnho(anho);
        setCondicion('D');
    }

    /**
     * @return the patente
     */
    public String getPatente() {
        return patente;
    }

    /**
     * @param patente the patente to set
     */
    public void setPatente(String patente) {
        if (patente.length() != 8) {
            throw new IllegalArgumentException("EL LARGO DE LA PATENTE DEBE SER DE 8");
        }
        
        this.patente = patente;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the anho
     */
    public int getAnho() {
        return anho;
    }

    /**
     * @param anho the anho to set
     */
    public void setAnho(int anho) {
        if (anho < 2000) {
            throw new IllegalArgumentException("EL AÑO DE FABRICACIÓN DEBE SER MAYOR O IGUAL AL AÑO 2000");
        }
        
        this.anho = anho;
    }

    /**
     * @return the condicion
     */
    public char getCondicion() {
        return condicion;
    }
    

    /**
     * @param condicion the condicion to set
     */
    public void setCondicion(char condicion) {
        if (condicion != 'A' && condicion != 'D' && condicion != 'M') {
            throw new IllegalArgumentException("LA CONDICIÓN DEL VEHÍCULO NO ES VÁLIDA");
        }
        
        this.condicion = condicion;
    }
    
    public void AsignarVehiculoEnMantencion(){
        if (this.condicion == 'A'){
            throw new IllegalArgumentException("No es posible enviar a mantención un vehículo arrendado");
        }

        this.condicion = 'M';
    }
    
    @Override
    public String toString() {
        return "PATENTE: " + getPatente() + "\t" +
                "MODELO: " + getModelo() + "\t" +
                "MARCA: " + getMarca() + "\t" +
                "CONDICION: " + getCondicion();
    }
}

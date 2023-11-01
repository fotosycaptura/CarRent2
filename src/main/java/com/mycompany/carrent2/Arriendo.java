/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrent2;

import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author Tom
 */
public class Arriendo {
    private int numero; //Número del arriendo
    private GregorianCalendar fechaArriendo;
    private int dias;
    private Vehiculo vehiculo;
    private Cliente cliente;
    // OJO QUE FALTA LA RELACIÓN CON EL CLIENTE - Resuelto.
    
    public Arriendo(int numero, GregorianCalendar fechaArriendo, int dias, Vehiculo vehiculo, Cliente cliente) {
        setNumero(numero);
        setFechaArriendo(fechaArriendo);
        setDias(dias);
        setVehiculo(vehiculo);
        setCliente(cliente);
        // LO NIEGO, YA QUE SI ES VÁLIDO EL MÉTODO ENTRARÁ A LA CONDICIÓN Y GATILLARÁ EL ERROR
        // POR LO QUE AL NEGARLO, EL TRUE LLEGA A SER FALSE Y EL FALSE LLEGA A SER TRUE
//        if (!validarArriendo()) {
//            throw new IllegalArgumentException("VEHICULO Ó CLIENTE INVÁLIDOS");
//        }
    }
    
    public Boolean IngresarArriendo(){
        if (!validarArriendo()) {
            throw new IllegalArgumentException("VEHICULO Ó CLIENTE INVÁLIDOS");
        }
        
        return true;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the fechaArriendo
     */
    public GregorianCalendar getFechaArriendo() {
        return fechaArriendo;
    }

    /**
     * @param fechaArriendo the fechaArriendo to set
     */
    public void setFechaArriendo(GregorianCalendar fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    /**
     * @return the dias
     */
    public int getDias() {
        return dias;
    }

    /**
     * @param dias the dias to set
     */
    public void setDias(int dias) {
        // VALIDAR LA CANTIDAD DÍAS
        this.dias = dias;
    }

    /**
     * @return the vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    private boolean validarArriendo() {
        // OJO VALIDAR LA VIGENCIA DEL CLIENTE
        if (getVehiculo().getCondicion() != 'D') {
            return false;
        }
        
        return true;
    }
    
    public void GenerarTicketDeArriendo(){
        /*
        * Este método debe de imprimir el ticket 
        * de arriendo
        */
        System.out.println("Ticket Arriendo de Vehículo");
        System.out.println("Número de Arriendo: " + getNumero());
        System.out.println("Vehículo: " + getVehiculo().getPatente() + " " + getVehiculo().getMarca() + " " + getVehiculo().getModelo());
        System.out.println("Precio Diario: " + getVehiculo().getPrecioArriendo());
        System.out.println("Fecha           Cliente          Días          A Pagar");
        
        for(int i=0; i < 80; i++){
            System.out.print("-");
        }
        System.out.println("");
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        fmt.setCalendar(getFechaArriendo());
        String fechaFormateada = fmt.format(getFechaArriendo().getTime());
        int totalAPagar = getVehiculo().getPrecioArriendo() * getDias();

        //getDias() * 
        System.out.println(fechaFormateada + "    " + this.cliente.getCedula() + "/" + this.cliente.getNombre() + "         " + getDias() + " días" + "          $" + totalAPagar);
        for(int i=0; i < 80; i++){
            System.out.print("-");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("                                                _____________");
        System.out.println("                                                Firma Cliente");
    }
}

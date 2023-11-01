/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrent2;
import java.util.*;
/**
 *
 * @author xavie
 */
public class Cliente {
    private String cedula;
    private String nombre;
    private Boolean vigente;
    
    //Constructor
    public Cliente(String cedula, String nombre){
        setCedula(cedula);
        setNombre(nombre);
        setVigente(true);
    }
    
    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        //Se pide validación de cedula. largo máximo 10
        //Estilo xxxxxxxx-d
        //Donde xxxxxxxx es una parte entera y d es un número de 0 a 9 o k
        
        if (cedula != null && cedula.length() == 10){
            //Se debe de dividir en dos partes y realizar validación
            StringTokenizer stk = new StringTokenizer(cedula, "-");
            if (stk.countTokens() == 2){
                String conversor = new String(stk.nextToken());
                int rutNumerico = Integer.parseInt(conversor);
                char chrDigito = stk.nextToken().charAt(0);
                //Se valida si el digito verificaro es correcto
                if (ValidarDigitoVerificador(rutNumerico).equals(String.valueOf(chrDigito).toUpperCase())){
                    this.cedula = cedula;
                }else{
                    throw new IllegalArgumentException("Cédula de cliente inválida. Posiblemente dígito verificador no válido.");       
                }
            }else{
                throw new IllegalArgumentException("Cédula de cliente inválida. Posiblemente no se incluyó el guión");   
            }
        }else{
             throw new IllegalArgumentException("Cédula de cliente inválida. No posee el largo de 10 caracteres");
        }
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        if (nombre != null && nombre.length() > 0){
            this.nombre = nombre;
        }else{
            throw new IllegalArgumentException("Nombre de cliente inválido");
        }
    }

    /**
     * @return the vigente
     */
    public Boolean getVigente() {
        return vigente;
    }

    /**
     * @param vigente the vigente to set
     */
    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }
    
    /**
    * Esta operación la ejecuta el gerente del local cuando el estime 
    * conveniente y lo único que debe hacer es dejar no vigente al cliente 
    * para que no pueda arrendar.
    */
    public void DeshabilitarCliente(){
        this.vigente = false;
    }
    
    /**
     * Se encarga de obtener el dígito verificador de un rut.
     * Se utiliza para obtenerlo - generarlo - o para la comparación en un if
     * @param rut
     * @return 
     */
    private String ValidarDigitoVerificador(int rut)
        {
            int Digito;
            int Contador;
            int Multiplo;
            int Acumulador;
            String RutDigito;
            
            Contador = 2;
            Acumulador = 0;

            while (rut != 0)
            {
                Multiplo = (rut % 10) * Contador;
                Acumulador = Acumulador + Multiplo;
                rut = rut / 10;
                Contador = Contador + 1;
                if (Contador == 8)
                {
                    Contador = 2;
                }
            }

            Digito = 11 - (Acumulador % 11);
            RutDigito = Integer.toString(Digito);
            if (Digito == 10)
            {
                RutDigito = "K";
            }
            if (Digito == 11)
            {
                RutDigito = "0";
            }
            return (RutDigito);
        }
    
    /**
     * Sobreescribe el método toString para desplegar valores personalizados.
     */
    @Override
    public String toString() {
        return "Cédula: " + getCedula() + "\t" +
                "Nombre: " + getNombre() + "\t" +
                "Estado: " + getVigente();
    }
}

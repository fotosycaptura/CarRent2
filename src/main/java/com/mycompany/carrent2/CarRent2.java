/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.carrent2;

import java.util.GregorianCalendar;

/**
 *
 * @author Tom
 */
public class CarRent2 {

    public static void main(String[] args) {
        // GENERO UNA NUEVA INSTANCIA DE VEHÍCULO
        Vehiculo v = new Vehiculo("XX-YY-23", "KIA", "HGF", 2015);
        
        //Se genera una nueva instancia de un cliente
        //Por default el nuevo cliente está vigente
        Cliente c = new Cliente("12345678-5", "Juanito Perez");
        System.out.println(c);
        
        // GENERO UNA INSTANCIA DE FECHA 
        GregorianCalendar f = new GregorianCalendar();
        
        // DESCOMENTAR SI DESEA GATILLAR EL ERROR DE VALIDACIÓN DE CONDICIÓN
        // v.setCondicion('H');
        
        // GENERAMOS UNA NUEVA INSTANCIA DE ARRIENDO
        Arriendo a = new Arriendo(10, f, 5, v, c);
        System.out.println(a.getVehiculo().toString());
               
        // DESCOMENTAR SI DESEA GATILLAR LA VALIDACIÓN DEL ARRIENDO
        // SE INGREDA UN VEHÍCULO QUE NO ESTÉ DISPONIBLE
        // v.setCondicion('A');
        // new Arriendo(10, f, 5, v);
    }
}

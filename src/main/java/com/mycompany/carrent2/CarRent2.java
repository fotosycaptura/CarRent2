/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.carrent2;

import java.util.GregorianCalendar;

/**
 *
 * @author Tom
 * Modificado por integrantes del grupo 2:
 * Xavier Fuentes
 * Carlos Anch
 * Felipe González
 * Sebastian Lantadilla
 */
public class CarRent2 {

    public static void main(String[] args) {
        
        //*************************** Arriendo 1 de forma correcta con su vehículo y cliente respectivo********************
        Vehiculo v = new Vehiculo("XX-YY-23", "KIA", "HGF", 2015);
        System.out.println("Vehículo generado: " + v);
        //Se genera una nueva instancia de un cliente
        //Por defecto el nuevo cliente está vigente desde el constructor
        Cliente c = new Cliente("12345678-5", "Juanito Perez");
        System.out.println("Cliente generado: " + c);
        
        // GENERO UNA INSTANCIA DE FECHA 
        GregorianCalendar f = new GregorianCalendar();
        // DESCOMENTAR SI DESEA GATILLAR EL ERROR DE VALIDACIÓN DE CONDICIÓN
        // v.setCondicion('H');
        // GENERAMOS UNA NUEVA INSTANCIA DE ARRIENDO
        Arriendo a1 = new Arriendo(10, f, 5, v, c);
        //se ingresa el arriendo
        a1.IngresarArriendo();
        
        //*************************** Se realiza el proceso de devolución *************************************************
        //Se genera vehículo a devolver para la validación posterior
        Vehiculo autoDevuelto = new Vehiculo("XX-YY-23", "KIA", "HGF", 2015);
        
        /* Se genera la fecha de devolución. En un caso normal, esta fecha se debería de capturar del sistema o permitir el ingreso
        del usuario y en base a eso, se debería de calcular la cantidad de días transcurridos y ahí realizar el cálculo después para 
        el total a pagar.
        Como en esta tarea se agregó el número de días al momento de generar el arriendo, creo que lo lógico sería sumar esa cantidad de días 
        a la fecha actual para simular la fecha de devolución.
        */
        GregorianCalendar fechaDevolucion = new GregorianCalendar();
        fechaDevolucion.add(fechaDevolucion.DAY_OF_MONTH, a1.getDias());
        
        System.out.println("Fecha devolucion (Fecha actual más los días que indicó al generar el arriendo) :" + fechaDevolucion.getTime());
        
        //Se procede con la validación y si es correcto, la devolución.
        a1.generarDevolucion(autoDevuelto, fechaDevolucion);
        
        //Se genera el voucher o ticket
        a1.generarTicketDeArriendo();
        System.out.println("**********************************************************************************");
        
        //*************************** Arriendo 2 FALLIDO con su vehículo y/o cliente deshabilitado********************
        Vehiculo v2 = new Vehiculo("XX-YY-24", "Toyota", "CROSS", 2023);
        v2.setCondicion('M');
        System.out.println("Vehículo generado: " + v2);
        //Se genera una nueva instancia de un cliente
        //Por defecto el nuevo cliente está vigente desde el constructor
        Cliente c2 = new Cliente("22222222-2", "Jhon Titor 2");
        c2.DeshabilitarCliente();
        System.out.println("Cliente generado (deshabilitado): " + c2);
        Arriendo a2 = new Arriendo(11, f, 5, v2, c2);
        
        //Se ingresa el arriendo. O eso debería, pero se lanza una excepción porque el vehículo generado está en mantención. Línea 52
        //Además el cliente está deshabilitado línea 57
        a2.IngresarArriendo();
    }
}

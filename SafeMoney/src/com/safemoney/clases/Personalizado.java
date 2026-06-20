/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.safemoney.clases;


/**
 *
 * @author JOHANNA
 */
public class Personalizado extends Bolsillo implements EstadisticasBolsillo {


    public Personalizado() {
        super();
    }

    @Override
    public void agregarCantidad(double cantidadActual, double cantidadAgregar) {
        if (cantidadAgregar >= 0) {
            
            cantidadTotal = cantidadActual;    // se suma la cantidad a cantidad total 
            totalIngresado += cantidadAgregar;  // se suma para generar la estadistica de la interface 
            
        }
    }

    @Override
    public void retirarCantidad(double cantidadActual, double cantidadRetirar) {

        if (cantidadRetirar >= 0 && cantidadRetirar < this.cantidadTotal) {
            
            cantidadTotal = cantidadActual;   //le asigna la cantidad actual a cantidad total 
            totalRetirado += cantidadRetirar;  //se suma para generar la estadistica de la interface 

        }

    }

    @Override
    public double totalDineroIngreado() {
      return totalIngresado;
    }

    @Override
    public double totalDineroRetirado() {
       return  totalRetirado;
        
    }
    
    
}

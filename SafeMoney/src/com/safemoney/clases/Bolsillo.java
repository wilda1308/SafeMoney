package com.safemoney.clases;

// clase abstracta para la creacion de bolsillos


public abstract class Bolsillo {

    private String nombre, descripcion;
    public double cantidadTotal = 0, totalIngresado = 0, totalRetirado = 0; // variables que almacenan el historial de todo el dinero tanto ingresado como retirado 
  
    // se inicializa en 0 debido a que va a sumar y s

    // costructor con parametros
    public Bolsillo(){
    }
    
    public Bolsillo(String nombre, String descripcion, double cantidadTotal) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadTotal = cantidadTotal;

    }
    // getters y setters de cada atributo

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //Mostrar la cantidad total 
    public double getCantidad() {
        return cantidadTotal;
    }

//Metodos abstractos 
    
    public abstract void agregarCantidad(double cantidadActual, double cantidadAgregar);
     
    public abstract void retirarCantidad(double cantidadActual, double cantidadRetirar);

}

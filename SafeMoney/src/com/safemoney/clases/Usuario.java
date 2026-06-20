package com.safemoney.clases;

import java.util.ArrayList;

public class Usuario {
     
    //Atributos de Usuario
    private int idUsuario; //Identificador unico donde para cada usuario (objeto) es diferente
    private String nombre; //Nombre de cada usuario
    private int edad; //Edad de cada usuario
    private String correo; //Correo de cada usuario
    private String contraseña; //Contraseña de cada usuario.
    public AhorrosFijos ahorroFijo;
    public Servicios servicio;
    public GastosHormiga gastosHormiga;
    public GastosFijos gastosFijos;
    
    //Método constructor vacio para utilizar sus metodos y algunos atributos para luego asignarle un usuario ya existente.
    public Usuario(){
        
    }
    
    //Método constructor con los valores y asi establecerlos dentro de cada usuario que se vaya instanciando.
    public Usuario(int id, String nombre, int edad, String correo, String contraseña){
        this.idUsuario = id;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.contraseña = contraseña;
        
        ahorroFijo = new  AhorrosFijos("Ahorros Fijos", "", 0);
        servicio = new Servicios("Servicios", "", 0);
        gastosHormiga = new GastosHormiga("Gastos Hormiga", "", 0);
        gastosFijos = new GastosFijos("Gastos Fijos", "", 0);
    }
    
    //Metodos getters and setters

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    //Método Registrar si el usuario que se envia por argumentos no es nulo entonces lo registra en una lista de tipo ArrayList que se creo en Iniciar sesion.
    public void registrar(Usuario us, ArrayList usuarios){
        if(us != null){ //Valida que el usuario en parametros no sea nulo
            usuarios.add(us); //Registra o agrega el usuario a la lista.
        }
    }
    
    
    //Método iniciar Sesion donde recibimos parametros de nombre, correo, contraseña y el arrayList para encontrar al usuario que se va a Iniciar Sesion. Retorna un valor tipo usuario.
    public Usuario iniciarSesion(String nombre, String correo, String contraseña, ArrayList<Usuario> usuarios){
        //Creamos un nuevo Usuario nulo
        Usuario usuario = null;
        for(Usuario user : usuarios){ //Recorremos la lista con un foreach
            if(nombre.equals(user.nombre) || correo.equals(user.correo)){ //Validamos que el nombre que se recibe por parametros sea igual al usuario que se esta recorriendo
                //o el correo que se recibe por parametros sea igual al correo que se esta recorriendo.
                if (contraseña.equals(user.contraseña)) { //Validamos si la contraseña que se envia por parametros es igual a la contraseña del usuarioque se esta recorriendo
                    usuario = user; //Al usuario nulo le asignamos el usuario "encontrado"
                    break; //Salimos del for para que deje de recorrerlo
                }
            }
        }
        return usuario; //Retornamos el valor de usuario donde en Iniciar Sesion valida si encontro o no el usuario.
    }
    
}

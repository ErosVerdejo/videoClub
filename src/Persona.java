/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eros-
 */
public class Persona {
    private String nombre;
    private String rut;

    
    /*
     * Constructor de la clase Persona.
     * nombre el nombre de la persona
     * rut el RUT de la persona
     */
    public Persona(String nombre, String rut)
    {
        this.nombre = nombre;
        this.rut = rut;

    }
    public String getnombre(){
        return nombre;
    }
    public String getrut(){
        return rut;
    }
                
    public void setnombre(String nombre)
    {
        this.nombre =nombre; 
    }
    public void setrut(String rut)
    {
        this.rut =rut; 
    }

}


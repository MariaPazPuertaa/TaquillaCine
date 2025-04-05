/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.TaquillaCine.models;

/**
 *
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @since 01042025
 * @see 
 * @version 1.0.0
 */
public class Pelicula {
    
    /**
     * Es el costo base de la boleta para ver la película.
     */
    private double costoBase;
    /**
     * Es el nombre o título de la película.
     */
    private String titulo;

    /**
     * Constructor de la clase Pelicula
     * @param costoBase Es el costo base de la entrada para esta película.
     * @param titulo Es el título de la película.
     */
    public Pelicula(double costoBase, String titulo) {
        this.costoBase = costoBase;
        this.titulo = titulo;
    }

    /**
     * Obtiene el costo base de la película.
     * @return Retorna el valor actual del costo base de la película.
     */
    public double getCostoBase() {
        return costoBase;
    }

    /**
     * Establece o modifica el costo base de la película.
     * @param costoBase Es el nuevo valor que se asignará como costo base.
     */
    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    /**
     * Obtiene el título de la película.
     * @return Retorna el título actual de la película.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece o modifica el título de la película.
     * @param titulo Es el nuevo título que se asignará a la película.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}

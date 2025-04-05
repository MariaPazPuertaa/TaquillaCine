/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.TaquillaCine.models;

/**
 *
 * @author Maria Paz Puerta Acevedo <mariaáp.puertaa@autonoma.edu.co>
 * @since 20250401
 * @version 1.0.0
 * 
 */
public abstract class Funcion {
    /**
     * Porcentaje de descuento que se aplica.
     */
    private float porcentajeDescuento;
     private Pelicula pelicula;


    /**
     * Constructor de la clase Funcion
     * @param porcentajeDescuento Es el porcentaje de descuento que se desea aplicar a el precio de la boleta.
     * @param pelicula
     */
    public Funcion(float porcentajeDescuento, Pelicula pelicula) {
        this.porcentajeDescuento = porcentajeDescuento;
        this.pelicula = pelicula;
    }

    /**
     * Obtiene el porcentaje de descuento actual.
     * @return Retorna el porcentaje de descuento como un valor flotante.
     */
    public float getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    /**
     * Establece un nuevo valor para el porcentaje de descuento.
     * @param porcentajeDescuento Retorna el nuevo porcentaje de descuento a aplicar.
     */
    public void setPorcentajeDescuento(float porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
    
    
    /**
     * Método abstracto que debe ser implementado por las subclases para calcular el porcentaje de 
     * descuento a un precio base.
     * @param precioBase Es el precio base que se tiene antes de aplicar el descuento.
     * @return Retorna el valor del descuento aplicado sobre el precio base.
     */
    public abstract double calcularPorcentajeDescuento(double precioBase);
}

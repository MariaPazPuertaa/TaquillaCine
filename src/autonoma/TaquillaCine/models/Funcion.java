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
    
    /**
     * Película asociada a la función.
     */
    private Pelicula pelicula;


    /**
     * Constructor de la clase Funcion
     * @param porcentajeDescuento Es el porcentaje de descuento que se desea aplicar a el precio de la boleta.
     * @param pelicula Es el objeto de tipo Pelicula que será proyectado en esta función.
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

    /**
     * Obtiene la película asociada a esta función.
     * @return Retorna un objeto de tipo Pelicula.
     */
    public Pelicula getPelicula() {
        return pelicula;
    }

    /**
     * Establece una película a esta función.
     * @param pelicula Es la pelicula Película que se va a asociar a la función.
     */
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
    

       public abstract String getDescripcion();

    /**
     * Devuelve una representación en forma de cadena de la función.
     * @return Retorna una cadena que representa la función, incluyendo el título de la película.
     */
}

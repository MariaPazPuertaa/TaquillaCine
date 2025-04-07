/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.TaquillaCine.models;

/**
 *
 * @author Maria Paz Puerta Acevedo <mariaáp.puertaa@autonoma.edu.co>
 * @since 20250104
 * @version 1.0.0
 * 
 */
public class PrimerFuncion extends Funcion {

    /**
     * Es el constructor de la subclase Primera Función, con un descuento fijo del 50%.
     * @param pelicula Es la película que se proyectará en la PrimerFuncion.
     */
    public PrimerFuncion(Pelicula pelicula) {
        super(0.50f,pelicula);
    }

    /**
     * Calcula el valor del descuento que se aplicará sobre el precio base.
     * @param precioBase Es el precio base de la boleta.
     * @return Retorna el monto del descuento aplicado a la boleta.
     */
    @Override
    public double calcularPorcentajeDescuento(double precioBase) {
        return precioBase * getPorcentajeDescuento();
    } 
}

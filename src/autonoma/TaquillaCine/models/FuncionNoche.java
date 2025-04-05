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
public class FuncionNoche extends Funcion {
    
    /**
     * Constructor de la subclase FuncionTarde, con un descuento fijo del 0%
     * @param pelicula
     * @param descuento 
     */
     public FuncionNoche(Pelicula pelicula) {    
        super(0.0f, pelicula); 
    }

    /**
     * Calcula el descuento aplicable al precio base de la boleta.
     * 
     * @param precioBase Precio original de la boleta.
     * @return Monto del descuento.
     */
    @Override
    public double calcularPorcentajeDescuento(double precioBase) {
        return precioBase * getPorcentajeDescuento(); 
    }
}

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
public class FuncionTarde extends Funcion {

    /**
     * Constructor de la subclase FuncionTarde, con un descuento fijo del 10%
     * @param porcentajeDescuento Es el valor del porcentaje de descuento. 
     */
    public FuncionTarde(float porcentajeDescuento) {
        super(0.10f);
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

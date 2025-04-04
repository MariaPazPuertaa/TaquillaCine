/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.TaquillaCine.models;

/**
 *
 * @author Maria Paz Puerta Acevedo <mariaáp.puertaa@autonoma.edu.co>
 * @since 20250331
 * @version 1.0.0
 * 
 */
public class FuncionTarde extends Funcion {

    /**
     * 
     * @param porcentajeDescuento 
     */
    public FuncionTarde(float porcentajeDescuento) {
        super(0.10f);
    }

    /**
     * 
     * @param precioBase
     * @return 
     */
    @Override
    public double calcularPorcentajeDescuento(double precioBase) {
        return precioBase * getPorcentajeDescuento();
    }
    
}

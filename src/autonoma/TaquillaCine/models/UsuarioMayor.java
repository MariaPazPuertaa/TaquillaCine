/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.TaquillaCine.models;

import autonoma.TaquillaCine.exceptions.PrecioInvalidoException;

/**
 *
 * 
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @since 01042025
 * @see 
 * @version 1.0.0
 */
public class UsuarioMayor extends Usuario {

    /**
     * Constructor de la subclase UsuarioMayor
     * @param nombre Es el nombre del usuario.
     * @param telefono Es el teléfono del usuario.
     */
    public UsuarioMayor(String nombre, String telefono) {
        super(nombre, telefono, 1000);
    }

    
   /**
     * Calcula el precio final aplicando un descuento fijo al precio base de la boleta.
     * Si el resultado es negativo, lanza una excepción
     *
     * @param precioBase Es el precio original antes de aplicar el descuento.
     * @return El precio final luego de aplicar el descuento.
     * @throws PrecioInvalidoException si el precio final resulta ser menor que cero, se lanza está excepción.
     */
    @Override
    public double calcularDescuentoFinal(double precioBase) {
        double precioFinal = precioBase - valorDescuento;
        if (precioFinal < 0) {
            throw new PrecioInvalidoException();
        }
        return precioFinal;
    }
}

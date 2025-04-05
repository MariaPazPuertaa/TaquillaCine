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

    public UsuarioMayor(String nombre, String telefono) {
        super(nombre, telefono, 1000);
    }

    

  @Override
    public double calcularDescuentoFinal(double precioBase) {
        double precioFinal = precioBase - valorDescuento;
        if (precioFinal < 0) {
            throw new PrecioInvalidoException();
        }
        return precioFinal;
    }
}

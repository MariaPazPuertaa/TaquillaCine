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
 * 
 */
public class UsuarioNino  extends Usuario{

    public UsuarioNino(String nombre, String telefono) {
        super(nombre, telefono, 500);
    }

    @Override
    public double calcularDescuentoFinal(Pelicula pelicula) {
        return pelicula.getCostoBase() -this.getValorDescuento();
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.TaquillaCine.models;

import autonoma.TaquillaCine.exceptions.PrecioInvalidoException;

/**
 *
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @since 01042025
 * @see 
 * @version 1.0.0
 */
public abstract class Usuario {
    
    /**
     * Nombre de el usuario.
     */
    String nombre;
    
    /**
     * Teléfono del usuario.
     */
    String telefono;
    
    /**
     * Valor del descuento que se le aplicará dependiendo de la función.
     */
    double valorDescuento;

    /**
     * Constructor de la clase Usuario.
     * @param nombre Es el nombre del usuario.
     * @param telefono Es el teléfono del usuario.
     * @param valorDescuento Es el valor del descuento de la boleta a pagar.
     */
    public Usuario(String nombre, String telefono, double valorDescuento) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.valorDescuento = valorDescuento;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return Retorna el nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nombre para el usuario.
     * @param nombre Nuevo nombre que se asignará al usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de teléfono del usuario.
     * @return Retorna el teléfono del usuario.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece un nuevo número de teléfono para el usuario.
     * @param telefono Nuevo número de contacto.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el valor del descuento base del usuario.
     * @return Retorna el valor del descuento.
     */
    public double getValorDescuento() {
        return valorDescuento;
    }

    /**
     * Establece un nuevo valor de descuento para el usuario.
     * @param valorDescuento Nuevo valor del descuento.
     */
    public void setValorDescuento(double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }
 
            
    /**
     * Método abstracto para calcular el precio final con descuento.
     * Si el precio es menor a $0, lanza una excepción.
     * @param precioBase Precio original de la boleta.
     * @return Precio con descuento aplicado.
     * @throws PrecioInvalidoException Si el precio es menor a $0.
     */
    public abstract double calcularDescuentoFinal(double precioBase) throws PrecioInvalidoException;

    
}

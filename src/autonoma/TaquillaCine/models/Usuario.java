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
    
    String nombre;
    String telefono;
    double valorDescuento;

    public Usuario(String nombre, String telefono, double valorDescuento) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.valorDescuento = valorDescuento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getValorDescuento() {
        return valorDescuento;
    }

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

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
 */
public class Boleta {
    /**
     * Es el precioFinal de la boleta luego de aplicar todos los descuentos respectivos.
     */
    private float precioFinal;
    /**
     * Es el precioBase de la boleta.
     */
    private float precioBase;

   /**
    * Constructor de la clase Boleta
    * @param precioFinal Es el precio final de la boleta luego de aplicar los descuentos respectivos.
    * @param precioBase Es el precio base de la boleta.
    */
    public Boleta(float precioFinal, float precioBase) {
        this.precioFinal = precioFinal;
        this.precioBase = precioBase;
    }

    /**
     * Obtiene el precio final de la boleta.
     * @return Precio final con el descuento aplicado.
     */
    public float getPrecioFinal() {
        return precioFinal;
    }

    /**
     * Establece el precio final de la boleta.
     * @param precioFinal Es el valor final a establecer para la boleta.
     */
    public void setPrecioFinal(float precioFinal) {
        this.precioFinal = precioFinal;
    }

    /**
     * Obtiene el precio base de la boleta (sin descuento).
     * @return Es el precio base de la boleta.
     */
    public float getPrecioBase() {
        return precioBase;
    }

    /**
     * Establece el precio base de la boleta.
     * @param precioBase Es el precio original de la boleta sin descuento.
     */
    public void setPrecioBase(float precioBase) {
        this.precioBase = precioBase;
    }

    /**
     * Calcula y actualiza el precio final de la boleta a partir del precio base
     * y el descuento proporcionado por la función.
     *
     * @param precioBase Es el precio original sin descuento.
     * @param funcion Es el objeto de tipo Funcion que define el descuento a aplicar.
     */
    public void calcularPrecioFinal(float precioBase, Funcion funcion) {
        double descuento = funcion.calcularPorcentajeDescuento(precioBase);
        this.precioFinal = (float)(precioBase - descuento);
    }
}
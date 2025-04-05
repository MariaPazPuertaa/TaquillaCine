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
     * Usuario que compra la boleta.
     */
    private Usuario usuario;

    /**
     * Función de cine a la que corresponde esta boleta.
     */
    private Funcion funcion;

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
    * @param usuario
    * @param funcion
    * @param precioBase Es el precio base de la boleta.
    */
    public Boleta(Usuario usuario, Funcion funcion) {
        this.usuario = usuario;
        this.funcion = funcion;
        this.precioBase = (float) funcion.getPelicula().getCostoBase();
        // Calculamos el precio final en el momento de la creación de la boleta
        calcularPrecioFinal();
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
     * Obtiene el usuario asociado a esta boleta.
     * @return Retorna el objeto usuario actual.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario asociado a esta boleta.
     * @param usuario Retorna el objeto Usuario que se desea asignar.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la función (película en cartelera) relacionada con esta boleta.
     * @return Retorna el objeto Funcion actual.
     */
    public Funcion getFuncion() {
        return funcion;
    }

    /**
     * Establece la función (película en cartelera) relacionada con esta boleta.
     * @param funcion Retorna el objeto Funcion que se desea asignar.
     */
    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }
    

    /**
     * Calcula y actualiza el precio final de la boleta a partir del precio base
     * y el descuento proporcionado por la función.
     *

     * @throws IllegalArgumentException Se lanzará está excepción cuando el precio final sea negativo.
     */
    public float calcularPrecioFinal() {
    // Calcular el descuento por función
    double descuentoFuncion = funcion.calcularPorcentajeDescuento(precioBase);
    double precioConDescuentoFuncion = precioBase - descuentoFuncion;

    // Calcular el descuento por usuario
    double precioFinalConUsuario = usuario.calcularDescuentoFinal(precioConDescuentoFuncion);

    // Verificar que el precio final no sea negativo
    if (precioFinalConUsuario < 0) {
        throw new IllegalArgumentException("El precio final no puede ser negativo.");
    }

    // Establecer el precio final de la boleta
    this.precioFinal = (float) precioFinalConUsuario;

    // Retornar el precio final calculado
    return this.precioFinal;
}

}
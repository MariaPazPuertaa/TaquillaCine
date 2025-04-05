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
    * @param precioFinal Es el precio final de la boleta luego de aplicar los descuentos respectivos.
    * @param precioBase Es el precio base de la boleta.
    */
    public Boleta(Usuario usuario, Funcion funcion, float precioFinal) {     
        this.usuario = usuario;
        this.funcion = funcion;
        this.precioFinal = precioFinal;
        this.precioBase = (float) funcion.getPelicula().getCostoBase();
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
     */
    public float calcularPrecioFinal() {
    
        double precioBase = funcion.getPelicula().getCostoBase();

      
        double descuentoFuncion = funcion.calcularPorcentajeDescuento(precioBase);
        double precioConDescuentoFuncion = precioBase - descuentoFuncion;

        
        double descuentoUsuario = usuario.calcularDescuentoFinal(precioConDescuentoFuncion);

       
        this.precioFinal = (float) (precioConDescuentoFuncion - descuentoUsuario);

        if (this.precioFinal < 0) this.precioFinal = 0; 

        return precioFinal;
    }
}
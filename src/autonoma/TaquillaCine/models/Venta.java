/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.TaquillaCine.models;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @since 01042025
 * @see 
 * @version 1.0.0
 */


public class Venta {

    /**
     * Lista de boletas vendidas en esta venta.
     */
    private ArrayList<Boleta> boletas;

    /**
     * Total acumulado de la venta (suma de precios finales de las boletas).
     */
    private float totalVenta;
    private LocalDate fecha;

    /**
     * Constructor de la clase Venta. Inicializa la lista de boletas y el total en 0.
     */
    public Venta() {
        this.boletas = new ArrayList<>();
        this.totalVenta = 0;
        this.fecha = LocalDate.now();
    }

    /**
     * Retorna la lista de boletas asociadas a esta venta.
     * 
     * @return Lista de boletas
     */
    public ArrayList<Boleta> getBoletas() {
        return boletas;
    }

    /**
     * Agrega una boleta a la venta y actualiza el total de la venta.
     * 
     * @param boleta Boleta a agregar
     */
    public void agregarBoleta(Boleta boleta) {
        this.boletas.add(boleta);
        this.totalVenta += boleta.getPrecioFinal();
    }

    /**
     * Retorna el total de la venta.
     * 
     * @return Total de la venta
     */
    public float getTotalVenta() {
        return totalVenta;
    }

    /**
     * Permite establecer manualmente el total de la venta.
     * 
     * @param totalVenta Total a establecer
     */
    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }

    /**
     * Calcula y actualiza el total de la venta sumando el precio final de cada boleta.
     * 
     * @return Total calculado de la venta
     */
    public float calcularTotal() {
        float total = 0;
        for (Boleta boleta : boletas) {
            total += boleta.getPrecioFinal();
        }
        this.totalVenta = total;
        return total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
    /**
     * Genera una factura en formato de texto con los detalles de cada boleta.
     * Incluye nombre del cliente, película y precio final de cada boleta.
     * 
     * @return Cadena de texto representando la factura
     */
    public String generarFactura() {
    String factura = "===== FACTURA DE VENTA =====\n";
    System.out.println("Fecha: " + fecha);

    for (Boleta boleta : boletas) {
        double precioBase = boleta.getFuncion().getPelicula().getCostoBase();

       
        double descuentoFuncion = boleta.getFuncion().calcularPorcentajeDescuento(precioBase);
        double precioConDescuentoFuncion = precioBase - descuentoFuncion;

        double precioFinal = boleta.getPrecioFinal();
        double descuentoUsuario = precioConDescuentoFuncion - precioFinal;

        factura += "Pelicula: " + boleta.getFuncion().getPelicula().getTitulo() + "\n";
        factura += "Cliente: " + boleta.getUsuario().getNombre() + "\n";
        factura += "Precio original: $" + precioBase + "\n";
        factura += "Descuento por funcion: $" + descuentoFuncion + "\n";
        factura += "Descuento por tipo de usuario: $" + descuentoUsuario + "\n";
        factura += "Precio final: $" + precioFinal + "\n";
        factura += "----------------------------\n";
    }

    factura += "TOTAL VENTA: $" + calcularTotal() + "\n";
    factura += "============================\n";

    return factura;
}
}
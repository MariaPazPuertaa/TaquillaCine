package autonoma.TaquillaCine.models;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Clase que representa un cine con su cartelera, funciones, usuarios y ventas.
 * 
 * Permite la gestión de películas, funciones y usuarios, así como la venta de boletas
 * y la generación de facturas.
 * 
 * @author Heily Yohana Rios Ayala<heilyy.riosa@autonoma.edu.co>
 * @author Maria Paz Puerta Acevedo <mariap.puertaa@autonoma.edu.co>
 * @since 01042025
 * @version 1.0.0
 */
public class Cine {

    /**
     * Cartelera que contiene las funciones y películas disponibles en el cine.
     */
    private Cartelera cartelera;

    /**
     * Lista de ventas realizadas en el cine.
     */
    private ArrayList<Venta> ventas;

    /**
     * Lista de usuarios registrados en el sistema del cine.
     */
    private ArrayList<Usuario> usuarios;

    private double totalVentas;

    private ArrayList<Funcion> funciones;

    // Constructor por defecto
    /**
     * Constructor por defecto. 
     * Se inicializan la cartelera vacía y listas de ventas y usuarios.
     */
    public Cine() {
        this.cartelera = new Cartelera();
        this.ventas = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.funciones = new ArrayList<>();
        this.totalVentas = 0.0; 
    }

    


    public Cartelera getCartelera() {
        return cartelera;
    }

    public void setCartelera(Cartelera cartelera) {
        this.cartelera = cartelera;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }

    /**
     * Agrega un usuario a la lista de usuarios registrados.
     * @param usuario El Usuario que se desea agregar.
     * @return Mensaje de confirmación de que el usuario fue agregado exitosamente. 
     */
    public String agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        return "Usuario agregado correctamente.";
    }

    /**
     * Elimina un usuario de la lista de registrados.
     * @param usuario Es el Usuario a eliminar.
     * @return Mensaje de confirmación de que el usuario fue eliminado exitosamente.
     * @throws NoSuchElementException Se lanza la excepción si el usuario no se encuentra en la lista.
     */
    public String eliminarUsuario(Usuario usuario) {
        if (usuarios.remove(usuario)) {
            return "Usuario eliminado correctamente.";
        } else {
            throw new NoSuchElementException("El usuario no existe.");
        }
    }

    /**
     * Muestra por consola la lista de usuarios registrados.
     */
    public void mostrarUsuarios() {
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }

    /**
     * Agrega una nueva película a la cartelera del cine.
     * @param pelicula Es la Película que se desea agregar.
     */
    public void agregarPelicula(Pelicula pelicula) {
        cartelera.crearPelicula(pelicula);
    }

    /**
     * Elimina una película de la cartelera.
     * @param pelicula Es la Película que se desea eliminar.
     */
    public void eliminarPelicula(Pelicula pelicula) {
        cartelera.eliminarPelicula(pelicula.getTitulo());
    }

    /**
     * Muestra las películas disponibles en la cartelera.
     */
    public void mostrarPeliculas() {
        cartelera.mostrarPeliculas();
    }

    /**
     * Actualiza los datos de una película existente en la cartelera.
     * @param tituloOriginal Es el título original de la película que se desea actualizar.
     * @param nuevaPelicula Es un objeto de tipo Pelicula que contiene los nuevos datos que reemplazarán a los de la película existente.
     */
    public void actualizarPelicula(String tituloOriginal, Pelicula nuevaPelicula){
         cartelera.actualizarPelicula(tituloOriginal, nuevaPelicula);
    }
    
    /**
     * Agrega una función (proyección de película) a la cartelera.
     * @param funcion Es la Función que se desea agregar.
     * @return 
     */
    public String agregarFuncion(Funcion funcion) {
        funciones.add(funcion);
        return "Se agrego correctamente la funcion.";
    }

    /**
     * Elimina una función de la lista.
     * @param funcion Es la Función a eliminar.
     * @return Mensaje de confirmación o excepción si no existe.
     */
    public String eliminarFuncion(Funcion funcion) {
        if (funciones.remove(funcion)) {
            return "Funcion eliminada correctamente.";
        } else {
            throw new NoSuchElementException("La funcion no existe.");
        }
    }

    /**
     * Muestra todas las funciones registradas.
     */
    public void mostrarFunciones() {
        for (Funcion f : funciones) {
            System.out.println(f);
        }
    }

    /**
     * Vende una boleta a un usuario para una función específica.
     * Calcula los descuentos aplicables y registra la venta.
     * @param usuario Es el Usuario que realiza la compra.
     * @param funcion Es la Función a la que asistirá.
     * @return Mensaje de confirmación con el valor final pagado.
     */
    public String venderBoleta(Usuario usuario, Funcion funcion) {
        double precioBase = funcion.getPelicula().getCostoBase();
        double descuentoFuncion = funcion.calcularPorcentajeDescuento(precioBase);
        double precioConDescuentoFuncion = precioBase - descuentoFuncion;
        double precioFinal = usuario.calcularDescuentoFinal(precioConDescuentoFuncion);

        if (precioFinal < 0) precioFinal = 0;

        Boleta boleta = new Boleta(usuario, funcion);       
        boleta.calcularPrecioFinal();

        Venta venta = new Venta();
        venta.agregarBoleta(boleta);

        ventas.add(venta);
        totalVentas += precioFinal;

        return "Boleta vendida a " + usuario.getNombre() + " por $" + boleta.getPrecioFinal();
    }

    /**
     * Genera y muestra por consola las facturas de todas las ventas realizadas.
     */
    public void generarFacturas() {
        double totalVenta = calcularTotalGeneralDeBoletas();
        for (Venta venta : ventas) {
            System.out.println(venta.generarFactura());
        }
        System.out.println("===========================================");
        System.out.println("TOTAL GENERAL DE TODAS LAS VENTAS: $" + totalVenta);
        System.out.println("===========================================\n");
    }

    /**
     * Calcula el total de todas las boletas vendidas en todas las ventas.
     * @return Retorna el total general de las boletas.
     */
    public double calcularTotalGeneralDeBoletas() {
        double total = 0.0;
        for (Venta venta : ventas) {
            for (Boleta boleta : venta.getBoletas()) {
                total += boleta.getPrecioFinal();
            }
        }
        return total;
    }
}

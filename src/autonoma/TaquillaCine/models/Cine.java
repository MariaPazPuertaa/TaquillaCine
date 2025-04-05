package autonoma.TaquillaCine.models;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @since 01042025
 * @see 
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

    // Constructor por defecto
    /**
     * Constructor por defecto. 
     * Se inicializan la cartelera vacía y listas de ventas y usuarios.
     */
    public Cine() {
        this.cartelera = new Cartelera();
        this.ventas = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.totalVentas = 0.0; 
    }

    // Constructor con parámetros
    /**
     * Constructor con parámetros para inicializar el cine con datos específicos.
     * @param cartelera Es la cartelera del cine.
     * @param ventas Es la lista de ventas realizadas.
     * @param usuarios Es la lista de usuarios registrados. 
     */
    public Cine(Cartelera cartelera, ArrayList<Venta> ventas, ArrayList<Usuario> usuarios) {
        this.cartelera = cartelera;
        this.ventas = ventas;
        this.usuarios = usuarios;
    }

    // Getters y setters
    /**
     * Obtiene la cartelera actual del cine.
     * @return Retorna la cartelera del cine. 
     */
    public Cartelera getCartelera() {
        return cartelera;
    }

    /**
     * Establece una nueva cartelera para el cine.
     * @param cartelera Es la nueva cartelera a establecer. 
     */
    public void setCartelera(Cartelera cartelera) {
        this.cartelera = cartelera;
    }

    /**
     * Obtiene la lista de ventas registradas.
     * @return Retorna la lista de objetos de Venta.
     */
    public ArrayList<Venta> getVentas() {
        return ventas;
    }


    /**
     * Establece una nueva lista de ventas.
     * @param ventas Es la lista de ventas a establecer.
     */
    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

    /**
     * Obtiene la lista de usuarios registrados.
     * @return Retorna la lista de objetos de Usuario.
     */
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Establece una nueva lista de usuarios.
     * @param usuarios Es la lista de usuarios a establecer.
     */
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
     * 
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
     * Agrega una función (proyección de película) a la cartelera.
     * @param funcion Es la Función que se desea agregar.
     */
    public void agregarFuncion(Funcion funcion) {
        cartelera.agregarFuncion(funcion);
    }

    /**
     * Vende una boleta a un usuario para una función específica.
     * Calcula los descuentos aplicables y registra la venta.
     * 
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
        for (Venta venta : ventas) {
            System.out.println(venta.generarFactura());
        }
    }
}


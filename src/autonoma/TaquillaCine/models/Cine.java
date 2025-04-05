package autonoma.TaquillaCine.models;


/**
 *
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @since 01042025
 * @see 
 * @version 1.0.0
 */

import java.util.ArrayList;
import java.util.NoSuchElementException;




public class Cine {

    private Cartelera cartelera;
    private ArrayList<Venta> ventas;
    private ArrayList<Usuario> usuarios;

    // Constructor por defecto
    public Cine() {
        this.cartelera = new Cartelera();
        this.ventas = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    // Constructor con parámetros
    public Cine(Cartelera cartelera, ArrayList<Venta> ventas, ArrayList<Usuario> usuarios) {
        this.cartelera = cartelera;
        this.ventas = ventas;
        this.usuarios = usuarios;
    }

    // Getters y setters
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

    // Agregar usuario
    public String agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        return "Usuario agregado correctamente.";
    }

    // Eliminar usuario
    public String eliminarUsuario(Usuario usuario) {
        if (usuarios.remove(usuario)) {
            return "Usuario eliminado correctamente.";
        } else {
            throw new NoSuchElementException("El usuario no existe.");
        }
    }

    // Mostrar usuarios registrados
    public void mostrarUsuarios() {
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }

    // Delegar manejo de películas a la cartelera
    public void agregarPelicula(Pelicula pelicula) {
        cartelera.crearPelicula(pelicula);
    }

    public void eliminarPelicula(Pelicula pelicula) {
        cartelera.eliminarPelicula(pelicula.getTitulo());
    }

    public void mostrarPeliculas() {
        cartelera.mostrarPeliculas();
    }

    
    public void agregarFuncion(Funcion funcion) {
        cartelera.agregarFuncion(funcion);
    }

    
   public String venderBoleta(Usuario usuario, Funcion funcion) {
    double precioBase = funcion.getPelicula().getCostoBase();
    double descuentoUsuario = usuario.calcularDescuentoFinal(precioBase);
    double descuentoFuncion = funcion.calcularPorcentajeDescuento(precioBase);
    double precioFinal = precioBase - descuentoUsuario - descuentoFuncion;

    if (precioFinal < 0) precioFinal = 0;

    Boleta boleta = new Boleta(usuario, funcion, (float) precioFinal);

    Venta venta = new Venta();
    venta.agregarBoleta(boleta);

    ventas.add(venta);

    return "Boleta vendida a " + usuario.getNombre() + " por $" + precioFinal;
}


    public void generarFacturas() {
        for (Venta venta : ventas) {
            venta.generarFactura();
        }
    }
}
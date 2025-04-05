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
    private ArrayList <Venta> ventas;
    private ArrayList<Usuario> usuarios;

     // Constructor vacío
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

    public Cartelera getCartelera() {
        return cartelera;
    }

    public void setCartelera(Cartelera cartelera) {
        this.cartelera = cartelera;
    }

    public ArrayList<Venta> getVenta() {
        return ventas;
    }

    public void setVenta(ArrayList<Venta> venta) {
        this.ventas = venta;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    

  

    /**
     * Agrega un usuario a la lista del cine.
     * @param usuario Usuario a agregar
     * @return 
     */
    public String agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        return "Usuario agregado correctamente.";
    }

    /**
     * Elimina un usuario de la lista si existe.
     * @param usuario Usuario a eliminar
     * @return 
     */
    
    public String eliminarUsuario(Usuario usuario) {
    if (usuarios.remove(usuario)) {
        return "Usuario eliminado correctamente.";
    } else {
        throw new NoSuchElementException("El usuario no existe.");
    }
} 
    
    public void mostrarUsuario(){
        
    }
    public String venderBoleta(Usuario usuario, Funcion funcion, String fecha) {
    Venta nuevaVenta = new Venta();
    nuevaVenta.calcularTotal();

    if (nuevaVenta.getTotalVenta() < 0) {
        return "Error: El valor de la boleta no puede ser negativo.";
    }

    this.ventas.add(nuevaVenta);
    return " Boleta vendida a " + usuario.getNombre() + " por $" + nuevaVenta.getTotalVenta();
}
    public void generarFactura(){
        
    }
}

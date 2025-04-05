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
    private ArrayList <Venta> venta;
    private ArrayList<Usuario> usuarios;

    public Cine() {
        this.cartelera = cartelera;
        this.venta = venta;
        this.usuarios = usuarios;
    }

    public Cartelera getCartelera() {
        return cartelera;
    }

    public void setCartelera(Cartelera cartelera) {
        this.cartelera = cartelera;
    }

    public ArrayList<Venta> getVenta() {
        return venta;
    }

    public void setVenta(ArrayList<Venta> venta) {
        this.venta = venta;
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
    public String venderBoleta(){
        
    
        
    }
    
    public void generarFactura(){
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package autonoma.TaquillaCine.main;

import autonoma.TaquillaCine.models.Cartelera;
import autonoma.TaquillaCine.models.Cine;
import autonoma.TaquillaCine.models.Funcion;
import autonoma.TaquillaCine.models.FuncionNoche;
import autonoma.TaquillaCine.models.FuncionTarde;
import autonoma.TaquillaCine.models.Pelicula;
import autonoma.TaquillaCine.models.Usuario;
import autonoma.TaquillaCine.models.UsuarioAdulto;
import autonoma.TaquillaCine.models.UsuarioMayor;
import autonoma.TaquillaCine.models.UsuarioNino;

/**
 *
 * @author USUARIO
 */
public class TaquillaCine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      
        Usuario usuario1 = new UsuarioNino("Heily", "3244");
        Usuario usuario2 = new UsuarioAdulto("Maria", "6799");
        Usuario usuario3 = new UsuarioMayor("Mateo", "1292");

        // Crear películas
        Pelicula pelicula1 = new Pelicula(3000, "Avengers: Endgame");
        Pelicula pelicula2 = new Pelicula(5000, "Avatar 2");

        
        Funcion funcion1 = new FuncionNoche( 500);  
        Funcion funcion2 = new FuncionTarde(pelicula2, 1000); // Martes tiene descuento de $1000

        // Crear cartelera y agregar funciones
        Cartelera cartelera = new Cartelera();
        cartelera.agregarFuncion(funcion1);
        cartelera.agregarFuncion(funcion2);

        // Crear listas vacías para ventas y usuarios y pasarlas al cine
        ArrayList<Venta> ventas = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Cine cine = new Cine(cartelera, ventas, usuarios);

        // Agregar usuarios al cine
        cine.agregarUsuario(usuario1);
        cine.agregarUsuario(usuario2);
        cine.agregarUsuario(usuario3);

        // Simular venta de boletas
        Venta venta1 = new Venta();
        venta1.venderBoleta(usuario1, funcion1);  // Niño
        venta1.venderBoleta(usuario2, funcion2);  // Adulto
        venta1.venderBoleta(usuario3, funcion1);  // Adulto mayor

        // Agregar la venta al cine
        cine.getVenta().add(venta1);

        // Mostrar resumen
        System.out.println("Factura generada:");
        venta1.generarFactura();
    }
    
    
}

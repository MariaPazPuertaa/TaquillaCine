/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package autonoma.TaquillaCine.main;

import autonoma.TaquillaCine.models.Cine;
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
        
        Usuario usuario1 = new UsuarioNino();
        Usuario usuario2 = new UsuarioAdulto();
        Usuario usuario3 = new UsuarioMayor();
       
        Pelicula pelicula1 = new Pelicula(3000,"Avengers: Endgame");
        Pelicula pelicula2 = new Pelicula(5000,"Avengers: Endgame");
      
        Cine cine = new Cine();
        cine.agregarUsuario(usuario1);
        cine.agregarUsuario(usuario2);
        cine.agregarUsuario(usuario3);
       
        System.out.println("Precio final Usuario Niño: $" + usuario1.calcularDescuentoFinal(pelicula1));
        System.out.println("Precio final Usuario Adulto: $" + usuario2.calcularDescuentoFinal(pelicula2));
        System.out.println("Precio final Usuario Adulto: $" + usuario3.calcularDescuentoFinal(pelicula1));
        
    }
    
    
}

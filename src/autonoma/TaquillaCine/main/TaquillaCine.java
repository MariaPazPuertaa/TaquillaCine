package autonoma.TaquillaCine.main;

import autonoma.TaquillaCine.models.Cine;
import autonoma.TaquillaCine.models.Funcion;
import autonoma.TaquillaCine.models.FuncionNoche;
import autonoma.TaquillaCine.models.FuncionTarde;
import autonoma.TaquillaCine.models.Pelicula;
import autonoma.TaquillaCine.models.PrimerFuncion;
import autonoma.TaquillaCine.models.Usuario;
import autonoma.TaquillaCine.models.UsuarioAdulto;
import autonoma.TaquillaCine.models.UsuarioMayor;
import autonoma.TaquillaCine.models.UsuarioNino;

/**
 * Clase principal que ejecuta la lógica de prueba para el sistema de taquilla del cine.
 * 
 * @author Heily Yohana Rios Ayala<heilyy.riosa@autonoma.edu.co>
 * @author Maria Paz Puerta Acevedo <mariaáp.puertaa@autonoma.edu.co>
 * @since 20250401
 * @version 1.0.0
 */
public class TaquillaCine {

    public static void main(String[] args) {

      
        Usuario usuario1 = new UsuarioNino("Heily", "3244");
        Usuario usuario2 = new UsuarioAdulto("Maria", "6799");
        Usuario usuario3 = new UsuarioMayor("Mateo", "1292");

      
        Pelicula pelicula1 = new Pelicula(3000, "Avengers");
        Pelicula pelicula2 = new Pelicula(6000, "Avatar 2");

     
        Funcion funcion1 = new FuncionNoche(pelicula1);
        Funcion funcion2 = new FuncionTarde(pelicula2);
        Funcion funcion3 = new PrimerFuncion(pelicula2); 

      
        Cine cine = new Cine();

       
        cine.agregarFuncion(funcion1);
        cine.agregarFuncion(funcion2);
        cine.agregarFuncion(funcion3);

     
        cine.agregarUsuario(usuario1);
        cine.agregarUsuario(usuario2);
        cine.agregarUsuario(usuario3);

        
        cine.venderBoleta(usuario1, funcion1);
        cine.venderBoleta(usuario2, funcion2);
        cine.venderBoleta(usuario3, funcion3);

      
        cine.generarFacturas();
    }
}

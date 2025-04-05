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
import autonoma.TaquillaCine.models.Venta;
import java.util.ArrayList;

/**
 *
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @since 01042025
 * @see 
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

        Cartelera cartelera = new Cartelera();
        cartelera.agregarFuncion(funcion1);
        cartelera.agregarFuncion(funcion2);

        ArrayList<Usuario> usuarios = new ArrayList<>();
        Cine cine = new Cine(cartelera, new ArrayList<>(), usuarios);

        cine.agregarUsuario(usuario1);
        cine.agregarUsuario(usuario2);
        cine.agregarUsuario(usuario3);

        cine.venderBoleta(usuario1, funcion1);
        cine.venderBoleta(usuario2, funcion2);
        cine.venderBoleta(usuario3, funcion1);

        cine.generarFacturas();
    }
}
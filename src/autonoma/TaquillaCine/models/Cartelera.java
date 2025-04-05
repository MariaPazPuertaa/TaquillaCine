/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.TaquillaCine.models;

import java.util.ArrayList;

/**
 *
 * @author Maria Paz Puerta Acevedo <mariaáp.puertaa@autonoma.edu.co>
 * @since 20250331
 * @version 1.0.0
 * 
 */
public class Cartelera {
    /**
     * La lista de peliculas en cartelera.
     */
    private ArrayList<Pelicula> peliculas;

    /**
     * Constructor de la clase Cartelera.
     * Inicializa una lista vacía de películas.
     */
    public Cartelera() {
        this.peliculas = new ArrayList<>();
    }

    /**
     * Agrega una nueva película a la cartelera.
     * @param pelicula Es la película que se desea agregar.
     */
    public void crearPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Película agregada: " + pelicula.getTitulo());
    }

    /**
     * Busca una película por su título.
     * @param titulo Es el título de la película a buscar.
     * @return Retorna la película encontrada o null si no existe.
     */
    public Pelicula buscarPelicula(String titulo) {
        for (Pelicula p : peliculas) {
            if (p.getTitulo().equalsIgnoreCase(titulo)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Actualiza una película existente en la cartelera.
     * @param tituloOriginal Es el título actual de la película.
     * @param nuevaPelicula Es el objeto con los nuevos datos de la película.
     */
    public void actualizarPelicula(String tituloOriginal, Pelicula nuevaPelicula) {
        Pelicula encontrada = buscarPelicula(tituloOriginal);
        if (encontrada != null) {
            encontrada.setTitulo(nuevaPelicula.getTitulo());
            encontrada.setCostoBase(nuevaPelicula.getCostoBase());
            System.out.println("Película actualizada.");
        } else {
            System.out.println("Película no encontrada.");
        }
    }

    /**
     * Elimina una película de la cartelera por su título.
     * @param titulo Es el título de la película a eliminar.
     */
    public void eliminarPelicula(String titulo) {
        Pelicula encontrada = buscarPelicula(titulo);
        if (encontrada != null) {
            peliculas.remove(encontrada);
            System.out.println("Película eliminada: " + titulo);
        } else {
            System.out.println("Película no encontrada.");
        }
    }

    /**
     * Muestra todas las películas registradas en la cartelera.
     */
    public void mostrarPeliculas() {
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas en la cartelera.");
        } else {
            System.out.println("Películas en cartelera:");
            for (Pelicula p : peliculas) {
                System.out.println("- " + p.getTitulo() + " ($" + p.getCostoBase() + ")");
            }
        }
    }
}

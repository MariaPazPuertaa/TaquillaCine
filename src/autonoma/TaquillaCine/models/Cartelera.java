/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.TaquillaCine.models;

import java.util.ArrayList;

import java.util.NoSuchElementException;


/**
 *
 * @author Maria Paz Puerta Acevedo <mariaáp.puertaa@autonoma.edu.co>
 * @since 20250331
 * @version 1.0.0
 * 
 */
public class Cartelera {

    /**
     * Lista de funciones en cartelera.
     */
    private ArrayList<Funcion> funciones;
    

    /**
     * Lista de peliculas en cartelera.
     */
    private ArrayList<Pelicula> peliculas;

    /**
     * Constructor de la clase Cartelera.
     * Inicializa una lista vacía de películas.
     */
    public Cartelera() {
        this.peliculas = new ArrayList<>();
        this.funciones = new ArrayList<>();
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
     * @return Retorna la película encontrada.
     * @throws NoSuchElementException Si la película no está en cartelera.
     */
    public Pelicula buscarPelicula(String titulo) {
        for (Pelicula p : peliculas) {
            if (p.getTitulo().equalsIgnoreCase(titulo)) {
                return p;
            }
        }
        throw new NoSuchElementException("Película no encontrada: " + titulo);
    }

    /**
     * Actualiza una película existente en la cartelera.
     * @param tituloOriginal Es el título actual de la película.
     * @param nuevaPelicula Es el objeto con los nuevos datos de la película.
     * @throws NoSuchElementException Si no se encuentra la película a actualizar.
     */
    public void actualizarPelicula(String tituloOriginal, Pelicula nuevaPelicula) {
        Pelicula encontrada = buscarPelicula(tituloOriginal);
        encontrada.setTitulo(nuevaPelicula.getTitulo());
        encontrada.setCostoBase(nuevaPelicula.getCostoBase());
        System.out.println("Película actualizada.");
    }

    /**
     * Elimina una película de la cartelera por su título.
     * @param titulo Es el título de la película a eliminar.
     * @throws NoSuchElementException Si la película no está en cartelera.
     */
    public void eliminarPelicula(String titulo) {
        Pelicula encontrada = buscarPelicula(titulo);
        peliculas.remove(encontrada);
        System.out.println("Película eliminada: " + titulo);
    }

    /**
     * Muestra todas las películas registradas en la cartelera.
     * @throws IllegalStateException Si no hay películas para mostrar.
     */
    public void mostrarPeliculas() {
        if (peliculas.isEmpty()) {
            throw new IllegalStateException("No hay películas en la cartelera.");
        } else {
            System.out.println("Películas en cartelera:");
            for (Pelicula p : peliculas) {
                System.out.println("- " + p.getTitulo() + " ($" + p.getCostoBase() + ")");
            }
        }
    }
    public void agregarFuncion(Funcion funcion) {
        funciones.add(funcion);
        System.out.println("Función agregada para: " + funcion.getPelicula().getTitulo());
    }

    public void mostrarFunciones() {
        if (funciones.isEmpty()) {
            System.out.println("No hay funciones disponibles.");
        } else {
            System.out.println("Funciones en cartelera:");
            for (Funcion f : funciones) {
                System.out.println("- Función de: " + f.getPelicula().getTitulo());
            }
        }
    }

    public Funcion buscarFuncionPorPelicula(String titulo) {
        for (Funcion f : funciones) {
            if (f.getPelicula().getTitulo().equalsIgnoreCase(titulo)) {
                return f;
            }
        }
        throw new NoSuchElementException("No se encontró función para la película: " + titulo);
    }

    public ArrayList<Funcion> getFunciones() {
        return funciones;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

}

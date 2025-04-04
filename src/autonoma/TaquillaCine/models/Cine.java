package autonoma.TaquillaCine.models;

import java.util.ArrayList;

public class Cine {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Pelicula> peliculas;

    public Cine() {
        this.usuarios = new ArrayList<>();
        this.peliculas = new ArrayList<>();
    }

    /**
     * Agrega un usuario a la lista del cine.
     * @param usuario Usuario a agregar
     */
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario agregado correctamente.");
    }

    /**
     * Elimina un usuario de la lista si existe.
     * @param usuario Usuario a eliminar
     */
    public void eliminarUsuario(Usuario usuario) {
        if (usuarios.remove(usuario)) {
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("El usuario no existe.");
        }
    }

    /**
     * Agrega una película al cine.
     * @param pelicula Película a agregar
     */
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Película agregada correctamente.");
    }

    /**
     * Elimina una película por su nombre.
     * @param nombre Nombre de la película a eliminar
     */
    public void eliminarPelicula(String nombre) {
        for (Pelicula p : peliculas) {
            if (p.getTitulo().equalsIgnoreCase(nombre)) {
                peliculas.remove(p);
                System.out.println("Película eliminada correctamente.");
                return;
            }
        }
        System.out.println("La película no se encontró.");
    }
}

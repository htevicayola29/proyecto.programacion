package Usuarios;

import java.util.ArrayList;
import java.util.List;

public class Usuarios {
    // Lista para almacenar los usuarios
    private List<Usuario> listaUsuarios;

    // Constructor
    public Usuarios() {
        this.listaUsuarios = new ArrayList<>();
    }

    // Método para agregar un usuario
    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    // Método para eliminar un usuario por ID
    public void eliminarUsuario(int id) {
        listaUsuarios.removeIf(usuario -> usuario.getId() == id);
    }

    // Método para buscar un usuario por ID
    public Usuario buscarUsuario(int id) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null; // Si no se encuentra
    }

    // Método para mostrar todos los usuarios
    public void mostrarUsuarios() {
        for (Usuario usuario : listaUsuarios) {
            System.out.println(usuario);
        }
    }
}
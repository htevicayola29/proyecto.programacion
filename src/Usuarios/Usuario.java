package Usuarios;

public class Usuario {
        // Atributos
        private int id;
        private String nombre;
        private String correo;
        private String contraseña;

        // Constructor
        public Usuario(int id, String nombre, String correo, String contraseña) {
            this.id = id;
            this.nombre = nombre;
            this.correo = correo;
            this.contraseña = contraseña;
        }

        // Getters y Setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getContraseña() {
            return contraseña;
        }

        public void setContraseña(String contraseña) {
            this.contraseña = contraseña;
        }

        // Método para mostrar información del usuario
        @Override
        public String toString() {
            return "Usuario{" + "id=" + id + ", nombre='" + nombre + '\'' + ", correo='" + correo + '\'' + '}';
        }
    }


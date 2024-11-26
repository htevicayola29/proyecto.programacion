import Modelo.Task;
import Usuarios.Usuario;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TodoListApp {
    private static List<Task> tasks;
    // Lista de usuarios registrados
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private Usuario usuarioActual; // Usuario actualmente logueado
    private HashMap<Usuario, ArrayList<String>> tareasPorUsuario = new HashMap<>(); // Tareas por usuario

    public static void main(String[] args) {
        TodoListApp todoListApp =new TodoListApp();
        todoListApp.showMenu();
    }

    // Método principal para mostrar el menú
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Menú inicial
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Agregar tarea");
            System.out.println("4. Ver tareas");
            System.out.println("5. Completar tarea");
            System.out.println("6. Eliminar tarea");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarUsuario();
                case 2 :
                    iniciarSesion();
                case 4:
                    addTask();
                    break;
                case 5:
                    showTasks();
                    break;
                case 6:
                    completeTask();
                    break;
                case 7:
                    deleteTask();
                    break;
                    case 8 : System.out.println("¡Gracias por usar la aplicación!");
                default :
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 8);

        scanner.close();
    }

    // Método para registrar un usuario
    private void registrarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Registro de Usuario ---");
        System.out.print("Ingrese su ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su correo: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();

        // Crear y registrar usuario
        Usuario nuevoUsuario = new Usuario(id, nombre, correo, contraseña);
        usuarios.add(nuevoUsuario);
        tareasPorUsuario.put(nuevoUsuario, new ArrayList<>());
        System.out.println("Usuario registrado con éxito.");
    }

    // Método para iniciar sesión
    private void iniciarSesion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Inicio de Sesión ---");
        System.out.print("Ingrese su correo: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(contraseña)) {
                usuarioActual = usuario;
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + usuario.getNombre() + "!");
                return;
            }
        }
        System.out.println("Correo o contraseña incorrectos. Intente de nuevo.");
    }
    private static void addTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el nombre de la nueva tarea: ");
        String name = scanner.nextLine();

        System.out.print("Ingresa la descripción de la tarea: ");
        String description = scanner.nextLine();

        System.out.print("Ingresa la fecha límite de la tarea (formato yyyy-MM-dd HH:mm): ");
        String dueDateString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dueDate = LocalDateTime.parse(dueDateString, formatter);

        tasks.add(new Task(name, description, dueDate));
        System.out.println("Tarea agregada con éxito.");
    }

    private static void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No hay tareas en la lista.");
            return;
        }
        System.out.println("\n===== Tareas =====");
        for (int i = 0; i < tasks.size(); i++) { // Se corrigió la condición del for
            Task task = tasks.get(i); // Se inicializó correctamente la variable task
            String status = task.isCompleted() ? "[Completada]" : "";
            String overdueStatus = task.isOverdue() ? " (Tarea atrasada)" : "";
            System.out.println((i+1) + ". [" + status + task.getName() + overdueStatus + "]"); // Se corrigieron los errores en la cadena de formato
            System.out.println("  Descripción: " + task.getDescription());
            System.out.println("  Fecha y hora de creación: " + task.getDateTime());
            System.out.println("  Fecha límite: " + task.getFormattedDueDate());
        }
    }

    private static void completeTask() {
        showTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Selecciona el número de la tarea que deseas completar: ");
        int index = getUserInput() - 1;

        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.markAsCompleted();
            System.out.println("Tarea marcada como completada.");
        } else {
            System.out.println("Número de tarea inválido.");
        }

    }

    private static int getUserInput() {
        return  getUserInput();
    }

    private static void deleteTask() {
        showTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Selecciona el número de la tarea que deseas eliminar: ");
        int index = getUserInput() - 1;

        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Tarea eliminada con éxito.");
        } else {
            System.out.println("Número de tarea inválido.");
        }
    }
}










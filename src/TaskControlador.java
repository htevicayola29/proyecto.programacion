import Modelo.Task;
import Modelo.TaskDAO;
import Vista.TaskVista;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class TaskControlador {
    private TaskDAO taskDAO;
    private TaskVista taskVista;

    public TaskControlador(TaskDAO taskDAO, TaskVista taskVista) {
        this.taskDAO = taskDAO;
        this.taskVista = taskVista;
    }

    public void listarTask() {
        List<Task> tasks = taskDAO.obtenerTask();
        taskVista.mostrarTask(tasks);
    }

    public void agregarTask() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre:  ");
        String name = sc.nextLine();
        System.out.println("Ingrese  la descripcion :  ");
        String description = sc.nextLine();
        System.out.println("Ingrese  la  fecha actual(formato:yyyy-MM-dd HH:mm:ss) :  ");
        String datetimeImput = sc.next();
        Timestamp dateTime = Timestamp.valueOf(datetimeImput);
        System.out.println("Ingrese  la fecha limite(formato:yyyy-MM-dd HH:mm:ss) : ");
        String dueDateImput = sc.nextLine();
        Timestamp dueDate = Timestamp.valueOf(dueDateImput);

        taskDAO.agregarTask(name, description, dateTime, dueDate);
        System.out.println("Tarea agregada con exito.");
    }
}
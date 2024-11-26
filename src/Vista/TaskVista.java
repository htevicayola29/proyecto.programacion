package Vista;

import Modelo.Task;
import Modelo.TaskDAO;
import java.util.List;

public class TaskVista {
    public void mostrarTask(List<Task> tasks){
        System.out.println("\n*****Lista de tareas*****");
        if(tasks.isEmpty()){
            System.out.println(".....No hay tareas registradas.....");

        }else{
            System.out.println();
            for(Task task:tasks){
                System.out.println();
            }
        }

    }
}

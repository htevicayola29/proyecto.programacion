package Modelo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private int id; // Id de la tarea, probablemente asignado desde la base de datos
    private String name;
    private String description;
    private LocalDateTime dateTime; // Fecha de creación
    private LocalDateTime dueDate; // Fecha límite para completar la tarea
    private boolean completed;

    // Constructor sin id, ya que se asigna automáticamente
    public Task(String name, String description, LocalDateTime dueDate) {
        this.name = name;
        this.description = description;
        this.dateTime = LocalDateTime.now(); // Fecha de creación
        this.dueDate = dueDate; // Fecha límite
        this.completed = false;
    }

    // Constructor adicional para tareas con ID (probablemente de la base de datos)
    public Task(int id, String name, String description, LocalDateTime dateTime, LocalDateTime dueDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateTime = dateTime;
        this.dueDate = dueDate;
        this.completed = false;
    }

    public Task(String titulo, String descripcion, Timestamp fechaCreacion, Timestamp fechaLimite, String categoria, String prioridad, String estado) {
    }

    public static  void add(Task nuevaTarea) {
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    // Formatear la fecha y hora de creación para mostrarla en un formato legible
    public String getFormattedDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }

    // Formatear la fecha límite para mostrarla en un formato legible
    public String getFormattedDueDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dueDate.format(formatter);
    }

    // Verifica si la tarea está atrasada
    public boolean isOverdue() {
        return !completed && LocalDateTime.now().isAfter(dueDate);
    }


    /*public boolean isEmpty() {
        return true;
    }*/
}
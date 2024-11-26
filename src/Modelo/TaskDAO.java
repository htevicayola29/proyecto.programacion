package Modelo;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
        private Connection connection;

        // Constructor que recibe la conexión a la base de datos
        public TaskDAO(Connection connection) {
                this.connection = connection;
        }

        // Método para obtener todas las tareas
        public List<Task> obtenerTask() {
                List<Task> tasks = new ArrayList<>();
                String sql = "SELECT id, name, description, dateTime, dueDate FROM tasks";

                try (PreparedStatement statement = connection.prepareStatement(sql);
                     ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                                int id = resultSet.getInt("id");
                                String name = resultSet.getString("name");
                                String description = resultSet.getString("description");
                                Timestamp dateTime = resultSet.getTimestamp("dateTime");
                                Timestamp dueDate = resultSet.getTimestamp("dueDate");

                                Task task = new Task(id, name, description, dateTime.toLocalDateTime(), dueDate.toLocalDateTime());
                                tasks.add(task);
                        }
                } catch (SQLException e) {
                        throw new RuntimeException("Error al obtener las tareas: " + e.getMessage(), e);
                }
                return tasks;
        }

        // Método para agregar una nueva tarea
        public void agregarTask(String name, String description, Timestamp dateTime, Timestamp dueDate) throws SQLException {
                String sql = "INSERT INTO tasks (name, description, dateTime, dueDate) VALUES (?, ?, ?, ?)";

                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, name);
                        stmt.setString(2, description);
                        stmt.setTimestamp(3, dateTime);
                        stmt.setTimestamp(4, dueDate);

                        // Ejecutar la actualización para insertar los datos
                        stmt.executeUpdate();
                } catch (SQLException e) {
                        throw new RuntimeException("Error al agregar la tarea: " + e.getMessage(), e);
                }
        }
}











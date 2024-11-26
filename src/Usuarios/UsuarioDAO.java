package Usuarios;

import MySQL.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private final Connection connection;

    // Constructor para initializer la conexión
    public UsuarioDAO() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    // Método para registrar un usuario
    public boolean registerUser(String nombre, String correo, String contraseña) {
        String sql = "INSERT INTO usuarios (nombre, correo, contraseña) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, correo);
            statement.setString(3, contraseña);
            statement.executeUpdate();
            System.out.println("Usuario registrado con éxito.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al registrar el usuario.");
            return false;
        }
    }

    // Método para iniciar sesión
    public Usuario loginUser(String correo, String contraseña) {
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND contraseña = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, correo);
            statement.setString(2, contraseña);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Inicio de sesión exitoso.");
                return new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("correo"),
                        resultSet.getString("contraseña")
                );
            } else {
                System.out.println("Credenciales incorrectas.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al iniciar sesión.");
        }
        return null;
    }

    // Método para buscar un usuario por su ID
    public Usuario getUserById(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("correo"),
                        resultSet.getString("contraseña")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al buscar el usuario.");
        }
        return null;
    }

    // Método para verificar si un correo ya está registrado
    public boolean isEmailRegistered(String correo) {
        String sql = "SELECT id FROM usuarios WHERE correo = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, correo);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Devuelve true si hay un resultado
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al verificar el correo.");
            return false;
        }
    }
}
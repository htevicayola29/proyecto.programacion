package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Parámetros de conexión
    private static final String URL = "jdbc:mysql://localhost:3306/todo_list_app"; // Cambia el puerto si es necesario
    private static final String USER = "root"; // Nombre de usuario de la base de datos
    private static final String PASSWORD = " ";// Contraseña de la base de datos
    private  static  Connection connection =null;

    // Método para obtener una conexión
    public static Connection getConnection() throws SQLException {
        if(connection ==null|| connection.isClosed()){
            try{
                connection=DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("..........Conexion establecida..........");
            }catch (SQLException e ){
                System.out.println("..........Error al conecctar la Base De Datos..........");
                throw e;
            }
        }
        return connection;
    }
    public static  void cerrarConnection()throws SQLException {
        if(connection !=null){
            try{
                connection.close();
                System.out.println("..........Conexion cerrada..........");
            }catch (SQLException e){
                System.out.println("..........Error al cerrar la conexion.........");
                throw e ;
            }
        }
    }
}




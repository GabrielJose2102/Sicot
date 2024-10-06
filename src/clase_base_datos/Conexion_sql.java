package clase_base_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_sql {
    //Conexión Local

    public static Connection conectar() {
        try {
//            String url = "jdbc:mysql://localhost:3306/bd_porcinos";
//            String us = "root";
//            String con = "";

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_porcinos"+"?useTimezone=true&serverTimezone=UTC", "root", "");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en conexión local " + e);
        }
        return (null);
    }
}

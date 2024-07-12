/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    
    private static final String url = "jdbc:mysql://localhost:3306/proyectojava_24112";
    private static final String user = "root";
    private static final String password = "";
    
    public static Connection obtenerConexion() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){   
            throw new SQLException("No se encontro driver jdbc", e);
        }
            return DriverManager.getConnection(url, user, password);
    }   
}

package Configuracion;

import java.sql.*;

public class ConexionBD {
    Connection conexion;
    String usuario = "root";
    String contraseña = "sas123";
    String servicio = "localhost";
    String puerto = "3306";
    String BaseDatos = "db_inventario";
    String configuracion = "useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    
    public ConexionBD(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_inventario?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","sas123"); 
            //conexion = DriverManager.getConnection("jdbc:mysql://"+ servicio + ":" + puerto +"/"+ BaseDatos + "?" + configuracion,usuario,contraseña); 
            System.out.println("Conectado a la base de datos");
        } catch (Exception e) {
            System.err.println("Error ................................ \n"+e);
        }
    }
    public Connection getConnection(){
        return conexion;
    }
}

package modelo;

import java.sql.*;

public class Conexion {
    
    public Connection getConexion() {
        
        try {
            
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");
            
        } catch(Exception e) {
            
        }
        
        return conexion;
        
    }
    
    private Connection conexion;
    
}

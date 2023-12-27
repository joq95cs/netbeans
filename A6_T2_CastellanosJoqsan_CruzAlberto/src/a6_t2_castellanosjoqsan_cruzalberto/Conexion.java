package a6_t2_castellanosjoqsan_cruzalberto;

import java.sql.*;

import javax.swing.*;

public class Conexion {
    
    public Conexion() throws SQLException {
        
        cbd = DriverManager.getConnection("jdbc:mysql://localhost/videojuegos", "root", "");
        
        ssql = cbd.createStatement();
        
        rc = ssql.executeQuery("SELECT * FROM artículos");
        
        JOptionPane.showMessageDialog(null, "Conexión a la base de datos creada con éxito", "Conectando", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    public Connection cbd;
    
    public Statement ssql;
    
    public ResultSet rc;
    
}
package a4_t4_castellanosjoqsan;

import java.sql.*;

import javax.swing.*;

public class Conexion {
    
    public Conexion() throws SQLException {
        
        cbd = DriverManager.getConnection("jdbc:mysql://localhost/videojuegos", "root", "");
        
        ssql = cbd.createStatement();
        
        JOptionPane.showMessageDialog(null, "Conexión a la base de datos creada con éxito", "Conectando", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    public Connection cbd;
    
    public Statement ssql;
    
    public ResultSet rc;
    
}
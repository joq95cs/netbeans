
package peliculas_baseremota;

import java.sql.*;
import javax.swing.*;

public class Conexion {
    
    public Conexion() {
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://192.168.0.9:3306/base_peliculas", "root", "");
            
        } catch(Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0); 
        }
    }
    
    public void insertar(String nombre, int agno, String genero, String pais, String estudio) throws Exception {
        
        String query = "INSERT INTO peliculas (nombre, agno, genero, pais, estudio) VALUES (?, ?, ?, ?, ?)";
        ps = cn.prepareStatement(query);
        ps.setString(1, nombre);
        ps.setInt(2, agno);
        ps.setString(3, genero);
        ps.setString(4, pais);
        ps.setString(5, estudio);
        
        boolean incorrecto = ps.execute();
        
        if(!incorrecto) {
            
            JOptionPane.showMessageDialog(null, "Registro insertado", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            
        } else {
            
            throw new Exception("Error de servidor remoto");
        } 
    }
    
    public ResultSet buscar(int id) throws Exception {
        
        String query = "SELECT id, nombre, agno, genero, pais, estudio FROM peliculas WHERE id = ?";
        ps = cn.prepareStatement(query);
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        
        if(!rs.next()) {
            
            throw new Exception("Registro no encontrado");
        }
        
        return rs;
    }
    
    public void actualizar(int id, String nombre, int agno, String genero, String pais, String estudio) throws Exception {
        
        String query = "UPDATE peliculas SET nombre = ?, agno = ?, genero = ?, pais = ?, estudio = ? WHERE ID = ?";
        ps = cn.prepareStatement(query);
        ps.setString(1, nombre);
        ps.setInt(2, agno);
        ps.setString(3, genero);
        ps.setString(4, pais);
        ps.setString(5, estudio);
        ps.setInt(6, id);
        
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Registro actualizado", "Correcto", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void eliminar(int id) throws Exception {
        
        String query = "DELETE FROM peliculas WHERE id = ?";
        ps = cn.prepareStatement(query);
        ps.setInt(1, id);
        
        boolean incorrecto = ps.execute();
        
        if(!incorrecto) {
            
            JOptionPane.showMessageDialog(null, "Registro eliminado", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            
        } else {
            
            throw new Exception("Error de servidor remoto");
        }   
    }
    
    public ResultSet ver() throws Exception {
        
        String query = "SELECT * FROM peliculas";
        ps = cn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        
        if(!rs.next()) {
            
            throw new Exception("Base de datos vacía");  
        }
        
        ps = cn.prepareStatement(query);
        rs = ps.executeQuery();
        
        return rs;
    }
    
    private Connection cn;
    private PreparedStatement ps;
}
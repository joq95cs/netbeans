package bbdd_jdbc;

import java.sql.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultaPreparada {
    
    public static void main(String[] args) {
        
        try {
            
            //1. Crear conexión
            
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");
            
            //2. Preparar consulta
            
            PreparedStatement sentencia = conexion.prepareStatement("SELECT NOMBREARTÍCULO, SECCIÓN, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN = ? AND PAÍSDEORIGEN = ?");
            
            System.out.println("PRIMERA CONSULTA\n");
            
            //3. Establecer parámetros de consulta
            
            sentencia.setString(1, "deportes");
            
            sentencia.setString(2, "USA");
            
            //4. Ejecutar y correr consulta
            
            ResultSet rs = sentencia.executeQuery();
            
            while(rs.next()) {
                
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                
            }
            
            rs.close();
            
            System.out.println("\nSEGUNDA CONSULTA\n");
            
            //3. Establecer parámetros de consulta
            
            sentencia.setString(1, "cerámica");
            
            sentencia.setString(2, "China");
            
            //4. Ejecutar y correr consulta
            
            rs = sentencia.executeQuery();
            
            while(rs.next()) {
                
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                
            }
            
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaPreparada.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

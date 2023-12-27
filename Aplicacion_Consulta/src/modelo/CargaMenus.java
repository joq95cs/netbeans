package modelo;

import java.sql.*;

public class CargaMenus { //Está en este paquete porque se hace una consulta a la base de datos
    
    public CargaMenus() {
        
        conexion = new Conexion();
        
    }
    
    public void ejecutaConsultas() {
        
        Connection acceso = conexion.getConexion();
        
        try {
            
            Statement st1 = acceso.createStatement();
            
            Statement st2 = acceso.createStatement();
            
            rs1 = st1.executeQuery("SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS");
            
            rs2 = st2.executeQuery("SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS");
            
        } catch(Exception e) {
            
        }
        
    }
    
    private Conexion conexion;
    
    public ResultSet rs1, rs2;
    
}

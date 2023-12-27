package modelo;

import java.sql.*;

public class EjecutaConsultas {
    
    public EjecutaConsultas() {
        
        conexion = new Conexion();
        
    }

    public ResultSet filtra(String seccion, String pais) {
        
        Connection cn = conexion.getConexion();
        
        rs = null;
        
        try {
        
            if(!seccion.equals("Todos") && pais.equals("Todos")) {

                ps1 = cn.prepareStatement(consultaSeccion);
                
                ps1.setString(1, seccion);
                
                rs = ps1.executeQuery();

            } else if(seccion.equals("Todos") && !pais.equals("Todos")) {
                
                ps2 = cn.prepareStatement(consultaPais);
                
                ps2.setString(1, pais);
                
                rs = ps2.executeQuery();

            } else {
                
                ps3 = cn.prepareStatement(consultaAmbos);
                
                ps3.setString(1, seccion);
                
                ps3.setString(2, pais);
                
                rs = ps3.executeQuery();

            }
            
        } catch(Exception e) {}
        
        return rs;
        
    }
    
    private Conexion conexion;
    
    private ResultSet rs;
    
    private PreparedStatement ps1;
    
    private PreparedStatement ps2;
    
    private PreparedStatement ps3;
    
    private final String consultaSeccion = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN = ?";
    
    private final String consultaPais = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN = ?";
    
    private final String consultaAmbos = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN = ? AND PAÍSDEORIGEN = ?";
    
}

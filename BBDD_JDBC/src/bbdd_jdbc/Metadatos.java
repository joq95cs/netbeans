package bbdd_jdbc;

import java.sql.*;

public class Metadatos {
    
    public static void main(String[] args) {
        
        //mostrarInfo1();
        
        mostrarInfo2();
        
    }
    
    private static void mostrarInfo1() {
        
        Connection cn = null;
        
        try {
            
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");
            
            //Obtención de metadatos
            
            DatabaseMetaData metadatos = cn.getMetaData();
            
            //Mostrar info
            
            System.out.println("Nombre del gestor: " + metadatos.getDatabaseProductName());
            
            System.out.println("Versión del gestor: " + metadatos.getDatabaseProductVersion());
            
            System.out.println("Nombre del driver: " + metadatos.getDriverName());
            
            System.out.println("Versión del driver: " + metadatos.getDriverVersion());
            
        } catch(Exception e) {
            
            e.printStackTrace();
            
        } finally {
            
            try {
                
                cn.close();
                
            } catch(SQLException ex) {}
            
        }
        
    }
    
    private static void mostrarInfo2() {
        
        Connection cn = null;
        
        ResultSet rs = null;
        
        try {
            
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");
            
            //Obtención de metadatos
            
            DatabaseMetaData metadatos = cn.getMetaData();
            
            //Mostrar info
            
            System.out.println("Lista de tablas: ");
            
            rs = metadatos.getTables(null, null, null, null); //Los parametros son para afinar la búsqueda
            
            while(rs.next()) {
                
                System.out.println(rs.getString("TABLE_NAME"));
                
            }
            
            System.out.println("\nLista de campos de tabla productos: ");
            
            rs = metadatos.getColumns(null, null, "productos", null);
            
            while(rs.next()) {
                
                System.out.println(rs.getString("COLUMN_NAME"));
                
            }
            
        } catch(Exception e) {
            
            e.printStackTrace();
            
        } finally {
            
            try {
                
                cn.close();
                
            } catch(SQLException ex) {}
            
        }
        
    }
    
}

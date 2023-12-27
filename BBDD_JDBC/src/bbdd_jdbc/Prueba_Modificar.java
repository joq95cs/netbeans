package bbdd_jdbc;

import java.sql.*;

public class Prueba_Modificar {
    
    public static void main(String[] args) {
        
        try {
			
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");

            Statement statement = conexion.createStatement();
            
            //String instruccion = "INSERT INTO productos (CÓDIGOARTÍCULO, NOMBREARTÍCULO, PRECIO) VALUES ('AR77', 'PANTALÓN', 25.35)";

            //String instruccion = "UPDATE PRODUCTOS SET PRECIO = '56,89' WHERE CÓDIGOARTÍCULO = 'AR77'";
            
            String instruccion = "DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO = 'AR77'";
            
            statement.executeUpdate(instruccion);
            
            System.out.println("Tabla actualizada");
            
        } catch(Exception e) {

            e.printStackTrace();

        }
        
    }
    
}

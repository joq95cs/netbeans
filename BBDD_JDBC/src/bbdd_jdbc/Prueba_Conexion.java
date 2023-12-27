package bbdd_jdbc;

import java.sql.*;

public class Prueba_Conexion {
    
    public static void main(String[] args) {
        
        try {
			
            //PASO 1
			
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");

            //PASO 2

            Statement statement = conexion.createStatement();

            //PASO 3

            ResultSet resultset = statement.executeQuery("SELECT * FROM PRODUCTOS");

            //PASO 4

            while(resultset.next()) {

                System.out.println(resultset.getString("CÓDIGOARTÍCULO") + " " + resultset.getString("NOMBREARTÍCULO") + " " + resultset.getString("PRECIO"));

            }

        } catch(Exception e) {

            e.printStackTrace();

        }
        
    }
    
}

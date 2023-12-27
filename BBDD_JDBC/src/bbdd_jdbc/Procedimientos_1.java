package bbdd_jdbc;

import java.sql.*;

public class Procedimientos_1 {
    
    public static void main(String[] args) {
        
        try {
            
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");
        
            CallableStatement cs = cn.prepareCall("{call CLIENTES_MADRID}");
            
            ResultSet rs = cs.executeQuery();
            
            while(rs.next()) {
                
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
        
    }
    
}

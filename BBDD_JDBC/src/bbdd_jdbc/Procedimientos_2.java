package bbdd_jdbc;

import java.sql.*;
import javax.swing.JOptionPane;

public class Procedimientos_2 {
    
    public static void main(String[] args) {
        
        String precio = JOptionPane.showInputDialog("Introduce precio");
            
        String articulo = JOptionPane.showInputDialog("Introduce nombre del artículo");
        
        try {
            
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");
        
            CallableStatement cs = cn.prepareCall("{call ACTUALIZA_PRODUCTO(?, ?)}");
            
            cs.setString(1, precio);
            
            cs.setString(2, articulo);
            
            cs.execute();
            
            System.out.println("Producto Anctualizado");
            
        } catch(Exception e) {
            
        }
        
    }
    
}

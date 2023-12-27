package bbdd_jdbc;

import java.sql.*;

import javax.swing.JOptionPane;

public class Transacciones_2 {
    
    public static void main(String[] a) {
        
        Connection cn = null;	

            try {	

                cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");	

                cn.setAutoCommit(false);

                Statement st = cn.createStatement();

                String instruccionSql_1 = "DELETE FROM PRODUCTOS WHERE PAÍSDEORIGEN = 'ITALIA'";
                
                String instruccionSql_2 = "DELETE FROM PRODUCTOS WHERE PRECIO > 300";
                
                String instruccionSql_3 = "UPDATE PRODUCTOS SET PRECIO = PRECIO * 1.15";
                
                boolean ejecutar = ejecutar_transaccion();
                
                if(ejecutar) {
                    
                    st.executeUpdate(instruccionSql_1);

                    st.executeUpdate(instruccionSql_2);

                    st.executeUpdate(instruccionSql_3); 
                    
                    cn.commit();
                    
                    JOptionPane.showMessageDialog(null, "Transacción ejecutada");
                    
                } else {
                    
                    JOptionPane.showMessageDialog(null, "No se realizó cambio");
                    
                }
                
            } catch(Exception e) {
                
                try {
                    
                    cn.rollback();
                    
                } catch(SQLException ex) {}
                
                JOptionPane.showMessageDialog(null, "Transacción no ejecutada", "Error", 0);
                
            }
            
    }
    
    private static boolean ejecutar_transaccion() {
        
        String ejecucion = JOptionPane.showInputDialog("¿Ejecutar transacción?");
       
        return ejecucion.equalsIgnoreCase("Sí");
        
    }
    
}

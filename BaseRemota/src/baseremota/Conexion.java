
package baseremota;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    
    public Conexion(String url, String user, String pass) {
        
        try {
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, user, pass);

            st = cn.createStatement();
            
        } catch(Exception e) {}
    }
    
    public void executeQuery(String query) {
        
        try {
        
            st.execute(query);
            JOptionPane.showMessageDialog(null, "Ejecución exitosa");
        
        } catch(Exception e) {}
    }
    
    private Connection cn;
    private Statement st;
}

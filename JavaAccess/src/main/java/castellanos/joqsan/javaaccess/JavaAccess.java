
package castellanos.joqsan.javaaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JavaAccess {

    public static void main(String[] args) {
        
        try {
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
      
            String url = "jdbc:ucanaccess://C:/Users/joqle/Documents/Access/db_libros.accdb";
            Connection cn = DriverManager.getConnection(url);
            Statement st = cn.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT * FROM libros");
            
            while(rs.next()) {
                
                System.out.println(rs.getString("nombre"));
                System.out.println(rs.getString("editorial"));
            }
            
        } catch(Exception e) {
            
        }
    }
}

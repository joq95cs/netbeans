/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package castellanos.joqsan.javasqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joqle
 */
public class JavaSQLite {

    public static void main(String[] args) {
        
        String url = "jdbc:sqlite:base.db";
        Connection cn = null;
        
        try {
            
            cn = DriverManager.getConnection(url);

            Statement stm = cn.createStatement();
            stm.execute("CREATE TABLE IF NOT EXISTS alumnos (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR(50) NOT NULL, sexo VARCHAR(50) NOT NULL)");
            stm.execute("INSERT INTO alumnos VALUES (null, 'Lola', 'Mujer')");

            ResultSet rs = stm.executeQuery("SELECT * FROM alumnos");
            
            while (rs.next()) {
                
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("nombre"));
                System.out.println(rs.getString("sexo"));
                System.out.println();
            }

        } catch (SQLException ex) {
            
            ex.printStackTrace();
            
        } finally {
            
            try {
                cn.close();
                
            } catch (SQLException ex) {
                
                ex.printStackTrace();
            }
        }
    }
}

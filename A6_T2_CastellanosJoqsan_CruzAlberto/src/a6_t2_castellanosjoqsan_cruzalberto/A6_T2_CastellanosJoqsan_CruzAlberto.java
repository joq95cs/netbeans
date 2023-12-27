package a6_t2_castellanosjoqsan_cruzalberto;

import javax.swing.*;

import java.sql.*;

public class A6_T2_CastellanosJoqsan_CruzAlberto {

    public static void main(String[] args) {
        
        try {
            
            new Marco().setVisible(true);
            
        } catch(SQLException e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            
        }
        
    }
    
}
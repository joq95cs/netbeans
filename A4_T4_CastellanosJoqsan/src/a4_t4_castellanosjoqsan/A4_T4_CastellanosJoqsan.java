package a4_t4_castellanosjoqsan;

import javax.swing.*;

import java.sql.*;

public class A4_T4_CastellanosJoqsan {

    public static void main(String[] args) {
        
        try {
            
            new Marco().setVisible(true);
            
        } catch(SQLException e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            
        }
        
    }
    
}
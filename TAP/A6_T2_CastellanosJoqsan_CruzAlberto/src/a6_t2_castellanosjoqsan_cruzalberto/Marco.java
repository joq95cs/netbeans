package a6_t2_castellanosjoqsan_cruzalberto;

import java.sql.*;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class Marco extends JFrame {
    
    public Marco() throws SQLException {
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        setTitle("Registro de videojuegos");
        
        setResizable(false);
        
        Lamina l = new Lamina();
        
        add(l);
        
        setIconImage(Toolkit.getDefaultToolkit().createImage("src/icono.png"));
        
        anchoPantalla = Toolkit.getDefaultToolkit().getScreenSize().width;
        
        altoPantalla = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        setBounds(anchoPantalla/4, altoPantalla/4, anchoPantalla/2, altoPantalla/2);
        
        addWindowListener(new WindowAdapter() {
            
            public void windowClosing(WindowEvent e) {
                
                try {
                    
                    l.cerrarConexion();
                    
                    JOptionPane.showMessageDialog(null, "Conexión cerrada con éxito", "Cerrando", JOptionPane.INFORMATION_MESSAGE);
                    
                    System.exit(0);
                    
                } catch (SQLException ex) {
                    
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
                    
                }
                
            }
            
        });
        
    }
    
    public static int anchoPantalla;
    
    public static int altoPantalla;
    
}
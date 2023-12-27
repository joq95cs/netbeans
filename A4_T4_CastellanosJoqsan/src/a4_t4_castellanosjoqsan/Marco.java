package a4_t4_castellanosjoqsan;

import javax.swing.*;

import java.awt.*;

import java.sql.*;

public class Marco extends JFrame {
    
    public Marco() throws SQLException {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle("Registro de videojuegos");
        
        setResizable(false);
        
        add(new Lamina());
        
        setIconImage(Toolkit.getDefaultToolkit().createImage("src/icono.png"));
        
        anchoPantalla = Toolkit.getDefaultToolkit().getScreenSize().width;
        
        altoPantalla = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        setBounds(anchoPantalla/4, altoPantalla/4, anchoPantalla/2, altoPantalla/2);
        
    }
    
    public static int anchoPantalla;
    
    public static int altoPantalla;
    
}
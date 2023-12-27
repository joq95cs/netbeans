package calculadora_hilos;

import javax.swing.*;

import java.awt.*;

public class Marco extends JFrame {
    
    public Marco() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(500, 300);
        
        setTitle("Calculadora con Hilos");
        
        int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
        
        int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        setLocation(ancho/2 - getWidth()/2, alto/2 - getHeight()/2);
        
        add(new Lamina());
        
    }
    
}
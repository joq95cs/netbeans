package a4_t1_castellanosjoqsan;

import javax.swing.*;

import java.awt.*;

public class Marco extends JFrame {
    
    public Marco() {
        
        ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
        
        alto = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        setBounds(ancho/3, alto/3, ancho/3, alto/3);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle("Tabla de multiplicar");
        
    }
    
    public void initComponents() {
        
        lamina = new Lamina();
        
        lamina.initComponents();
        
        add(lamina);
        
    }
    
    private int ancho;
    
    private int alto;
    
    private Lamina lamina;
    
}
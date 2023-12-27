package a6_t1_castellanosjoqsan;

import javax.swing.*;

import java.awt.*;

public class Marco extends JFrame {
    
    public Marco() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
        
        int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        setBounds(ancho/4, alto/4, ancho/2, alto/2);
        
        setTitle("Inscripción");
        
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/a6_t1_castellanosjoqsan/icono.gif"));
        
        add(new Lamina());
        
    }
    
}
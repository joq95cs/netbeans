package a5_t1_castellanosjoqsan;

import javax.swing.*;

import java.awt.*;

public class Marco extends JFrame {
    
    public Marco() {
        
        int anchoPantalla = Toolkit.getDefaultToolkit().getScreenSize().width;
        
        int altoPantalla = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        setBounds(anchoPantalla/3, altoPantalla/3, anchoPantalla/3, altoPantalla/3);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle("Videojuegos");
        
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/a5_t1_castellanosjoqsan/icono.gif"));
        
        l = new Lamina();
        
        add(l);
        
    }
    
    private Lamina l;
    
}

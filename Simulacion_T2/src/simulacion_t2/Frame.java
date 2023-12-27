package simulacion_t2;

import javax.swing.*;

import java.awt.*;

public class Frame extends JFrame {
    
    public Frame() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle("Simulación: Tema 2");
        
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        setBounds(w/4, h/4, w/2, h/2);
        
        add(new Panel());
        
    }
    
}
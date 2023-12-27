package a2_t3_castellanosjoqsan;

import javax.swing.*;

import java.awt.*;

public class Marco extends JFrame {
    
    public Marco() {
        
        setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/3,
                Toolkit.getDefaultToolkit().getScreenSize().height/3, 
                Toolkit.getDefaultToolkit().getScreenSize().width/3,
                Toolkit.getDefaultToolkit().getScreenSize().height/3);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle("Operaciones con hilos");
        
        setResizable(false);
        
        add(new Lamina());
        
    }
    
}
package servidor;

import javax.swing.*;

import java.awt.*;

public class Marco extends JFrame {
    
    public Marco() {
        
        setTitle("Servidor");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(400, 300);
        
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        setLocation(w/2 - getWidth()/2, h/2 - getHeight()/2);
        
        add(new Lamina());
        
    }
    
}

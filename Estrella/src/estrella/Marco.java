package estrella;

import javax.swing.*;

import java.awt.*;

public class Marco extends JFrame {
    
    public Marco() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle("Estrella");
        
        setSize(500, 500);
        
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - 250,
                    Toolkit.getDefaultToolkit().getScreenSize().height/2 - 250);
        
        l = new Lamina();
        
        add(l);
        
    }
    
    public void dibujar() {
        
        l.dibujar(getWidth(), getHeight(), l.getGraphics());
        
    }
    
    public void setListo() {
        
        l.setListo();
        
    }
    
    private Lamina l;
    
}
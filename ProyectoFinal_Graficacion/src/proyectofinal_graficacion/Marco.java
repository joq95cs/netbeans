package proyectofinal_graficacion;

import javax.swing.*;

import java.awt.*;

public class Marco extends JFrame {
    
    public Marco() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle("Graficación: Proyecto final");
        
        setIconImage(Toolkit.getDefaultToolkit().getImage("icono.png"));
        
        setSize(1080, 486);
        
        setResizable(false);
        
        setLayout(null);
        
        add(new Lamina());
        
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - 540, 
                Toolkit.getDefaultToolkit().getScreenSize().height/2 - 240);
        
    }
    
}
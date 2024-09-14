package a2_t2_castellanosjoqsan;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class Marco extends JFrame {

    public Marco() {
        
        setTitle("Uso de librerías");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setResizable(false);
        
        add(new Lamina(this));
        
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/a2_t2_castellanosjoqsan/icono.png"));
        
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        setBounds(w/3, h/3, w/3, h/3);
        
    }
    
}
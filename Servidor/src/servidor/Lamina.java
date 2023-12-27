package servidor;

import javax.swing.*;

import java.awt.*;

public class Lamina extends JPanel {
    
    public Lamina() {
        
        setLayout(new GridLayout(1, 1));
        
        at.setEditable(false);
        
        add(new JScrollPane(at));
        
        new Hilo().start();
        
    }
    
    public static JTextArea at = new JTextArea();
    
}

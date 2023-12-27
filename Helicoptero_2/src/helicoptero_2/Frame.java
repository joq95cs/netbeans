package helicoptero_2;

import javax.swing.*;

import java.awt.*;

public class Frame extends JFrame {
    
    public Frame() {
            
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        setFocusable(false);

        setTitle("Helicoptero");

        setLayout(null);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        setBounds(0, 0, d.width, d.height);

        add(new Panel(d.width, d.height));
            
    }
    
}

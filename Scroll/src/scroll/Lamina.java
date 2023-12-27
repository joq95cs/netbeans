
package scroll;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Lamina extends ScrollPane {
    
    public Lamina() {
        
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(7, 1));
        p.add(new JButton("Hola"));
        p.add(new JButton("Hola"));
        p.add(new JButton("Hola"));
        p.add(new JButton("Hola"));
        p.add(new JButton("Hola"));
        p.add(new JButton("Hola"));
        p.add(new JButton("Hola"));
        add(p);
    }
}
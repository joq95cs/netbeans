
package scroll;

import java.awt.Toolkit;
import javax.swing.JFrame;

public class Marco extends JFrame {
    
    public Marco() {
        
        setTitle("Scroll");
        
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 200);
        setLocation(w/2 - getWidth()/2, h/2 - getHeight()/2);
        
        add(new Lamina());
    }
}

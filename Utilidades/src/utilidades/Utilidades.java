
package utilidades;

import java.awt.Toolkit;
import javax.swing.JFrame;

public class Utilidades {
    
    public static void crearMarco(JFrame marco, String titulo, int w, int h, int DefaultClose) {
        
        marco.setDefaultCloseOperation(DefaultClose);
        marco.setSize(w, h);
        marco.setTitle(titulo);
        
        int sw = Toolkit.getDefaultToolkit().getScreenSize().width,
            sh = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        marco.setLocation((sw/2) - (w/2), (sh/2) - (h/2));
    }
}
package a3_t3_castellanosjoqsan;

import javax.swing.*;

public class Hilo3 extends Thread {
    
    public void run() {
                
        do {
                    
            Lamina.i3.refrescar(Manipulador.imagenes.elementAt(getI()));
                    
            try {
                        
                Thread.sleep(250);
                        
            } catch(InterruptedException e) {
                        
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        
            }
            
            Thread.yield();
                    
        } while(true);
                
    }
    
    private int getI() {
        
        return Math.round((float)(Math.random() * 4));
        
    }
    
}
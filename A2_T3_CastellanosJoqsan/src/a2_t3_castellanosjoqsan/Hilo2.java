package a2_t3_castellanosjoqsan;

import javax.swing.*;

public class Hilo2 extends Thread {
    
    public void run() {
        
        do {
            
            if(Iniciar_Detener.listo) {
                
                Lamina.ct3.setText(String.valueOf(Iniciar_Detener.n1 + Iniciar_Detener.n2));
                
            }
            
            try {
                
                Thread.sleep(750);
                
            } catch(InterruptedException e) {
                
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                
            }
            
        } while(true);
        
    }
    
}
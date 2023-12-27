package a2_t3_castellanosjoqsan;

import javax.swing.JOptionPane;

public class Hilo1 extends Thread {
    
    public void run() {
        
        do {
            
            try {  
                
                Iniciar_Detener.n1 = Double.parseDouble(Lamina.ct1.getText());
                
                Iniciar_Detener.n2 = Double.parseDouble(Lamina.ct2.getText());
                
                Iniciar_Detener.listo = true;
                
            } catch(NumberFormatException e) {}
            
            try {
                
                Thread.sleep(500);
                
            } catch (InterruptedException e) {
                
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                
            }
            
        } while(true);
        
    }
    
}
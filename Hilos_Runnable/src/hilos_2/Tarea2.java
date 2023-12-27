package hilos_2;

import java.awt.Color;

public class Tarea2 implements Runnable {
    
    public void run() {
        
        while(true) {
            
            try {
                
                Marco.jPanel2.setBackground(new Color( (int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256) ));
                
                Thread.sleep(100);
                
            } catch(InterruptedException e) {}
            
        }
        
    }
    
}
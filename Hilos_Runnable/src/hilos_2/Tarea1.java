package hilos_2;

import java.awt.Color;

public class Tarea1 implements Runnable {
    
    public void run() {
        
        while(true) {
            
            try {
                
                Marco.jPanel1.setBackground(new Color( (int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256) ));
                
                Thread.sleep(500);
                
            } catch(InterruptedException e) {}
            
        }
        
    }
    
}
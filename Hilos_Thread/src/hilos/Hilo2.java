package hilos;

import java.awt.*;

public class Hilo2 extends Thread {
    
    public void run() {
        
        while(true) {
            
            try {
                
                Marco.jPanel2.setBackground(new Color( (int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256) ));
                
                Thread.sleep(100);
                
            } catch(InterruptedException e) {}
            
        }
        
    }
    
}
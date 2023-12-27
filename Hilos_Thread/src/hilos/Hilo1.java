package hilos;

import java.awt.*;

public class Hilo1 extends Thread {
    
    public void run() {
        
        while(true) {
            
            try {
                
                Marco.jPanel1.setBackground(new Color( (int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256) ));
                
                Thread.sleep(500);
                
            } catch(InterruptedException e) {}
            
        }
        
    }
    
}

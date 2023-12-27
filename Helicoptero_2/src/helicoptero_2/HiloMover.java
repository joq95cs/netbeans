package helicoptero_2;

import javax.swing.*;

public class HiloMover extends Thread {
    
    public HiloMover(JPanel h, int ancho, int alto) {
        
        this.h = h;
        
        this.ancho = ancho;
        
        this.alto = alto;
        
    }
        
    public void run() {

        while(true) {

            try {

                if(h.getX()+dx > ancho-120 || h.getX()+dx < 0) {

                    dx = 0;

                }

                if(h.getY()+dy > alto-120 || h.getY()+dy < 0) {

                    dy = 0;

                }

                h.setLocation(h.getX()+dx, h.getY()+dy);

                Thread.sleep(100);

            } catch(InterruptedException e) {

                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);

            }

        }

    }
    
    public void arriba() {
        
        dy -= 5;
        
    }
    
    public void abajo() {
        
        dy += 5;
        
    }
    
    public void derecha() {
        
        dx += 5;
        
    }
    
    public void izquierda() {
        
        dx -= 5;
        
    }
    
    private JPanel h;
    
    private int ancho;
    
    private int alto;
    
    private int dx = 0;
    
    private int dy = 0;
    
}
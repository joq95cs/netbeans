package helicoptero;

import javax.swing.*;

public class Hilos {
    
    public static class HiloArriba extends Thread {
        
        public void run() {
            
            dy -= 5;
            
        }
        
    }
    
    public static class HiloAbajo extends Thread {
        
        public void run() {
            
            dy += 5;
            
        }
        
    }
    
    public static class HiloDerecha extends Thread {
        
        public void run() {
            
            dx += 5;
            
        }
        
    }
    
    public static class HiloIzquierda extends Thread {
        
        public void run() {
            
            dx -= 5;
            
        }
        
    }
    
    public static class HiloMover extends Thread {
        
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
        
    }
    
    public static void setValores(JPanel h, int ancho, int alto) {
        
        Hilos.h = h;
        
        Hilos.ancho = ancho;
        
        Hilos.alto = alto;
        
    }
    
    private static JPanel h;
    
    private static int ancho;
    
    private static int alto;
    
    private static int dx = 0;
    
    private static int dy = 0;
    
}
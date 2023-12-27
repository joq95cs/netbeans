package carro_hilos;

import javax.swing.*;

public class Hilos {
    
    public static class HiloAcelerar extends Thread {
        
        public void run() {
            
            dx += 3;
            
        }
    
    }
    
    public static class HiloFrenar extends Thread {
        
        public void run() {
            
            if(dx >= 3) {
                
                dx -= 3;
                
            } else {
                
                JOptionPane.showMessageDialog(null, "El carro está detenido");
                
            }
            
        }
    
    }
    
    public static class HiloMover extends Thread {
        
        public HiloMover(JPanel carro, JPanel lamina, JButton ba, JButton bf) {
            
            this.carro = carro;
            
            this.lamina = lamina;
            
            this.ba = ba;
            
            this.bf = bf;
            
        }
        
        public void run() {
            
            while(true) {
                
                try {
                    
                    Thread.sleep(50);
                    
                } catch(InterruptedException e) {
                    
                    e.printStackTrace();
                    
                }
                
                carro.setLocation(carro.getX() + dx, 0);
                    
                if(carro.getX() >= lamina.getWidth() - 640/4) {
                    
                    JOptionPane.showMessageDialog(null, "¡Has chocado!", "Alerta", JOptionPane.WARNING_MESSAGE);
                    
                    ba.setEnabled(false);
                    
                    bf.setEnabled(false);
                    
                    stop();
                    
                }    
                
            }
            
        }
        
        private JPanel carro, lamina;
        
        private JButton ba, bf;
        
    }
    
    public static class HiloRegresar extends Thread {
        
        public HiloRegresar(JPanel carro, JButton ba, JButton bf) {
            
            this.carro = carro;
            
            this.ba = ba;
            
            this.bf = bf;
            
        }
        
        public void run() {
            
            carro.setLocation(0, 0);
            
            if(!ba.isEnabled()) {
                
                ba.setEnabled(true);
                
            }
            
            if(!bf.isEnabled()) {
                
                bf.setEnabled(true);
                
            }
            
        }
        
        private JPanel carro;
        
        private JButton ba, bf;
        
    }
    
    public static void reiniciarDX() {
        
        dx = 0;
        
    }
    
    private static int dx = 0;
    
}
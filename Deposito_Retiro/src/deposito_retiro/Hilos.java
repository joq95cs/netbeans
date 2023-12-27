package deposito_retiro;

import javax.swing.*;

public class Hilos {
    
    public static class Deposito implements Runnable {
        
        public Deposito(Monitor m) {
            
            this.m = m;

            hDeposito = new Thread(this);
            
        }
        
        public void iniciarHilo() {
            
            hDeposito.start();
            
        }
        
        public void run() {
            
            try {
            
                while(true) {
                    
                    m.depositar();
                    
                    Thread.sleep(300);
                    
                }
                
            } catch(InterruptedException e) {
                
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                
            }
            
        }
        
        private final Thread hDeposito;
        
        private final Monitor m;
        
    }
    
    public static class Retiro implements Runnable {
        
        public Retiro(Monitor m) {
            
            this.m = m;
            
            hRetiro = new Thread(this);
            
        }
        
        public void iniciarHilo() {
            
            hRetiro.start();
            
        }
        
        public Thread getHRetiro() {
            
            return hRetiro;
            
        }
        
        public void run() {
            
            try {
                
                while(true) {
                    
                    m.retirar(0);
                    
                    Thread.sleep(300);
                    
                }
                
            } catch(InterruptedException e) {
                
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                
            }
            
        }
        
        private final Thread hRetiro;
        
        private final Monitor m;
        
    }
    
}
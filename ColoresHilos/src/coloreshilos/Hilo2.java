package coloreshilos;

public class Hilo2 extends Thread {
    
    public void run() {
        
        try {
            
            while(true) {
                
                for(int i=5; i<9; i++) {
                    
                    Marco.jPanel4.setBackground(Marco.colores[i]);
                    
                    Marco.jTextArea2.append(Marco.colores[i].toString() + "\n");
                    
                    Thread.sleep(200);
                    
                }
                
            }
            
        } catch(Exception e) {}
        
    }
    
}

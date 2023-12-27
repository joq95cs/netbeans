package coloreshilos;

public class Hilo1 extends Thread {
    
    public void run() {
        
        try {
            
            while(true) {
                
                for(int i=0; i<4; i++) {
                    
                    Marco.jPanel3.setBackground(Marco.colores[i]);
                    
                    Marco.jTextArea1.append(Marco.colores[i].toString() + "\n");
                    
                    Thread.sleep(200);
                    
                }
                
            }
            
        } catch(Exception e) {}
        
    }
    
}

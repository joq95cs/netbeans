package numeroaleatorio;

public class NumeroAleatorio {
    
    public static double generar(int decimales) {
        
        String valor = "0.";
        
        for(int i=0; i<decimales; i++) {
            
            HiloContador contador = new HiloContador();
            
            contador.start();
            
            try {
                
                Thread.sleep(100);
                
            } catch(Exception e) {}
            
            contador.stop();
            
            valor += digito;
            
        }
        
        return Double.parseDouble(valor);
        
    }
    
    private static int digito = 0;
    
    private static class HiloContador extends Thread {
        
        public void run() {
            
            while(true) {
                
                if(digito < 9) {
                    
                    digito ++;
                    
                } else {
                    
                    digito = 0;
                    
                }
                
            }
            
        }
        
    }
    
}
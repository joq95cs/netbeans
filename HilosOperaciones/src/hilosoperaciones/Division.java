package hilosoperaciones;

public class Division implements Runnable {
    
    public void run() {
        
        double num1, num2;
        
        while(true) {
            
            try {
                
                num1 = Double.parseDouble(Ventana.ctNum1.getText());
                num2 = Double.parseDouble(Ventana.ctNum2.getText());
                
                Ventana.ctDiv.setText("" + (num1 / num2));
                
                Thread.sleep(50);
                
            } catch(Exception e) {}
            
        }
        
    }
    
}
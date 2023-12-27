package calculadora;

import javax.swing.*;

public class Funcionalidad {
    
    public Funcionalidad(JTextField tf_entrada) throws Exception {
        
        this.tf_entrada = tf_entrada;
        enProceso = false;
        borrar = true;
    }
    
    public void escribirNumero(String numero) throws Exception {
        
        if(borrar) {
            
            tf_entrada.setText("");
            borrar = false;
        }
        
        tf_entrada.setText(tf_entrada.getText() + numero);
    }
    
    public void operacion(String simbolo) throws Exception {
        
        if(tf_entrada.getText().isEmpty()) {
            
            return;
        }
        
        enProceso = true;
        
        n1 = Integer.parseInt(tf_entrada.getText());
        this.simbolo = simbolo;
        
        tf_entrada.setText(simbolo);
        borrar = true;
    }
    
    public void resultado() throws Exception {
        
        if(enProceso) {
            
            n2 = Integer.parseInt(tf_entrada.getText());
            
            switch(simbolo) {
            
                case "+":

                    r = n1 + n2;
                    tf_entrada.setText(String.valueOf(r));
                    break;

                case "-":

                    r = n1 - n2;
                    tf_entrada.setText(String.valueOf(r));
                    break;
                    
                case "*":
                    
                    r = n1 * n2;
                    tf_entrada.setText(String.valueOf(r));
                    break;
                    
                case "/":
                    
                    r = n1 / n2;
                    tf_entrada.setText(String.valueOf(r));
                    break;
            }
            
            enProceso = false;
            //borrar = true;
        }  
    }
    
    public void limpiar() throws Exception {
        
        enProceso = false;
        borrar = true;
        
        n1 = 0;
        n2 = 0;
        r = 0;
        
        tf_entrada.setText("0");
    }
    
    private JTextField tf_entrada;
    private int n1, n2, r;
    private String simbolo;
    private boolean enProceso;
    
    boolean borrar;
}

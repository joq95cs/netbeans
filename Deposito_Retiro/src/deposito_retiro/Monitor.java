package deposito_retiro;

import javax.swing.*;

public class Monitor {
    
    public Monitor(JTextField ct1, JTextField ct2, JButton bt2, JTextArea at) {
        
        this.ct1 = ct1;
        
        this.ct2 = ct2;
        
        this.bt2 = bt2;
        
        this.at = at;
        
    }
    
    public synchronized void depositar() {
        
        try {
        
            if(depositar) {

                if(Double.parseDouble(ct1.getText()) <= 0) {

                    JOptionPane.showMessageDialog(null, "Cantidad no válida", "Error", 0);

                } else {

                    JOptionPane.showMessageDialog(null, "Ha depositado: " + Double.parseDouble(ct1.getText()));

                    ct2.setText(String.valueOf(Double.parseDouble(ct2.getText()) + Double.parseDouble(ct1.getText())));

                    notifyAll();

                }

            }
            
        } catch(Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            
        } finally {
            
            depositar = false;
            
        }
        
    }
    
    public synchronized void retirar(double x) {
        
        try {
            
            if(Double.parseDouble(ct2.getText()) == 0) {
                
                bt2.setEnabled(false);
                
                at.append("Hilo retirar dormido\n");
                
                wait();
                
                at.append("Hilo retirar en ejecución\n");
                
                bt2.setEnabled(true);
                
            }
            
            if(retirar) {
            
                if(x == 0) {

                    x = Double.parseDouble(ct1.getText());

                }

                if(Double.parseDouble(ct2.getText()) < x){

                    JOptionPane.showMessageDialog(null, "No hoy fondos suficientes", "Error", 0);
                    
                    bt2.setEnabled(false);
                    
                    at.append("Hilo retirar dormido\n");

                    wait();
                    
                    at.append("Hilo retirar en ejecución\n");

                    retirar(x);

                } else {
                    
                    if(Double.parseDouble(ct1.getText()) <= 0) {
                        
                        JOptionPane.showMessageDialog(null, "Cantidad no válida", "Error", 0);
                        
                    } else {
                        
                        JOptionPane.showMessageDialog(null, "Ha retirado: " + x);

                        ct2.setText(String.valueOf(Double.parseDouble(ct2.getText()) - x));

                        bt2.setEnabled(true);
                        
                    }
                    
                }
                
            }
            
        } catch(Exception e) {
        
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            
        } finally {
            
            retirar = false;
            
        }
        
    }
    
    public void setDepositar(boolean depositar) {
        
        this.depositar = depositar;
        
    }
    
    public void setRetirar(boolean retirar) {
        
        this.retirar = retirar;
        
    }
    
    private boolean depositar, retirar;
    
    private final JTextField ct1, ct2;
    
    private final JButton bt2;
    
    private final JTextArea at;
    
}
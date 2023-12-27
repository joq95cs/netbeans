
package carrito;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Movimiento {
    
    public Movimiento(JPanel lcar, double d, JLabel lTimer, JLabel lVel, JButton btAc, JButton btDes) {
        
        this.lcar = lcar;
        this.d = d;
        this.lTimer = lTimer;
        
        min = 0;
        seg = 0;
        
        tc = new Timer(1000, new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                seg ++;
                
                if(seg == 60) {
                    
                    min++;
                    seg = 0;
                }
                
                String aux_seg = (seg + "").length() == 1 ? "0" + seg : seg + "";
                String aux_min = (min + "").length() == 1 ? "0" + min : min + "";
                
                lTimer.setText("Cronómetro = " + aux_min + ":" + aux_seg);
            }
        });
        
        tm = new Timer(100, new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                lcar.setLocation(lcar.getLocation().x + calcularPixeles(), lcar.getLocation().y);
                
                if(lcar.getLocation().x >= 1366) {
                    
                    int aux_dx = dx;
                    dx = 0;
                    
                    lcar.setLocation(0, lcar.getLocation().y);
                    
                    lTimer.setText("Cronómetro = 00:00");
                    
                    tc.stop();
                    
                    String aux_seg = (seg + "").length() == 1 ? "0" + seg : seg + "";
                    String aux_min = (min + "").length() == 1 ? "0" + min : min + "";
                    
                    btAc.setBackground(Color.RED);
                    btDes.setBackground(Color.RED);
                    
                    JOptionPane.showMessageDialog(null, "Tiempo total: " + aux_min + ":" + aux_seg + "\nVelocidad final: " + aux_dx + " Km/s", "Recorrido terminado", JOptionPane.WARNING_MESSAGE);
                    
                    min = 0;
                    seg = 0;
                    
                    lVel.setText("Velocidad: 0 Km/s");
                    
                } else if(lcar.getLocation().x <= 0) {
                    
                    dx = 0;
                    lVel.setText("Velocidad: 0 Km/s");
                    lTimer.setText("Cronómetro = 00:00");
                    tc.stop();

                    min = 0;
                    seg = 0;
                    
                    lcar.setLocation(0, lcar.getLocation().y);
                    
                    btAc.setBackground(Color.RED);
                    btDes.setBackground(Color.RED);
                }
            
            }
        
        });
        
    }
    
    private JPanel lcar;
    
    public int getDX() {
        
        return dx;
    }
    
    public Timer getTC() {
        
        return tc;
    }
    
    public Timer getTM() {
        
        return tm;
    }
        
    public void acelerar() {
        
        dx += 10;
    }
    
    public void desacelerar() {
        
        dx -= 10;
    }
    
    private int calcularPixeles() {
        
        double aux = d / 100; //3
        double porcentaje = dx / aux; //3.33
        porcentaje = porcentaje / 100; //0.03333
        
        return (int)Math.round((1366*porcentaje)/10);
    }
    
    private int dx = 0;
    private double d;
    private JLabel lTimer;
    
    private Timer tc, tm;
    private int min, seg;
    
}

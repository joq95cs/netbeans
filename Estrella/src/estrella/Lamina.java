package estrella;

import javax.swing.*;

import java.awt.*;

public class Lamina extends JPanel {
    
    public Lamina() {
        
        while(true) {
            
            try {
                
                String valor = JOptionPane.showInputDialog(null, "Ingrese cantidad de líneas", "Dibujando estrella", JOptionPane.QUESTION_MESSAGE);
            
                if(valor == null) {
                    
                    System.exit(0);
                    
                }
                
                cantidad = Integer.parseInt(valor);
                
                if(cantidad <= 0) {
                    
                    throw new Exception("Cantidad no válida");
                    
                }
                
                break;
                
            } catch(Exception e) {
                
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                
            }
                
        }
        
        listo = false;
        
    }
    
    public void dibujar(int ancho, int alto, Graphics g) {
        
        g.drawLine(ancho/2, 0, ancho/2, alto);
        
        g.drawLine(0, alto/2, ancho, alto/2);
        
        for(int i=0; i<cantidad; i++) {
            
            g.drawLine(ancho/2, i*alto/2/cantidad, ancho/2+(i+1)*ancho/2/cantidad, alto/2 );
            
        }
        
        for(int i=0; i<cantidad; i++) {
            
            g.drawLine(ancho/2, alto-i*alto/2/cantidad, ancho/2+(i+1)*ancho/2/cantidad, alto/2);
            
        }
        
        for(int i=0; i<cantidad; i++) {
            
            g.drawLine(ancho/2, alto-i*alto/2/cantidad, ancho/2-(i+1)*ancho/2/cantidad, alto/2);
            
        }
        
        for(int i=0; i<cantidad; i++) {
            
            g.drawLine(ancho/2, i*alto/2/cantidad, ancho/2-(i+1)*ancho/2/cantidad, alto/2 );
            
        }
        
    }
    
    public void setListo() {
        
        listo = true;
        
    }
    
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        setBackground(Color.WHITE);
        
        if(listo) {
            
            dibujar(getWidth(), getHeight(), g);
            
        }
        
    }  
    
    private int cantidad;
    
    private boolean listo;
    
}

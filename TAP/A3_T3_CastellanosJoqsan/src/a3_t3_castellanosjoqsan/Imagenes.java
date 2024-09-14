package a3_t3_castellanosjoqsan;

import java.awt.*;

import java.io.*;

import javax.swing.*;

import javax.imageio.*;

public class Imagenes {
    
    public static class Imagen1 extends JPanel {
        
        public void refrescar(int n) {
            
            Imagen1.n = n;
            
            repaint();
            
        }
        
        public void paintComponent(Graphics g) {
            
            super.paintComponent(g);
            
            try {
                
                g.drawImage(ImageIO.read(new File("images/img" + n + ".jpg")), 0, 0, getWidth(), getHeight(), null);
                
            } catch(IOException e) {
            
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                
            }
            
        }
        
        public static void setN() {
            
            n = (int)(Math.random() * 10);
            
            if(n < 1) {
                
                setN();
                
            }
            
        }
        
        public static int n;
        
    }
    
    public static class Imagen2 extends JPanel {
        
        public void refrescar(int n) {
            
            Imagen2.n = n;
            
            repaint();
            
        }
        
        public void paintComponent(Graphics g) {
            
            super.paintComponent(g);
            
            try {
                
                g.drawImage(ImageIO.read(new File("images/img" + n + ".jpg")), 0, 0, getWidth(), getHeight(), null);
                
            } catch(IOException e) {
            
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                
            }
            
        }
        
        public static void setN() {
            
            n = (int)(Math.random() * 10);
            
            if(n < 1) {
                
                setN();
                
            }
            
        }
        
        public static int n;
        
    }
    
    public static class Imagen3 extends JPanel {
        
        public void refrescar(int n) {
            
            Imagen3.n = n;
            
            repaint();
            
        }
        
        public void paintComponent(Graphics g) {
            
            super.paintComponent(g);
            
            try {
                
                g.drawImage(ImageIO.read(new File("images/img" + n + ".jpg")), 0, 0, getWidth(), getHeight(), null);
                
            } catch(IOException e) {
            
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                
            }
            
        }
        
        public static void setN() {
            
            n = (int)(Math.random() * 10);
            
            if(n < 1) {
                
                setN();
                
            }
            
        }
        
        public static int n;
        
    }
    
}
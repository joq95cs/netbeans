package helicoptero;

import javax.swing.*;

import javax.imageio.*;

import java.awt.*;

import java.awt.event.*;

import java.io.*;

public class Graficos {
    
    public static class Marco extends JFrame {
        
        public Marco() {
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            setResizable(false);
            
            setFocusable(false);
            
            setTitle("Helicoptero");
            
            setLayout(null);
            
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            
            setBounds(0, 0, d.width, d.height);
            
            add(new Lamina(d.width, d.height));
            
        }
        
    }
    
    public static class Lamina extends JPanel {
        
        public Lamina(int ancho, int alto) {
            
            setLayout(null);
            
            setBounds(0, 0, ancho, alto);
            
            setBackground(Color.cyan);
            
            setFocusable(true);
            
            h = new JPanel() {
                
                public void paintComponent(Graphics g) {
                    
                    super.paintComponent(g);
                        
                    setBackground(Color.cyan);
                    
                    try {
                        
                        g.drawImage(ImageIO.read(new File("src/helicoptero/helicoptero.png")), 0, 0, getWidth(), getHeight(), null);
                        
                    } catch(IOException e) {
                        
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                        
                    }
                    
                }
                
            };
            
            h.setBounds(0, getHeight()-120, 120, 120);
            
            h.setFocusable(false);
            
            add(h);
            
            addKeyListener(new Oyente());
            
            Hilos.setValores(h, ancho, alto);
            
            mover = new Hilos.HiloMover();
            
            mover.start();
            
        }
        
        private JPanel h;
        
        private Hilos.HiloMover mover;
        
        private class Oyente extends KeyAdapter {
            
            public void keyPressed(KeyEvent e) {
                
                switch(e.getKeyCode()) {
                    
                    case KeyEvent.VK_UP:
                        
                        new Hilos.HiloArriba().start();
                        
                        break;
                        
                    case KeyEvent.VK_DOWN:
                        
                        new Hilos.HiloAbajo().start();
                        
                        break;
                        
                    case KeyEvent.VK_RIGHT:
                        
                        new Hilos.HiloDerecha().start();
                        
                        break;
                        
                    case KeyEvent.VK_LEFT:
                        
                        new Hilos.HiloIzquierda().start();
                    
                }
                
            }
            
        }
        
    }
    
}
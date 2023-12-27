package globoaerostatico;

import javax.swing.*;

import java.awt.*;

import javax.imageio.*;

import java.io.*;

public class Graficos {
    
    public static class Marco extends JFrame {
        
        public Marco() {
            
            setSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
                    (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
            
            setTitle("Globo aerostático con hilos");
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            add(l);
            
        }
        
    }
    
    public static class Lamina extends JPanel {
        
        public Lamina() {
            
            setLayout(null);
            
            setBackground(new Color(12, 183, 242));
            
            globo.setBounds(0, ((532/10)+5), 592/4, 800/4);
            
            add(globo);
            
            Hilos.hg.start();
            
            Hilos.hc.start();
            
            Hilos.hh.start();
            
            Hilos.hs.start();
            
        }
        
        public static JPanel globo = new JPanel() {
                
            public void paintComponent(Graphics g1) {
                    
                super.paintComponent(g1);
                    
                setBackground(new Color(12, 183, 242));
                    
                Graphics2D g2 = (Graphics2D)g1;
                    
                try {
                    
                    g2.drawImage(ImageIO.read(new File("src/globoaerostatico/globo.png")), 0, 0, this.getWidth(), this.getHeight(), null);
                    
                } catch(Exception e) {}
            }
                
        };
        
    }
    
    public static Lamina l = new Lamina();
    
    public static Marco m = new Marco();
    
}
package carro_hilos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import javax.imageio.*;

import java.io.*;

public class Graficos {
    
    public static class Marco extends JFrame {
    
        public Marco() {
        
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
            setTitle("Carro con hilos");
        
            setSize(Toolkit.getDefaultToolkit().getScreenSize().width,
                    Toolkit.getDefaultToolkit().getScreenSize().height/4);
        
            setLocation(0, 3*Toolkit.getDefaultToolkit().getScreenSize().height/8);
        
            add(new Lamina());
        
        }
    
    }
    
    public static class Lamina extends JPanel {
        
        public Lamina() {
            
            setSize(Toolkit.getDefaultToolkit().getScreenSize().width,
                    Toolkit.getDefaultToolkit().getScreenSize().height/4);
        
            setLayout(new BorderLayout());
        
            JPanel lc = new JPanel();
        
            lc.setLayout(null);
        
            add(lc, BorderLayout.CENTER);
        
            JPanel ls = new JPanel();
        
            add(ls, BorderLayout.SOUTH);
        
            ba = new JButton("Acelerar");
        
            ls.add(ba);
        
            bf = new JButton("Frenar");
        
            ls.add(bf);
            
            br = new JButton("Regresar");
            
            ls.add(br);
        
            carro = new JPanel() {
            
                public void paintComponent(Graphics g) {
                
                    super.paintComponent(g);
                
                    try {
                
                        g.drawImage(ImageIO.read(new File("src/carro_hilos/carro.png")), 0, 0, getWidth(), getHeight(), null);
                    
                    } catch(IOException e) {
                    
                        System.err.println("No se encuentra la imágen");
                    
                    }
                
                }
            
            };
        
            carro.setBounds(0, 20, 640/4, 320/4);
        
            lc.add(carro);
            
            ActionListener o = new Oyente1();
            
            ba.addActionListener(o);
            
            bf.addActionListener(o);
            
            br.addActionListener(o);
            
            hm = new Hilos.HiloMover(carro, this, ba, bf);
            
            hm.start();
        
        }
        
        public void reiniciarHM() {
            
            hm = new Hilos.HiloMover(carro, this, ba, bf);
            
            hm.start();
            
        }
    
        private JButton ba, bf, br;
    
        private JPanel carro;
        
        private Hilos.HiloMover hm;
        
        private class Oyente1 implements ActionListener {
            
            public void actionPerformed(ActionEvent e) {
                
                if(e.getSource() == ba) {
                    
                    System.out.println("Acelerando");
                    
                    new Hilos.HiloAcelerar().start();
                    
                } else if(e.getSource() == bf) {
                    
                    System.out.println("Frenando");
                    
                    new Hilos.HiloFrenar().start();
                    
                } else {
                    
                    new Hilos.HiloRegresar(carro, ba, bf).start();
                    
                    if(!hm.isAlive()) {
                        
                        Hilos.reiniciarDX();
                        
                        reiniciarHM();
                        
                    }
                    
                }
                
            }
            
        }
        
    }
    
}
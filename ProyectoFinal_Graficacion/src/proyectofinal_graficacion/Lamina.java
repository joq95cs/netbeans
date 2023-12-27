package proyectofinal_graficacion;

import javax.swing.*;

import javax.swing.event.*;

import javax.imageio.*;

import java.awt.*;

import java.io.*;

public class Lamina extends JPanel {
    
    public Lamina() {
        
        setBounds(0, 0, 1080, 486);
        
        setLayout(null);
        
        JPanel lamina1 = new JPanel() {
            
            public void paintComponent(Graphics g) {
        
                super.paintComponent(g);
        
                try {
            
                    g.drawImage(ImageIO.read(new File("imagenes/base.png")), 0, 0, 1080, 336, null);
                
                } catch(IOException e) {
            
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            
                }
        
            }
            
        };
        
        lamina1.setBounds(0, 0, 1080, 336);
        
        lamina1.setLayout(null);
        
        add(lamina1);
        
        JPanel lamina2 = new JPanel();
        
        lamina2.setBounds(0, 336, 1080, 100);
        
        lamina2.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        
        c.weightx = 1;
        
        c.weighty = 1;
        
        c.gridx = 0;
        
        c.gridy = 0;
        
        lamina2.add(new JLabel("Lampara"), c);
        
        c.gridx = 1;
        
        lamina2.add(new JLabel("Planta"), c);
        
        c.gridx = 2;
        
        lamina2.add(new JLabel("Ventilador"), c);
        
        c.gridx = 0;
        
        c.gridy = 1;
        
        s1 = new JSlider(1, 25, 1);
        
        lamina2.add(s1, c);
        
        c.gridx = 1;
        
        s2 = new JSlider(1, 25, 1);
        
        lamina2.add(s2, c);
        
        c.gridx = 2;
        
        s3 = new JSlider(1, 25, 1);
        
        lamina2.add(s3, c);
        
        c.gridx = 0;
        
        c.gridy = 2;
        
        lamina2.add(new JLabel("Silla"), c);
        
        c.gridx = 1;
        
        lamina2.add(new JLabel("Velas"), c);
        
        c.gridx = 2;
        
        lamina2.add(new JLabel("Laptop"), c);
        
        c.gridx = 0;
        
        c.gridy = 3;
        
        s4 = new JSlider(1, 25, 1);
        
        lamina2.add(s4, c);
        
        c.gridx = 1;
        
        s5 = new JSlider(1, 25, 1);
        
        lamina2.add(s5, c);
        
        c.gridx = 2;
        
        s6 = new JSlider(1, 25, 1);
        
        lamina2.add(s6, c);
        
        add(lamina2);
        
        ChangeListener o = new Oyente();
        
        s1.addChangeListener(o);
        
        s2.addChangeListener(o);
        
        s3.addChangeListener(o);
        
        s4.addChangeListener(o);
        
        s5.addChangeListener(o);
        
        s6.addChangeListener(o);
        
        n1 = 1;
        
        lo1 = new JPanel() {
            
            public void paintComponent(Graphics g) {
                
                super.paintComponent(g);
                
                try {
                    
                    g.drawImage(ImageIO.read(new File("imagenes/l" + n1 + ".png")), 0, 0, 170, 148, 204, 0, 374, 148, null);
                
                } catch(IOException e) {
            
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            
                }
                
            }
            
        };
        
        lo1.setBounds(204, 0, 170, 148);
        
        lamina1.add(lo1);
        
        n2 = 1;
        
        lo2 = new JPanel() {
            
            public void paintComponent(Graphics g) {
                
                super.paintComponent(g);
                
                try {
                    
                    g.drawImage(ImageIO.read(new File("imagenes/p" + n2 + ".png")), 0, 0, 151, 124, 416, 158, 567, 282, null);
                
                } catch(IOException e) {
            
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            
                }
                
            }
            
        };
        
        lo2.setBounds(416, 158, 151, 124);
        
        lamina1.add(lo2);
        
        n3 = 1;
        
        lo3 = new JPanel() {
            
            public void paintComponent(Graphics g) {
                
                super.paintComponent(g);
                
                try {
                    
                    g.drawImage(ImageIO.read(new File("imagenes/v" + n3 + ".png")), 0, 0, 144, 63, 580, 0, 724, 63, null);
                
                } catch(IOException e) {
            
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            
                }
                
            }
            
        };
        
        lo3.setBounds(580, 0, 144, 63);
        
        lamina1.add(lo3);
        
        n4 = 1;
        
        lo4 = new JPanel() {
            
            public void paintComponent(Graphics g) {
                
                super.paintComponent(g);
                
                try {
                    
                    g.drawImage(ImageIO.read(new File("imagenes/s" + n4 + ".png")), 0, 0, 98, 132, 713, 179, 811, 311, null);
                
                } catch(IOException e) {
            
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            
                }
                
            }
            
        };
        
        lo4.setBounds(713, 179, 98, 132);
        
        lamina1.add(lo4);
        
        n5 = 1;
        
        lo5 = new JPanel() {
            
            public void paintComponent(Graphics g) {
                
                super.paintComponent(g);
                
                try {
                    
                    g.drawImage(ImageIO.read(new File("imagenes/c" + n5 + ".png")), 0, 0, 100, 106, 864, 218, 964, 324, null);
                
                } catch(IOException e) {
            
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            
                }
                
            }
            
        };
        
        lo5.setBounds(864, 218, 100, 106);
        
        lamina1.add(lo5);
        
        n6 = 1;
        
        lo6 = new JPanel() {
            
            public void paintComponent(Graphics g) {
                
                super.paintComponent(g);
                
                try {
                    
                    g.drawImage(ImageIO.read(new File("imagenes/o" + n6 + ".png")), 0, 0, 87, 60, 617, 131, 704, 191, null);
                
                } catch(IOException e) {
            
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            
                }
                
            }
            
        };
        
        lo6.setBounds(617, 131, 87, 60);
        
        lamina1.add(lo6);
        
    }
    
    private JSlider s1, s2, s3, s4, s5, s6;
    
    private JPanel lo1, lo2, lo3, lo4, lo5, lo6;
    
    private int n1, n2, n3, n4, n5, n6;
    
    private class Oyente implements ChangeListener {
        
        public void stateChanged(ChangeEvent e) {
            
            if(e.getSource().equals(s1)) {
                
                n1 = s1.getValue();
                
                lo1.repaint();
                
            } else if(e.getSource().equals(s2)) {
                
                n2 = s2.getValue();
                
                lo2.repaint();
                
            } else if(e.getSource().equals(s3)) {
                
                n3 = s3.getValue();
                
                lo3.repaint();
                
            } else if(e.getSource().equals(s4)) {
                
                n4 = s4.getValue();
                
                lo4.repaint();
                
            } else if(e.getSource().equals(s5)) {
                
                n5 = s5.getValue();
                
                lo5.repaint();
                
            } else {
                
                n6 = s6.getValue();
                
                lo6.repaint();
                
            }
            
        }
        
    }
    
}
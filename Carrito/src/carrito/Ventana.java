
package carrito;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class Ventana {
    
    public static class Marco extends JFrame {
        
        public Marco() {
            
            setTitle("Carrito");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            setIconImage(Toolkit.getDefaultToolkit().getImage("src/img/carrito.png"));
            
            setSize(w, h);
            setLocation(0, Toolkit.getDefaultToolkit().getScreenSize().height/2 - h/2);
            setResizable(true);
            
            add(ln, BorderLayout.NORTH);
            add(ls, BorderLayout.SOUTH);
            add(lc, BorderLayout.CENTER);
            
            double d = 0;
            
            while(true) {
                
                try {
                    
                    String aux_d = JOptionPane.showInputDialog(null, "Ingrese la distancia a recorrer", "Carrito", JOptionPane.QUESTION_MESSAGE);
                    
                    if(aux_d == null) System.exit(0);
                    
                    d = Double.parseDouble(aux_d);
                    
                    break;
                    
                } catch(NumberFormatException e) {
                    
                    JOptionPane.showMessageDialog(null, "Valor no válido", "Error", 0);
                }
            }
            
            ln.getLDist().setText("Distancia: " + d + " Km");
            
            m = new Movimiento(lc.getLCar(), d, ln.getLTimer(), ln.getLVel(), ls.getBTAc(), ls.getBTDes());
            m.getTM().start();
            
            
        }
        
        public static int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        public static int h = Toolkit.getDefaultToolkit().getScreenSize().height/3;
        
    }
    
    private static class LCentro extends JPanel {
        
        public LCentro() {
            
            setBackground(new Color(179, 233, 234));
            
            setLayout(null);
            
            lcar = new LCarrito();
            
            
            lcar.setSize(120, 79);
            lcar.setLocation(0, Marco.h - 180);
            add(lcar);
        }
        
        public LCarrito getLCar() {
            
            return lcar;
        }
        
        private LCarrito lcar;
    }
        
    private static class LNorte extends JPanel {
        
        public LNorte() {
            
            setBackground(new Color(179, 233, 234));
            
            setLayout(new GridLayout(3, 1));
            
            lTimer = new JLabel("Cronómetro = 00:00");
            lTimer.setHorizontalAlignment(JLabel.CENTER);
            lDist = new JLabel("Distancia: 0");
            lDist.setHorizontalAlignment(JLabel.CENTER);
            lVel = new JLabel("Velocidad: 0 Km/s");
            lVel.setHorizontalAlignment(JLabel.CENTER);
            add(lTimer);
            add(lDist);
            add(lVel);

        }
        
        public JLabel getLTimer() {
            
            return lTimer;
        }
        
        public JLabel getLDist() {
            
            return lDist;
        }
        
        public JLabel getLVel() {
            
            return lVel;
        }
        
        private JLabel lTimer;
        private JLabel lDist;
        private JLabel lVel;
            
    }
        
    private static class LSur extends JPanel {
        
        public LSur() {
            
            setBackground(Color.gray);
            
            btAc = new JButton("Acelerar");
            btDes = new JButton("Desacelerar");
            
            btAc.setBackground(new Color(255, 0, 0));
            btAc.setForeground(new Color(255, 255, 255));
            
            btDes.setBackground(new Color(255, 0, 0));
            btDes.setForeground(new Color(255, 255, 255));
            
            Oyente o = new Oyente();
            
            btAc.addActionListener(o);
            btAc.addKeyListener(o);
            btDes.addActionListener(o);
            btDes.addKeyListener(o);
            
            //addKeyListener(o);
            
            add(btAc);
            add(btDes);

        }
        
        public JButton getBTAc() {
            
            return btAc;
        }
        
        public JButton getBTDes() {
            
            return btDes;
        }
        
        private JButton btAc;
        private JButton btDes;
                
    }
    
    private static class LCarrito extends JPanel {
        
        public void paint(Graphics g) {

            try {
                
                Image img = ImageIO.read(new File("src/img/carrito.png"));
                g.drawImage(img, 0, 0, this);
            } catch (IOException ex) {
                
                ex.printStackTrace();
            }
        }
    }
    
    private static class Oyente extends KeyAdapter implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            
            if(!m.getTC().isRunning()) m.getTC().start();
            
            if(e.getSource().equals(ls.btAc)) { 
                
                m.acelerar();
                ln.getLVel().setText("Velocidad: " + m.getDX() + " Km/s");
                
                if(m.getDX() == 0) {
                
                    ls.getBTAc().setBackground(Color.RED);
                    ls.getBTDes().setBackground(Color.RED);
                } else {
                    
                    ls.getBTAc().setBackground(Color.GREEN);
                    ls.getBTDes().setBackground(Color.GREEN);
                } 
            } else {
                
                m.desacelerar();
                ln.getLVel().setText("Velocidad: " + m.getDX() + " Km/s");
                
                if(m.getDX() == 0) {
                
                    ls.getBTAc().setBackground(Color.RED);
                    ls.getBTDes().setBackground(Color.RED);
                } else {
                    
                    ls.getBTAc().setBackground(Color.GREEN);
                    ls.getBTDes().setBackground(Color.GREEN);
                }
            }
            
        }
        
        public void keyPressed(KeyEvent e) {
            
            ls.getBTAc().setBackground(Color.GREEN);
            ls.getBTDes().setBackground(Color.GREEN);
            
            if(!m.getTC().isRunning()) m.getTC().start();
            
            if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                
                m.acelerar();
                ln.getLVel().setText("Velocidad: " + m.getDX() + " Km/s");
                
                if(m.getDX() == 0) {
                
                    ls.getBTAc().setBackground(Color.RED);
                    ls.getBTDes().setBackground(Color.RED);
                } else {
                    
                    ls.getBTAc().setBackground(Color.GREEN);
                    ls.getBTDes().setBackground(Color.GREEN);
                }

            } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                
                m.desacelerar();
                ln.getLVel().setText("Velocidad: " + m.getDX() + " Km/s");
                
                if(m.getDX() == 0) {
                
                    ls.getBTAc().setBackground(Color.RED);
                    ls.getBTDes().setBackground(Color.RED);
                } else {
                    
                    ls.getBTAc().setBackground(Color.GREEN);
                    ls.getBTDes().setBackground(Color.GREEN);
                }

            }
        }
    }
    
    private static LNorte ln = new LNorte();
    private static LSur ls = new LSur();
    private static LCentro lc = new LCentro();
    
    private static Movimiento m = null;
    
}

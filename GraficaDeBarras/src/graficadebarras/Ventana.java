package graficadebarras;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class Ventana {
    
    public static class Marco extends JFrame {
        
        public Marco() {
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            setTitle("Gráfica de barras");
            
            setSize(600, 350);
            
            int w = Toolkit.getDefaultToolkit().getScreenSize().width;
            
            int h = Toolkit.getDefaultToolkit().getScreenSize().height;
            
            setLocation(w/2 - getWidth()/2, h/2 - getHeight()/2);
            
            add(new Lamina());
            
        }
        
    }
    
    public static class Lamina extends JPanel {
        
        public Lamina() {
            
            setLayout(new BorderLayout());
            
            add(new LaminaNorte(), BorderLayout.NORTH);
            
            add(new LaminaCentro(), BorderLayout.CENTER);
            
            add(new LaminaSur(), BorderLayout.SOUTH);
            
        }
        
        private void actualizarGrafica(int v1, int v2, int v3, int v4, int v5) {
            
            for(int i=0; i<100; i++) {
                
                b1[i].setBackground(Color.green);
                
            }
            
            for(int i=0; i<100-v1; i++) {
                
                b1[i].setBackground(Color.white);
                
            }
            
            for(int i=0; i<100; i++) {
                
                b2[i].setBackground(Color.cyan);
                
            }
            
            for(int i=0; i<100-v2; i++) {
                
                b2[i].setBackground(Color.white);
                
            }
            
            for(int i=0; i<100; i++) {
                
                b3[i].setBackground(Color.pink);
                
            }
            
            for(int i=0; i<100-v3; i++) {
                
                b3[i].setBackground(Color.white);
                
            }
            
            for(int i=0; i<100; i++) {
                
                b4[i].setBackground(Color.red);
                
            }
            
            for(int i=0; i<100-v4; i++) {
                
                b4[i].setBackground(Color.white);
                
            }
            
            for(int i=0; i<100; i++) {
                
                b5[i].setBackground(Color.yellow);
                
            }
            
            for(int i=0; i<100-v5; i++) {
                
                b5[i].setBackground(Color.white);
                
            }
            
        }
        
        private boolean verificarValor(int v) {
            
            return v>=0 && v<=100;
            
        }
        
        private class LaminaNorte extends JPanel {
            
            public LaminaNorte() {
                
                setLayout(new GridBagLayout());
                
                GridBagConstraints c = new GridBagConstraints();
                
                c.gridwidth = 1;
                
                c.gridheight = 1;
                
                c.weightx = 1;
                
                c.gridx = 0;
                
                c.gridy = 0;
                
                add(new JLabel("Valor 1"), c);
                
                tf1 = new JTextField(3);
                
                c.gridx = 1;
                
                add(tf1, c);
                
                c.gridx = 2;
                
                add(new JLabel("Valor 2"), c);
                
                tf2 = new JTextField(3);
                
                c.gridx = 3;
                
                add(tf2, c);
                
                c.gridx = 4;
                
                add(new JLabel("Valor 3"), c);
                
                tf3 = new JTextField(3);
                
                c.gridx = 5;
                
                add(tf3, c);
                
                c.gridx = 6;
                
                add(new JLabel("Valor 4"), c);
                
                c.gridx = 7;
                
                tf4 = new JTextField(3);
                
                add(tf4, c);
                
                c.gridx = 8;
                
                add(new JLabel("Valor 5"), c);
                
                tf5 = new JTextField(3);
                
                c.gridx = 9;
                
                add(tf5, c);
                
                bt = new JButton("Generar");
                
                bt.addActionListener(new Oyente());
                
                c.gridx = 10;
                
                add(bt, c);
                
            }
            
        }
        
        private class LaminaCentro extends JPanel {
            
            public LaminaCentro() {
                
                setLayout(new GridLayout(1, 5));
                
                JPanel l1 = new JPanel();
                
                l1.setLayout(new GridLayout(100, 1));
                
                b1 = new JPanel[100];
                
                for(int i=0; i<100; i++) {
                    
                    b1[i] = new JPanel();
                    
                    b1[i].setBackground(Color.white);
                    
                    l1.add(b1[i]);
                    
                }
                
                add(l1);
                
                JPanel l2 = new JPanel();
                
                l2.setLayout(new GridLayout(100, 1));
                
                b2 = new JPanel[100];
                
                for(int i=0; i<100; i++) {
                    
                    b2[i] = new JPanel();
                    
                    b2[i].setBackground(Color.white);
                    
                    l2.add(b2[i]);
                    
                }
                
                add(l2);
                
                JPanel l3 = new JPanel();
                
                l3.setLayout(new GridLayout(100, 1));
                
                b3 = new JPanel[100];
                
                for(int i=0; i<100; i++) {
                    
                    b3[i] = new JPanel();
                    
                    b3[i].setBackground(Color.white);
                    
                    l3.add(b3[i]);
                    
                }
                
                add(l3);
                
                JPanel l4 = new JPanel();
                
                l4.setLayout(new GridLayout(100, 1));
                
                b4 = new JPanel[100];
                
                for(int i=0; i<100; i++) {
                    
                    b4[i] = new JPanel();
                    
                    b4[i].setBackground(Color.white);
                    
                    l4.add(b4[i]);
                    
                }
                
                add(l4);
                
                JPanel l5 = new JPanel();
                
                l5.setLayout(new GridLayout(100, 1));
                
                b5 = new JPanel[100];
                
                for(int i=0; i<100; i++) {
                    
                    b5[i] = new JPanel();
                    
                    b5[i].setBackground(Color.white);
                    
                    l5.add(b5[i]);
                    
                }
                
                add(l5);
                
            }
            
        }
        
        private class LaminaSur extends JPanel {
            
            public LaminaSur() {
                
                setLayout(new GridLayout(1, 5));
                
                JPanel l1 = new JPanel();
                
                l1.add(new JLabel("Valor 1"), JLabel.CENTER);
                
                add(l1);
                
                JPanel l2 = new JPanel();
                
                l2.add(new JLabel("Valor 2"), JLabel.CENTER);
                
                add(l2);
                
                JPanel l3 = new JPanel();
                
                l3.add(new JLabel("Valor 3"), JLabel.CENTER);
                
                add(l3);
                
                JPanel l4 = new JPanel();
                
                l4.add(new JLabel("Valor 4"), JLabel.CENTER);
                
                add(l4);
                
                JPanel l5 = new JPanel();
                
                l5.add(new JLabel("Valor 5"), JLabel.CENTER);
                
                add(l5);
                
            }
            
        }
        
        private class Oyente implements ActionListener {
            
            public void actionPerformed(ActionEvent e) {
                
                try {
                
                    int v1 = Integer.parseInt(tf1.getText());

                    int v2 = Integer.parseInt(tf2.getText());

                    int v3 = Integer.parseInt(tf3.getText());

                    int v4 = Integer.parseInt(tf4.getText());

                    int v5 = Integer.parseInt(tf5.getText());
                    
                    if(!verificarValor(v1) || !verificarValor(v2) || !verificarValor(v3) || !verificarValor(v4) || !verificarValor(v5)) {
                        
                        JOptionPane.showMessageDialog(null, "Uno o más valores fuera de rango", "Error", JOptionPane.ERROR_MESSAGE);
                        
                    } else {

                        actualizarGrafica(v1, v2, v3, v4, v5);
                        
                    }
                    
                } catch(Exception ex) {
                
                    JOptionPane.showMessageDialog(null, "Campos vacíos o valores invalidos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    
                }
                
            }
            
        }
        
        private JTextField tf1, tf2, tf3, tf4, tf5, tf6;
        
        private JButton bt;
        
        private JPanel[] b1, b2, b3, b4, b5;
        
    }
    
}
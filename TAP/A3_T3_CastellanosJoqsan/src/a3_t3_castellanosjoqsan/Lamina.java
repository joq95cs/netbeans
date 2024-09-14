package a3_t3_castellanosjoqsan;

import java.awt.*;

import java.awt.event.*;

import java.io.*;

import javax.swing.*;

import javax.imageio.*;

public class Lamina extends JPanel {
    
    public Lamina() {
        
        setLayout(new BorderLayout());
        
        JPanel laminaCentro = new JPanel();
        
        laminaCentro.setLayout(new GridLayout(2, 1));
        
        JPanel laminaSuperior = new JPanel();
        
        laminaSuperior.setLayout(new GridLayout(1, 3));
        
        Imagenes.Imagen1.setN();
        
        i1 = new Imagenes.Imagen1();
        
        laminaSuperior.add(i1);
        
        Imagenes.Imagen2.setN();
        
        i2 = new Imagenes.Imagen2();
        
        laminaSuperior.add(i2);
        
        Imagenes.Imagen3.setN();
        
        i3 = new Imagenes.Imagen3();
        
        laminaSuperior.add(i3);
        
        laminaCentro.add(laminaSuperior);
        
        JPanel laminaInferior = new JPanel();
        
        laminaInferior.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        
        c.weightx = 1;
        
        c.weighty = 1;
        
        c.gridx = 0;
        
        c.gridy = 0;
        
        laminaInferior.add(new JLabel("Cantidad a apostar"), c);
        
        ct1 = new JTextField(5);
        
        ct1.setText("0.0");
        
        ct1.setEditable(false);
        
        c.gridx = 1;
        
        laminaInferior.add(ct1, c);
        
        c.gridx = 2;
        
        laminaInferior.add(new JLabel("Cantidad restante"), c);
        
        ct2 = new JTextField(5);
        
        ct2.setText(String.valueOf(500000));
        
        ct2.setEditable(false);
        
        c.gridx = 3;
        
        laminaInferior.add(ct2, c);
        
        bt1 = new JButton("Apostar");
        
        c.gridwidth = 2;
        
        c.gridx = 0;
        
        c.gridy = 1;
        
        laminaInferior.add(bt1, c);
        
        bt2 = new JButton("Cancelar");
        
        bt2.setEnabled(false);
        
        c.gridx = 2;
        
        laminaInferior.add(bt2, c);
        
        bt3 = new JButton("Iniciar");
        
        bt3.setEnabled(false);
        
        c.gridx = 0;
        
        c.gridy = 2;
        
        laminaInferior.add(bt3, c);
        
        bt4 = new JButton("Terminar");
        
        bt4.setEnabled(false);
        
        c.gridx = 2;
        
        laminaInferior.add(bt4, c);
        
        et1 = new JLabel("¡BIENVENIDO!");
        
        c.gridwidth = 4;
        
        c.gridx = 0;
        
        c.gridy = 3;
        
        laminaInferior.add(et1, c);
        
        et2 = new JLabel("MONTO GANADO: 0.0");
        
        c.gridy = 4;
        
        laminaInferior.add(et2, c);
        
        c.gridy = 5;
        
        et3 = new JLabel("MONTO RECUPERADO: 0.0");
        
        laminaInferior.add(et3, c);
        
        c.gridy = 6;
        
        et4 = new JLabel("TOTAL ACUMULADO: 0.0");
        
        laminaInferior.add(et4, c);
        
        laminaCentro.add(laminaInferior);
        
        add(laminaCentro, BorderLayout.CENTER);
        
        JPanel laminaEste = new JPanel();
        
        laminaEste.setLayout(new BorderLayout());
        
        JLabel etImagenes = new JLabel("Imágenes");
        
        laminaEste.add(etImagenes, BorderLayout.NORTH);
        
        JPanel limagenes = new JPanel();
        
        limagenes.setLayout(new GridLayout(10, 1));
        
        JPanel li1 = new JPanel();
        
        li1.setLayout(new GridLayout(1, 2));
        
        checks = new JCheckBox[10];
        
        checks[0] = new JCheckBox();
        
        li1.add(checks[0]);
        
        li1.add(new JPanel() {
            
            public void paintComponent(Graphics g) {
                
                super.paintComponent(g);
                
                try {
                
                    g.drawImage(ImageIO.read(new File("images/img1.jpg")), 0, 0, getWidth(), getHeight(), null);
                    
                } catch(IOException e) {
                
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                    
                }
                
            }
            
        });
        
        limagenes.add(li1);
        
        JPanel li2 = new JPanel();
        
        li2.setLayout(new GridLayout(1, 2));
        
        checks[1] = new JCheckBox();
        
        li2.add(checks[1]);
        
        li2.add(new JPanel() {
            
            public void paintComponent(Graphics g) {
                
                super.paintComponent(g);
                
                try {
                
                    g.drawImage(ImageIO.read(new File("images/img2.jpg")), 0, 0, getWidth(), getHeight(), null);
                    
                } catch(IOException e) {
                
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                    
                }
                
            }
            
        });
        
        limagenes.add(li2);
        
        JPanel li3 = new JPanel();
        
        li3.setLayout(new GridLayout(1, 2));
        
        checks[2] = new JCheckBox();
        
        li3.add(checks[2]);
        
        li3.add(new JPanel() {
            
            public void paintComponent(Graphics g) {
                
                super.paintComponent(g);
                
                try {
                
                    g.drawImage(ImageIO.read(new File("images/img3.jpg")), 0, 0, getWidth(), getHeight(), null);
                    
                } catch(IOException e) {
                
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                    
                }
                
            }
            
        });
        
        limagenes.add(li3);
        
        JPanel li4 = new JPanel();
        
        li4.setLayout(new GridLayout(1, 2));
        
        checks[3] = new JCheckBox();
        
        li4.add(checks[3]);
        
        li4.add(new JPanel() {
            
            public void paintComponent(Graphics g) {
                
                super.paintComponent(g);
                
                try {
                
                    g.drawImage(ImageIO.read(new File("images/img4.jpg")), 0, 0, getWidth(), getHeight(), null);
                    
                } catch(IOException e) {
                
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                    
                }
                
            }
            
        });
        
        limagenes.add(li4);
        
        JPanel li5 = new JPanel();
        
        li5.setLayout(new GridLayout(1, 2));
        
        checks[4] = new JCheckBox();
        
        li5.add(checks[4]);
        
        li5.add(new JPanel() {
            
            public void paintComponent(Graphics g) {
                
                super.paintComponent(g);
                
                try {
                
                    g.drawImage(ImageIO.read(new File("images/img5.jpg")), 0, 0, getWidth(), getHeight(), null);
                    
                } catch(IOException e) {
                
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                    
                }
                
            }
            
        });
        
        limagenes.add(li5);
        
        JPanel li6 = new JPanel();
        
        li6.setLayout(new GridLayout(1, 2));
        
        checks[5] = new JCheckBox();
        
        li6.add(checks[5]);
        
        li6.add(new JPanel() {
            
            public void paintComponent(Graphics g) {
                
                super.paintComponent(g);
                
                try {
                
                    g.drawImage(ImageIO.read(new File("images/img6.jpg")), 0, 0, getWidth(), getHeight(), null);
                    
                } catch(IOException e) {
                
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                    
                }
                
            }
            
        });
        
        limagenes.add(li6);
        
        JPanel li7 = new JPanel();
        
        li7.setLayout(new GridLayout(1, 2));
        
        checks[6] = new JCheckBox();
        
        li7.add(checks[6]);
        
        li7.add(new JPanel() {
            
            public void paintComponent(Graphics g) {
                
                super.paintComponent(g);
                
                try {
                
                    g.drawImage(ImageIO.read(new File("images/img7.jpg")), 0, 0, getWidth(), getHeight(), null);
                    
                } catch(IOException e) {
                
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                    
                }
                
            }
            
        });
        
        limagenes.add(li7);
        
        JPanel li8 = new JPanel();
        
        li8.setLayout(new GridLayout(1, 2));
        
        checks[7] = new JCheckBox();
        
        li8.add(checks[7]);
        
        li8.add(new JPanel() {
            
            public void paintComponent(Graphics g) {
                
                super.paintComponent(g);
                
                try {
                
                    g.drawImage(ImageIO.read(new File("images/img8.jpg")), 0, 0, getWidth(), getHeight(), null);
                    
                } catch(IOException e) {
                
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                    
                }
                
            }
            
        });
        
        limagenes.add(li8);
        
        JPanel li9 = new JPanel();
        
        li9.setLayout(new GridLayout(1, 2));
        
        checks[8] = new JCheckBox();
        
        li9.add(checks[8]);
        
        li9.add(new JPanel() {
            
            public void paintComponent(Graphics g) {
                
                super.paintComponent(g);
                
                try {
                
                    g.drawImage(ImageIO.read(new File("images/img9.jpg")), 0, 0, getWidth(), getHeight(), null);
                    
                } catch(IOException e) {
                
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                    
                }
                
            }
            
        });
        
        limagenes.add(li9);
        
        JPanel li10 = new JPanel();
        
        li10.setLayout(new GridLayout(1, 2));
        
        checks[9] = new JCheckBox();
        
        li10.add(checks[9]);
        
        li10.add(new JPanel() {
            
            public void paintComponent(Graphics g) {
                
                super.paintComponent(g);
                
                try {
                
                    g.drawImage(ImageIO.read(new File("images/img10.jpg")), 0, 0, getWidth(), getHeight(), null);
                    
                } catch(IOException e) {
                
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                    
                }
                
            }
            
        });
        
        limagenes.add(li10);
        
        laminaEste.add(limagenes, BorderLayout.CENTER);
        
        add(laminaEste, BorderLayout.EAST);
        
        Oyente1 o1 = new Oyente1();
        
        bt1.addActionListener(o1);
        
        bt2.addActionListener(o1);
        
        bt3.addActionListener(o1);
        
        bt4.addActionListener(o1);
        
        Oyente2 o2 = new Oyente2();
        
        checks[0].addActionListener(o2);
        
        checks[1].addActionListener(o2);
        
        checks[2].addActionListener(o2);
        
        checks[3].addActionListener(o2);
        
        checks[4].addActionListener(o2);
        
        checks[5].addActionListener(o2);
        
        checks[6].addActionListener(o2);
        
        checks[7].addActionListener(o2);
        
        checks[8].addActionListener(o2);
        
        checks[9].addActionListener(o2);
        
    }
    
    private class Oyente1 implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            
            try {
            
                if(e.getSource() == bt1) {
                    
                    Manipulador.apostar();

                } else if(e.getSource() == bt2) {
                    
                    Manipulador.cancelar();

                } else if(e.getSource() == bt3) {
                    
                    Manipulador.iniciar();

                } else {
                    
                    Manipulador.terminar();

                }
                
            } catch(Exception ex) {
                
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                
                ct1.setText("0.0");
                        
                if(bt2.isEnabled()) {
                                
                    bt2.setEnabled(false);
                                
                }
                            
                if(bt3.isEnabled()) {
                                
                    bt3.setEnabled(false);
                                
                }
                            
                if(bt4.isEnabled()) {
                                
                    bt4.setEnabled(false);
                                
                }
                        
                Manipulador.listo = false;
                
            }
            
        }
        
    }
    
    private class Oyente2 implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource() == checks[0]) {
                
                if(checks[0].isSelected()) {
                    
                    Manipulador.imagenes.addElement(1);
                    
                } else {
                    
                    Manipulador.imagenes.removeElement(1);
                    
                }
                
            } else if(e.getSource() == checks[1]) {
                
                if(checks[1].isSelected()) {
                    
                    Manipulador.imagenes.addElement(2);
                    
                } else {
                    
                    Manipulador.imagenes.removeElement(2);
                    
                }
                
            } else if(e.getSource() == checks[2]) {
                
                if(checks[2].isSelected()) {
                    
                    Manipulador.imagenes.addElement(3);
                    
                } else {
                    
                    Manipulador.imagenes.removeElement(3);
                    
                }
                
            } else if(e.getSource() == checks[3]) {
                
                if(checks[3].isSelected()) {
                    
                    Manipulador.imagenes.addElement(4);
                    
                } else {
                    
                    Manipulador.imagenes.removeElement(4);
                    
                }
                
            } else if(e.getSource() == checks[4]) {
                
                if(checks[4].isSelected()) {
                    
                    Manipulador.imagenes.addElement(5);
                    
                } else {
                    
                    Manipulador.imagenes.removeElement(5);
                    
                }
                
            } else if(e.getSource() == checks[5]) {
                
                if(checks[5].isSelected()) {
                    
                    Manipulador.imagenes.addElement(6);
                    
                } else {
                    
                    Manipulador.imagenes.removeElement(6);
                    
                }
                
            } else if(e.getSource() == checks[6]) {
                
                if(checks[6].isSelected()) {
                    
                    Manipulador.imagenes.addElement(7);
                    
                } else {
                    
                    Manipulador.imagenes.removeElement(7);
                    
                }
                
            } else if(e.getSource() == checks[7]) {
                
                if(checks[7].isSelected()) {
                    
                    Manipulador.imagenes.addElement(8);
                    
                } else {
                    
                    Manipulador.imagenes.removeElement(8);
                    
                }
                
            } else if(e.getSource() == checks[8]) {
                
                if(checks[8].isSelected()) {
                    
                    Manipulador.imagenes.addElement(9);
                    
                } else {
                    
                    Manipulador.imagenes.removeElement(9);
                    
                }
                
            } else {
                
                if(checks[9].isSelected()) {
                    
                    Manipulador.imagenes.addElement(10);
                    
                } else {
                    
                    Manipulador.imagenes.removeElement(10);
                    
                }
                
            }
            
            if(Manipulador.imagenes.size() == 5) {
                
                for(int i=0; i<10; i++) {
                    
                    if(!Manipulador.imagenes.contains(i + 1)) {
                        
                        checks[i].setEnabled(false);
                        
                    }
                    
                }
                
                if(Manipulador.listo) {
                            
                    if(!bt3.isEnabled()) {
                                
                        bt3.setEnabled(true);
                                
                    }
                    
                }
                
            } else {
                
                for(int i=0; i<10; i++) {
                    
                    if(!checks[i].isEnabled()) {
                        
                        checks[i].setEnabled(true);
                        
                    }
                    
                }
                            
                if(bt3.isEnabled()) {
                                
                    bt3.setEnabled(false);
                                
                }
                
            }
            
        }
        
    }
    
    public static Imagenes.Imagen1 i1;
    
    public static Imagenes.Imagen2 i2;
    
    public static Imagenes.Imagen3 i3;
    
    public static JButton bt1, bt2, bt3, bt4;
    
    public static JTextField ct1, ct2;
    
    public static JLabel et1, et2, et3, et4;
    
    public static JCheckBox[] checks;
    
}
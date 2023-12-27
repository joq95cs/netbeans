package graficacion3d;

import javax.swing.*;

import javax.swing.event.*;

import java.awt.*;

import java.awt.event.*;

import java.io.*;

import javax.imageio.*;

public class Panel extends JPanel {
    
    public Panel() {
        
        lado = 0;
        
        lados = new Image[4];
        
        try {
        
            lados[0] = ImageIO.read(new File("src/lados/frontal.png"));

            lados[1] = ImageIO.read(new File("src/lados/derecha.png"));

            lados[2] = ImageIO.read(new File("src/lados/trasera.png"));

            lados[3] = ImageIO.read(new File("src/lados/izquierda.png"));
            
        } catch (IOException e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            
        }
        
        setLayout(new BorderLayout());
        
        PanelEste pe = new PanelEste();
        
        add(pe, BorderLayout.EAST);
        
        pc = new PanelCentro();
        
        add(pc, BorderLayout.CENTER);
        
    }
    
    public void iniciarPG() {
        
        pg = new PanelGrafico();
        
        pg.setLocation(0, 0);
        
        pg.setSize(pc.getSize().width, pc.getSize().height);
        
        pc.add(pg);
        
    }
    
    private PanelCentro pc;
    
    private PanelGrafico pg;
    
    private JButton botonNorte, botonSur, botonEste, botonOeste, boton0, boton90, boton180, boton270;
        
    private JSlider sliderZoom;
    
    private Image[] lados;
    
    private int lado;
    
    private class PanelEste extends JPanel {
        
        public PanelEste() {
            
            setLayout(new GridLayout(3, 1));
            
            JPanel panel1 = new JPanel();
            
            panel1.setLayout(new GridBagLayout());
            
            panel1.setBackground(new Color(132, 239, 244));
            
            GridBagConstraints c = new GridBagConstraints();
            
            JLabel etiqueta1 = new JLabel("Traslación");
            
            c.weightx = 1;
            
            c.weighty = 1;
            
            c.gridwidth = 2;
            
            c.gridheight = 1;
            
            c.gridx = 0;
            
            c.gridy = 0;
            
            panel1.add(etiqueta1, c);
            
            botonNorte = new JButton("Norte");
            
            OyenteTraslacion ot = new OyenteTraslacion();
            
            botonNorte.addMouseListener(ot);
            
            c.gridy = 1;
            
            panel1.add(botonNorte, c);
            
            botonOeste = new JButton("Oeste");
            
            botonOeste.addMouseListener(ot);
            
            c.gridwidth = 1;
            
            c.gridy = 2;
            
            panel1.add(botonOeste, c);
            
            botonEste = new JButton("Este");
            
            botonEste.addMouseListener(ot);
            
            c.gridx = 1;
            
            panel1.add(botonEste, c);
            
            botonSur = new JButton("Sur");
            
            botonSur.addMouseListener(ot);
            
            c.gridwidth = 2;
            
            c.gridx = 0;
            
            c.gridy = 3;
            
            panel1.add(botonSur, c);
            
            add(panel1);
            
            JPanel panel2 = new JPanel();
            
            panel2.setBackground(new Color(128, 249, 137));
            
            panel2.setLayout(new GridBagLayout());
            
            JLabel etiqueta2 = new JLabel("Rotación");
            
            c.gridx = 0;
            
            c.gridy = 0;
            
            panel2.add(etiqueta2, c);
            
            boton90 = new JButton("90°");
            
            OyenteRotacion or = new OyenteRotacion();
            
            c.gridy = 1;
            
            boton90.addMouseListener(or);
            
            panel2.add(boton90, c);
            
            boton180 = new JButton("180°");
            
            boton180.addMouseListener(or);
            
            c.gridwidth = 1;
            
            c.gridy = 2;
            
            panel2.add(boton180, c);
            
            boton0 = new JButton("0°");
            
            boton0.addMouseListener(or);
            
            c.gridx = 1;
            
            panel2.add(boton0, c);
            
            boton270 = new JButton("270°");
            
            boton270.addMouseListener(or);
            
            c.gridwidth = 2;
            
            c.gridx = 0;
            
            c.gridy = 3;
            
            panel2.add(boton270, c);
            
            add(panel2);
            
            JPanel panel3 = new JPanel();
            
            panel3.setLayout(new BorderLayout());
            
            panel3.setBackground(new Color(255, 163, 70));
            
            JLabel etiqueta3 = new JLabel("Escalación", JLabel.CENTER);
            
            panel3.add(etiqueta3, BorderLayout.NORTH);
            
            sliderZoom = new JSlider(10, 100, 100);
            
            sliderZoom.addChangeListener(new OyenteEscalacion());
            
            sliderZoom.setBackground(new Color(255, 163, 70));
            
            sliderZoom.setMajorTickSpacing(30);
            
            sliderZoom.setPaintLabels(true);
		
            sliderZoom.setPaintTicks(true);
            
            sliderZoom.setPaintTrack(true);
            
            sliderZoom.setOrientation(JSlider.VERTICAL);
            
            panel3.add(sliderZoom, BorderLayout.CENTER);
            
            add(panel3);
            
        }
        
    }
    
    private class PanelCentro extends JPanel {
        
        public PanelCentro() {
            
            setLayout(null);
            
            setBackground(Color.WHITE);
            
        }
        
    }
    
    private class PanelGrafico extends JPanel {
        
        public void paintComponent(Graphics g) {
            
            super.paintComponent(g);
            
            g.drawImage(lados[lado], 0, 0, getWidth(), getHeight(), null);
            
        }
        
    }
    
    private class OyenteTraslacion extends MouseAdapter {
        
        public void mouseClicked(MouseEvent e) {
            
            if(e.getSource() == botonNorte) {
                
                pg.setLocation(pg.getX(), pg.getY() - 5);
                
                pg.repaint();
                
            } else if(e.getSource() == botonOeste) {
                
                pg.setLocation(pg.getX() - 5, pg.getY());
                
                pg.repaint();
                
            } else if(e.getSource() == botonEste) {
                
                pg.setLocation(pg.getX() + 5, pg.getY());
                
                pg.repaint();
                
            } else if(e.getSource() == botonSur) {
                
                pg.setLocation(pg.getX(), pg.getY() + 5);
                
                pg.repaint();
                
            }
            
        }
        
    }
    
    private class OyenteRotacion extends MouseAdapter {
        
        public void mouseClicked(MouseEvent e) {
            
            if(e.getSource() == boton0) {
                
                lado = 0;
                
                pg.repaint();
                
            } else if(e.getSource() == boton90) {
                
                lado = 1;
                
                pg.repaint();
                
            } else if(e.getSource() == boton180) {
                
                lado = 2;
                
                pg.repaint();
                
            } else if(e.getSource() == boton270) {
                
                lado = 3;
                
                pg.repaint();
                
            }
            
        }
        
    }
    
    private class OyenteEscalacion implements ChangeListener {
        
        public void stateChanged(ChangeEvent e) {
            
            pg.setSize(1024*sliderZoom.getValue()/100, 768*sliderZoom.getValue()/100);
            
            pg.repaint();
            
        }
        
    }
    
}
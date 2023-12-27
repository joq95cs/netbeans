package graficacion2d;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.awt.geom.*;

import java.util.*;

public class Graficacion2D {

    public static void main(String[] args) { 
        
        Ventana v = new Ventana();
        
        v.setVisible(true);
        
    }
    
}

class Ventana extends JFrame {
    
    public Ventana() {
        
        int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
        
        int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        setSize(3*ancho/4, 3*alto/4);
        
        setLocation(ancho/8, alto/8);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle("Graficación de figuras en 2D");
        
        add(new Panel());
        
    }
    
}

class Panel extends JPanel {
    
    public Panel() {
        
        setLayout(new BorderLayout());
        
        panelCentro = new PanelCentro();
        
        panelCentro.setBackground(Color.white);
        
        add(panelCentro, BorderLayout.CENTER);
        
        JPanel panelEste = new JPanel();
        
        panelEste.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        
        c.weightx = 1;
        
        c.weighty = 1;
        
        c.gridwidth = 1;
        
        c.gridheight = 1;
        
        c.gridx = 0;
        
        c.gridy = 0;
        
        boton1 = new JButton("Cuadrante 1");
        
        Oyente o = new Oyente();
        
        boton1.addMouseListener(o);
        
        panelEste.add(boton1, c);
        
        c.gridy = 1;
        
        boton2 = new JButton("Cuadrante 2");
        
        boton2.addMouseListener(o);
        
        panelEste.add(boton2, c);
        
        c.gridy = 2;
        
        boton3 = new JButton("Cuadrante 3");
        
        boton3.addMouseListener(o);
        
        panelEste.add(boton3, c);
        
        c.gridy = 3;
        
        boton4 = new JButton("Cuadrante 4");
        
        boton4.addMouseListener(o);
        
        panelEste.add(boton4, c);
        
        c.gridy = 4;
        
        comboFiguras = new JComboBox();
        
        comboFiguras.addItem("Mario Bros");
        
        comboFiguras.addItem("Yoshi");
        
        panelEste.add(comboFiguras, c);
        
        c.gridy = 5;
        
        botonLimpiar = new JButton("Limpiar");
        
        botonLimpiar.addMouseListener(o);
        
        panelEste.add(botonLimpiar, c);
        
        add(panelEste, BorderLayout.EAST);
           
    }
    
    private JButton boton1, boton2, boton3, boton4, botonLimpiar;
    
    private JComboBox comboFiguras;
    
    private PanelCentro panelCentro;
    
    private class PanelCentro extends JPanel {
        
        public PanelCentro() {
            
            cuadrante1 = false;
            
            cuadrante2 = false;
            
            cuadrante3 = false;
            
            cuadrante4 = false;
            
        }
        
        public void paintComponent(Graphics g1) {
                
            super.paintComponent(g1);
                
            Graphics2D g2 = (Graphics2D)g1;
                
            g2.draw(new Line2D.Double(getSize().width/2, 0, getSize().width/2, getSize().height));
                
            g2.draw(new Line2D.Double(0, getSize().height/2, getSize().width, getSize().height/2));
            
            if(cuadrante1) {
                
                if(comboFiguras.getSelectedIndex() == 0) {
                    
                    new Thread(new Figuras(1, 1, false)).start();
                    
                } else {
                    
                    new Thread(new Figuras(2, 1, false)).start();
                    
                }
                
            } 
            
            if(cuadrante2) {
                
                if(comboFiguras.getSelectedIndex() == 0) {
                    
                    new Thread(new Figuras(1, 2, false)).start();
                    
                } else {
                    
                    new Thread(new Figuras(2, 2, false)).start();
                    
                }
                
            }
            
            if(cuadrante3) {
                
                if(comboFiguras.getSelectedIndex() == 0) {
                    
                    new Thread(new Figuras(1, 3, false)).start();
                    
                } else {
                    
                    new Thread(new Figuras(2, 3, false)).start();
                    
                }
                
            }
            
            if(cuadrante4) {
                
                if(comboFiguras.getSelectedIndex() == 0) {
                    
                    new Thread(new Figuras(1, 4, false)).start();
                    
                } else {
                    
                    new Thread(new Figuras(2, 4, false)).start();
                    
                }
                
            }
                
        }
        
        public boolean cuadrante1, cuadrante2, cuadrante3, cuadrante4;
        
    }
    
    private class Oyente extends MouseAdapter {
    	
        public void mouseClicked(MouseEvent ev) {
            
            if(ev.getSource() == boton1) {
                
                if(comboFiguras.getSelectedIndex() == 0) {
                    
                    new Thread(new Figuras(1, 1, true)).start();
                    
                    panelCentro.cuadrante1 = true;
                    
                } else {
                    
                    new Thread(new Figuras(2, 1, true)).start();
                    
                    panelCentro.cuadrante1 = true;
                    
                }
                
            } else if(ev.getSource() == boton2) {
                
                if(comboFiguras.getSelectedIndex() == 0) {
                    
                    new Thread(new Figuras(1, 2, true)).start();
                    
                    panelCentro.cuadrante2 = true;
                    
                } else {
                    
                    new Thread(new Figuras(2, 2, true)).start();
                    
                    panelCentro.cuadrante2 = true;
                    
                }
                
            } else if(ev.getSource() == boton3) {
                
                if(comboFiguras.getSelectedIndex() == 0) {
                    
                    new Thread(new Figuras(1, 3, true)).start();
                    
                    panelCentro.cuadrante3 = true;
                    
                } else {
                    
                    new Thread(new Figuras(2, 3, true)).start();
                    
                    panelCentro.cuadrante3 = true;
                    
                }
                
            } else if(ev.getSource() == boton4) {
                
                if(comboFiguras.getSelectedIndex() == 0) {
                    
                    new Thread(new Figuras(1, 4, true)).start();
                    
                    panelCentro.cuadrante4 = true;
                    
                } else {
                    
                    new Thread(new Figuras(2, 4, true)).start();
                    
                    panelCentro.cuadrante4 = true;
                    
                }
                
            } else {
                
                panelCentro.cuadrante1 = false;
                
                panelCentro.cuadrante2 = false;
                
                panelCentro.cuadrante3 = false;
                
                panelCentro.cuadrante4 = false;
                
                panelCentro.repaint();
                
            }
            
        }
        
    }
    
    private class Figuras implements Runnable {
        
        public Figuras(int noFigura, int noCuadrante, boolean sleep) {
            
            this.noFigura = noFigura;
            
            this.noCuadrante = noCuadrante;
            
            this.sleep = sleep;
            
        }
        
        public void graficarFigura1() {
            
            g = (Graphics2D)panelCentro.getGraphics();
            	
            cx = panelCentro.getWidth()/2;
            		
            cy = panelCentro.getHeight()/2;
            
            if(noCuadrante == 1) {
            		
                ArrayList<Point2D.Double> puntos = new ArrayList<Point2D.Double>();
                    
                ArrayList<Rectangle2D.Double>cuadrosRojos= new ArrayList<Rectangle2D.Double>();
                    
                ArrayList<Rectangle2D.Double>cuadrosPiel= new ArrayList<Rectangle2D.Double>();
                    
                ArrayList<Rectangle2D.Double>cuadrosNegro= new ArrayList<Rectangle2D.Double>();
                    
                puntos.add(new Point2D.Double(cx+2*cx/9, cy));
            	
                puntos.add(new Point2D.Double(cx+2*cx/9, cy-cy/8));
            		
                puntos.add(new Point2D.Double(cx+4*cx/9, cy-cy/8));
                    
                //BIGOTE
            		
                puntos.add(new Point2D.Double(cx+4*cx/9, cy-2*cy/8));
            		
                puntos.add(new Point2D.Double(cx+5*cx/9, cy-2*cy/8));
            		
                puntos.add(new Point2D.Double(cx+5*cx/9, cy-3*cy/8));
            		
                puntos.add(new Point2D.Double(cx+6*cx/9, cy-3*cy/8));
            		
                puntos.add(new Point2D.Double(cx+6*cx/9, cy-4*cy/8));
            		
                puntos.add(new Point2D.Double(cx+5*cx/9, cy-4*cy/8));
                    
                puntos.add(new Point2D.Double(cx+5*cx/9, cy-5*cy/8));
                                                      
                puntos.add(new Point2D.Double(cx+3*cx/9, cy-5*cy/8));
                    
                puntos.add(new Point2D.Double(cx+3*cx/9, cy-6*cy/8));
                    
                puntos.add(new Point2D.Double(cx+5*cx/9, cy-6*cy/8));
                    
                puntos.add(new Point2D.Double(cx+5*cx/9, cy-7*cy/8));
                    
                puntos.add(new Point2D.Double(cx+2*cx/9, cy-7*cy/8));
                    
                puntos.add(new Point2D.Double(cx+2*cx/9, cy-8*cy/8));
                    
                puntos.add(new Point2D.Double(cx+0*cx/9, cy-8*cy/8));
                    
                //CUADROS ROJOS
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx+0*cx/9, cy-8*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx+1*cx/9, cy-8*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx+0*cx/9, cy-7*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx+1*cx/9, cy-7*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx+2*cx/9, cy-7*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx+3*cx/9, cy-7*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx+4*cx/9, cy-7*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx+0*cx/9, cy-1*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx+1*cx/9, cy-1*cy/8,cx/9,cy/8));
                    
                //CUADROS PIEL
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx+0*cx/9, cy-6*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx+2*cx/9, cy-6*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx+0*cx/9, cy-5*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx+2*cx/9, cy-5*cy/8,cx/9,cy/8));
                        
                cuadrosPiel.add(new Rectangle2D.Double(cx+3*cx/9, cy-5*cy/8,cx/9,cy/8));
                        
                cuadrosPiel.add(new Rectangle2D.Double(cx+4*cx/9, cy-5*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx+0*cx/9, cy-4*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx+1*cx/9, cy-4*cy/8,cx/9,cy/8));
            	  
                cuadrosPiel.add(new Rectangle2D.Double(cx+3*cx/9, cy-4*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx+4*cx/9, cy-4*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx+5*cx/9, cy-4*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx+0*cx/9, cy-3*cy/8,cx/9,cy/8));

                cuadrosPiel.add(new Rectangle2D.Double(cx+0*cx/9, cy-2*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx+1*cx/9, cy-2*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx+2*cx/9, cy-2*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx+3*cx/9, cy-2*cy/8,cx/9,cy/8));
                                   
                //CUADROS NEGROS
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx+1*cx/9, cy-6*cy/8,cx/9,cy/8)); 
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx+1*cx/9, cy-5*cy/8,cx/9,cy/8)); 
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx+2*cx/9, cy-4*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx+1*cx/9, cy-3*cy/8,cx/9,cy/8)); 
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx+2*cx/9, cy-3*cy/8,cx/9,cy/8));   
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx+3*cx/9, cy-3*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx+4*cx/9, cy-3*cy/8,cx/9,cy/8));
                    
                if(sleep) {
                    
                    g.setColor(Color.black);
                    
                    for(int i=0; i<puntos.size()-1; i++) {
            			
                        g.draw(new Line2D.Double(puntos.get(i), puntos.get(i+1)));
            			
                        try {
                        
                            Thread.sleep(100);
                        
                        } catch (InterruptedException ex) {}
                    
                    }
                    
                    g.setColor(Color.red);
                    
                    for(int i=0; i<cuadrosRojos.size(); i++) {
                        
                        g.fill(cuadrosRojos.get(i));
            			
                        try {
                        
                            Thread.sleep(100);
                        
                        } catch (InterruptedException ex) {}
                    
                    }
                    
                    g.setColor(Color.pink);
                    
                    for(int i=0; i<cuadrosPiel.size(); i++) {
                        
                        g.fill(cuadrosPiel.get(i));
                        	
                        try {
                        
                            Thread.sleep(100);
                        
                        } catch (InterruptedException ex) {}
                    
                    }
                    
                    g.setColor(Color.black);
                    
                    for(int i=0; i<cuadrosNegro.size(); i++) {
                        
                        g.fill(cuadrosNegro.get(i));
            			
                        try {
                        
                            Thread.sleep(100);
                        
                        } catch (InterruptedException ex) {}
                        
                    }
                    
                } else {
                    
                    g.setColor(Color.black);
                    
                    for(int i=0; i<puntos.size()-1; i++) {
            			
                        g.draw(new Line2D.Double(puntos.get(i), puntos.get(i+1)));
                    
                    }
                    
                    g.setColor(Color.red);
                    
                    for(int i=0; i<cuadrosRojos.size(); i++) {
                        
                        g.fill(cuadrosRojos.get(i));
                    
                    }
                    
                    g.setColor(Color.pink);
                    
                    for(int i=0; i<cuadrosPiel.size(); i++) {
                        
                        g.fill(cuadrosPiel.get(i));
                    
                    }
                    
                    g.setColor(Color.black);
                    
                    for(int i=0; i<cuadrosNegro.size(); i++) {
                        
                        g.fill(cuadrosNegro.get(i));
                        
                    }
                    
                }
                
            } else if(noCuadrante == 2) {
                
                ArrayList<Point2D.Double> puntos = new ArrayList<Point2D.Double>();  
                    
                ArrayList<Rectangle2D.Double>cuadrosRojos= new ArrayList<Rectangle2D.Double>();
                    
            	ArrayList<Rectangle2D.Double>cuadrosPiel= new ArrayList<Rectangle2D.Double>();
                    
                ArrayList<Rectangle2D.Double>cuadrosAzul= new ArrayList<Rectangle2D.Double>();
                    
                ArrayList<Rectangle2D.Double>cuadrosNegro= new ArrayList<Rectangle2D.Double>();
                      
                puntos.add(new Point2D.Double(cx-0*cx/9, cy-8*cy/8));
                    
                puntos.add(new Point2D.Double(cx-3*cx/9, cy-8*cy/8));
                    
                puntos.add(new Point2D.Double(cx-3*cx/9, cy-7*cy/8));
                    
                puntos.add(new Point2D.Double(cx-4*cx/9, cy-7*cy/8));
                    
                puntos.add(new Point2D.Double(cx-4*cx/9, cy-5*cy/8));
                    
                puntos.add(new Point2D.Double(cx-5*cx/9, cy-5*cy/8));  
                    
                puntos.add(new Point2D.Double(cx-5*cx/9, cy-2*cy/8)); 
                    
                puntos.add(new Point2D.Double(cx-3*cx/9, cy-2*cy/8));
                    
                puntos.add(new Point2D.Double(cx-3*cx/9, cy-1*cy/8)); 
                    
                puntos.add(new Point2D.Double(cx-4*cx/9, cy-1*cy/8)); 
                    
                puntos.add(new Point2D.Double(cx-4*cx/9, cy-0*cy/8));
                    
                //CUADROS ROJOS
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx-1*cx/9, cy-8*cy/8,cx/9,cy/8));    
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx-2*cx/9, cy-8*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx-3*cx/9, cy-8*cy/8,cx/9,cy/8)); 
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx-1*cx/9, cy-7*cy/8,cx/9,cy/8)); 
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx-2*cx/9, cy-7*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx-3*cx/9, cy-7*cy/8,cx/9,cy/8)); 
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx-4*cx/9, cy-7*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx-3*cx/9, cy-1*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx-4*cx/9, cy-1*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx-1*cx/9, cy-1*cy/8,cx/9,cy/8));
                    
                //CUADROS PIEL
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx-1*cx/9, cy-6*cy/8,cx/9,cy/8)); 

                cuadrosPiel.add(new Rectangle2D.Double(cx-1*cx/9, cy-5*cy/8,cx/9,cy/8));

                cuadrosPiel.add(new Rectangle2D.Double(cx-2*cx/9, cy-5*cy/8,cx/9,cy/8));

                cuadrosPiel.add(new Rectangle2D.Double(cx-4*cx/9, cy-5*cy/8,cx/9,cy/8));

                cuadrosPiel.add(new Rectangle2D.Double(cx-1*cx/9, cy-4*cy/8,cx/9,cy/8));

                cuadrosPiel.add(new Rectangle2D.Double(cx-4*cx/9, cy-4*cy/8,cx/9,cy/8));

                cuadrosPiel.add(new Rectangle2D.Double(cx-1*cx/9, cy-3*cy/8,cx/9,cy/8));

                cuadrosPiel.add(new Rectangle2D.Double(cx-2*cx/9, cy-3*cy/8,cx/9,cy/8));

                cuadrosPiel.add(new Rectangle2D.Double(cx-3*cx/9, cy-3*cy/8,cx/9,cy/8));

                cuadrosPiel.add(new Rectangle2D.Double(cx-1*cx/9, cy-2*cy/8,cx/9,cy/8));

                cuadrosPiel.add(new Rectangle2D.Double(cx-2*cx/9, cy-2*cy/8,cx/9,cy/8));

                cuadrosPiel.add(new Rectangle2D.Double(cx-3*cx/9, cy-2*cy/8,cx/9,cy/8));
                   
                //CUADROS AZUL
                   
                cuadrosAzul.add(new Rectangle2D.Double(cx-2*cx/9, cy-1*cy/8,cx/9,cy/8));
                   
                //CUADROS NEGROS
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx-2*cx/9, cy-6*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx-3*cx/9, cy-6*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx-4*cx/9, cy-6*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx-3*cx/9, cy-5*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx-5*cx/9, cy-5*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx-2*cx/9, cy-4*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx-3*cx/9, cy-4*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx-5*cx/9, cy-4*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx-4*cx/9, cy-3*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx-5*cx/9, cy-3*cy/8,cx/9,cy/8));
                
                if(sleep) {
                    
                    g.setColor(Color.black);
                    
                    for(int i=0; i<puntos.size()-1; i++) {

                        g.draw(new Line2D.Double(puntos.get(i), puntos.get(i+1)));

                        try {

                            Thread.sleep(100);

                        } catch (InterruptedException ex) {}

                    } 
                    
                    g.setColor(Color.red);

                    for(int i=0; i<cuadrosRojos.size(); i++) {

                        g.fill(cuadrosRojos.get(i));

                        try {

                            Thread.sleep(100);

                        } catch (InterruptedException ex) {}

                    }
                    
                    g.setColor(Color.pink);

                    for(int i=0; i<cuadrosPiel.size(); i++) {

                        g.fill(cuadrosPiel.get(i));

                        try {

                            Thread.sleep(100);

                        } catch (InterruptedException ex) {}

                    }
                    
                    g.setColor(Color.blue);

                    for(int i=0; i<cuadrosAzul.size(); i++) {

                        g.fill(cuadrosAzul.get(i));

                        try {

                            Thread.sleep(100);

                        } catch (InterruptedException ex) {}

                    }
                    
                    g.setColor(Color.black);

                    for(int i=0; i<cuadrosNegro.size(); i++) {

                        g.fill(cuadrosNegro.get(i));

                        try {

                            Thread.sleep(100);

                        } catch (InterruptedException ex) {}

                    }
                    
                } else {
                    
                    g.setColor(Color.black);
                    
                    for(int i=0; i<puntos.size()-1; i++) {

                        g.draw(new Line2D.Double(puntos.get(i), puntos.get(i+1)));

                    }
                    
                    g.setColor(Color.red);

                    for(int i=0; i<cuadrosRojos.size(); i++) {

                        g.fill(cuadrosRojos.get(i));

                    }
                    
                    g.setColor(Color.pink);

                    for(int i=0; i<cuadrosPiel.size(); i++) {

                        g.fill(cuadrosPiel.get(i));

                    }
                    
                    g.setColor(Color.blue);

                    for(int i=0; i<cuadrosAzul.size(); i++) {

                        g.fill(cuadrosAzul.get(i));

                    }  
                    
                    g.setColor(Color.black);

                    for(int i=0; i<cuadrosNegro.size(); i++) {

                        g.fill(cuadrosNegro.get(i));

                    }
                    
                }
                
            } else if(noCuadrante == 3) {
            		
                ArrayList<Point2D.Double> puntos = new ArrayList<Point2D.Double>();   
                    
                ArrayList<Rectangle2D.Double>cuadrosRojos= new ArrayList<Rectangle2D.Double>();
                    
            	ArrayList<Rectangle2D.Double>cuadrosPiel= new ArrayList<Rectangle2D.Double>();
                    
                ArrayList<Rectangle2D.Double>cuadrosAzul= new ArrayList<Rectangle2D.Double>();
                    
                ArrayList<Rectangle2D.Double>cuadrosNegro= new ArrayList<Rectangle2D.Double>();
     
                puntos.add(new Point2D.Double(cx-5*cx/9, cy-0*cy/8));
                    
                puntos.add(new Point2D.Double(cx-5*cx/9, cy+1*cy/8));
                    
                puntos.add(new Point2D.Double(cx-6*cx/9, cy+1*cy/8));
                    
                puntos.add(new Point2D.Double(cx-6*cx/9, cy+5*cy/8));
                    
                puntos.add(new Point2D.Double(cx-4*cx/9, cy+5*cy/8));
                    
                //PUÑO
                    
                puntos.add(new Point2D.Double(cx-4*cx/9, cy+4*cy/8));
                    
                puntos.add(new Point2D.Double(cx-3*cx/9, cy+4*cy/8));
                    
                puntos.add(new Point2D.Double(cx-3*cx/9, cy+3*cy/8));
                    
                puntos.add(new Point2D.Double(cx-4*cx/9, cy+3*cy/8));
                    
                puntos.add(new Point2D.Double(cx-4*cx/9, cy+2*cy/8));
                    
                puntos.add(new Point2D.Double(cx-6*cx/9, cy+2*cy/8));
                    
                puntos.add(new Point2D.Double(cx-6*cx/9, cy+1*cy/8));
                    
                puntos.add(new Point2D.Double(cx-6*cx/9, cy+5*cy/8));
                    
                puntos.add(new Point2D.Double(cx-4*cx/9, cy+5*cy/8));
                    
                puntos.add(new Point2D.Double(cx-4*cx/9, cy+6*cy/8));
                    
                puntos.add(new Point2D.Double(cx-5*cx/9, cy+6*cy/8));
                    
                puntos.add(new Point2D.Double(cx-5*cx/9, cy+7*cy/8));
                    
                puntos.add(new Point2D.Double(cx-6*cx/9, cy+7*cy/8));
                    
                puntos.add(new Point2D.Double(cx-6*cx/9, cy+8*cy/8));
                    
                puntos.add(new Point2D.Double(cx-2*cx/9, cy+8*cy/8));
                    
                puntos.add(new Point2D.Double(cx-2*cx/9, cy+6*cy/8));
                    
                puntos.add(new Point2D.Double(cx-1*cx/9, cy+6*cy/8));
                    
                puntos.add(new Point2D.Double(cx-1*cx/9, cy+5*cy/8));
                    
                puntos.add(new Point2D.Double(cx-0*cx/9, cy+5*cy/8));
                    
                //CUADROS ROJOS
                   
                cuadrosRojos.add(new Rectangle2D.Double(cx-1*cx/9, cy-0*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx-3*cx/9, cy-0*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx-4*cx/9, cy-0*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx-5*cx/9, cy-0*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx-1*cx/9, cy+1*cy/8,cx/9,cy/8)); 
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx-3*cx/9, cy+1*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx-4*cx/9, cy+1*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx-5*cx/9, cy+1*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx-6*cx/9, cy+1*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx-4*cx/9, cy+2*cy/8,cx/9,cy/8));
                    
                //CUADROS PIEL
                                                                                             
                cuadrosPiel.add(new Rectangle2D.Double(cx-5*cx/9, cy+2*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx-6*cx/9, cy+2*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx-4*cx/9, cy+3*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx-5*cx/9, cy+3*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx-6*cx/9, cy+3*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx-5*cx/9, cy+4*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx-6*cx/9, cy+4*cy/8,cx/9,cy/8));
                    
                //CUADROS AZUL
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx-2*cx/9, cy+0*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx-1*cx/9, cy+1*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx-2*cx/9, cy+1*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx-1*cx/9, cy+2*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx-3*cx/9, cy+2*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx-1*cx/9, cy+3*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx-2*cx/9, cy+3*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx-3*cx/9, cy+3*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx-1*cx/9, cy+4*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx-2*cx/9, cy+4*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx-3*cx/9, cy+4*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx-4*cx/9, cy+4*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx-2*cx/9, cy+5*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx-3*cx/9, cy+5*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx-4*cx/9, cy+5*cy/8,cx/9,cy/8));

                //CUADROS NEGROS

                cuadrosNegro.add(new Rectangle2D.Double(cx-3*cx/9, cy+6*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx-4*cx/9, cy+6*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx-5*cx/9, cy+6*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx-3*cx/9, cy+7*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx-4*cx/9, cy+7*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx-5*cx/9, cy+7*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx-6*cx/9, cy+7*cy/8,cx/9,cy/8));
                
                if(sleep) {
                    
                    g.setColor(Color.black);

                    for(int i=0; i<puntos.size()-1; i++) {

                        g.draw(new Line2D.Double(puntos.get(i), puntos.get(i+1)));

                        try {

                            Thread.sleep(100);

                        } catch (InterruptedException ex) {}

                    }
                    
                    g.setColor(Color.red);

                    for(int i=0; i<cuadrosRojos.size(); i++) {

                        g.fill(cuadrosRojos.get(i));

                        try {

                            Thread.sleep(100);

                        } catch (InterruptedException ex) {}

                    }
                    
                    g.setColor(Color.pink);

                    for(int i=0; i<cuadrosPiel.size(); i++) {

                        g.fill(cuadrosPiel.get(i));

                        try {

                            Thread.sleep(100);

                        } catch (InterruptedException ex) {}

                    }
                    
                    g.setColor(Color.blue);

                    for(int i=0; i<cuadrosAzul.size(); i++) {

                        g.fill(cuadrosAzul.get(i));

                        try {

                            Thread.sleep(100);

                        } catch (InterruptedException ex) {}

                    }
                    
                    g.setColor(Color.black);

                    for(int i=0; i<cuadrosNegro.size(); i++) {

                        g.fill(cuadrosNegro.get(i));

                        try {

                            Thread.sleep(100);

                        } catch (InterruptedException ex) {}

                    }

                    Shape A = new Rectangle2D.Double(cx-2*cx/9, cy+2*cy/8, cx/8, cx/9);

                    g.setColor(Color.yellow);

                    g.fill(A);
                    
                } else {
                    
                    g.setColor(Color.black);
                    
                    for(int i=0; i<puntos.size()-1; i++) {

                        g.draw(new Line2D.Double(puntos.get(i), puntos.get(i+1)));

                    }
                    
                    g.setColor(Color.red);

                    for(int i=0; i<cuadrosRojos.size(); i++) {

                        g.fill(cuadrosRojos.get(i));

                    }
                    
                    g.setColor(Color.pink);

                    for(int i=0; i<cuadrosPiel.size(); i++) {

                        g.fill(cuadrosPiel.get(i));
                        
                    }
                    
                    g.setColor(Color.blue);

                    for(int i=0; i<cuadrosAzul.size(); i++) {

                        g.fill(cuadrosAzul.get(i));

                    }
                    
                    g.setColor(Color.black);

                    for(int i=0; i<cuadrosNegro.size(); i++) {

                        g.fill(cuadrosNegro.get(i));

                    }

                    Shape A = new Rectangle2D.Double(cx-2*cx/9, cy+2*cy/8, cx/8, cx/9);

                    g.setColor(Color.yellow);

                    g.fill(A);
                    
                }
                
            } else {
            		
                ArrayList<Point2D.Double> puntos = new ArrayList<Point2D.Double>(); 
                    
                ArrayList<Rectangle2D.Double>cuadrosRojos= new ArrayList<Rectangle2D.Double>();
                    
                ArrayList<Rectangle2D.Double>cuadrosPiel= new ArrayList<Rectangle2D.Double>();
                    
                ArrayList<Rectangle2D.Double>cuadrosAzul= new ArrayList<Rectangle2D.Double>();
                    
                ArrayList<Rectangle2D.Double>cuadrosNegro= new ArrayList<Rectangle2D.Double>();
          
                puntos.add(new Point2D.Double(cx+0*cx/9, cy+5*cy/8));
                    
                puntos.add(new Point2D.Double(cx+1*cx/9, cy+5*cy/8));
                    
                puntos.add(new Point2D.Double(cx+1*cx/9, cy+6*cy/8));
                    
                puntos.add(new Point2D.Double(cx+2*cx/9, cy+6*cy/8));
                    
                puntos.add(new Point2D.Double(cx+2*cx/9, cy+8*cy/8));
                    
                puntos.add(new Point2D.Double(cx+6*cx/9, cy+8*cy/8));
                    
                puntos.add(new Point2D.Double(cx+6*cx/9, cy+7*cy/8));
                    
                puntos.add(new Point2D.Double(cx+5*cx/9, cy+7*cy/8));
                    
                puntos.add(new Point2D.Double(cx+5*cx/9, cy+6*cy/8));
                    
                puntos.add(new Point2D.Double(cx+4*cx/9, cy+6*cy/8));
                    
                puntos.add(new Point2D.Double(cx+4*cx/9, cy+5*cy/8));
                    
                puntos.add(new Point2D.Double(cx+6*cx/9, cy+5*cy/8));
                    
                //PUÑO
                   
                puntos.add(new Point2D.Double(cx+6*cx/9, cy+2*cy/8));
                    
                puntos.add(new Point2D.Double(cx+4*cx/9, cy+2*cy/8));
                    
                puntos.add(new Point2D.Double(cx+4*cx/9, cy+3*cy/8));
                    
                puntos.add(new Point2D.Double(cx+3*cx/9, cy+3*cy/8));
                    
                puntos.add(new Point2D.Double(cx+3*cx/9, cy+4*cy/8));
                    
                puntos.add(new Point2D.Double(cx+4*cx/9, cy+4*cy/8));
                    
                puntos.add(new Point2D.Double(cx+4*cx/9, cy+5*cy/8));
                    
                puntos.add(new Point2D.Double(cx+6*cx/9, cy+5*cy/8));
                              
                puntos.add(new Point2D.Double(cx+6*cx/9, cy+1*cy/8));
                    
                puntos.add(new Point2D.Double(cx+5*cx/9, cy+1*cy/8));
                    
                puntos.add(new Point2D.Double(cx+5*cx/9, cy+0*cy/8));
                    
                //CUADROS ROJOS
                   
                cuadrosRojos.add(new Rectangle2D.Double(cx+0*cx/9, cy-0*cy/8,cx/9,cy/8));
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx+2*cx/9, cy+0*cy/8,cx/9,cy/8)); 
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx+3*cx/9, cy+0*cy/8,cx/9,cy/8)); 
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx+4*cx/9, cy+0*cy/8,cx/9,cy/8)); 
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx+2*cx/9, cy+1*cy/8,cx/9,cy/8)); 
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx+3*cx/9, cy+1*cy/8,cx/9,cy/8)); 
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx+4*cx/9, cy+1*cy/8,cx/9,cy/8)); 
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx+5*cx/9, cy+1*cy/8,cx/9,cy/8));  
                    
                cuadrosRojos.add(new Rectangle2D.Double(cx+3*cx/9, cy+2*cy/8,cx/9,cy/8)); 
                    
                //CUADROS PIEL
                   
                cuadrosPiel.add(new Rectangle2D.Double(cx+4*cx/9, cy+2*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx+5*cx/9, cy+2*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx+3*cx/9, cy+3*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx+4*cx/9, cy+3*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx+5*cx/9, cy+3*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx+4*cx/9, cy+4*cy/8,cx/9,cy/8));
                    
                cuadrosPiel.add(new Rectangle2D.Double(cx+5*cx/9, cy+4*cy/8,cx/9,cy/8));
                    
                //CUADROS AZUL
                   
                cuadrosAzul.add(new Rectangle2D.Double(cx+1*cx/9, cy+0*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx+0*cx/9, cy+1*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx+1*cx/9, cy+1*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx+0*cx/9, cy+2*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx+2*cx/9, cy+2*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx+0*cx/9, cy+3*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx+1*cx/9, cy+3*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx+2*cx/9, cy+3*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx+0*cx/9, cy+4*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx+1*cx/9, cy+4*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx+2*cx/9, cy+4*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx+3*cx/9, cy+4*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx+1*cx/9, cy+5*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx+2*cx/9, cy+5*cy/8,cx/9,cy/8));
                    
                cuadrosAzul.add(new Rectangle2D.Double(cx+3*cx/9, cy+5*cy/8,cx/9,cy/8));
                    
                //CUADROS NEGRO
                   
                cuadrosNegro.add(new Rectangle2D.Double(cx+2*cx/9, cy+6*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx+3*cx/9, cy+6*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx+4*cx/9, cy+6*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx+2*cx/9, cy+7*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx+3*cx/9, cy+7*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx+4*cx/9, cy+7*cy/8,cx/9,cy/8));
                    
                cuadrosNegro.add(new Rectangle2D.Double(cx+5*cx/9, cy+7*cy/8,cx/9,cy/8));
                
                if(sleep) {
                    
                    g.setColor(Color.black);
                   
                    for(int i=0; i<puntos.size()-1; i++) {

                        g.draw(new Line2D.Double(puntos.get(i), puntos.get(i+1)));

                        try {

                            Thread.sleep(100);

                        } catch (InterruptedException ex) {}

                    }
                    
                    g.setColor(Color.red);

                    for(int i=0; i<cuadrosRojos.size(); i++) {

                        g.fill(cuadrosRojos.get(i));

                        try {

                            Thread.sleep(100);

                        } catch (InterruptedException ex) {}

                    }
                    
                    g.setColor(Color.pink);

                    for(int i=0; i<cuadrosPiel.size(); i++) {

                        g.fill(cuadrosPiel.get(i));

                        try {

                            Thread.sleep(100);

                        } catch (InterruptedException ex) {}

                    }
                    
                    g.setColor(Color.blue);

                    for(int i=0; i<cuadrosAzul.size(); i++) {

                        g.fill(cuadrosAzul.get(i));

                        try {

                            Thread.sleep(100);

                        } catch (InterruptedException ex) {}

                    }
                    
                    g.setColor(Color.black);

                    for(int i=0; i<cuadrosNegro.size(); i++) {

                        g.fill(cuadrosNegro.get(i));

                        try {

                            Thread.sleep(100);

                        } catch (InterruptedException ex) {}

                    }

                    Shape A = new Rectangle2D.Double(cx+1*cx/9, cy+2*cy/8, cx/8, cx/9);

                    g.setColor(Color.yellow);

                    g.fill(A);
                    
                } else {
                    
                    g.setColor(Color.black);
                    
                    for(int i=0; i<puntos.size()-1; i++) {

                        g.draw(new Line2D.Double(puntos.get(i), puntos.get(i+1)));

                    }
                    
                    g.setColor(Color.red);

                    for(int i=0; i<cuadrosRojos.size(); i++) {

                        g.fill(cuadrosRojos.get(i));

                    }
                    
                    g.setColor(Color.pink);

                    for(int i=0; i<cuadrosPiel.size(); i++) {

                        g.fill(cuadrosPiel.get(i));

                    }
                    
                    g.setColor(Color.blue);

                    for(int i=0; i<cuadrosAzul.size(); i++) {

                        g.fill(cuadrosAzul.get(i));

                    }
                    
                    g.setColor(Color.black);

                    for(int i=0; i<cuadrosNegro.size(); i++) {

                        g.fill(cuadrosNegro.get(i));

                    }

                    Shape A = new Rectangle2D.Double(cx+1*cx/9, cy+2*cy/8, cx/8, cx/9);

                    g.setColor(Color.yellow);

                    g.fill(A);
                    
                }
                
            }
            
        }
        
        public void graficarFigura2() {
            
            g = (Graphics2D)panelCentro.getGraphics();
            
            cx = panelCentro.getWidth()/2;
            
            cy = panelCentro.getHeight()/2;
            
            if(noCuadrante == 1) {
                
                ArrayList<Point2D.Double> contorno = new ArrayList<Point2D.Double>();
                
                contorno.add(new Point2D.Double(cx+11*cx/20, cy));
                
                contorno.add(new Point2D.Double(cx+11*cx/20, cy-cy/15));
                
                contorno.add(new Point2D.Double(cx+12*cx/20, cy-cy/15));
                
                contorno.add(new Point2D.Double(cx+12*cx/20, cy-cy/15));
                
                contorno.add(new Point2D.Double(cx+12*cx/20, cy-6*cy/15));
                
                contorno.add(new Point2D.Double(cx+11*cx/20, cy-6*cy/15));
                
                contorno.add(new Point2D.Double(cx+11*cx/20, cy-7*cy/15));
                
                contorno.add(new Point2D.Double(cx+10*cx/20, cy-7*cy/15));
                
                contorno.add(new Point2D.Double(cx+10*cx/20, cy-8*cy/15));
                
                contorno.add(new Point2D.Double(cx+9*cx/20, cy-8*cy/15));
                
                contorno.add(new Point2D.Double(cx+9*cx/20, cy-9*cy/15));
                
                contorno.add(new Point2D.Double(cx+7*cx/20, cy-9*cy/15));
                
                contorno.add(new Point2D.Double(cx+7*cx/20, cy-12*cy/15));
                
                contorno.add(new Point2D.Double(cx+6*cx/20, cy-12*cy/15));
                
                contorno.add(new Point2D.Double(cx+6*cx/20, cy-13*cy/15));
                
                contorno.add(new Point2D.Double(cx+5*cx/20, cy-13*cy/15));
                
                contorno.add(new Point2D.Double(cx+5*cx/20, cy-14*cy/15));
                
                contorno.add(new Point2D.Double(cx+3*cx/20, cy-14*cy/15));
                
                contorno.add(new Point2D.Double(cx+3*cx/20, cy-13*cy/15));
                
                contorno.add(new Point2D.Double(cx+2*cx/20, cy-13*cy/15));
                
                contorno.add(new Point2D.Double(cx+2*cx/20, cy-14*cy/15));
                
                contorno.add(new Point2D.Double(cx, cy-14*cy/15));
                
                ArrayList<Rectangle2D.Double> rectangulosNegros = new ArrayList<Rectangle2D.Double>();
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+10*cx/20, cy-cy/15, cx/20, cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+11*cx/20, cy-6*cy/15, cx/20, 5*cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+9*cx/20, cy-6*cy/15, 2*cx/20, cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+7*cx/20, cy-6*cy/15, cx/20, cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+10*cx/20, cy-7*cy/15, cx/20, cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+9*cx/20, cy-8*cy/15, cx/20, cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+6*cx/20, cy-9*cy/15, 3*cx/20, cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+6*cx/20, cy-12*cy/15, cx/20, 3*cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+5*cx/20, cy-13*cy/15, cx/20, cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+3*cx/20, cy-14*cy/15, 2*cx/20, cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+2*cx/20, cy-13*cy/15, cx/20, cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx, cy-14*cy/15, 2*cx/20, cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+5*cx/20, cy-8*cy/15, cx/20, cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+3*cx/20, cy-3*cy/15, cx/20, 3*cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+2*cx/20, cy-2*cy/15, cx/20, cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+3*cx/40, cy-11*cy/15, cx/20, 2*cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+7*cx/40, cy-11*cy/15, cx/20, 2*cy/15));
                
                ArrayList<Rectangle2D.Double> rectangulosVerdes = new ArrayList<Rectangle2D.Double>();
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx+4*cx/20, cy-cy/15, 6*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx+4*cx/20, cy-2*cy/15, 7*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx+4*cx/20, cy-3*cy/15, 7*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx+4*cx/20, cy-4*cy/15, 7*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx+4*cx/20, cy-5*cy/15, 7*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx+8*cx/20, cy-6*cy/15, cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx, cy-6*cy/15, 7*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx, cy-7*cy/15, 7*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx+5*cx/40, cy-8*cy/15, cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx+6*cx/20, cy-8*cy/15, 3*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx+6*cx/20, cy-7*cy/15, 4*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx+2*cx/20, cy-5*cy/15, cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx+3*cx/20, cy-5*cy/15, cx/20, 2*cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx, cy-13*cy/15, 2*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx, cy-12*cy/15, cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx+3*cx/20, cy-13*cy/15, 2*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx+3*cx/20, cy-13*cy/15, 2*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx+5*cx/20, cy-12*cy/15, cx/20, cy/15));
                
                ArrayList<Rectangle2D.Double> rectangulosBlancos = new ArrayList<Rectangle2D.Double>();
                
                rectangulosBlancos.add(new Rectangle2D.Double(cx, cy-5*cy/15, cx/20, 5*cy/15));
                
                rectangulosBlancos.add(new Rectangle2D.Double(cx, cy-11*cy/15, cx/20, 4*cy/15));
                
                rectangulosBlancos.add(new Rectangle2D.Double(cx, cy-cy/15, 3*cx/20, cy/15));
                
                ArrayList<Rectangle2D.Double> rectangulosFondo = new ArrayList<Rectangle2D.Double>();
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+11*cx/20, cy-cy/15, 9*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+12*cx/20, cy-2*cy/15, 8*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+12*cx/20, cy-3*cy/15, 8*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+12*cx/20, cy-4*cy/15, 8*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+12*cx/20, cy-5*cy/15, 8*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+12*cx/20, cy-6*cy/15, 8*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+11*cx/20, cy-7*cy/15, 9*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+12*cx/20, cy-7*cy/15, 8*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+10*cx/20, cy-8*cy/15, 10*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+9*cx/20, cy-9*cy/15, 11*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+7*cx/20, cy-10*cy/15, 13*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+7*cx/20, cy-11*cy/15, 13*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+7*cx/20, cy-12*cy/15, 13*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+6*cx/20, cy-13*cy/15, 14*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+6*cx/20, cy-13*cy/15, 14*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+5*cx/20, cy-14*cy/15, 15*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+2*cx/20, cy-14*cy/15, cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx, cy-15*cy/15, cx, cy/15));
                
                if(sleep) {
                
                    g.setColor(Color.black);

                    for(int i=0; i<contorno.size()-1; i++) {

                        g.draw(new Line2D.Double(contorno.get(i), contorno.get(i+1)));

                        try {

                            Thread.sleep(100);

                        } catch(InterruptedException e) {}

                    }

                    g.setColor(Color.black);

                    for(int i=0; i<rectangulosNegros.size(); i++) {

                        g.fill(rectangulosNegros.get(i));

                        try {

                            Thread.sleep(100);

                        } catch(InterruptedException e) {}

                    }

                    g.setColor(Color.green);

                    for(int i=0; i<rectangulosVerdes.size(); i++) {

                        g.fill(rectangulosVerdes.get(i));

                        try {

                            Thread.sleep(100);

                        } catch(InterruptedException e) {}

                    }

                    g.setColor(Color.cyan);

                    for(int i=0; i<rectangulosFondo.size(); i++) {

                        g.fill(rectangulosFondo.get(i));

                        try {

                            Thread.sleep(100);

                        } catch(InterruptedException e) {}

                    }
                    
                    g.setColor(Color.white);

                    for(int i=0; i<rectangulosBlancos.size(); i++) {

                        g.fill(rectangulosBlancos.get(i));

                        try {

                            Thread.sleep(100);

                        } catch(InterruptedException e) {}

                    }
                    
                } else {
                    
                    g.setColor(Color.black);

                    for(int i=0; i<contorno.size()-1; i++) {

                        g.draw(new Line2D.Double(contorno.get(i), contorno.get(i+1)));

                    }

                    g.setColor(Color.black);

                    for(int i=0; i<rectangulosNegros.size(); i++) {

                        g.fill(rectangulosNegros.get(i));

                    }

                    g.setColor(Color.green);

                    for(int i=0; i<rectangulosVerdes.size(); i++) {

                        g.fill(rectangulosVerdes.get(i));

                    }

                    g.setColor(Color.cyan);

                    for(int i=0; i<rectangulosFondo.size(); i++) {

                        g.fill(rectangulosFondo.get(i));

                    }
                    
                    g.setColor(Color.white);

                    for(int i=0; i<rectangulosBlancos.size(); i++) {

                        g.fill(rectangulosBlancos.get(i));

                    }
                    
                }
                
            } else if(noCuadrante == 2) {
                
                ArrayList<Point2D.Double> contorno = new ArrayList<Point2D.Double>();
                
                contorno.add(new Point2D.Double(cx-6*cx/20, cy));
                
                contorno.add(new Point2D.Double(cx-6*cx/20, cy));
                
                contorno.add(new Point2D.Double(cx-6*cx/20, cy-2*cy/15));
                
                contorno.add(new Point2D.Double(cx-7*cx/20, cy-2*cy/15));
                
                contorno.add(new Point2D.Double(cx-7*cx/20, cy-4*cy/15));
                
                contorno.add(new Point2D.Double(cx-8*cx/20, cy-4*cy/15));
                
                contorno.add(new Point2D.Double(cx-8*cx/20, cy-5*cy/15));
                
                contorno.add(new Point2D.Double(cx-9*cx/20, cy-5*cy/15));
                
                contorno.add(new Point2D.Double(cx-9*cx/20, cy-7*cy/15));
                
                contorno.add(new Point2D.Double(cx-8*cx/20, cy-7*cy/15));
                
                contorno.add(new Point2D.Double(cx-8*cx/20, cy-8*cy/15));
                
                contorno.add(new Point2D.Double(cx-7*cx/20, cy-8*cy/15));
                
                contorno.add(new Point2D.Double(cx-7*cx/20, cy-11*cy/15));
                
                contorno.add(new Point2D.Double(cx-6*cx/20, cy-11*cy/15));
                
                contorno.add(new Point2D.Double(cx-6*cx/20, cy-12*cy/15));
                
                contorno.add(new Point2D.Double(cx-2*cx/20, cy-12*cy/15));
                
                contorno.add(new Point2D.Double(cx-2*cx/20, cy-13*cy/15));
                
                contorno.add(new Point2D.Double(cx-1*cx/20, cy-13*cy/15));
                
                contorno.add(new Point2D.Double(cx-1*cx/20, cy-14*cy/15));
                
                contorno.add(new Point2D.Double(cx, cy-14*cy/15));
                
                ArrayList<Rectangle2D.Double> rectangulosNegros = new ArrayList<Rectangle2D.Double>();
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-6*cx/20, cy-2*cy/15, cx/20, 2*cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-4*cx/20, cy-2*cy/15, cx/20, 2*cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-5*cx/20, cy-3*cy/15, cx/20, 2*cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-7*cx/20, cy-5*cy/15, cx/20, 3*cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-8*cx/20, cy-5*cy/15, cx/20, cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-9*cx/20, cy-7*cy/15, cx/20, 2*cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-8*cx/20, cy-8*cy/15, cx/20, cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-7*cx/20, cy-9*cy/15, 3*cx/20, cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-6*cx/20, cy-8*cy/15, cx/20, 5*cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-7*cx/20, cy-11*cy/15, cx/20, 2*cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-6*cx/20, cy-12*cy/15, 4*cx/20, cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-2*cx/20, cy-13*cy/15, cx/20, 4*cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-4*cx/20, cy-10*cy/15, 2*cx/20, cy/15));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-cx/20, cy-14*cy/15, cx/20, cy/15));
                
                ArrayList<Rectangle2D.Double> rectangulosVerdes = new ArrayList<Rectangle2D.Double>();
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-3*cx/20, cy-cy/15, 3*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-3*cx/20, cy-2*cy/15, 2*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-3*cx/20, cy-2*cy/15, 2*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-4*cx/20, cy-3*cy/15, 3*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-5*cx/20, cy-4*cy/15, 4*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-5*cx/20, cy-5*cy/15, 5*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-5*cx/20, cy-6*cy/15, 5*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-5*cx/20, cy-7*cy/15, 5*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-5*cx/20, cy-8*cy/15, 5*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-4*cx/20, cy-9*cy/15, 4*cx/20, cy/15));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-cx/20, cy-13*cy/15, cx/20, 2*cy/15));
                
                ArrayList<Rectangle2D.Double> rectangulosRojos = new ArrayList<Rectangle2D.Double>();
                
                rectangulosRojos.add(new Rectangle2D.Double(cx-5*cx/20, cy-cy/15, cx/20, cy/15));
                
                rectangulosRojos.add(new Rectangle2D.Double(cx-6*cx/20, cy-3*cy/15, cx/20, cy/15));
                
                rectangulosRojos.add(new Rectangle2D.Double(cx-8*cx/20, cy-6*cy/15, 2*cx/20, cy/15));
                
                rectangulosRojos.add(new Rectangle2D.Double(cx-8*cx/20, cy-7*cy/15, 2*cx/20, cy/15));
                
                rectangulosRojos.add(new Rectangle2D.Double(cx-7*cx/20, cy-8*cy/15, cx/20, cy/15));
                
                rectangulosRojos.add(new Rectangle2D.Double(cx-6*cx/20, cy-10*cy/15, 2*cx/20, cy/15));
                
                rectangulosRojos.add(new Rectangle2D.Double(cx-6*cx/20, cy-11*cy/15, 4*cx/20, cy/15));
                
                ArrayList<Rectangle2D.Double> rectangulosFondo = new ArrayList<Rectangle2D.Double>();
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy-cy/15, 14*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy-2*cy/15, 14*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy-3*cy/15, 13*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy-4*cy/15, 13*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy-5*cy/15, 12*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy-6*cy/15, 11*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy-7*cy/15, 11*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy-8*cy/15, 12*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy-9*cy/15, 13*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy-10*cy/15, 13*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy-11*cy/15, 13*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy-12*cy/15, 14*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy-13*cy/15, 18*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy-14*cy/15, 19*cx/20, cy/15));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, 0, cx, cy/15));
                
                if(sleep) {
                
                    g.setColor(Color.black);

                    for(int i=0; i<contorno.size()-1; i++) {

                        g.draw(new Line2D.Double(contorno.get(i), contorno.get(i+1)));

                        try {

                            Thread.sleep(100);

                        } catch(InterruptedException e) {}

                    }

                    g.setColor(Color.black);

                    for(int i=0; i<rectangulosNegros.size(); i++) {

                        g.fill(rectangulosNegros.get(i));

                        try {

                            Thread.sleep(100);

                        } catch(InterruptedException e) {}

                    }
                    
                    g.setColor(Color.green);

                    for(int i=0; i<rectangulosVerdes.size(); i++) {

                        g.fill(rectangulosVerdes.get(i));

                        try {

                            Thread.sleep(100);

                        } catch(InterruptedException e) {}

                    }
                    
                    g.setColor(Color.red);

                    for(int i=0; i<rectangulosRojos.size(); i++) {

                        g.fill(rectangulosRojos.get(i));

                        try {

                            Thread.sleep(100);

                        } catch(InterruptedException e) {}

                    }
                    
                    g.setColor(Color.cyan);

                    for(int i=0; i<rectangulosFondo.size(); i++) {

                        g.fill(rectangulosFondo.get(i));

                        try {

                            Thread.sleep(100);

                        } catch(InterruptedException e) {}

                    }
                    
                } else {
                    
                    g.setColor(Color.black);

                    for(int i=0; i<contorno.size()-1; i++) {

                        g.draw(new Line2D.Double(contorno.get(i), contorno.get(i+1)));

                    }

                    g.setColor(Color.black);

                    for(int i=0; i<rectangulosNegros.size(); i++) {

                        g.fill(rectangulosNegros.get(i));

                    }
                    
                    g.setColor(Color.green);

                    for(int i=0; i<rectangulosVerdes.size(); i++) {

                        g.fill(rectangulosVerdes.get(i));

                    }
                    
                    g.setColor(Color.red);

                    for(int i=0; i<rectangulosRojos.size(); i++) {

                        g.fill(rectangulosRojos.get(i));

                    }
                    
                    g.setColor(Color.cyan);

                    for(int i=0; i<rectangulosFondo.size(); i++) {

                        g.fill(rectangulosFondo.get(i));

                    }
                    
                }
                
            } else if(noCuadrante == 3) {
                
                ArrayList<Point2D.Double> contorno = new ArrayList<Point2D.Double>();
                
                contorno.add(new Point2D.Double(cx-6*cx/20, cy));
                
                contorno.add(new Point2D.Double(cx-6*cx/20, cy+cy/18));
                
                contorno.add(new Point2D.Double(cx-9*cx/20, cy+cy/18));
                
                contorno.add(new Point2D.Double(cx-9*cx/20, cy+2*cy/18));
                
                contorno.add(new Point2D.Double(cx-10*cx/20, cy+2*cy/18));
                
                contorno.add(new Point2D.Double(cx-10*cx/20, cy+3*cy/18));
                
                contorno.add(new Point2D.Double(cx-11*cx/20, cy+3*cy/18));
                
                contorno.add(new Point2D.Double(cx-11*cx/20, cy+4*cy/18));
                
                contorno.add(new Point2D.Double(cx-14*cx/20, cy+4*cy/18));
                
                contorno.add(new Point2D.Double(cx-14*cx/20, cy+8*cy/18));
                
                contorno.add(new Point2D.Double(cx-13*cx/20, cy+8*cy/18));
                
                contorno.add(new Point2D.Double(cx-13*cx/20, cy+11*cy/18));
                
                contorno.add(new Point2D.Double(cx-12*cx/20, cy+11*cy/18));
                
                contorno.add(new Point2D.Double(cx-12*cx/20, cy+14*cy/18));
                
                contorno.add(new Point2D.Double(cx-13*cx/20, cy+14*cy/18));
                
                contorno.add(new Point2D.Double(cx-13*cx/20, cy+17*cy/18));
                
                contorno.add(new Point2D.Double(cx, cy+17*cy/18));
                
                ArrayList<Rectangle2D.Double> rectangulosNegros = new ArrayList<Rectangle2D.Double>();
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-4*cx/20, cy, cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-6*cx/20, cy, cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-9*cx/20, cy+cy/18, 5*cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-10*cx/20, cy+2*cy/18, cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-11*cx/20, cy+3*cy/18, cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-14*cx/20, cy+4*cy/18, 3*cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-14*cx/20, cy+5*cy/18, cx/20, 3*cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-13*cx/20, cy+8*cy/18, cx/20, 3*cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-12*cx/20, cy+11*cy/18, cx/20, 3*cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-12*cx/20, cy+11*cy/18, cx/20, 3*cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-13*cx/20, cy+14*cy/18, cx/20, 3*cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-12*cx/20, cy+16*cy/18, 12*cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-7*cx/20, cy+2*cy/18, 3*cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-8*cx/20, cy+3*cy/18, 2*cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-10*cx/20, cy+4*cy/18, 2*cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-11*cx/20, cy+5*cy/18, cx/20, 4*cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-10*cx/20, cy+9*cy/18, 5*cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-5*cx/20, cy+8*cy/18, cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-4*cx/20, cy+5*cy/18, cx/20, 3*cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-5*cx/20, cy+6*cy/18, cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-5*cx/20, cy+4*cy/18, cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-4*cx/20, cy+3*cy/18, cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-11*cx/20, cy+11*cy/18, 5*cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-7*cx/20, cy+12*cy/18, cx/20, 2*cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-6*cx/20, cy+13*cy/18, 2*cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-4*cx/20, cy+12*cy/18, 4*cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-3*cx/20, cy+13*cy/18, 3*cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-6*cx/20, cy+14*cy/18, cx/20, 2*cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx-10*cx/20, cy+5*cy/18, cx/20, cy/18));
                
                ArrayList<Rectangle2D.Double> rectangulosVerdes = new ArrayList<Rectangle2D.Double>();
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-3*cx/20, cy, 3*cx/20, cy/18));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-4*cx/20, cy+cy/18, 4*cx/20, cy/18));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-4*cx/20, cy+2*cy/18, 4*cx/20, cy/18));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-3*cx/20, cy+3*cy/18, 3*cx/20, cy/18));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-4*cx/20, cy+4*cy/18, 2*cx/20, cy/18));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-6*cx/20, cy+3*cy/18, 2*cx/20, cy/18));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-8*cx/20, cy+4*cy/18, 3*cx/20, cy/18));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-9*cx/20, cy+5*cy/18, 2*cx/20, cy/18));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-5*cx/20, cy+5*cy/18, cx/20, cy/18));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-10*cx/20, cy+6*cy/18, 3*cx/20, cy/18));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-10*cx/20, cy+7*cy/18, 6*cx/20, cy/18));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-10*cx/20, cy+8*cy/18, 5*cx/20, cy/18));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-13*cx/20, cy+5*cy/18, 2*cx/20, cy/18));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx-12*cx/20, cy+6*cy/18, cx/20, cy/18));
                
                ArrayList<Rectangle2D.Double> rectangulosRojos = new ArrayList<Rectangle2D.Double>();
                
                rectangulosRojos.add(new Rectangle2D.Double(cx-10*cx/20, cy+3*cy/18, 2*cx/20, cy/18));
                
                rectangulosRojos.add(new Rectangle2D.Double(cx-9*cx/20, cy+2*cy/18, 2*cx/20, cy/18));
                
                rectangulosRojos.add(new Rectangle2D.Double(cx-5*cx/20, cy, cx/20, cy/18));
                
                rectangulosRojos.add(new Rectangle2D.Double(cx-11*cx/20, cy+12*cy/18, 4*cx/20, cy/18));
                
                rectangulosRojos.add(new Rectangle2D.Double(cx-11*cx/20, cy+13*cy/18, 4*cx/20, cy/18));
                
                rectangulosRojos.add(new Rectangle2D.Double(cx-12*cx/20, cy+14*cy/18, 3*cx/20, cy/18));
                
                rectangulosRojos.add(new Rectangle2D.Double(cx-8*cx/20, cy+14*cy/18, 2*cx/20, cy/18));
                
                rectangulosRojos.add(new Rectangle2D.Double(cx-12*cx/20, cy+15*cy/18, 6*cx/20, cy/18));
                
                rectangulosRojos.add(new Rectangle2D.Double(cx-4*cx/20, cy+13*cy/18, cx/20, cy/18));
                
                rectangulosRojos.add(new Rectangle2D.Double(cx-5*cx/20, cy+14*cy/18, 3*cx/20, cy/18));
                
                rectangulosRojos.add(new Rectangle2D.Double(cx-1*cx/20, cy+14*cy/18, cx/20, cy/18));
                
                rectangulosRojos.add(new Rectangle2D.Double(cx-5*cx/20, cy+15*cy/18, 5*cx/20, cy/18));
                
                ArrayList<Rectangle2D.Double> rectangulosFondo = new ArrayList<Rectangle2D.Double>();
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy, 14*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy+cy/18, 11*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy+2*cy/18, 10*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy+3*cy/18, 9*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy+4*cy/18, 6*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy+5*cy/18, 6*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy+6*cy/18, 6*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy+7*cy/18, 6*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy+8*cy/18, 7*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy+9*cy/18, 7*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy+10*cy/18, 7*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy+11*cy/18, 8*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy+12*cy/18, 8*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy+13*cy/18, 8*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy+14*cy/18, 7*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy+15*cy/18, 7*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy+16*cy/18, 7*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(0, cy+17*cy/18, cx, cy/18));
                
                if(sleep) {
                
                    g.setColor(Color.black);

                    for(int i=0; i<contorno.size()-1; i++) {

                        g.draw(new Line2D.Double(contorno.get(i), contorno.get(i+1)));

                        try {

                            Thread.sleep(100);

                        } catch(InterruptedException e) {}

                    }

                    g.setColor(Color.black);

                    for(int i=0; i<rectangulosNegros.size(); i++) {

                        g.fill(rectangulosNegros.get(i));

                        try {

                            Thread.sleep(100);

                        } catch(InterruptedException e) {}

                    }

                    g.setColor(Color.green);

                    for(int i=0; i<rectangulosVerdes.size(); i++) {

                        g.fill(rectangulosVerdes.get(i));

                        try {

                            Thread.sleep(100);

                        } catch(InterruptedException e) {}

                    }

                    g.setColor(Color.red);

                    for(int i=0; i<rectangulosRojos.size(); i++) {

                        g.fill(rectangulosRojos.get(i));

                        try {

                            Thread.sleep(100);

                        } catch(InterruptedException e) {}

                    }

                    g.setColor(Color.cyan);

                    for(int i=0; i<rectangulosFondo.size(); i++) {

                        g.fill(rectangulosFondo.get(i));

                        try {

                            Thread.sleep(100);

                        } catch(InterruptedException e) {}

                    }
                    
                } else {
                    
                    g.setColor(Color.black);

                    for(int i=0; i<contorno.size()-1; i++) {

                        g.draw(new Line2D.Double(contorno.get(i), contorno.get(i+1)));

                    }

                    g.setColor(Color.black);

                    for(int i=0; i<rectangulosNegros.size(); i++) {

                        g.fill(rectangulosNegros.get(i));

                    }

                    g.setColor(Color.green);

                    for(int i=0; i<rectangulosVerdes.size(); i++) {

                        g.fill(rectangulosVerdes.get(i));

                    }

                    g.setColor(Color.red);

                    for(int i=0; i<rectangulosRojos.size(); i++) {

                        g.fill(rectangulosRojos.get(i));

                    }

                    g.setColor(Color.cyan);

                    for(int i=0; i<rectangulosFondo.size(); i++) {

                        g.fill(rectangulosFondo.get(i));

                    }
                    
                }
                
            } else {
                
                ArrayList<Point2D.Double> contorno = new ArrayList<Point2D.Double>();
                
                contorno.add(new Point2D.Double(cx+10*cx/20, cy));
                
                contorno.add(new Point2D.Double(cx+10*cx/20, cy+cy/18));
                
                contorno.add(new Point2D.Double(cx+9*cx/20, cy+cy/18));
                
                contorno.add(new Point2D.Double(cx+9*cx/20, cy+2*cy/18));
                
                contorno.add(new Point2D.Double(cx+4*cx/20, cy+2*cy/18));
                
                contorno.add(new Point2D.Double(cx+4*cx/20, cy+8*cy/18));
                
                contorno.add(new Point2D.Double(cx+3*cx/20, cy+8*cy/18));
                
                contorno.add(new Point2D.Double(cx+3*cx/20, cy+9*cy/18));
                
                contorno.add(new Point2D.Double(cx+2*cx/20, cy+9*cy/18));
                
                contorno.add(new Point2D.Double(cx+2*cx/20, cy+10*cy/18));
                
                contorno.add(new Point2D.Double(cx+cx/20, cy+10*cy/18));
                
                contorno.add(new Point2D.Double(cx+cx/20, cy+12*cy/18));
                
                contorno.add(new Point2D.Double(cx, cy+12*cy/18));
                
                contorno.add(new Point2D.Double(cx, cy+13*cy/18));
                
                contorno.add(new Point2D.Double(cx+cx/20, cy+13*cy/18));
                
                contorno.add(new Point2D.Double(cx+cx/20, cy+14*cy/18));
                
                contorno.add(new Point2D.Double(cx+cx/20, cy+14*cy/18));
                
                contorno.add(new Point2D.Double(cx+2*cx/20, cy+14*cy/18));
                
                contorno.add(new Point2D.Double(cx+2*cx/20, cy+17*cy/18));
                
                contorno.add(new Point2D.Double(cx, cy+17*cy/18));
                
                ArrayList<Rectangle2D.Double> rectangulosNegros = new ArrayList<Rectangle2D.Double>();
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+8*cx/20, cy, 2*cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+3*cx/20, cy+cy/18, 6*cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+3*cx/20, cy+2*cy/18, cx/20, 6*cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+2*cx/20, cy+8*cy/18, cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+1*cx/20, cy+9*cy/18, cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx, cy+10*cy/18, cx/20, 2*cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx, cy+13*cy/18, cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+cx/20, cy+14*cy/18, cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+cx/20, cy+15*cy/18, cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+cx/20, cy+16*cy/18, cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx+4*cx/20, cy, cx/20, cy/18));
                
                rectangulosNegros.add(new Rectangle2D.Double(cx, cy+16*cy/18, cx/20, cy/18));
                
                ArrayList<Rectangle2D.Double> rectangulosVerdes = new ArrayList<Rectangle2D.Double>();
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx, cy, cx/20, 3*cy/18));
                
                rectangulosVerdes.add(new Rectangle2D.Double(cx+5*cx/20, cy, 3*cx/20, cy/18));
                
                ArrayList<Rectangle2D.Double> rectangulosRojos = new ArrayList<Rectangle2D.Double>();
                
                rectangulosRojos.add(new Rectangle2D.Double(cx, cy+14*cy/18, cx/20, 2*cy/18));
                
                ArrayList<Rectangle2D.Double> rectangulosBlancos = new ArrayList<Rectangle2D.Double>();
                
                rectangulosBlancos.add(new Rectangle2D.Double(cx, cy+3*cy/18, cx/20, 7*cy/18));
                
                rectangulosBlancos.add(new Rectangle2D.Double(cx+cx/20, cy, 3*cx/20, cy/18));
                
                ArrayList<Rectangle2D.Double> rectangulosFondo = new ArrayList<Rectangle2D.Double>();
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+10*cx/20, cy, 10*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+9*cx/20, cy+cy/18, 11*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+4*cx/20, cy+2*cy/18, 16*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+4*cx/20, cy+3*cy/18, 16*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+4*cx/20, cy+4*cy/18, 16*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+4*cx/20, cy+5*cy/18, 16*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+4*cx/20, cy+6*cy/18, 16*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+4*cx/20, cy+7*cy/18, 16*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+3*cx/20, cy+8*cy/18, 17*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+2*cx/20, cy+9*cy/18, 18*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+cx/20, cy+10*cy/18, 19*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+cx/20, cy+11*cy/18, 19*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx, cy+12*cy/18, cx, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+cx/20, cy+13*cy/18, 19*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+2*cx/20, cy+14*cy/18, 18*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+2*cx/20, cy+15*cy/18, 18*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx+2*cx/20, cy+16*cy/18, 18*cx/20, cy/18));
                
                rectangulosFondo.add(new Rectangle2D.Double(cx, cy+17*cy/18, cx, cy/18));
                
                if(sleep) {
                    
                    g.setColor(Color.black);
                
                    for(int i=0; i<contorno.size()-1; i++) {
                    
                        g.draw(new Line2D.Double(contorno.get(i), contorno.get(i+1)));
                    
                        try {
                        
                            Thread.sleep(100);
                        
                        } catch(InterruptedException e) {}
                    
                    }
                
                    g.setColor(Color.black);
                
                    for(int i=0; i<rectangulosNegros.size(); i++) {
                    
                        g.fill(rectangulosNegros.get(i));
                    
                        try {
                        
                            Thread.sleep(100);
                        
                        } catch(InterruptedException e) {}
                    
                    }
                
                    g.setColor(Color.green);
                
                    for(int i=0; i<rectangulosVerdes.size(); i++) {
                    
                        g.fill(rectangulosVerdes.get(i));
                    
                        try {
                        
                            Thread.sleep(100);
                        
                        } catch(InterruptedException e) {}
                    
                    }
                
                    g.setColor(Color.red);
                
                    for(int i=0; i<rectangulosRojos.size(); i++) {
                    
                        g.fill(rectangulosRojos.get(i));
                    
                        try {
                        
                            Thread.sleep(100);
                        
                        } catch(InterruptedException e) {}
                    
                    }
                
                    g.setColor(Color.cyan);
                
                    for(int i=0; i<rectangulosFondo.size(); i++) {
                    
                        g.fill(rectangulosFondo.get(i));
                    
                        try {
                        
                            Thread.sleep(100);
                        
                        } catch(InterruptedException e) {}
                    
                    }
                    
                    g.setColor(Color.white);
                
                    for(int i=0; i<rectangulosBlancos.size(); i++) {
                    
                        g.fill(rectangulosBlancos.get(i));
                    
                        try {
                        
                            Thread.sleep(100);
                        
                        } catch(InterruptedException e) {}
                    
                    }
                     
                } else {
                    
                    g.setColor(Color.black);
                
                    for(int i=0; i<contorno.size()-1; i++) {
                    
                        g.draw(new Line2D.Double(contorno.get(i), contorno.get(i+1)));
                    
                    }
                
                    g.setColor(Color.black);
                
                    for(int i=0; i<rectangulosNegros.size(); i++) {
                    
                        g.fill(rectangulosNegros.get(i));
                    
                    }
                
                    g.setColor(Color.green);
                
                    for(int i=0; i<rectangulosVerdes.size(); i++) {
                    
                        g.fill(rectangulosVerdes.get(i));
                    
                    }
                
                    g.setColor(Color.red);
                
                    for(int i=0; i<rectangulosRojos.size(); i++) {
                    
                        g.fill(rectangulosRojos.get(i));
                    
                    }
                
                    g.setColor(Color.cyan);
                
                    for(int i=0; i<rectangulosFondo.size(); i++) {
                        
                        g.fill(rectangulosFondo.get(i));
                    
                    }
                    
                    g.setColor(Color.white);
                
                    for(int i=0; i<rectangulosBlancos.size(); i++) {
                        
                        g.fill(rectangulosBlancos.get(i));
                    
                    }
                    
                }
                
            }
            
        }
        
        public void run() {
            
            if(noFigura == 1) {
                
                graficarFigura1();
                
            } else {
                
                graficarFigura2();
                
            }
            
        }
        
        private int noFigura, noCuadrante;
        
        private Graphics2D g;
        
        private double cx, cy;
        
        private boolean sleep;
        
    }
    
}
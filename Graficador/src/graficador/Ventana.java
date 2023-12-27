
package graficador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Ventana {
    
    public void abrirVentana() {
        
        new Marco().setVisible(true);
        
    }
    
    private class Marco extends JFrame {
        
        public Marco() {
            
            setTitle("Graficador 2D");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            int w = Toolkit.getDefaultToolkit().getScreenSize().width;
            int h = Toolkit.getDefaultToolkit().getScreenSize().height;
            
            setSize(w/2, 3*h/4);
            setLocation(w/2 - (w/2)/2, h/2 - (3*h/4)/2);
            
            add(new Lamina(), BorderLayout.CENTER);
            
        }
        
    }
    
    private class Lamina extends JPanel {
        
        public Lamina() {
            
            setLayout(new BorderLayout());
            
            fijarComponentes();
            fijarLienzo(); 
            
        }
        
        public void graficar() {
            
            try {
                
                limpiarLienzo();
                
                leer();
                
                dibujar();
                
            } catch(Exception e) {
                
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
                e.printStackTrace();
                
            }
            
        }
        
        private void fijarComponentes() {
            
            campo = new JTextField(20);
            campo.setText("C:\\Prueba\\Instrucciones.txt");
            boton = new JButton("Graficar");
            
            boton.addActionListener(new ActionListener(){
                
                public void actionPerformed(ActionEvent e) {
                    
                    graficar();
                    
                }
                
            });
            
            JPanel componentes = new JPanel();
            componentes.add(new JLabel("Archivo de instrucciones"));
            componentes.add(campo);
            componentes.add(boton);
            
            add(componentes, BorderLayout.NORTH);
            
        }
       
        private void fijarLienzo() {
            
            l = new Lienzo();
            add(l, BorderLayout.CENTER);
            
        }
        
        private void limpiarLienzo() {
            
            l.removeAll();
            l.setBackground(Color.WHITE);
            
        }
        
        private void leer() throws Exception {
            
            BufferedReader lector = new BufferedReader(new FileReader(campo.getText()));
            
            StringTokenizer st = new StringTokenizer(lector.readLine(), " ");
            
            rx = Integer.parseInt(st.nextToken());
            ry = Integer.parseInt(st.nextToken());
            
            l.setLayout(new GridLayout(ry, rx));
            
            dibujo = new ArrayList<ArrayList<Rectangulo>>();
            
            lector.readLine();
            
            while(lector.ready()) {
                
                String linea = lector.readLine();
                
                if(linea.contains("new")) {
                    
                    StringTokenizer st1 = new StringTokenizer(linea, "-");
                    StringTokenizer st2 = new StringTokenizer(st1.nextToken(), " ");
                    
                    st2.nextToken();
                    
                    int r = Integer.parseInt(st2.nextToken());
                    int g = Integer.parseInt(st2.nextToken());
                    int b = Integer.parseInt(st2.nextToken());
                    
                    StringTokenizer st3 = new StringTokenizer(st1.nextToken(), " ");
                    
                    ArrayList<Rectangulo> rectangulos = new ArrayList<Rectangulo>();
                    
                    while(st3.hasMoreTokens()) {
                        
                        rectangulos.add(new Rectangulo(Integer.parseInt(st3.nextToken())));

                    }
                    
                    for (Rectangulo rectangulo: rectangulos) {
                        
                        rectangulo.setColor(new Color(r, g, b));
                        
                    }
                    
                    dibujo.add(rectangulos);
                    
                } else if(linea.contains("end")){
                    
                    lector.close();
                    return;
                    
                } else {
                    
                    lector.close();
                    throw new Exception("Error en las instrucciones");
                    
                }
                
            }     
            
            
        }
        
        private void dibujar() throws Exception {
            
            ArrayList<Rectangulo> blancos = new ArrayList<Rectangulo>();
            
            for(int i=1; i<=rx*ry; i++) {
                
                boolean pintado = false;
                
                for(ArrayList<Rectangulo> colores: dibujo) {
                    
                    for(Rectangulo rectangulo: colores) {
                        
                        if(i == rectangulo.getN()) {
                            
                            pintado = true;
                            
                        }
                        
                    }
                    
                }
                
                if(!pintado) {
                    
                    blancos.add(new Rectangulo(i));
                    
                }
                
            }
            
            for(Rectangulo blanco: blancos) {
                
                blanco.setColor(Color.WHITE);
                
            }
            
            dibujo.add(blancos);
            
            ArrayList<Rectangulo> finales = new ArrayList<Rectangulo>();
            
            for(ArrayList<Rectangulo> rectangulos: dibujo) {
                
                for(Rectangulo rectangulo: rectangulos) {
                    
                    finales.add(rectangulo);
                    
                }
                
            }
            
            for(int i=1; i<=rx*ry; i++) {
                
                for(Rectangulo rectangulo: finales) {
                    
                    if(i == rectangulo.getN()) {
                        
                        System.out.println(rectangulo.getN());
                        
                        l.add(rectangulo);
                        
                    }
                    
                }
                
            }
            
            for(Rectangulo rectangulo: finales) {
                
                rectangulo.pintar();
                
            }
            
            l.updateUI();
            
        }
        
        private JTextField campo;
        private JButton boton;
        private Lienzo l;
        
        private int rx, ry;
        
        private ArrayList<ArrayList<Rectangulo>> dibujo;
        
        private class Lienzo extends JPanel {
            
            public Lienzo() {
                
                setBackground(Color.WHITE);
                
            }
            
        }
        
        private class Rectangulo extends JPanel {
            
            public Rectangulo(int n) {
                
                this.n = n;
    
                
            }
            
            public void setColor(Color c) {
                
                this.c = c;
                
            }
            
            public int getN() {
                
                return n;
                
            }
            
            public void pintar() {
                
                setBackground(c);
                
            }
            
            private int n;
            private Color c;
            
        }
        
    }
    
}
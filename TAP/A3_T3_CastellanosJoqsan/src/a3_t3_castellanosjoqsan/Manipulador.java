package a3_t3_castellanosjoqsan;

import java.util.*;

import javax.swing.*;

public class Manipulador {
    
    public static void apostar() {
        
        double cantidad = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese cantidad a apostar", "Apostando", JOptionPane.QUESTION_MESSAGE));

        if(cantidad >= 1 && cantidad <= Double.parseDouble(Lamina.ct2.getText())) {

            JOptionPane.showMessageDialog(null, "Cantidad apostada: " + cantidad, "Apostando", JOptionPane.INFORMATION_MESSAGE);
                       
            Lamina.ct1.setText(String.valueOf(cantidad));
                        
            if(imagenes.size() == 5) {
                            
                if(!Lamina.bt3.isEnabled()) {
                                
                    Lamina.bt3.setEnabled(true);
                                
                }
                           
            }
                        
            listo = true;
                        
        } else {

            JOptionPane.showMessageDialog(null, "Cantidad máxima a apostar: " + Double.parseDouble(Lamina.ct2.getText()) + "\nCantidad mínima a apostar: 1.0", "Error", JOptionPane.ERROR_MESSAGE);
                        
            Lamina.ct1.setText("0.0");
                            
            if(Lamina.bt3.isEnabled()) {
                                
                Lamina.bt3.setEnabled(false);
                                
            }
                        
            listo = false;
                        
        }
        
    }
    
    public static void cancelar() {
        
        h1.stop();
                    
        h2.stop();
                    
        h3.stop();
                    
        Lamina.bt1.setEnabled(true);
                    
        Lamina.bt3.setEnabled(true);
                    
        Lamina.bt2.setEnabled(false);
                    
        Lamina.bt4.setEnabled(false);
                    
        Lamina.et1.setText("JUEGO CANCELADO");
        
    }
    
    public static void iniciar() {
        
        h1 = new Hilo1();
                    
        h1.start();
                    
        h2 = new Hilo2();
                    
        h2.start();
                    
        h3 = new Hilo3();
                    
        h3.start();
                    
        Lamina.bt2.setEnabled(true);
                    
        Lamina.bt4.setEnabled(true);
                    
        Lamina.bt1.setEnabled(false);
                    
        Lamina.bt3.setEnabled(false);
                    
        Lamina.et1.setText("JUGANDO");
        
    }
    
    public static void terminar() {
        
        h1.stop();
                    
        h2.stop();
                    
        h3.stop();
                    
        Lamina.bt1.setEnabled(true);
                    
        Lamina.bt3.setEnabled(true);
                    
        Lamina.bt2.setEnabled(false);
                    
        Lamina.bt4.setEnabled(false);
                    
        if(Imagenes.Imagen1.n == Imagenes.Imagen2.n && Imagenes.Imagen1.n == Imagenes.Imagen3.n) {
                        
            JOptionPane.showMessageDialog(null, "¡Felicidades!\nHas ganado: " + Double.parseDouble(Lamina.ct1.getText())*2, "Juego terminado", JOptionPane.INFORMATION_MESSAGE);
                        
            Lamina.ct2.setText(String.valueOf(Double.parseDouble(Lamina.ct2.getText()) - Double.parseDouble(Lamina.ct1.getText())));
                        
            mg += Double.parseDouble(Lamina.ct1.getText());
            
            Lamina.et1.setText("JUEGO GANADO");
                        
            Lamina.et2.setText("MONTO GANADO: " + mg);
            
            Lamina.et3.setText("MONTO RECUPERADO: " + mg);
            
            Lamina.et4.setText("TOTAL ACUMULADO: " + mg*2);
                 
            if(Double.parseDouble(Lamina.ct2.getText()) < 1) {
                            
                JOptionPane.showMessageDialog(null, "La máquina se ha quedado sin dinero", "Error", JOptionPane.ERROR_MESSAGE);
                            
                Lamina.bt1.setEnabled(false);
                            
                Lamina.bt3.setEnabled(false);
                            
                for(int i=0; i<10; i++) {
                                
                    if(Lamina.checks[i].isEnabled()) {
                                    
                        Lamina.checks[i].setEnabled(false);
                                    
                    }
                                
                }
                            
            } else {
                            
                if(Double.parseDouble(Lamina.ct2.getText()) < Double.parseDouble(Lamina.ct1.getText())) {
                            
                    JOptionPane.showMessageDialog(null, "El saldo es insuficiente para continuar con la cantidad apostada", "Error", JOptionPane.ERROR_MESSAGE);
                            
                    Lamina.bt3.setEnabled(false);
                    
                    listo = false;
                            
                }
                            
            }
                        
        } else {
                        
            Lamina.et1.setText("JUEGO PERDIDO");
                        
        }
        
    }
    
    public static boolean listo;
    
    public static double mg = 0;
    
    public static Vector<Integer> imagenes = new Vector<Integer>(1, 1);
    
    private static Hilo1 h1;
    
    private static Hilo2 h2;
    
    private static Hilo3 h3;
    
}
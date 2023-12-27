package a4_t1_castellanosjoqsan;

import javax.swing.*;

import java.awt.*;

import java.util.*;

public class Lamina extends JPanel {
    
    public Lamina() {
        
        setLayout(new GridLayout(10, 2));
        
        entrada = new Scanner(System.in);
        
    }
    
    public void initComponents() throws InputMismatchException {
        
        etiquetas = new JLabel[10];
        
        campos = new JTextField[10];
        
        double n = 0;
        
        do {
            
            try {
                
                System.out.print("Ingrese un número para generar su tabla de multiplicar: ");
                
                n = entrada.nextDouble();
                
                for(int i=0; i<10; i++) {
                
                etiquetas[i] = new JLabel(n + " x " + (i+1) + " =", SwingConstants.CENTER);
            
                campos[i] = new JTextField();
                
                campos[i].setText(String.valueOf(n * (i+1)));
                
                campos[i].setHorizontalAlignment(SwingConstants.CENTER);
            
                campos[i].setEditable(false);
            
                add(etiquetas[i]);
            
                add(campos[i]);
                
                }
                
                break;
                
            } catch(InputMismatchException e) {
                
                entrada = new Scanner(System.in);
                
            }
            
        } while(true);
        
    }
    
    private JLabel[] etiquetas;
    
    private JTextField[] campos;
    
    private Scanner entrada;
    
}
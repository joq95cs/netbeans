package hilosoperaciones;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    
    public Ventana() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Operaciones con hilos");
        setSize(400, 250);
        setLocationRelativeTo(null);
        
        add(new Contenedor());
        
    }
    
    public static JTextField ctNum1 = new JTextField(7);
    public static JTextField ctNum2 = new JTextField(7);
    public static JTextField ctSum = new JTextField(7);
    public static JTextField ctRes = new JTextField(7);
    public static JTextField ctMul = new JTextField(7);
    public static JTextField ctDiv = new JTextField(7);
    
    private class Contenedor extends JPanel {
    
        public Contenedor() {

            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            
            c.weightx = 1;
            c.weighty = 1;
            
            c.gridx = 0;
            c.gridy = 0;
            add(new JLabel("Número 1"), c);
            
            c.gridx = 1;
            add(ctNum1, c);
            
            c.gridx = 2;
            add(new JLabel("Número 2"), c);
            
            c.gridx = 3;
            add(ctNum2, c);
            
            c.gridy = 1;
            c.gridx = 0;
            add(new JLabel("Suma"), c);
            
            c.gridx = 1;
            add(ctSum, c);
            
            c.gridx = 2;
            add(new JLabel("Resta"), c);
            
            c.gridx = 3;
            add(ctRes, c);
            
            c.gridy = 2;
            c.gridx = 0;
            add(new JLabel("Multiplicación"), c);
            
            c.gridx = 1;
            add(ctMul, c);
            
            c.gridx = 2;
            add(new JLabel("División"), c);
            
            c.gridx = 3;
            add(ctDiv, c);
            
        }

    }
    
}
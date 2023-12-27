package crearnumerosaleatorios;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import numeroaleatorio.*;

public class CrearNumerosAleatorios {
    
    public static void main(String[] args) {
        
        new Marco().setVisible(true);
        
    }
    
}

class Marco extends JFrame {
    
    public Marco() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle("Numeros Aleatorios");
        
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        setBounds(w/3, h/3, w/3, h/3);
        
        add(new Lamina());
        
    }
    
}

class Lamina extends JPanel {
    
    public Lamina() {
        
        setLayout(new BorderLayout());
        
        JPanel superior = new JPanel();
        
        superior.add(new JLabel("Decimales: "));
        
        sp = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        
        ((JSpinner.DefaultEditor) sp.getEditor()).getTextField().setEditable(false);
        
        superior.add(sp);
        
        bt = new JButton("Crear");
        
        superior.add(bt);
        
        add(superior, BorderLayout.NORTH);
        
        JPanel central = new JPanel();
        
        central.setLayout(new GridLayout(2, 5));
        
        ets = new JTextField[10];
        
        for(int i=0; i<ets.length; i++) {
            
            ets[i] = new JTextField();
            
            ets[i].setEditable(false);
            
            ets[i].setHorizontalAlignment(SwingUtilities.CENTER);
            
            central.add(ets[i]);
            
        }
        
        add(central, BorderLayout.CENTER);
        
        bt.addMouseListener(new Oyente());
        
    }
    
    private JSpinner sp;
    
    private JButton bt;
    
    private JTextField[] ets;
    
    private class Oyente extends MouseAdapter {
        
        public void mouseClicked(MouseEvent ev) {
            
            for(JTextField e: ets) {
                
                e.setText(String.valueOf(NumeroAleatorio.generar(Integer.parseInt(sp.getValue().toString()))));
                
            }
            
        }
        
    }
    
}
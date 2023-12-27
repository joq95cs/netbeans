package a2_t3_castellanosjoqsan;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class Lamina extends JPanel {
    
    public Lamina() {
        
        initComponents();
        
    }
    
    private void initComponents() {
        
        setLayout(new GridLayout(5, 1));
        
        JPanel l1 = new JPanel();
        
        l1.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        l1.add(new JLabel("Número 1"));
        
        ct1 = new JTextField(7);
        
        l1.add(ct1);
        
        add(l1);
        
        JPanel l2 = new JPanel();
        
        l2.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        l2.add(new JLabel("Número 2"));
        
        ct2 = new JTextField(7);
        
        l2.add(ct2);
        
        add(l2);
        
        JPanel l3 = new JPanel();
        
        bt1 = new JButton("Iniciar hilos");
        
        Oyente o = new Oyente();
        
        bt1.addActionListener(o);
        
        l3.add(bt1);
        
        bt2 = new JButton("Detener hilos");
        
        bt2.setEnabled(false);
        
        bt2.addActionListener(o);
        
        l3.add(bt2);
        
        add(l3);
        
        JPanel l4 = new JPanel();
        
        l4.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        l4.add(new JLabel("Resultado suma"));
        
        ct3 = new JTextField(7);
        
        ct3.setEditable(false);
        
        l4.add(ct3);
        
        add(l4);
        
        JPanel l5 = new JPanel();
        
        l5.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        l5.add(new JLabel("Resultado resta"));
        
        ct4 = new JTextField(7);
        
        ct4.setEditable(false);
        
        l5.add(ct4);
        
        add(l5);
        
    }
    
    private class Oyente implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource() == bt1) {
                
                Iniciar_Detener.iniciarHilos();
                
            } else {
                
                Iniciar_Detener.detenerHilos();
                
            }
            
        }
       
    }
    
    public static JTextField ct1, ct2, ct3, ct4;
    
    public static JButton bt1, bt2;
    
}
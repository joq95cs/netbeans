package a3_t2_castellanosjoqsan;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import libreriacastellanos.*;

public class Marco extends JFrame {
    
    public Marco() {
        
        initComponents();
        
        Metodos.setMarco(this);
        
    }
    
    private void initComponents() {
        
        setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/3, 
                  Toolkit.getDefaultToolkit().getScreenSize().height/3, 
                  Toolkit.getDefaultToolkit().getScreenSize().width/3, 
                  Toolkit.getDefaultToolkit().getScreenSize().height/3);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle("Series");
        
        setLayout(new GridLayout(3, 1));
        
        JPanel lamina1 = new JPanel();
        
        lamina1.setBackground(Color.CYAN);
        
        combo = new JComboBox<String>();
        
        Font fuente = new Font("Comic Sans MS", Font.BOLD, 14);
        
        combo.setFont(fuente);
        
        combo.addItem("Serie Fibonacci");
        
        combo.addItem("Números primos");
        
        combo.addItem("Aproximación de sen(x)");
        
        combo.addItem("Factorial de un número");
        
        combo.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                comboActionPerformed(e);
                
            }
            
        });
        
        lamina1.add(combo);
        
        add(lamina1);
        
        JPanel lamina2 = new JPanel();
        
        lamina2.setBackground(Color.GREEN);
        
        etiqueta1 = new JLabel("No. Límite");
        
        etiqueta1.setFont(fuente);
        
        etiqueta1.setVisible(false);
        
        lamina2.add(etiqueta1);
        
        campo1 = new JTextField(4);
        
        campo1.setFont(fuente);
        
        campo1.setVisible(false);
        
        lamina2.add(campo1);
        
        etiqueta2 = new JLabel("No. Iteraciones");
        
        etiqueta2.setFont(fuente);
        
        lamina2.add(etiqueta2);
        
        campo2 = new JTextField(4);
        
        campo2.setFont(fuente);
        
        lamina2.add(campo2);
        
        JButton boton = new JButton("Ejecutar");
        
        boton.setFont(fuente);
        
        boton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                botonActionPerformed(e);
                
            }
            
        });
        
        lamina2.add(boton);
        
        add(lamina2);
        
        JPanel lamina3 = new JPanel();
        
        lamina3.setLayout(new GridLayout(1, 1));
        
        area = new JTextArea();
        
        area.setBackground(Color.YELLOW);
        
        area.setFont(fuente);
        
        area.setEditable(false);
        
        lamina3.add(new JScrollPane(area));
        
        add(lamina3);
        
    }
    
    private void comboActionPerformed(ActionEvent e) {
        
        Metodos.combo(combo.getSelectedIndex());
        
    }
    
    private void botonActionPerformed(ActionEvent e) {
        
        try {
            
            Metodos.boton(combo.getSelectedIndex());
            
        } catch(SeriesException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
            
        }
        
    }
    
    public JTextField[] getCampos() {
        
        JTextField[] campos = {campo1, campo2};
        
        return campos;
        
    }
    
    public JTextArea getArea() {
        
        return area;
        
    }
    
    public JLabel[] getEtiquetas() {
        
        JLabel[] etiquetas = {etiqueta1, etiqueta2};
        
        return etiquetas;
        
    }
    
    private JComboBox<String> combo;
    
    private JTextField campo1, campo2;
    
    private JTextArea area;
    
    private JLabel etiqueta1, etiqueta2;
    
}
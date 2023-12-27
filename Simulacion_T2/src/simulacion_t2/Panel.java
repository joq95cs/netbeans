package simulacion_t2;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class Panel extends JPanel {
    
    public Panel() {
        
        setLayout(new BorderLayout());
        
        JPanel p1 = new JPanel();
        
        p1.add(new JLabel("Método"));
        
        cb = new JComboBox();
        
        cb.addItem("Cuadrados medios");
        
        cb.addItem("Aditivo");
        
        cb.addItem("Mixto");
        
        cb.addItem("Combinado");
        
        p1.add(cb);
        
        p1.add(new JLabel("No. iteraciones"));
        
        tf = new JTextField(4);
        
        p1.add(tf);
        
        bt = new JButton("Generar");
        
        bt.addActionListener(new Oyente());
        
        p1.add(bt);
        
        add(p1, BorderLayout.NORTH);
        
        p2 = new JPanel();
        
        add(p2, BorderLayout.CENTER);
        
        add(new JLabel("Castellanos Alicea Joqsan Adalid - 5° B", SwingConstants.CENTER), BorderLayout.SOUTH);
        
        m = new Metodos();
        
    }
    
    private JComboBox cb;
    
    private JTextField tf;
    
    private JButton bt;
    
    private Metodos m;
    
    private JPanel p2;
    
    private class Oyente implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            
            try {
                
                if(Integer.parseInt(tf.getText()) < 1) {
                    
                    throw new Exception("No. iteraciones no válido");
                    
                }
                
                Panel.this.remove(p2);

                switch(cb.getSelectedIndex()) {

                    case 0:
                        
                        p2 = new Panel1();
                        
                        break;

                    case 1:
                        
                        p2 = new Panel2();

                        break;

                    case 2:
                        
                        p2 = new Panel3();

                        break;

                    default:   
                        
                        p2 = new Panel4();

                }
                        
                Panel.this.add(p2, BorderLayout.CENTER);
                        
                Panel.this.updateUI();

            } catch(Exception ex) {
                
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
                
            }
            
        }
        
    }
    
    private class Panel1 extends JPanel {
        
        public Panel1() throws Exception {
            
            setLayout(new BorderLayout());
            
            add(new JScrollPane(m.cuadradosMedios(Integer.parseInt(tf.getText()),
            Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese n0", "Método: Cuadrados medios", JOptionPane.QUESTION_MESSAGE)))));
            
        }
        
    }
    
    private class Panel2 extends JPanel {
        
        public Panel2() throws Exception {
            
            setLayout(new BorderLayout());
            
            add(new JScrollPane(m.aditivo(Integer.parseInt(tf.getText()))));
            
        }
        
    }
    
    private class Panel3 extends JPanel {
        
        public Panel3() throws Exception {
            
            setLayout(new BorderLayout());
            
            add(new JScrollPane(m.mixto(Integer.parseInt(tf.getText()), 
            Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese n0", "Método: Mixto", JOptionPane.QUESTION_MESSAGE)))));
            
        }
        
    }
    
    private class Panel4 extends JPanel {
        
        public Panel4() throws Exception {
            
            setLayout(new BorderLayout());
            
            add(new JScrollPane(m.combinado(Integer.parseInt(tf.getText()))));
            
        }
        
    }
    
}
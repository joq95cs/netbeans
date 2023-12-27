package cesar;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class Marco extends JFrame {
    
    public Marco() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(600, 300);
        
        setLocationRelativeTo(null);
        
        setTitle("Cesar: Castellanos Alicea Joqsan Adalid");
        
        add(new Lamina());
        
    }
    
}

class Lamina extends JPanel {
    
    public Lamina() {
        
        setLayout(new BorderLayout());
        
        JPanel laminaCentro = new JPanel();
        
        laminaCentro.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        
        c.weightx = 1;
        
        c.weighty = 1;
        
        c.gridx = 0;
        
        c.gridy = 0;
        
        laminaCentro.add(new JLabel("Texto a encriptar"), c);
        
        c.gridx = 1;
        
        int columnas = 30;
        
        tf1 = new JTextField(columnas);
        
        laminaCentro.add(tf1, c);
        
        c.gridx = 0;
        
        c.gridy = 1;
        
        laminaCentro.add(new JLabel("Texto encriptado"), c);
        
        c.gridx = 1;
        
        tf2 = new JTextField(columnas);
        
        tf2.setEditable(false);
        
        laminaCentro.add(tf2, c);
        
        c.gridx = 0;
        
        c.gridy = 2;
        
        laminaCentro.add(new JLabel("Texto a desencriptar"), c);
        
        c.gridx = 1;
        
        tf3 = new JTextField(columnas);
        
        laminaCentro.add(tf3, c);
        
        c.gridx = 0;
        
        c.gridy = 3;
        
        laminaCentro.add(new JLabel("Texto desencriptado"), c);
        
        c.gridx = 1;
        
        tf4 = new JTextField(columnas);
        
        tf4.setEditable(false);
        
        laminaCentro.add(tf4, c);
        
        c.gridx = 0;
        
        c.gridy = 4;
        
        add(laminaCentro, BorderLayout.CENTER);
        
        JPanel laminaSur = new JPanel();
        
        bt1 = new JButton("Encriptar");
        
        Oyente o = new Oyente();
        
        bt1.addActionListener(o);
        
        laminaSur.add(bt1);
        
        bt2 = new JButton("Desencriptar");
        
        bt2.addActionListener(o);
        
        laminaSur.add(bt2);
        
        add(laminaSur, BorderLayout.SOUTH);
        
    }
    
    private JTextField tf1, tf2, tf3, tf4;
    
    private JButton bt1, bt2;
    
    private class Oyente implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource().equals(bt1)) {
                
                tf2.setText(Metodos.encriptar(tf1.getText()));
                
            } else {
                
                tf4.setText(Metodos.desencriptar(tf3.getText()));
                
            }
            
        }
        
    }
    
}
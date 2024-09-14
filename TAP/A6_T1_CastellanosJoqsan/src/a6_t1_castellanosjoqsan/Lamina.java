package a6_t1_castellanosjoqsan;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class Lamina extends JPanel {
    
    public Lamina() {
        
        setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridwidth = 1;
        
        c.gridheight = 1;
        
        c.weightx = 1;
        
        c.weighty = 1;
        
        c.gridx = 0;
        
        c.gridy = 0;
        
        etGrado = new JLabel("Grado");
        
        add(etGrado, c);
        
        c.gridx = 1;
        
        cbGrado = new JComboBox();
        
        cbGrado.addItem("1°");
        
        cbGrado.addItem("2°");
        
        cbGrado.addItem("3°");
        
        cbGrado.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            
                if(cbGrado.getSelectedItem() == "1°") {
                    
                    ctTotal.setText("" + 15200);
                    
                    etDescuento.setText("Descuento (0%)");
                    
                    ctDescuento.setText("" + 0);
                
                } else if(cbGrado.getSelectedItem() == "2°") {
                    
                    ctTotal.setText("" + (15200 - 15200*0.05));
                    
                    etDescuento.setText("Descuento (5%)");
                    
                    ctDescuento.setText("" + 15200*0.05);
                
                } else {
                    
                    ctTotal.setText("" + (15200 - 15200*0.1));
                    
                    etDescuento.setText("Descuento (10%)");
                    
                    ctDescuento.setText("" + 15200*0.1);
                
                }
                
                etInscripcion.setVisible(true);
                    
                ctInscripcion.setVisible(true);
                    
                etColegiatura.setVisible(true);
                    
                ctColegiatura.setVisible(true);
                
                etDescuento.setVisible(true);
                
                ctDescuento.setVisible(true);
            
            }
            
        });
        
        add(cbGrado, c);
        
        c.gridx = 2;
        
        etTotal = new JLabel("Total");
        
        add(etTotal, c);
        
        c.gridx = 3;
        
        ctTotal = new JTextField(10);
        
        ctTotal.setEditable(false);
        
        add(ctTotal, c);
        
        c.gridx = 0;
        
        c.gridy = 1;
        
        etInscripcion = new JLabel("Inscripción");
        
        etInscripcion.setVisible(false);
          
        add(etInscripcion, c);
        
        c.gridx = 1;
        
        ctInscripcion = new JTextField(10);
        
        ctInscripcion.setText("" + 500);
        
        ctInscripcion.setEditable(false);
        
        ctInscripcion.setVisible(false);
        
        add(ctInscripcion, c);
        
        c.gridx = 2;
        
        etColegiatura = new JLabel("Colegiatura (10 meses)");
        
        etColegiatura.setVisible(false);
        
        add(etColegiatura, c);
        
        c.gridx = 3;
        
        ctColegiatura = new JTextField(10);
        
        ctColegiatura.setText("" + 15000);
        
        ctColegiatura.setEditable(false);
        
        ctColegiatura.setVisible(false);
        
        add(ctColegiatura, c);
        
        c.gridx = 4;
        
        etDescuento = new JLabel("Descuento");
        
        etDescuento.setVisible(false);
        
        add(etDescuento, c);
        
        c.gridx = 5;
        
        ctDescuento = new JTextField(10);
        
        ctDescuento.setEditable(false);
        
        ctDescuento.setVisible(false);
        
        add(ctDescuento, c);
        
    }
    
    private JLabel etGrado, etTotal, etInscripcion, etColegiatura, etDescuento;
    
    private JComboBox cbGrado;
    
    private JTextField ctTotal, ctInscripcion, ctColegiatura, ctDescuento;
    
}
package a3_t3_castellanosjoqsan;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class Marco extends JFrame {
    
    public Marco() {
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        setSize(432, 632);
        
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-216, Toolkit.getDefaultToolkit().getScreenSize().height/2-316);
        
        setTitle("Máquina de apuestas");
        
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/icono.png"));
        
        setResizable(false);
        
        add(new Lamina());
        
        addWindowListener(new WindowAdapter() {
            
            public void windowClosing(WindowEvent e) {
                
                if(JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Saliendo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    
                    System.exit(0);
                    
                }
                
            }
            
        });
        
    }
    
}
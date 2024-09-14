package a2_t2_castellanosjoqsan;

import java.awt.event.*;

import java.awt.BorderLayout;

import cadenasrolando.CadenasRolando;

public class Oyente implements ActionListener {
    
    public Oyente(Lamina l) {
        
        this.l = l;
        
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == l.getCombo()) {
            
            l.getLamina1().removeAll();
            
            l.getLamina1().add(l.getCampo1());
            
            if(l.getCombo().getSelectedIndex() == 1 || l.getCombo().getSelectedIndex() == 2) {
                
                l.getLamina1().add(l.getCampo2());
                
            }
            
            l.getLamina1().add(l.getBoton());
            
            l.recargarMarco();
            
        } else if(e.getSource() == l.getBoton()) {
            
            l.getLamina2().removeAll();
            
            l.getLamina2().add(l.getCampo3(), BorderLayout.CENTER);
            
            CadenasRolando cr = new CadenasRolando();
            
            switch (l.getCombo().getSelectedIndex()) {
                
                case 0:
                    
                    l.getCampo3().setText("" + cr.getLongitudCadena(l.getCampo1().getText()));
                    
                    break;
                
                case 1:
                    
                    l.getCampo3().setText(cr.getBusqueda(l.getCampo1().getText(), l.getCampo2().getText()));
                    
                    break;
                
                case 2:
                    
                    l.getCampo3().setText(cr.getComparacionCadenas(l.getCampo1().getText(), l.getCampo2().getText()));
                    
                    break;
                
                case 3:
                    
                    l.getCampo3().setText(cr.getCambioMayusculas(l.getCampo1().getText()));
                    
                    break;
                    
            }
            
            l.recargarMarco();
            
        }
        
    }
    
    private Lamina l;
    
}
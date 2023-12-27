package controlador;

import java.awt.event.*;

import modelo.*;

import vista.*;

public class ControladorCargaMenus extends WindowAdapter {
    
    public ControladorCargaMenus(Marco_Aplicacion marco) {
        
        this.marco = marco;
        
        cs = new CargaMenus();
        
    }
    
    public void windowOpened(WindowEvent e) {
        
        cs.ejecutaConsultas();
        
        try {
            
            while(cs.rs1.next()) {
                
                marco.secciones.addItem(cs.rs1.getString(1));
                
            }
            
            while(cs.rs2.next()) {
                
                marco.paises.addItem(cs.rs2.getString(1));
                
            }
            
            cs.rs1.close();
            
            cs.rs2.close();
            
        } catch(Exception ex) {}
        
    }
    
    private CargaMenus cs;
    
    private Marco_Aplicacion marco;
    
}

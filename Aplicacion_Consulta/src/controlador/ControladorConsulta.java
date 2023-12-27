package controlador;

import java.awt.event.*;

import modelo.*;

import vista.*;

import java.sql.*;

public class ControladorConsulta implements ActionListener {
    
    public ControladorConsulta(Marco_Aplicacion marco) {
        
        this.marco = marco;
        
        ec = new EjecutaConsultas();
        
    }
    
    public void actionPerformed(ActionEvent e) {
        
        marco.resultado.setText("");
        
        String seleccionSeccion = marco.secciones.getSelectedItem().toString();
        
        String seleccionPais = marco.paises.getSelectedItem().toString();
        
        rs = ec.filtra(seleccionSeccion, seleccionPais);
        
        try {
        
            while(rs.next()) {
                
                marco.resultado.append(rs.getString(1));
                
                marco.resultado.append(", ");
                
                marco.resultado.append(rs.getString(2));
                
                marco.resultado.append(", ");
                
                marco.resultado.append(rs.getString(3));
                
                marco.resultado.append(", ");
                
                marco.resultado.append(rs.getString(4));

                marco.resultado.append("\n");

            }
            
        } catch (Exception ex) {}
        
    }
    
    private Marco_Aplicacion marco;
    
    private EjecutaConsultas ec;
    
    private ResultSet rs;
    
}

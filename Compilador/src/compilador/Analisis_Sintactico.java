package compilador;

import java.util.*;

import javax.swing.table.*;

import javax.swing.*;

public class Analisis_Sintactico {
    
    public static void mostrarTablaSimbolos(ArrayList<String[]> variables, ArrayList<String[]> lexemas) {
        
        for(int i=0; i<variables.size(); i++) {
        
            for(int j=0; j<lexemas.size(); j++) {

                if(lexemas.get(j)[0].equals(variables.get(i)[1])) {

                    if((lexemas.get(j-1)[0].equals("ent") || lexemas.get(j-1)[0].equals("flot")) && (lexemas.get(j+1)[0].equals(";") || lexemas.get(j+1)[0].equals("="))) {
                        
                        variables.get(i)[2] = lexemas.get(j-1)[0];
                        
                        if(lexemas.get(j-1)[0].equals("ent")) {
                            
                            variables.get(i)[3] = "4 bits";
                            
                        } else {
                            
                            variables.get(i)[3] = "8 bits";
                            
                        }
                        
                    }
                    
                    if(lexemas.get(j+1)[0].equals("=") && (lexemas.get(j+2)[1].equals("Entero") || lexemas.get(j+2)[1].equals("Flotante")) && lexemas.get(j+3)[0].equals(";")) {
                        
                        variables.get(i)[4] = lexemas.get(j+2)[0];
                        
                    }

                }

            }

        }
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("ID");
        
        modelo.addColumn("VARIABLE");
        
        modelo.addColumn("TIPO");
        
        modelo.addColumn("LONGITUD");
        
        modelo.addColumn("DATO");
        
        String[] campos = new String[5];
        
        campos[0] = "ID";
        
        campos[1] = "VARIABLE";
        
        campos[2] = "TIPO";
        
        campos[3] = "LONGITUD";
        
        campos[4] = "DATO";
        
        modelo.addRow(campos);
        
        for(int i=0; i<variables.size(); i++) {
            
            String[] fila = new String[5];
            
            fila[0] = variables.get(i)[0];
            
            fila[1] = variables.get(i)[1];
            
            fila[2] = variables.get(i)[2];
            
            fila[3] = variables.get(i)[3];
            
            fila[4] = variables.get(i)[4];
            
            modelo.addRow(fila);
            
        }
        
        Marco.jPanel4.removeAll();
        
        Marco.jPanel4.add(new JTable(modelo));
        
        Marco.jPanel4.updateUI();
        
    }
    
}
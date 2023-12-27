
package compararexcel;

import java.util.*;

public class Comparar {
    
    Comparar(ArchivoTexto texto, ArchivoExcel excel, int ri, int rf, int c1, int c2, int c3) {
        
        this.texto = texto;
        this.excel = excel;
        this.ri = ri; this.rf = rf;
        this.c1 = c1; this.c2 = c2; this.c3 = c3;
    }
    
    public void mostrarFaltantesEnExcel() {
        
        int x = 1;
        
        for(int i=ri; i<=rf; i++) {
            
            String e = excel.getText(i, c1) + " " + excel.getText(i, c2) + " " + excel.getText(i, c3);
            //System.out.println(e);
            
            for(int j=0; j<texto.getRowsSize(); j++) {
                
                String t = texto.getText(j, 0) + " " + texto.getText(j, 1) + " " + texto.getText(j, 2);
                //System.out.println(t);
                
                if(e.equalsIgnoreCase(t)) {
                    
                    break;
                }
                
                if(j == (texto.getRowsSize()-1)) {
                    
                    System.out.println(x + ". " + e);
                    x++;
                }
            }
        }
    }
    
    public void mostrarIncorrectos() {
        
        int x = 1;
        
        for(int i=ri; i<=rf; i++) {
            
            String e = excel.getText(i, c1) + " " + excel.getText(i, c2) + " " + excel.getText(i, c3);
            
            for(int j=0; j<texto.getLinesSize(); j++) {
                
                String t = texto.getLine(j);
                
                if(e.equalsIgnoreCase(t)) {
                    
                    //System.out.println(x + ". " + e);
                    //System.out.println(x + ". " + t);
                    
                    break;
                    
                }
                
                if(j == (texto.getLinesSize()-1)) {
                    
                    System.out.println(x + ". " + e);
                    x++;
                }
            }
            
        }
    }
    
    private ArchivoTexto texto;
    private ArchivoExcel excel;
    int ri, rf, c1, c2, c3;
}

package compararexcel;

import java.util.ArrayList;

public class CompararExcel {

    public static void main(String[] args) {
        
        try {
            
            ArchivoTexto texto = new ArchivoTexto("C:\\Users\\joqle\\Downloads\\FINAL\\Control.txt", 1);
            ArchivoExcel excel = new ArchivoExcel("C:\\Users\\joqle\\Downloads\\FINAL\\bd alumnos 141021.xlsx", 1);
            
            Comparar c = new Comparar(texto, excel, 1, 298, 9, 10, 8);
            c.mostrarFaltantesEnExcel();
            
        } catch(Exception e) {
            
            e.printStackTrace();
        }
    }
}
package cuadrodialogo;

import javax.swing.*;

public class CuadroDialogo {

    public static void main(String[] args) {
        
        JComboBox combo = new JComboBox();
        
        combo.addItem("Hombre");
        
        combo.addItem("Mujer");
        
        String opciones[] = {"OK", "Cancelar"};
        
        int opcion = JOptionPane.showOptionDialog(null, combo, "Elija su sexo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        
        //System.out.println("" + opcion);
        
        if(opcion == 0) {
            
            if(combo.getSelectedItem().equals("Hombre")) {
                
                System.out.println("Eres: hombre");
                
            } else {
                
                System.out.println("Eres: mujer");
                
            }
            
        }
        
    }
    
}

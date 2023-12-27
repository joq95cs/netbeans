package analizadorlexico;

import java.io.*;

import jflex.*;

import javax.swing.*;

public class AnalizadorLexico {

    public static void main(String[] args) {
        
        if(JOptionPane.showConfirmDialog(null, "¿Generar código?", "Elija una opción", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            
            Main.generate(new File("src/analizadorlexico/Lexer.flex"));
            
        }
        
        new Marco().setVisible(true);
        
    }
    
}
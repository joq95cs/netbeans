package so2_t1;

import javax.swing.*;

public class Metodos {
    
    public void llenarArreglo(JTextField[][] array) { //Metodo que pide el arreglo para trabar
        
        for(int i=0; i<10; i++) {
            
            for(int j=0; j<5; j++) {
                
                array[i][j].setText(String.valueOf((int)(Math.random()*100))); //Coloca un número aleatorio entre 0 y 100 en cada JTextField
                
            }
            
        }
        
    }
    
    public void contar(JTextField[][] array, JTextField[] filas, JTextField[] columnas) {
        
        int cantidadFila = 0;
        
        for(int i=0; i<10; i++) {
            
            for(int j=0; j<5; j++) {
                
                if(Integer.parseInt(array[i][j].getText()) == 0) {
                    
                    cantidadFila++; //Se aumenta la variable en 1 si el JTextField tiene un 0
                    
                }
                
            }
            
            filas[i].setText(String.valueOf(cantidadFila)); //Se le pone la cantidad al JTextField correspondiente
            
            cantidadFila = 0; //Se reinicia para contar en una nueva fila
            
        }
        
        int cantidadColumnas = 0;
        
        for(int j=0; j<5; j++) {
            
            for(int i=0; i<10; i++) {
                
                if(Integer.parseInt(array[i][j].getText()) == 0) {
                    
                    cantidadColumnas++;
                    
                }
                
            }
            
            columnas[j].setText(String.valueOf(cantidadColumnas));
            
            cantidadColumnas = 0;
            
        }
        
    }
    
}
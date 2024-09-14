package a2_t1_castellanosjoqsan;

import java.util.Scanner;

public class Numeros {
    
    public Numeros() {
        
        entrada = new Scanner(System.in);
        
    }
    
    public void iniciarArregloNumeros(int n) {
        
        arreglo_numeros = new int[n];
        
    }
    
    public void setArregloNumeros() {
        
        for(int i=0; i<arreglo_numeros.length; i++) {
            
            do {
                
                try {
                
                    System.out.print("Ingres valor de la posición [" + i + "]: ");
            
                    arreglo_numeros[i] = entrada.nextInt();
                
                    break;
                
                } catch(Exception e) {
                    
                    entrada = new Scanner(System.in);
                
                }
                
            } while(true);
            
        }
        
    }
    
    public int[] getArregloNumeros() {
        
        return arreglo_numeros;
        
    }
    
    private int[] arreglo_numeros;
    
    private Scanner entrada;
    
}
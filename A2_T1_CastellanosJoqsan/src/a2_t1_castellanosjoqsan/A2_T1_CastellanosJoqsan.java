package a2_t1_castellanosjoqsan;

import java.util.Scanner;

import java.util.ArrayList;

public class A2_T1_CastellanosJoqsan {
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        Numeros objeto_1 = new Numeros();
        
        do {
            
            try {
                
                System.out.print("Ingresa cantidad de posiciones para el arreglo del objeto 1: ");
            
                objeto_1.iniciarArregloNumeros(entrada.nextInt());
            
                break;
            
            } catch(Exception e) {
                
                entrada = new Scanner(System.in);
                
            }
            
        } while(true);
        
        System.out.println();
        
        objeto_1.setArregloNumeros();
        
        System.out.println();
        
        Numeros objeto_2 = new Numeros();
        
        int n;
        
        do {
            
            try {
                
                System.out.print("Ingresa cantidad de posiciones del arreglo del objeto 1: ");
                
                n = entrada.nextInt();
                
                break;
            
            } catch(Exception e) {
                
                entrada = new Scanner(System.in);
                
            }
            
        } while(true);
        
        do {
            
            try {
                
                if(n > objeto_1.getArregloNumeros().length) {
                
                System.out.print("Ingresa un número menor: ");
                
                n = entrada.nextInt();
                
                } else if(n < objeto_1.getArregloNumeros().length) {
                
                System.out.print("Ingresa un número mayor: ");
                
                n = entrada.nextInt();
                
                } else {
                
                objeto_2.iniciarArregloNumeros(n);
                
                System.out.println();
                
                objeto_2.setArregloNumeros();
                
                break;
                
                }
                
            } catch(Exception e) {
                
                entrada = new Scanner(System.in);
                
            }
            
        } while(true);
        
        System.out.print("\nARREGLO DE OBJETO 1: ");
        
        for(int i = 0; i<objeto_1.getArregloNumeros().length; i++) {
            
            System.out.print("[" + objeto_1.getArregloNumeros()[i] + "]");
            
        }
        
        System.out.print("\nARREGLO DE OBJETO 2: ");
        
        for(int i = 0; i<objeto_2.getArregloNumeros().length; i++) {
            
            System.out.print("[" + objeto_2.getArregloNumeros()[i] + "]");
            
        }
        
        ArrayList <Integer> arreglo_final= new ArrayList <Integer> ();
        
        for(int i=0; i<objeto_1.getArregloNumeros().length; i++) {
            
            for(int j=0; j<objeto_2.getArregloNumeros().length; j++) {
                
                if(objeto_1.getArregloNumeros()[i] == objeto_2.getArregloNumeros()[j]) {
                    
                    arreglo_final.add(objeto_1.getArregloNumeros()[i]);
                    
                }
                
            }
            
        }
        
        System.out.print("\nVALORES EN AMBOS ARREGLOS: ");
        
        for(int i=0; i<arreglo_final.size(); i++) {
            
            System.out.print("[" + arreglo_final.get(i) + "]");
            
        }
        
        System.out.println();
        
    }
    
}
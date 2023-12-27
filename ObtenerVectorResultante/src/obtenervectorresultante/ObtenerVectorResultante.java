package obtenervectorresultante;

import java.util.*;

public class ObtenerVectorResultante {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("1) Rotación\n2) Traslación\n3) Escalado\n4) Todos\n\nElija una opción: ");
        
        int opcion = 0;
        
        do {
            
            try {
                
                opcion = entrada.nextInt();
                
                if(opcion==1 || opcion==2 || opcion==3 || opcion==4) break;
                
                else throw new Exception();
                
            } catch(Exception e) {
                
                entrada = new Scanner(System.in);
                
                System.out.print("Elija una opción: ");
                
            }   
            
        } while(true);
        
        System.out.println();
        
        int n = 0;
        
        do {
            
            try {
            
                System.out.print("Ingrese cantidad de vértices: ");
        
                n = entrada.nextInt();
                
                break;
            
            } catch(InputMismatchException e) {
            
                entrada = new Scanner(System.in);
            
            }
            
        } while(true);
        
        Vertice[] vertices = new Vertice[n];
        
        Vertice[] resultantes = new Vertice[n];
        
        System.out.println();
        
        for(int i=0; i<n; i++) {
            
            do {
                
                try {
                    
                    System.out.print("Ingrese vértice " + (i+1) + " (x y z): ");
            
                    vertices[i] = new Vertice(entrada.nextDouble(), entrada.nextDouble(), entrada.nextDouble());
                    
                    break;
                    
                } catch(InputMismatchException e) {
                    
                    entrada = new Scanner(System.in);
                    
                } 
                
            } while(true);
            
        }
        
        double x=0, y=0, z=0;
        
        switch(opcion) {
            
            case 1:
                
                Vertice.iniciarMatrizRotacion();
        
                for(int i=0; i<n; i++) {
            
                    x = vertices[i].getX()*Vertice.getMatrizRotacion()[0][0] + vertices[i].getY()*Vertice.getMatrizRotacion()[0][1] + vertices[i].getZ()*Vertice.getMatrizRotacion()[0][2];
            
                    y = vertices[i].getX()*Vertice.getMatrizRotacion()[1][0] + vertices[i].getY()*Vertice.getMatrizRotacion()[1][1] + vertices[i].getZ()*Vertice.getMatrizRotacion()[1][2];
            
                    z = vertices[i].getX()*Vertice.getMatrizRotacion()[2][0] + vertices[i].getY()*Vertice.getMatrizRotacion()[2][1] + vertices[i].getZ()*Vertice.getMatrizRotacion()[2][2];
            
                    resultantes[i] = new Vertice(x, y, z);
            
                }
        
                System.out.println();
        
                for(int i=0; i<n; i++) {
            
                    System.out.println("VR " +(i+1) + ": (" + resultantes[i].getX() + ", " + resultantes[i].getY() + ", " + resultantes[i].getZ() + ")");
            
                }
                
                break;
                
            case 2:
                
                for(int i=0; i<n; i++) {
                    
                    Vertice.iniciarMatrizTraslacion(vertices[i].getX(), vertices[i].getY());
                    
                    x = vertices[i].getX()*Vertice.getMatrizTraslacion()[0][0] + vertices[i].getY()*Vertice.getMatrizTraslacion()[0][1] + vertices[i].getZ()*Vertice.getMatrizTraslacion()[0][2];
            
                    y = vertices[i].getX()*Vertice.getMatrizTraslacion()[1][0] + vertices[i].getY()*Vertice.getMatrizTraslacion()[1][1] + vertices[i].getZ()*Vertice.getMatrizTraslacion()[1][2];
            
                    z = vertices[i].getX()*Vertice.getMatrizTraslacion()[2][0] + vertices[i].getY()*Vertice.getMatrizTraslacion()[2][1] + vertices[i].getZ()*Vertice.getMatrizTraslacion()[2][2];
                    
                    resultantes[i] = new Vertice(x, y, z);
                    
                }
                
                System.out.println();
        
                for(int i=0; i<n; i++) {
            
                    System.out.println("VR " +(i+1) + ": (" + resultantes[i].getX() + ", " + resultantes[i].getY() + ", " + resultantes[i].getZ() + ")");
            
                }
                
                break;
                
            case 3:
                
                for(int i=0; i<n; i++) {
                    
                    Vertice.iniciarMatrizEscalado(vertices[i].getX(), vertices[i].getY());
                    
                    x = vertices[i].getX()*Vertice.getMatrizEscalado()[0][0] + vertices[i].getY()*Vertice.getMatrizEscalado()[0][1] + vertices[i].getZ()*Vertice.getMatrizEscalado()[0][2];
            
                    y = vertices[i].getX()*Vertice.getMatrizEscalado()[1][0] + vertices[i].getY()*Vertice.getMatrizEscalado()[1][1] + vertices[i].getZ()*Vertice.getMatrizEscalado()[1][2];
            
                    z = vertices[i].getX()*Vertice.getMatrizEscalado()[2][0] + vertices[i].getY()*Vertice.getMatrizEscalado()[2][1] + vertices[i].getZ()*Vertice.getMatrizEscalado()[2][2];
                    
                    resultantes[i] = new Vertice(x, y, z);
                    
                }
                
                System.out.println();
        
                for(int i=0; i<n; i++) {
            
                    System.out.println("VR " +(i+1) + ": (" + resultantes[i].getX() + ", " + resultantes[i].getY() + ", " + resultantes[i].getZ() + ")");
            
                }
                
                break;
                
            case 4:
                
                Vertice.iniciarMatrizRotacion();
        
                for(int i=0; i<n; i++) {
            
                    x = vertices[i].getX()*Vertice.getMatrizRotacion()[0][0] + vertices[i].getY()*Vertice.getMatrizRotacion()[0][1] + vertices[i].getZ()*Vertice.getMatrizRotacion()[0][2];
            
                    y = vertices[i].getX()*Vertice.getMatrizRotacion()[1][0] + vertices[i].getY()*Vertice.getMatrizRotacion()[1][1] + vertices[i].getZ()*Vertice.getMatrizRotacion()[1][2];
            
                    z = vertices[i].getX()*Vertice.getMatrizRotacion()[2][0] + vertices[i].getY()*Vertice.getMatrizRotacion()[2][1] + vertices[i].getZ()*Vertice.getMatrizRotacion()[2][2];
            
                    resultantes[i] = new Vertice(x, y, z);
            
                }
        
                System.out.println("\nROTACIÓN\n");
        
                for(int i=0; i<n; i++) {
            
                    System.out.println("VR " +(i+1) + ": (" + resultantes[i].getX() + ", " + resultantes[i].getY() + ", " + resultantes[i].getZ() + ")");
            
                }
                
                for(int i=0; i<n; i++) {
                    
                    Vertice.iniciarMatrizTraslacion(vertices[i].getX(), vertices[i].getY());
                    
                    x = vertices[i].getX()*Vertice.getMatrizTraslacion()[0][0] + vertices[i].getY()*Vertice.getMatrizTraslacion()[0][1] + vertices[i].getZ()*Vertice.getMatrizTraslacion()[0][2];
            
                    y = vertices[i].getX()*Vertice.getMatrizTraslacion()[1][0] + vertices[i].getY()*Vertice.getMatrizTraslacion()[1][1] + vertices[i].getZ()*Vertice.getMatrizTraslacion()[1][2];
            
                    z = vertices[i].getX()*Vertice.getMatrizTraslacion()[2][0] + vertices[i].getY()*Vertice.getMatrizTraslacion()[2][1] + vertices[i].getZ()*Vertice.getMatrizTraslacion()[2][2];
                    
                    resultantes[i] = new Vertice(x, y, z);
                    
                }
                
                System.out.println("\nTRASLACIÓN\n");
        
                for(int i=0; i<n; i++) {
            
                    System.out.println("VR " +(i+1) + ": (" + resultantes[i].getX() + ", " + resultantes[i].getY() + ", " + resultantes[i].getZ() + ")");
            
                }
                
                for(int i=0; i<n; i++) {
                    
                    Vertice.iniciarMatrizEscalado(vertices[i].getX(), vertices[i].getY());
                    
                    x = vertices[i].getX()*Vertice.getMatrizEscalado()[0][0] + vertices[i].getY()*Vertice.getMatrizEscalado()[0][1] + vertices[i].getZ()*Vertice.getMatrizEscalado()[0][2];
            
                    y = vertices[i].getX()*Vertice.getMatrizEscalado()[1][0] + vertices[i].getY()*Vertice.getMatrizEscalado()[1][1] + vertices[i].getZ()*Vertice.getMatrizEscalado()[1][2];
            
                    z = vertices[i].getX()*Vertice.getMatrizEscalado()[2][0] + vertices[i].getY()*Vertice.getMatrizEscalado()[2][1] + vertices[i].getZ()*Vertice.getMatrizEscalado()[2][2];
                    
                    resultantes[i] = new Vertice(x, y, z);
                    
                }
                
                System.out.println("\nESCALADO\n");
        
                for(int i=0; i<n; i++) {
            
                    System.out.println("VR " +(i+1) + ": (" + resultantes[i].getX() + ", " + resultantes[i].getY() + ", " + resultantes[i].getZ() + ")");
            
                }
            
        }
        
    }
    
}
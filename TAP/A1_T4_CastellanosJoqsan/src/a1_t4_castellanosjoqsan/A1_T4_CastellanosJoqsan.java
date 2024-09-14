package a1_t4_castellanosjoqsan;

import java.io.*;

public class A1_T4_CastellanosJoqsan {

    public static void main(String[] args) {
        
        File carpeta = new File("src/Registro/");
        
        if(!carpeta.exists()) {
            
            carpeta.mkdir();
            
        }
        
        m = new Marco();
        
        m.setVisible(true);
        
    }
    
    public static Marco m;
    
}
package cesar;

import com.sun.glass.events.KeyEvent;

public class Metodos {
    
    public static String encriptar(String texto) {
        
        if(texto.isEmpty()) {
            
            return "";
            
        }
        
        String resultado = "";
        
        for(int i=0; i<texto.length(); i++) {
            
            if(texto.charAt(i) == KeyEvent.VK_SPACE) {
                
                resultado += " ";
                
                continue;
                
            } else if(!esLetra(texto.charAt(i))) {
                
                resultado += texto.charAt(i);
                
                continue;
                
            }
            
            resultado += encriptaLetra(texto.charAt(i));
            
        }
        
        return resultado;
        
    }
    
    public static String desencriptar(String texto) {
        
        if(texto.isEmpty()) {
            
            return "";
            
        }
        
        String resultado = "";
        
        for(int i=0; i<texto.length(); i++) {
            
            if(texto.charAt(i) == KeyEvent.VK_SPACE) {
                
                resultado += " ";
                
                continue;
                
            } else if(!esLetra(texto.charAt(i))) {
                
                resultado += texto.charAt(i);
                
                continue;
                
            }
            
            resultado += desencriptaLetra(texto.charAt(i));
            
        }
        
        return resultado;
        
    }
    
    private static char encriptaLetra(char letra) {
        
        char nuevaLetra = 0;
        
        if(esMayuscula(letra)) {
            
            switch(letra) {
                
                case 'X':
                    
                    return 'A';
                    
                case 'Y':
                    
                    return 'B';
                    
                case 'Z':
                    
                    return 'C';
                
            }
            
            int x = 0;
            
            for(int i=0; i<mayusculas.length; i++) {
                
                if(letra == mayusculas[i]) {
                    
                    x = i;
                    
                    break;
                    
                }
                
            }
            
            nuevaLetra = mayusculas[x+3];
            
        } else {
            
            switch(letra) {
                
                case 'x':
                    
                    return 'a';
                    
                case 'y':
                    
                    return 'b';
                    
                case 'z':
                    
                    return 'c';
                
            }
            
            int x = 0;
            
            for(int i=0; i<minusculas.length; i++) {
                
                if(letra == minusculas[i]) {
                    
                    x = i;
                    
                    break;
                    
                }
                
            }
            
            nuevaLetra = minusculas[x+3];
            
        }
        
        return nuevaLetra;
        
    }
    
    private static char desencriptaLetra(char letra) {
        
        char nuevaLetra = 0;
        
        if(esMayuscula(letra)) {
            
            switch(letra) {
                
                case 'A':
                    
                    return 'X';
                    
                case 'B':
                    
                    return 'Y';
                    
                case 'C':
                    
                    return 'Z';
                
            }
            
            int x = 0;
            
            for(int i=0; i<mayusculas.length; i++) {
                
                if(letra == mayusculas[i]) {
                    
                    x = i;
                    
                    break;
                    
                }
                
            }
            
            nuevaLetra = mayusculas[x-3];
            
        } else {
            
            switch(letra) {
                
                case 'a':
                    
                    return 'x';
                    
                case 'b':
                    
                    return 'y';
                    
                case 'c':
                    
                    return 'z';
                
            }
            
            int x = 0;
            
            for(int i=0; i<minusculas.length; i++) {
                
                if(letra == minusculas[i]) {
                    
                    x = i;
                    
                    break;
                    
                }
                
            }
            
            nuevaLetra = minusculas[x-3];
            
        }
        
        return nuevaLetra;
        
    }
    
    private static boolean esMayuscula(char letra) {
        
        for(char e: mayusculas) {
            
            if(letra == e) {
                
                return true;
                
            }
            
        }
        
        return false;
        
    }
    
    private static boolean esLetra(char letra) {
        
        for(char e: mayusculas) {
            
            if(e == letra) {
                
                return true;
                
            }
            
        }
        
        for(char e: minusculas) {
            
            if(e == letra) {
                
                return true;
                
            } 
            
        }
        
        return false;
        
    }
    
    private static char[] mayusculas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
    'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    
    private static char[] minusculas = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
    'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    
}
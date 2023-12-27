package cadenasjoqsan;

public class CadenasJoqsan {   
    
    public int getLongitud(String c) {
        
        return c.length();
        
    }
    
    public String getBusqueda(String c1, String c2) {
        
        if(c2.contains(c1)) return "La cadena 1 es subcadena de la cadena 2";
        
        else return "La cadena 1 no es subcadena de la cadena 2";
        
    }
    
    public String getComparacion(String c1, String c2) {
        
        if(c1.equals(c2)) {
            
            return "Las cadenas son iguales";
            
        } else {
            
            return "Las cadenas no son iguales";
            
        }
        
    }
    
    public String getMayusculas(String c) {
        
        return c.toUpperCase();
        
    }
    
    public String getMinusculas(String c) {
        
        return c.toLowerCase();
        
    }
    
}
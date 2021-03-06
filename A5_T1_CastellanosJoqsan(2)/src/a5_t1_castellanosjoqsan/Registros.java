package a5_t1_castellanosjoqsan;

import mi_arraylist.*;

public class Registros {
    
    public static void setVideojuego(Videojuego vd) {
        
        videojuegos.add(vd);
        
    }
    
    public static String getInformacionFinal(int noID) {
        
        Mi_ArrayList <Object> informacionObtenida = new Mi_ArrayList <Object> ();
        
        for(int i=0; i<videojuegos.size(); i++) {
            
            if((Integer)videojuegos.get(i).getInformacionVideojuego().get(0) == noID) {
                
                informacionObtenida = videojuegos.get(i).getInformacionVideojuego();
                
                break;
                
            }
            
        }
        
        String informacionFinal = "ID: " + informacionObtenida.get(0) + "\nNombre: " + informacionObtenida.get(1) +
                           "\nDescripción: " + informacionObtenida.get(2) + "\nExistencia: " + informacionObtenida.get(3) +
                           "\nPrecio: " + informacionObtenida.get(4) + "\nCategoría: " + informacionObtenida.get(5);
        
        return informacionFinal;
        
    }
    
    public static boolean registroVacio() {
        
        return videojuegos.isEmpty();
        
    }
    
    public static boolean videojuegoExistente(int noID) {
        
        for(int i=0; i<videojuegos.size(); i++) {
            
            if(videojuegos.get(i).getNoID() == noID) {
                
                return true;
                
            }
            
        }
        
        return false;
        
    }
    
    private static Mi_ArrayList<Videojuego> videojuegos = new Mi_ArrayList<Videojuego>();
    
}
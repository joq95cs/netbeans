package a5_t1_castellanosjoqsan;

import mi_arraylist.*;

public class Videojuego {
    
    public void setInformacionVideojuego(int noID, String nombre, String descripcion, int existencia, double precio, String categoria) {
        
        this.noID = noID;
        
        this.nombre = nombre;
        
        this.descripcion = descripcion;
        
        this.existencia = existencia;
        
        this.precio = precio;
        
        this.categoria = categoria;
        
    }
    
    public Mi_ArrayList<Object> getInformacionVideojuego() {
        
        Mi_ArrayList<Object> informacion = new Mi_ArrayList<Object>();
        
        informacion.add(noID);
        
        informacion.add(nombre);
        
        informacion.add(descripcion);
        
        informacion.add(existencia);
        
        informacion.add(precio);
        
        informacion.add(categoria);
        
        return informacion;
        
    }
    
    public int getNoID() {
        
        return noID;
        
    }
    
    private String nombre, descripcion, categoria;
    
    private int noID, existencia;
    
    private double precio;
    
}
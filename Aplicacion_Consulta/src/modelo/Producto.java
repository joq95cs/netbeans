package modelo;

public class Producto {
    
    public Producto() {
        
        nArticulo = "";
        
        seccion = "";
        
        precio = "";
        
        pOrigen = "";
        
    }
    
    public void setNArticulo(String nArticulo) {
        
        this.nArticulo = nArticulo;
        
    }
    
    public String getNArticulo() {
        
        return nArticulo;
        
    }
    
    public void setSeccion(String seccion) {
        
        this.seccion = seccion;
        
    }
    
    public String getSeccion() {
        
        return seccion;
        
    }
    
    public void setPrecio(String precio) {
        
        this.precio = precio;
        
    }
    
    public String getPrecio() {
        
        return precio;
        
    }
    
    public void setPOrigen(String pOrigen) {
        
        this.pOrigen = pOrigen;
        
    }
    
    public String getPOrigen() {
        
        return pOrigen;
        
    }
    
    private String nArticulo, seccion, precio, pOrigen;
    
}

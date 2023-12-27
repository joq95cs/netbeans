package escuela;

public class Alumno extends Persona {
    
    public Alumno(int id, String nombre, String apellido, String correo) {
        
        super(id, nombre, apellido, correo);
        calificacion = 0;
        
    }
    
    public void guardarCalificacion(double calificacion) {
        
        this.calificacion = calificacion;
        
    }
    
    public double getCalificacion() {
        
        return calificacion;
        
    }
    
    protected double calificacion;
    
}

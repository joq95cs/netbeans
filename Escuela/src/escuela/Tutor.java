package escuela;

public class Tutor extends Maestro {
    
    public Tutor(int id, String nombre, String apellido, String correo, String alumno) {
        
        super(id, nombre, apellido, correo);
        
        
    }
    
    public void setAlumno(Alumno a) {
        
        this.a = a;
        
    }
    
        public String getNombreAlumno() {
        
        return a.nombre;
        
    }
    
    public void mostrarCalificacion() {
        
        System.out.println("Calificación del alumno: " + a.calificacion);
        
    }
    
    private Alumno a;
    
}

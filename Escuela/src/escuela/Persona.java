package escuela;

public class Persona {
    
    public Persona(int id, String nombre, String apellido, String correo) {
        
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        
    }
    
    public void imprimirPerfil() {
        
        System.out.println("\n---DATOS---\n\n" + "ID: " + id + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nCorreo: " + correo);
        
    }
    
    protected int id;
    protected String nombre;
    protected String apellido;
    protected String correo;
    
}


package proyectofinal; //Paquete donde se encuentra la clase Persona

import java.time.LocalDate; //Se importa el paquete para manejar fechas


public abstract class Persona { //Clase padre Persona
    
    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, String genero, int edad, LocalDate fechaNacimiento) {
        
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.genero = genero;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    //MÉTODOS SETTERS PARA FIJAR NUEVOS VALORES A LOS ATRIBUTOS
    public void setNombre(String nombre) { //Recibe valor
        
        this.nombre = nombre; //Fija valor recibido en la propiedad de la clase
    }
    
    public void setApellidoPaterno(String apellidoPaterno) { //Recibe valor
        
        this.apellidoPaterno = apellidoPaterno; //Fija valor recibido en la propiedad de la clase
    }
    
    public void setApellidoMaterno(String apellidoMaterno) { //Recibe valor
        
        this.apellidoMaterno = apellidoMaterno; //Fija valor recibido en la propiedad de la clase
    }
    
    
    public void setGenero(String genero) { //Recibe valor
        
        this.genero = genero; //Fija valor recibido en la propiedad de la clase
    }
    
    public void setEdad(int edad) { //Recibe valor
        
        this.edad = edad; //Fija valor recibido en la propiedad de la clase
    }
    
    public void setFechaNacimiento(int agno, int mes, int dia) { //Recibe valor
        
        this.fechaNacimiento = LocalDate.of(agno, mes, dia); //Fija valor recibido en la propiedad de la clase
    }
    
    //MÉTODOS GETTERS PARA OBTENER LOS VALORES DE LOS ATRIBUTOS
    public String getNombre() {
        
        return nombre; //Regresa valor de la propiedad de la clase
    }
    
    public String getApellidoMaterno() {
        
        return apellidoMaterno; //Regresa valor de la propiedad de la clase
    }
    
    public String getApellidoPaterno() {
        
        return apellidoPaterno; //Regresa valor de la propiedad de la clase
    }
    
    public String getGenero() {
        
        return genero; //Regresa valor de la propiedad de la clase
    }
    
    public int getEdad() {
        
        return edad; //Regresa valor de la propiedad de la clase
    }
    
    public LocalDate getFechaNacimiento() {
        
        return fechaNacimiento; //Regresa valor de la propiedad de la clase
    }
    
    public String getDatos() {
        
        return "Nombre: " + nombre + "\n"
             + "Apellidos: " + apellidoPaterno + " " + apellidoMaterno + "\n"
             + "Genero: " + genero + "\n"
             + "Edad: " + genero + "\n"
             + "Fecha de nacimiento: " + fechaNacimiento.getDayOfMonth() + "-" + fechaNacimiento.getMonthValue() + "-" + fechaNacimiento.getYear();
    }
    
    //MÉTODOS ABSTRACTOS
    public abstract String getFichaDatos(); //Este método será sobreescrito y definido por las clases hijas con sus datos propios
    
    public abstract void darDeAlta(); //Método para dar de alta y completar los atributos faltantes en las clases hijas
    
    //ATRIBUTOS DE LA CLASE
    //Se declaran ocho atributos encapsulados con el modificador protected para que sean visibles desde las clases hijas
    protected String nombre;
    protected String apellidoMaterno;
    protected String apellidoPaterno;
    protected String genero;
    protected int edad;
    protected LocalDate fechaNacimiento; //Se usa el tipo de dato LocalDate para fijar la fecha
}
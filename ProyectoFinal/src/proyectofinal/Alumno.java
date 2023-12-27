
package proyectofinal; //Paquete donde se encuentra la clase Persona

import java.time.LocalDate;
import java.util.Scanner; //Importaciones de clases necesarias

public class Alumno extends Persona { //Declaración de clase Alumno que hereda de clase Persona
    
    public Alumno(String nombre, String apellidoPaterno, String apellidoMaterno, String genero, int edad, LocalDate fechaNacimiento) { //Declaración de constructor de clase
    //El constructor pide los valores que solicita el constructor de la clase padre
        
        super(nombre, apellidoPaterno, apellidoMaterno, genero, edad, fechaNacimiento); //Se llama al constructor de la clase padre y se le pasan los valores
    }
    
    //SETTERS Y GETTERS
    
    public void setCarrera(String carrera) {
        
        this.carrera = carrera;
    }
    
    public void setSemestre(int semestre) {
        
        this.semestre = semestre;
    }
    
    public String getCarrera() {
        
        return carrera;
    }
    
    public int getSemestre() {
        
        return semestre;
    }

    @Override
    public String getFichaDatos() { //Método sobreescrito para los datos propios de la clase
        
        return "-----FICHA DE DATOS DE ALUMNO-----\n"
             + super.getDatos() + "\n"
             + "Carrera: " + carrera + "\n"
             + "Semestre: " + semestre;
    }

    @Override
    public void darDeAlta() { //Se define el método para dar de alta alumnos
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese la carrera: ");
        this.carrera = scanner.nextLine();
                
        System.out.print("Ingrese el semestre: ");
        this.semestre = scanner.nextInt();
        
        scanner.close();
        
        Main.alumnosRegistrados.add(this); //Se agrega el alumno al arreglo estático
        
        System.out.println("\nALUMNO AGREGADO CORRECTAMENTE");
    }
    
    //ATRIBUTOS DE LA CLASE
    private String carrera;
    private int semestre;
}

package proyectofinal; //Paquete donde se encuentra la clase Docente

import java.time.LocalDate; //Importaciones de clases necesarias
import java.util.ArrayList;
import java.util.Scanner;


public class Docente extends Persona {
    
    public Docente(String nombre, String apellidoPaterno, String apellidoMaterno, String genero, int edad, LocalDate fechaNacimiento) {
        
        super(nombre, apellidoPaterno, apellidoMaterno, genero, edad, fechaNacimiento);
        
        asignaturas = new ArrayList<String>();
    }
    
    //MÉTODOS PARA AGREGAR Y OBTENER LAS ASIGNATURAS DEL DOCENTE
    
    public void addAsignatura(String asignatura) {
        
        asignaturas.add(asignatura);
    }
    
    public String getAsignatura(int index) {
        
        return asignaturas.get(index);
    } 
    
    public String getAsignaturas() {
        
        String var = "";
        
        for(String each: asignaturas) {
            
            var += each + ", ";
        }
        
        return var;
    }

    @Override
    public String getFichaDatos() { //Método sobreescrito para los datos propios de la clase
        
        return "-----FICHA DE DATOS DE DOCENTE-----\n"
             + super.getDatos() + "\n"
             + "Asignaturas: " + getAsignaturas() + "\n";
    }

    @Override
    public void darDeAlta() { //Se sobreescribe el método para dar de alta un docente
       
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese asignatura: ");
        asignaturas.add(scanner.nextLine());
        
        scanner.close();
        
        Main.docentesRegistrados.add(this);
        
        System.out.println("\nDOCENTE AGREGADO CORRECTAMENTE");
    }
    
    //ATRIBUTOS DE CLASE
    private ArrayList<String> asignaturas;
}
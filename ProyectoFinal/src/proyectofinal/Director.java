
package proyectofinal; //Paquete donde se encuentra la clase Directora

import java.time.LocalDate; //Importaciones de clases necesarias
import java.util.Scanner;


public class Director extends Persona {
    
    public Director(String nombre, String apellidoPaterno, String apellidoMaterno, String genero, int edad, LocalDate fechaNacimiento) { //Declaración de constructor de clase
    //El constructor pide los valores que solicita el constructor de la clase padre
        
        super(nombre, apellidoPaterno, apellidoMaterno, genero, edad, fechaNacimiento); //Se llama al constructor de la clase padre y se le pasan los valores
    }
    
    public void setSueldo(double sueldo) {
        
        this.sueldo = sueldo;
    }
    
    public void setPlantel(String plantel) {
        
        this.plantel = plantel;
    }
    
    public double getSueldo() {
        
        return sueldo;
    }
    
    public String getPlantel() {
        
        return plantel;
    }

    @Override
    public String getFichaDatos() { //Método sobreescrito para los datos propios de la clase
        
       return "-----FICHA DE DATOS DE DIRECTOR-----\n"
             + super.getDatos() + "\n"
             + "Plantel: " + plantel + "\n"
             + "Sueldo: " + sueldo;
    }

    @Override
    public void darDeAlta() { //Se sobreescribe el método para dar de alta un director
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el plantel: ");
        this.plantel = scanner.nextLine();
                
        System.out.print("Ingrese el sueldo: ");
        this.sueldo = scanner.nextInt();
        
        scanner.close();
        
        Main.director = this; //Se agrega el alumno al arreglo estático
        
        System.out.println("\nDIRECTOR ACTUALIZADO CORRECTAMENTE");
    }


    public static void darDeBaja(Director director) {
        
        Main.director = null;
    }
    
    private double sueldo;
    private String plantel;
}

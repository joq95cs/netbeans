
package proyectofinal; //Paquete donde se encuentra la clase Coordinacion

import java.time.LocalDate; //Importaciones de clases necesarias
import java.util.Scanner;


public class Coordinacion extends Persona {
    
    public Coordinacion(String nombre, String apellidoPaterno, String apellidoMaterno, String genero, int edad, LocalDate fechaNacimiento) { //Declaración de constructor de clase
    //El constructor pide los valores que solicita el constructor de la clase padre
        
        super(nombre, apellidoPaterno, apellidoMaterno, genero, edad, fechaNacimiento); //Se llama al constructor de la clase padre y se le pasan los valores
    }
    
    //SETTERS Y GETTERS
    
    public void setEmail(String email) {
        
        this.email = email;
    }
    
    public void setTelefono(long telefono) {
        
        this.telefono = telefono;
    }
    
    public String getEmail() {
        
        return email;
    }
    
    public long getTelefono() {
        
        return telefono;
    }

    @Override
    public String getFichaDatos() { //Método sobreescrito para los datos propios de la clase
       
        return "-----FICHA DE DATOS DE COORDINADOR-----\n"
             + super.getDatos() + "\n"
             + "Email: " + email + "\n"
             + "Telefono: " + telefono;
    }

    @Override
    public void darDeAlta() { //Se sobreescribe el método para dar de alta un coordinador
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el email: ");
        this.email = scanner.nextLine();
                
        System.out.print("Ingrese el telefono: ");
        this.telefono = scanner.nextInt();
        
        scanner.close();
        
        Main.coordinadoresRegistrados.add(this);
        
        System.out.println("\nDIRECTOR ACTUALIZADO CORRECTAMENTE");
    }  

    //ATRIBUTOS PROPIOS DE LA CLASE, NO HEREDADOS
    String email;
    long telefono;
}

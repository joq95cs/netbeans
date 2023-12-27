package escuela;

import java.util.Scanner;

public class Escuela {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        System.out.print("1. Registrar alumno\n2. Registrar maestro\n3. Registrar tutor\n4. Salir\n\nOpción seleccionada: ");
        
        int opc = s.nextInt();
        
        if(opc == 4) {
            
            System.exit(0);
            
        } else {
            
            System.out.print("\nIngrese ID: ");
            int id = s.nextInt();
            
            System.out.print("Ingrese nombre: ");
            String nombre = s.next();
            
            System.out.print("Ingrese apellido: ");
            String apellido = s.next();
            
            System.out.print("Ingrese correo: ");
            String correo = s.next();
            
            if(opc == 1) {
            
                System.out.print("Ingrese calificación: ");
                double calificacion = s.nextDouble();

                Alumno a = new Alumno(id, nombre, apellido, correo);
                a.guardarCalificacion(calificacion);
                a.imprimirPerfil();

                System.out.println("Calificación: " + a.getCalificacion());  
            
            } else if(opc == 2) {

                Maestro m = new Maestro(id, nombre, apellido, correo);
                m.imprimirPerfil();

            } else {
                
                Tutor t = new Tutor(id, nombre, apellido, correo, correo);
                
                System.out.print("\n---DATOS DEL ALUMNO---\n\nIngrese ID: ");
                id = s.nextInt();
            
                System.out.print("Ingrese nombre: ");
                nombre = s.next();

                System.out.print("Ingrese apellido: ");
                apellido = s.next();

                System.out.print("Ingrese correo: ");
                correo = s.next();
                
                System.out.print("Ingrese calificación: ");
                double calificacion = s.nextDouble();
                
                Alumno a = new Alumno(id, nombre, apellido, correo);
                a.guardarCalificacion(calificacion);
                t.setAlumno(a);
                
                t.imprimirPerfil();
                System.out.println("Nombre del alumno: " + t.getNombreAlumno());
                t.mostrarCalificacion();
                
            }
            
        }

    }
    
}

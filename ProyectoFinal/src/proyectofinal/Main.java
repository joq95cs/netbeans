
package proyectofinal; //Paquete donde se encuentra la clase Main

//Zona de importaciones de clases necesarias
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Main { //Clase principal que contiene el método main

    public static void main(String[] args) { //Método estático main
        
        //Se definen valores para los arreglos de los alumnos, docentes, y coordinadores
        Main.alumnosRegistrados.add(new Alumno("Jonathan", "Bonilla", "Hernandez", "Hombre", 25, LocalDate.of(1996, 10, 14)));
        Main.alumnosRegistrados.add(new Alumno("Cristian", "Diaz", "Cambrano", "Hombre", 25, LocalDate.of(1996, 9, 14)));
        Main.alumnosRegistrados.add(new Alumno("Luis", "Navarro", "Salcido", "Hombre", 26, LocalDate.of(1995, 8, 9)));
        
        Main.docentesRegistrados.add(new Docente("Carlos", "Veron", "Gutierrez", "Hombre", 35, LocalDate.of(1985, 8, 9)));
        Main.docentesRegistrados.add(new Docente("Jose", "Delgado", "Mendoza", "Hombre", 30, LocalDate.of(1980, 11, 10)));
        
        Main.coordinadoresRegistrados.add(new Coordinacion("Ana", "Juarez", "Ortega", "Mujer", 40, LocalDate.of(1990, 8, 9)));
        Main.coordinadoresRegistrados.add(new Coordinacion("Diana", "Aguirre", "Estrada", "Mujer", 50, LocalDate.of(1970, 12, 12)));
        
        //Se define un único director
        Main.director = new Director("Patricia", "Rodriguez", "Gaspar", "Mujer", 35, LocalDate.of(1985, 8, 9));
        
        Scanner scanner = new Scanner(System.in); //Variable para hacer captura de datos por consola
        
        //MENÚ DEL PROGRAMA
        System.out.println("PROYECTO FINAL" + "\n");
        System.out.println("-----BIENVENIDO-----" + "\n");
        
        System.out.println("MENU PRINCIPAL");
        System.out.println("1. Dar de alta usuarios");
        System.out.println("2. Mostrar datos de usuarios");
        System.out.print("Seleccione una opcion: ");
        int op1 = scanner.nextInt(); //Se escanea y guarda la opción en la variable
        
        switch(op1) { //Se usa un switch para ir la opción elegida
            
            case 1: //Dar de alta
                
                //Variables temporales para guardar los datos para dar de alta
                String nombre = "";
                String apellidoPaterno = "";
                String apellidoMaterno = "";
                String genero = "";
                int edad = 0;
                int agno = 0;
                int mes = 0;
                int dia = 0;
                
                //MENU INTERIOR
                System.out.println("\nMENU DE ALTA DE USUARIOS");
                System.out.println("1. Dar de alta alumno");
                System.out.println("2. Dar de alta docente");
                System.out.println("3. Dar de alta director");
                System.out.println("4. Dar de alta coordinador");
                System.out.print("Seleccione una opcion: ");
                int op2 = scanner.nextInt(); //Se escanea la opción del menú de alta
                
                if(op2 == 1) { //Opción para dar de alta un alumno
                    
                    scanner = new Scanner(System.in); //Se reinicia el escáner para que no haya errores
                    
                    //Se capturan los datos generales de la clase Persona
                    System.out.print("\n-----DANDO DE ALTA NUEVO ALUMNO-----\n");
                    System.out.print("Ingrese nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese apellido paterno: ");
                    apellidoPaterno = scanner.nextLine();
                    System.out.print("Ingrese apellido materno: ");
                    apellidoMaterno = scanner.nextLine();
                    System.out.print("Ingrese genero: ");
                    genero = scanner.nextLine();
                    System.out.print("Ingrese edad: ");
                    edad = scanner.nextInt();
                    System.out.print("Ingrese dia de nacimiento: ");
                    dia = scanner.nextInt();
                    System.out.print("Ingrese mes de nacimiento: ");
                    mes = scanner.nextInt();
                    System.out.print("Ingrese agno de nacimiento: ");
                    agno = scanner.nextInt();
                   
                    //Se crea una variable para el nuevo alumno
                    Alumno alumnoNuevo = new Alumno(nombre, apellidoPaterno, apellidoMaterno, genero, edad, LocalDate.of(agno, mes, dia));
                    alumnoNuevo.darDeAlta(); //Termina de dar de alta el alumno con los valores que faltan
                    
                    System.out.println();
                    System.out.println(alumnoNuevo.getFichaDatos()); //Se muestra la ficha de los datos del alumno nuevo
                    
                } else if(op2 == 2) { //Dar de alta docente
                    
                    //Se repite el proceso de la opción anterior
                    scanner = new Scanner(System.in);
                    
                    System.out.print("\n-----DANDO DE ALTA NUEVO DOCENTE-----\n");
                    System.out.print("Ingrese nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese apellido paterno: ");
                    apellidoPaterno = scanner.nextLine();
                    System.out.print("Ingrese apellido materno: ");
                    apellidoMaterno = scanner.nextLine();
                    System.out.print("Ingrese genero: ");
                    genero = scanner.nextLine();
                    System.out.print("Ingrese edad: ");
                    edad = scanner.nextInt();
                    System.out.print("Ingrese dia de nacimiento: ");
                    dia = scanner.nextInt();
                    System.out.print("Ingrese mes de nacimiento: ");
                    mes = scanner.nextInt();
                    System.out.print("Ingrese agno de nacimiento: ");
                    agno = scanner.nextInt();
                   
                    Docente docenteNuevo = new Docente(nombre, apellidoPaterno, apellidoMaterno, genero, edad, LocalDate.of(agno, mes, dia));
                    docenteNuevo.darDeAlta(); //Se crea un objeto para el nuevo docente y se llama el método para terminar de dar de alta
                    
                    System.out.println();
                    System.out.println(docenteNuevo.getFichaDatos()); //Se imprime la ficha del docente agregado
                    
                } else if(op2 == 3) { //Opción para un director nuevo
                    
                    //Es el mismo proceso, pero se llama la clase para el director
                    scanner = new Scanner(System.in);
                    
                    System.out.print("\n-----DANDO DE ALTA NUEVO DIRECTOR-----\n");
                    System.out.print("Ingrese nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese apellido paterno: ");
                    apellidoPaterno = scanner.nextLine();
                    System.out.print("Ingrese apellido materno: ");
                    apellidoMaterno = scanner.nextLine();
                    System.out.print("Ingrese genero: ");
                    genero = scanner.nextLine();
                    System.out.print("Ingrese edad: ");
                    edad = scanner.nextInt();
                    System.out.print("Ingrese dia de nacimiento: ");
                    dia = scanner.nextInt();
                    System.out.print("Ingrese mes de nacimiento: ");
                    mes = scanner.nextInt();
                    System.out.print("Ingrese agno de nacimiento: ");
                    agno = scanner.nextInt();
                    
                    Director directorNuevo = new Director(nombre, apellidoPaterno, apellidoMaterno, genero, edad, LocalDate.of(agno, mes, dia));
                    directorNuevo.darDeAlta();
                    
                    System.out.println();
                    System.out.println(directorNuevo.getFichaDatos());
                    
                } else if(op2 == 4) {
                    
                    //Se repite el proceso, pero esta vez se llama a la clase para el nuevo coordinador
                    
                    scanner = new Scanner(System.in);
                    
                    System.out.print("\n-----DANDO DE ALTA NUEVO COORDINADOR-----\n");
                    System.out.print("Ingrese nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese apellido paterno: ");
                    apellidoPaterno = scanner.nextLine();
                    System.out.print("Ingrese apellido materno: ");
                    apellidoMaterno = scanner.nextLine();
                    System.out.print("Ingrese genero: ");
                    genero = scanner.nextLine();
                    System.out.print("Ingrese edad: ");
                    edad = scanner.nextInt();
                    System.out.print("Ingrese dia de nacimiento: ");
                    dia = scanner.nextInt();
                    System.out.print("Ingrese mes de nacimiento: ");
                    mes = scanner.nextInt();
                    System.out.print("Ingrese agno de nacimiento: ");
                    agno = scanner.nextInt();
                    
                    Coordinacion coordinadorNuevo = new Coordinacion(nombre, apellidoPaterno, apellidoMaterno, genero, edad, LocalDate.of(agno, mes, dia));
                    coordinadorNuevo.darDeAlta();
                    
                    System.out.println();
                    System.out.println(coordinadorNuevo.getFichaDatos());
                }
     
                break; //SE ROMPE EL CASO 1
                
            case 2: //Opción del menú principal para consultar los datos existentes en los arreglos
                
                //SEGUNDO MENÚ INTERIOR
                System.out.println("\nMENU DE CONSULTA DE DATOS");
                System.out.println("1. Consultar alumnos");
                System.out.println("2. Consultar docentes");
                System.out.println("3. Consultar director");
                System.out.println("4. Consultar coordinadores");
                System.out.print("Seleccione una opcion: ");
                int op3 = scanner.nextInt(); //Se guarda la opción del segundo menú interior
                
                if(op3 == 1) { //Muestra los alumnos existentes
                    
                    System.out.println("\nALUMNOS REGISTRADOS");
                    
                    for(Alumno each: Main.alumnosRegistrados) {
                        
                        System.out.println(each.nombre + " " + each.apellidoPaterno + " " + each.apellidoMaterno);
                    }
                    
                } else if(op3 == 2) { //Muestra los docentes existentes
                    
                    System.out.println("\nDOCENTES REGISTRADOS");
                    
                    for(Docente each: Main.docentesRegistrados) {
                        
                        System.out.println(each.nombre + " " + each.apellidoPaterno + " " + each.apellidoMaterno);
                    }

                } else if(op3 == 3) { //Muestra el director registrado, solo uno, si es nuevo se reemplaza
                    
                    System.out.println("\nDIRECTOR REGISTRADO");
                    
                    System.out.println(Main.director.nombre + " " + Main.director.apellidoPaterno + " " + Main.director.apellidoMaterno);
                
                } else if(op3 == 4) { //Muestra los coordinadores registrados
                    
                    System.out.println("\nCOORDINADORES REGISTRADOS");
                    
                    for(Coordinacion each: Main.coordinadoresRegistrados) {
                        
                        System.out.println(each.nombre + " " + each.apellidoPaterno + " " + each.apellidoMaterno);
                    }
                }
                
                break; //SE ROMPE EL CASO 1
        }
        
        scanner.close(); //Se cierra la variable para captura de datos
       
    }
    
    //CAMPOS ESTÁTICOS PARA LOS USUARIOS REGISTRADOS
    public static ArrayList<Alumno> alumnosRegistrados = new ArrayList<Alumno>(); //Array dinámico de los alumnos que se den de alta
    public static ArrayList<Docente> docentesRegistrados = new ArrayList<Docente>(); //Array dinámico de los docentes que se den de alta
    public static Director director = null;
    public static ArrayList<Coordinacion> coordinadoresRegistrados = new ArrayList<Coordinacion>();
}
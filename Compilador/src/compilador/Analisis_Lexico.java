package compilador;

import java.io.*;

import java.util.*;

import javax.swing.*;

import javax.swing.table.*;

public class Analisis_Lexico{
    
    public static void analizar(String ruta) throws Exception {
        
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        
        StringTokenizer st1 = null, st2 = null;
        
        while(br.ready()) {
            
            st1 = new StringTokenizer(br.readLine(), "\t");
            
            while(st1.hasMoreTokens()) {
                
                st2 = new StringTokenizer(st1.nextToken(), " ");
                
                while(st2.hasMoreTokens()) {
                    
                    cadenas.add(st2.nextToken());
                    
                }
                
            }
            
        }
        
        br.close();
        
        for(int i=0; i<cadenas.size(); i++) {
            
            if(!getTipo(cadenas.get(i)).equals("No definido")) {
                
                String[] array = {cadenas.get(i), getTipo(cadenas.get(i))};
                
                lexemas.add(array);
                
            } else {
                
                JOptionPane.showMessageDialog(null, "Error de compilación", "Error", 0);
                
                lexemas = new ArrayList<String[]>();
                
                break;
                
            }
            
        }
        
        if(!lexemas.isEmpty()) {
            
            Marco.jButton2.setEnabled(true);
            
            Marco.jButton3.setEnabled(true);
            
        }
        
    }
    
    public static void mostrarLexemas() {
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("LEXEMA");
        
        modelo.addColumn("COMPONENTE LÉXICO");
        
        String[] campos = new String[2];
        
        campos[0] = "LEXEMA";
        
        campos[1] = "COMPONENTE LÉXICO";
        
        modelo.addRow(campos);
        
        for(int i=0; i<lexemas.size(); i++) {
            
            String[] fila = new String[2];
            
            fila[0] = lexemas.get(i)[0];
            
            fila[1] = lexemas.get(i)[1];
            
            modelo.addRow(fila);
            
        }
        
        Marco.jPanel4.removeAll();
        
        Marco.jPanel4.add(new JTable(modelo));
        
        Marco.jPanel4.updateUI();
        
    }
    
    public static void mostrarTablaSimbolos() {
        
        ArrayList<String> var = new ArrayList<String>();
        
        for(int i=0; i<lexemas.size(); i++) {
            
            if(lexemas.get(i)[1].equals("Variable")) {
                
                var.add(lexemas.get(i)[0]);
                
            }
            
        }
        
        ArrayList<String> aux = new ArrayList<String>();
        
        for(int i=0; i<var.size(); i++) {
            
            if(!aux.contains(var.get(i))) {
                
                aux.add(var.get(i));
                
            }

        }
        
        String[] array = null;
        
        ArrayList<String[]> variables = new ArrayList<String[]>();
        
        for(int i=0; i<aux.size(); i++) {
            
            array = new String[5];
            
            array[0] = String.valueOf(i+1);
            
            array[1] = aux.get(i);
            
            variables.add(array);
            
        }
        
        Analisis_Sintactico.mostrarTablaSimbolos(variables, lexemas);
        
    }
    
    private static boolean esLetraMayuscula(char c) {
        
        return c == 'A' || c == 'B' || c == 'C' || c == 'D' || c == 'E' || c == 'F' 
                || c == 'G' || c == 'H' || c == 'I' || c == 'J' || c == 'K' || c == 'L'
                || c == 'M' || c == 'N' || c == 'Ñ' || c == 'O' || c == 'P' || c == 'Q' 
                || c == 'R' || c == 'S' || c == 'T' || c == 'U' || c == 'V' || c == 'W'
                || c == 'X' || c == 'Y' || c == 'Z';
        
    }
    
    private static boolean esLetraMinuscula(char c) {
        
        return c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e' || c == 'f' 
                || c == 'g' || c == 'h' || c == 'i' || c == 'j' || c == 'k' || c == 'l'
                || c == 'm' || c == 'n' || c == 'ñ' || c == 'o' || c == 'p' || c == 'q' 
                || c == 'r' || c == 's' || c == 't' || c == 'u' || c == 'v' || c == 'w'
                || c == 'x' || c == 'y' || c == 'z';
        
    }
    
    private static boolean esNumero(char c) {
        
        return c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' 
                || c == '6' || c == '7' || c == '8' || c == '9';
        
    }
    
    private static boolean esBooleano(String s) {
        
        return s.equals("verdadero") || s.equals("falso");
        
    }
    
    private static boolean esSimbolo(String s) {
        
        return s.equals(";") || s.equals("=") || s.equals("<") || s.equals(">") || s.equals("+")
                    || s.equals("-") || s.equals("/") || s.equals("*") || s.equals("%") || s.equals(",")
                    || s.equals(".") || s.equals(":") || s.equals("{") || s.equals("}") || s.equals("(")
                    || s.equals(")") || s.equals("&") || s.equals("|") || s.equals("$") || s.equals("#") 
                    || s.equals("\'") || s.equals("\"") || s.equals("\\");
        
    }
    
    private static boolean esPalabraReservada(String s) {
        
        return s.equals("principal") || s.equals("ent") || s.equals("flot") || s.equals("bool");
        
    }
    
    private static String getTipo(String cadena) {
        
        if(esPalabraReservada(cadena)) {
            
            return cadena;
            
        } else if(esBooleano(cadena)) {
            
            return "Booleano";

        } else if(esSimbolo(cadena)) {
            
            return cadena;

        } else if(cadena.length() == 2) {

            if(esLetraMinuscula(cadena.charAt(0))) {

                if(esNumero(cadena.charAt(1))) {
                    
                    return "Variable";

                } else {
                    
                    return "No definido";

                }

            } else {
                
                return "No definido";

            }

        } else if(cadena.length() == 3) {

            if(esLetraMayuscula(cadena.charAt(0))) {

                if(esLetraMinuscula(cadena.charAt(1))) {

                    if(esNumero(cadena.charAt(2))) {
                        
                        return "Función";

                    } else {
                        
                        return "No definido";

                    }

                } else {
                    
                    return "No definido";

                }

            } else if(esNumero(cadena.charAt(0))) {

                if(cadena.charAt(1) == '.') {

                    if(esNumero(cadena.charAt(2))) {
                        
                        return "Flotante";

                    } else {
                        
                        return "No definido";

                    }

                } else {
                    
                   return "No definido";

                }

            } else {
                
                return "No definido";

            }

        } else if(cadena.length() == 1) {

            if(esNumero(cadena.charAt(0))) {
                
                return "Entero";

            } else {
                
                return "No definido";

            }

        }
        
        return "No definido";
        
    }
    
    private static ArrayList<String> cadenas = new ArrayList<String>();
    
    private static ArrayList<String[]> lexemas = new ArrayList<String[]>();
    
}
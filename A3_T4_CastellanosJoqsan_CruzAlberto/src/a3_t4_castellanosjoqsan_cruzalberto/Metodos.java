package a3_t4_castellanosjoqsan_cruzalberto;

import java.util.*;

import javax.swing.*;

import java.io.*;

public class Metodos {
    
    public Metodos() {
        
        r = new Registros();
        
        c = new Consultas();
        
        b = new Borrar();
        
        File[] registros = new File("src/a3_t4_castellanosjoqsan_cruzalberto/registros/").listFiles();
        
        i = registros.length;
        
        if(new File("src/a3_t4_castellanosjoqsan_cruzalberto/registros/Auxiliar.txt").exists()) i --; 
        
    }
    
    public class Registros {
        
        public void agregarRegistro(JTextArea jTextArea1, JComboBox jComboBox1, JComboBox jComboBox2) throws Exception {
            
            FileWriter fw1 = new FileWriter("src/a3_t4_castellanosjoqsan_cruzalberto/registros/Auxiliar.txt");
            
            BufferedWriter bw1 = new BufferedWriter(fw1);
            
            bw1.write(jTextArea1.getText());
            
            bw1.close();
            
            fw1.close();
           
            FileReader fr = new FileReader("src/a3_t4_castellanosjoqsan_cruzalberto/registros/Auxiliar.txt");
            
            BufferedReader br = new BufferedReader(fr);
            
            StringTokenizer st1 = null, st2 = null, st3 = null;
            
            String linea = br.readLine();
            
            while(linea != null) {
                
                i ++;
                
                FileWriter fw2 = new FileWriter("src/a3_t4_castellanosjoqsan_cruzalberto/registros/Registro" + i + ".txt");
            
                BufferedWriter bw2 = new BufferedWriter(fw2);
                
                st1 = new StringTokenizer(linea, jComboBox1.getSelectedItem().toString());
                
                st3 = new StringTokenizer("Nombre: #Edad: #Sexo: #Teléfono: #Email: #Dirección: ", "#");
                
                do {
                
                    st2 = new StringTokenizer(st1.nextElement().toString(), jComboBox2.getSelectedItem().toString());
                    
                    bw2.write(st3.nextElement().toString());
                    
                    bw2.write(st2.nextElement().toString());

                    while(st2.hasMoreElements()) {

                        bw2.write(" ");

                        bw2.write(st2.nextElement().toString());

                    }
                    
                    if(st1.hasMoreElements() == false) break;
                    
                    bw2.newLine();
                    
                } while(true);
                
                bw2.close();
                
                fw2.close();
                
                linea = br.readLine();
                
            }
            
        }
        
    }
    
    public class Consultas {
        
        public void mostrarDatos(int n, JTextArea jTextArea1) throws Exception {
            
            FileReader fr = new FileReader("src/a3_t4_castellanosjoqsan_cruzalberto/registros/Registro" + n + ".txt");
            
            BufferedReader br = new BufferedReader(fr);
            
            String linea = br.readLine(), datos = "";
            
            while(linea != null) {
                
                datos += linea + "\n";
                
                linea = br.readLine();
                
            }
            
            jTextArea1.setText(datos);
            
            br.close();
            
            fr.close();
            
        }
        
    }
    
    public class Borrar {
        
        public void borrarTodo() {
            
            File[] registros = new File("src/a3_t4_castellanosjoqsan_cruzalberto/registros/").listFiles();
            
            for(int i=0; i<registros.length; i++) {
                
                registros[i].delete();
                
            }
            
            i = 0;
            
        }
        
    }
    
    public Registros r;
    
    public Consultas c;
    
    public Borrar b;
    
    private int i;
    
}
package a5_t2_castellanosjoqsan;

import com.toedter.calendar.*;

import javax.swing.*;

import java.io.*;

import javax.swing.table.*;

import java.util.*;

import java.awt.*;

public class MarcoEventos extends JFrame {
    
    public MarcoEventos(JCalendar calendario1) throws Exception {
        
        setLayout(new GridLayout(1, 1));
        
        setSize(400, 250);
        
        String c = calendario1.getDayChooser().getDay() + "-" + calendario1.getMonthChooser().getMonth() +
                "-" + calendario1.getYearChooser().getYear();
        
        setTitle("Eventos programados para el " + c);
        
        c += ".txt";
        
        File archivos[] = new File("src/registros").listFiles();
        
        for(int i=0; i<archivos.length; i++) {
            
            if(archivos[i].getName().equals(c)) {
                
                FileReader lector1 = new FileReader("src/registros/" + c);
               
                BufferedReader lector2 = new BufferedReader(lector1);
                
                DefaultTableModel modelo = new DefaultTableModel();
                
                modelo.addColumn("Nombre del evento");
                
                modelo.addColumn("Hora inicio");
                
                modelo.addColumn("Hora fin");
                
                String[] campos = new String[3];
                
                campos[0] = "Nombre del evento";
                
                campos[1] = "Hora inicio";
                
                campos[2] = "Hora fin";
                
                modelo.addRow(campos);
                
                String linea = "";
                
                while(lector2.ready()) {
                    
                    linea = lector2.readLine();
                    
                    StringTokenizer st = new StringTokenizer(linea, "#");
                    
                    String[] datos = new String[3];
                    
                    datos[0] = st.nextToken();
                    
                    datos[1] = st.nextToken();
                    
                    datos[2] = st.nextToken();
                    
                    modelo.addRow(datos);
                    
                }
                
                add(new JTable(modelo));
                
                lector2.close();
                
                lector1.close();
                
                break;
                
            }
            
        }
        
    }
    
}
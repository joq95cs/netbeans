
package compararexcel;

import java.io.*;
import java.util.*;

public class ArchivoTexto {
    
    public ArchivoTexto(String path, int option) throws Exception {
        
        if(option == 1) {
            
            rows = new ArrayList<ArrayList<String>>();
            
            BufferedReader br = new BufferedReader(new FileReader(path));
        
            while(br.ready()) {

                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                ArrayList<String> values = new ArrayList<String>();

                int i = 1;

                while(st.hasMoreTokens()) {

                    if(i >= 4) {

                        String aux = values.get(2);
                        aux += " " + st.nextToken();
                        values.set(2, aux);

                    } else {

                        values.add(st.nextToken());
                    }

                    i++;
                }

                rows.add(values);
            }
        
            br.close();
            
        } else if(option == 2) {
            
            lines = new ArrayList<String>();          
            BufferedReader br = new BufferedReader(new FileReader(path));
            
            while(br.ready()) {
                
                lines.add(br.readLine());
            }
            
            br.close();
        }
        
    }
           
    public void printRows() {
        
        int i = 1;
        
        for(ArrayList<String> r: rows) {
            
            System.out.print(i + ". ");
            
            for(String v: r) {
               
                System.out.print(v + " ");
            }
            
            System.out.println();
            i++;
        }
    }
    
    public void printLines() {
        
        for(String line: lines) {
            
            System.out.println(line);
        }
    }
    
    public int getRowsSize() {
        
        return rows.size();
    }
    
    public int getLinesSize() {
        
        return lines.size();
    }
    
    public String getText(int r, int c) {
        
        return rows.get(r).get(c);
    }
    
    public String getLine(int l) {
        
        return lines.get(l);
    }
    
    private ArrayList<ArrayList<String>> rows;
    
    private ArrayList<String> lines;
}
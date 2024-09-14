package a5_t2_castellanosjoqsan;

import java.io.*;

import java.util.*;

import com.itextpdf.text.*;

import com.itextpdf.text.pdf.*;

import java.awt.*;

public class Metodos {
    
    public static void agregar() throws Exception {
        
        File carpeta = new File("src/registros");
        
        if(carpeta.exists() == false) {
            
            carpeta.mkdir();
            
        }
        
        FileWriter escritor1 = new FileWriter(carpeta.getPath() + "\\" + m.calendario1.getDayChooser().getDay() +
                "-" + m.calendario1.getMonthChooser().getMonth() + "-" + m.calendario1.getYearChooser().getYear() +
                ".txt", true);
        
        BufferedWriter escritor2 = new BufferedWriter(escritor1);
        
        escritor2.write(m.campo1.getText() + "#" + m.spin1.getValue() + ":" + m.spin2.getValue() +
                " " + m.combo1.getSelectedItem() + "#" + m.spin3.getValue() + ":" + m.spin4.getValue() +
                " " + m.combo2.getSelectedItem());
        
        escritor2.newLine();
        
        escritor2.close();
        
        escritor1.close();
        
    }
    
    public static void ver() throws Exception {
        
        new MarcoEventos(m.calendario1).setVisible(true);
        
    }
    
    public static void exportar() throws Exception {
        
        File carpeta = new File("src/registros_pdf");
        
        if(carpeta.exists() == false) {
            
            carpeta.mkdir();
            
        }
        
        String c = m.calendario1.getDayChooser().getDay() + "-" + m.calendario1.getMonthChooser().getMonth() + 
                "-" + m.calendario1.getYearChooser().getYear();
        
        Document doc = new Document(PageSize.A1, 30, 30, 30, 30);
        
        PdfWriter.getInstance(doc, new FileOutputStream(new File("src/registros_pdf/" + c + ".pdf")));
        
        doc.open();
        
        doc.add(new Paragraph("Eventos programados para el " + c + "\n\n\n"));
        
        PdfPTable tabla = new PdfPTable(3);
        
        tabla.addCell("Nombre del evento");
        
        tabla.addCell("Hora inicio");
        
        tabla.addCell("Hora fin");
        
        FileReader lector1 = new FileReader("src/registros/" + c + ".txt");
        
        BufferedReader lector2 = new BufferedReader(lector1);
        
        String linea = "";
        
        while(lector2.ready()) {
            
            linea = lector2.readLine();
            
            StringTokenizer st = new StringTokenizer(linea, "#");
            
            tabla.addCell(st.nextToken());
            
            tabla.addCell(st.nextToken());
            
            tabla.addCell(st.nextToken());
            
        }
        
        lector2.close();
        
        lector1.close();
        
        doc.add(tabla);
      
        doc.add(new Paragraph("\n\nFecha de creación: " + new Date().toString()));
        
        doc.close();
        
        Desktop.getDesktop().open(new File("src/registros_pdf/" + c + ".pdf"));
        
    }
    
    public static Marco m = new Marco();
    
}
package a6_t2_castellanosjoqsan_cruzalberto;

import mi_arraylist.*;

import java.sql.*;

import java.util.*;

import java.util.Date;

import java.io.*;

import javax.swing.*;

import javax.swing.table.*;

import com.itextpdf.text.*;

import com.itextpdf.text.pdf.*;

public class Registros_Joqsan_Alberto {
    
    public Registros_Joqsan_Alberto() throws SQLException {
        
        c = new Conexion();
        
        x = 0;
        
    }
    
    public void altas(Mi_ArrayList<String> datos) throws SQLException {
        
        c.ssql.executeUpdate("INSERT INTO artículos VALUES(" + datos.get(0) + ", '" + datos.get(1) + "', '" + datos.get(2) + "', " + datos.get(3) + ", " + datos.get(4) + ", '" + datos.get(5) + "')");
        
        JOptionPane.showMessageDialog(null, "Registro añadido con éxito", "Añadiendo registro", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    public void bajas() throws SQLException {
        
        String id = JOptionPane.showInputDialog(null, "Ingrese ID(s) para eliminar registro(s) o 0 para eliminar todos", "Eliminando registro(s)", JOptionPane.QUESTION_MESSAGE);
        
        if(id.equals("0")) {
            
            c.ssql.executeUpdate("DELETE FROM artículos");
            
        } else {
            
            StringTokenizer st = new StringTokenizer(id, " ");
            
            Mi_ArrayList<String> ids = new Mi_ArrayList<String>();
            
            while(st.hasMoreTokens()) {
                
                ids.add(st.nextToken());
                
            }
            
            String u = "DELETE FROM artículos WHERE id = " + ids.get(0);
            
            for(int i=1; i<ids.size(); i++) {
                
                u += " OR id = " + ids.get(i);
                
            }
            
            c.ssql.executeUpdate(u);
            
        }
        
        JOptionPane.showMessageDialog(null, "Registro(s) eliminado(s) con éxito", "Eliminando registro(s)", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    public void modificaciones(Mi_ArrayList<JTextField> campos, Mi_ArrayList<JSpinner> spinners, Mi_ArrayList<String> datos) throws SQLException {
        
        if(x == 0) {
        
            id = JOptionPane.showInputDialog(null, "Ingrese ID del registro a actualizar", "Actualizando registro", JOptionPane.QUESTION_MESSAGE);
            
            c.rc = c.ssql.executeQuery("SELECT * FROM artículos WHERE id = " + id);
            
            while(c.rc.next()) {
                
                spinners.get(0).setValue(c.rc.getInt("id"));
                
                campos.get(0).setText(c.rc.getString("nombre"));
                
                campos.get(1).setText(c.rc.getString("descripción"));
                
                spinners.get(1).setValue(c.rc.getInt("existencia"));
                
                spinners.get(2).setValue(c.rc.getInt("precio"));
                
                campos.get(2).setText(c.rc.getString("categoría"));
                
            }
            
            x ++;
        
        } else {
            
            c.ssql.executeUpdate("UPDATE artículos SET id = " + datos.get(0) + ", nombre = '" + datos.get(1) + "', descripción = '" + datos.get(2) + "', existencia = " + datos.get(3) + ", precio = " + datos.get(4) + ", categoría = '" + datos.get(5) + "' WHERE id = " + id);
            
            JOptionPane.showMessageDialog(null, "Registro actualizado con éxito", "Actualizando registro", JOptionPane.INFORMATION_MESSAGE);
            
            x = 0;
            
        }
    }
    
    public void consultas() throws SQLException {
        
        String id = JOptionPane.showInputDialog(null, "Ingrese ID(s) para consultar registro(s) o 0 para consultar todos", "Consultando registro(s)", JOptionPane.QUESTION_MESSAGE);
        
        String q = null;
        
        if(id.equals("0")) {
            
            q = "SELECT * FROM artículos";
            
        } else {
            
            StringTokenizer st = new StringTokenizer(id, " ");
        
            Mi_ArrayList<String> ids = new Mi_ArrayList<String>();

            while(st.hasMoreTokens()) {

                ids.add(st.nextToken());

            }
            
            q = "SELECT * FROM artículos WHERE id = " + ids.get(0);

            for(int i=1; i<ids.size(); i++) {

                q += " OR id = " + ids.get(i);

            }
            
        }
        
        c.rc = c.ssql.executeQuery(q);
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("ID");
        
        modelo.addColumn("Nombre");
        
        modelo.addColumn("Descripción");
        
        modelo.addColumn("Existencia");
        
        modelo.addColumn("Precio");
        
        modelo.addColumn("Categoría");
        
        boolean existentes = false;
        
        while(c.rc.next()) {
            
            Object[] datos = new Object[6];
            
            datos[0] = c.rc.getInt("id");
            
            datos[1] = c.rc.getString("nombre");
            
            datos[2] = c.rc.getString("descripción");
            
            datos[3] = c.rc.getInt("existencia");
            
            datos[4] = c.rc.getInt("precio");
            
            datos[5] = c.rc.getString("categoría");
            
            modelo.addRow(datos);
            
            existentes = true;
            
        }
        
        if(existentes) {
        
            new MarcoConsulta(modelo).setVisible(true);
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Registro(s) no encontrado(s)", "Error", 0);
            
        }
        
    }
    
    public void generarArchivo() throws Exception {
        
        File carpeta = new File("src/registros");
        
        if(!carpeta.exists()) {
            
            carpeta.mkdir();
            
        }
        
        Document documento = new Document(PageSize.A1, 30, 30, 30, 30);
        
        PdfWriter.getInstance(documento, new FileOutputStream(new File(carpeta, "archivo_registros.pdf")));
        
        documento.open();
        
        documento.add(new Paragraph("Nombre de la base de datos: videojuegos\nNombre de la tabla: artículos\nFecha: " + new Date()));
        
        documento.add(Chunk.NEWLINE);
        
        documento.add(Chunk.NEWLINE);
        
        c.rc = c.ssql.executeQuery("SELECT * FROM artículos");
        
        PdfPTable tabla = new PdfPTable(6);
        
        tabla.addCell("ID");
        
        tabla.addCell("Nombre");
        
        tabla.addCell("Descripción");
        
        tabla.addCell("Existencia");
        
        tabla.addCell("Precio");
        
        tabla.addCell("Categoría");
        
        while(c.rc.next()) {
            
            tabla.addCell(String.valueOf(c.rc.getInt("id")));
            
            tabla.addCell(c.rc.getString("nombre"));
            
            tabla.addCell(c.rc.getString("descripción"));
            
            tabla.addCell(String.valueOf(c.rc.getInt("existencia")));
            
            tabla.addCell(String.valueOf(c.rc.getInt("precio")));
            
            tabla.addCell(c.rc.getString("categoría"));
            
        }
        
        documento.add(tabla);
        
        documento.add(Chunk.NEWLINE);
        
        documento.add(Chunk.NEWLINE);
        
        documento.add(new Paragraph("Nombre: Castellanos Alicea Joqsan Adalid, Cruz Alvarado Alberto Ángel\nGrupo: 4A"));
        
        documento.close();
        
        JOptionPane.showMessageDialog(null, "Archivo PDF creado con éxito", "Creando PDF", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    public void cerrarConexion() throws SQLException {
        
        c.cbd.close();
        
        c.ssql.close();
        
        c.rc.close();
        
    }
    
    private Conexion c;
    
    private String id;
    
    private int x;
    
    private class MarcoConsulta extends JFrame {
        
        public MarcoConsulta(DefaultTableModel modelo) {
            
            setTitle("Consulta");
            
            setBounds(Marco.anchoPantalla/3, Marco.altoPantalla/3, Marco.anchoPantalla/3, Marco.altoPantalla/3);
            
            JTable tabla = new JTable();
            
            tabla.setModel(modelo);
            
            add(new JScrollPane(tabla));
            
        }
        
    }
    
}
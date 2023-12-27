package aplicacionuniversal;

import java.awt.*;

import javax.swing.*;

import java.sql.*;

import java.awt.event.*;

import java.util.*;

import java.io.*;

import javax.swing.filechooser.*;

public class AplicacionUniversal {

    public static void main(String[] args) {

        MarcoAU marco = new MarcoAU();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        marco.setVisible(true);

    }

}

class MarcoAU extends JFrame{

    public MarcoAU(){
        
        setTitle("Aplicación Universal");

        setSize(700,700);
        
        setLocationRelativeTo(null);
        
        add(new LaminaAU());

    }	
	
}

class LaminaAU extends JPanel{
	
    public LaminaAU(){

        setLayout(new BorderLayout());

        comboTablas = new JComboBox();

        areaInformacion = new JTextArea();
        
        areaInformacion.setEditable(false);

        add(new JScrollPane(areaInformacion), BorderLayout.CENTER);		

        add(comboTablas, BorderLayout.NORTH);
        
        comboTablas.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                String nombreTabla = comboTablas.getSelectedItem().toString();
                
                mostrarInformacion(nombreTabla);
                
            }
            
        });
        
        conecta();
        
        obtenerTablas();
    
    }
    
    public void conecta() {
        
        String[] datos = new String[3];
        
        cn = null;
        
        BufferedReader br = null;
        
        try {
            
            br = new BufferedReader(new FileReader("C:/Users/joqle/Desktop/datos.txt"));
            
        } catch(IOException e) {
            
            JOptionPane.showMessageDialog(this, "No se encuentra el archivo de datos", "Error", 0);
            
            JFileChooser chooser = new JFileChooser();
        
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");

            chooser.setFileFilter(filter);

            int returnVal = chooser.showOpenDialog(this);

            if(returnVal == JFileChooser.APPROVE_OPTION) {
                
                try {
                    
                    br = new BufferedReader(new FileReader(chooser.getSelectedFile().getAbsolutePath()));
                    
                } catch (FileNotFoundException ex) {}

            } else {
                
                System.exit(0);
                
            }
            
        }
        
        try {
            
            for(int i=0; i<3; i++) {
                
                datos[i] = br.readLine();
                
            }
            
            br.close();
            
            cn = DriverManager.getConnection(datos[0], datos[1], datos[2]);
            
        } catch(Exception e) {}
        
    }
    
    public void obtenerTablas() {
        
        ResultSet rs = null;
        
        try {
            
            DatabaseMetaData metadatos = cn.getMetaData();
            
            rs = metadatos.getTables(null, null, null, null);
            
            while(rs.next()) {
                
                comboTablas.addItem(rs.getString("TABLE_NAME"));
                
            }
            
        } catch(Exception e) {}
        
    }
    
    public void mostrarInformacion(String nombreTabla) {
        
        ArrayList<String> campos = new ArrayList<String>();
        
        String consulta = "SELECT * FROM " + nombreTabla;
        
        try {
            
            areaInformacion.setText("");

            Statement st = cn.createStatement();
            
            ResultSet rs = st.executeQuery(consulta);
            
            ResultSetMetaData rsmd = rs.getMetaData();
            
            for(int i=1; i<=rsmd.getColumnCount(); i++) {
                
                campos.add(rsmd.getColumnLabel(i));
                
            }
            
            while(rs.next()) {
                
                for(String c: campos) {
                    
                    areaInformacion.append(rs.getString(c) + " ");
                    
                }
                
                areaInformacion.append("\n");
                
            }
            
        } catch(Exception e) {}
        
    }
    
    private JComboBox comboTablas;

    private JTextArea areaInformacion;
    
    private Connection cn;
	
}
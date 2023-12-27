package bbdd_jdbc;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;

public class Aplicacion_Consulta {

    public static void main(String[] args) {

        JFrame mimarco = new Marco_Aplicacion();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mimarco.setVisible(true);

    }

}

class Marco_Aplicacion extends JFrame{

    public Marco_Aplicacion() {
		
        setTitle ("Consulta BBDD");

        setSize(400,400);
        
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel menus = new JPanel();

        menus.setLayout(new FlowLayout());

        secciones = new JComboBox();

        secciones.setEditable(false);

        secciones.addItem("Todos");

        paises = new JComboBox();

        paises.setEditable(false);

        paises.addItem("Todos");

        resultado = new JTextArea(4,50);

        resultado.setEditable(false);

        add(resultado);

        menus.add(secciones);

        menus.add(paises);	

        add(menus, BorderLayout.NORTH);

        add(resultado, BorderLayout.CENTER);

        JButton botonConsulta = new JButton("Consulta");
        
        botonConsulta.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                ejecutaConsulta();
                
            }
            
        });
        
        JPanel inferior = new JPanel();
        
        inferior.add(botonConsulta);

        add(inferior, BorderLayout.SOUTH);	
        
        //Conexión con base de datos
        
        try {
            
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");
           
            Statement sentencia = conexion.createStatement();
            
            //Carga JCOMBOBOX SECCIÓN
            
            String consulta = "SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS";
            
            ResultSet rs = sentencia.executeQuery(consulta);
            
            while(rs.next()) {
                
                secciones.addItem(rs.getString(1));
                
            }
            
            rs.close();
            
            //CARGA JCOMBOBOX PAISES
            
            consulta = "SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS";
            
            rs = sentencia.executeQuery(consulta);
            
            while(rs.next()) {
                
                paises.addItem(rs.getString(1));
                
            }
            
            rs.close();
            
        } catch(Exception e) {
            
        }

    }
    
    private void ejecutaConsulta() {
        
        try {
            
            ResultSet rs = null;
            
            String seccion = secciones.getSelectedItem().toString();
            
            String pais = paises.getSelectedItem().toString();
            
            if(!seccion.equals("Todos") && pais.equals("Todos")) {
                
                enviaConsultaSeccion = conexion.prepareStatement(consultaSeccion);
            
                enviaConsultaSeccion.setString(1, seccion);
            
                rs = enviaConsultaSeccion.executeQuery();
                
            } else if(seccion.equals("Todos") && !pais.equals("Todos")) {
                
                enviaConsultaPais = conexion.prepareStatement(consultaPais);
            
                enviaConsultaPais.setString(1, pais);
            
                rs = enviaConsultaPais.executeQuery();
                
            } else if(!seccion.equals("Todos") && !pais.equals("Todos")) {
                
                enviaConsultaAmbos = conexion.prepareStatement(consultaAmbos);
            
                enviaConsultaAmbos.setString(1, seccion);
                
                enviaConsultaAmbos.setString(2, pais);
            
                rs = enviaConsultaAmbos.executeQuery();
                
            }
            
            resultado.setText("");
            
            while(rs.next()) {
                
                resultado.append(rs.getString(1));
                
                resultado.append(", ");
                
                resultado.append(rs.getString(2));
                
                resultado.append(", ");
                
                resultado.append(rs.getString(3));
                
                resultado.append("\n");
                
            }
            
        } catch(Exception e) {
            
        }
        
    }
    
    private JComboBox secciones;

    private JComboBox paises;

    private JTextArea resultado;
    
    private PreparedStatement enviaConsultaSeccion;
    
    private PreparedStatement enviaConsultaPais;
    
    private PreparedStatement enviaConsultaAmbos;
    
    private final String consultaSeccion = "SELECT NOMBREARTÍCULO, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN = ?";

    private final String consultaPais = "SELECT NOMBREARTÍCULO, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN = ?";
    
    private final String consultaAmbos = "SELECT NOMBREARTÍCULO, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN = ? AND PAÍSDEORIGEN = ?";
    
    private Connection conexion;
    
}
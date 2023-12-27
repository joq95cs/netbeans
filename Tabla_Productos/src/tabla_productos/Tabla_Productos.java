package tabla_productos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;

import javax.swing.table.*;

public class Tabla_Productos {

    public static void main(String[] args) {
        
        new Marco().setVisible(true);
        
    }
    
}

class Marco extends JFrame {
    
    public Marco() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(600, 400);
        
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        setLocation(w/2-getWidth()/2, h/2-getHeight()/2);
        
        setTitle("Productos");
        
        JPanel superior = new JPanel();
        
        comboTablas = new JComboBox();
        
        try {
            
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");
            
            datos = cn.getMetaData();
            
            rs = datos.getTables(null, null, null, null);
            
            while(rs.next()) {
                
                comboTablas.addItem(rs.getString("TABLE_NAME"));
                
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
        
        JTable tabla = new JTable();
        
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        
        comboTablas.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                String seleccionada = comboTablas.getSelectedItem().toString();
                
                String consulta = "SELECT * FROM " + seleccionada;
                
                try {
                
                    st = cn.createStatement();
                
                    rs = st.executeQuery(consulta);
                    
                    modelo = new ModeloTabla(rs);
                    
                    tabla.setModel(modelo);
                    
                    //add(new JScrollPane(tabla), BorderLayout.CENTER);
                    
                    validate(); //Para pintar
                    
                } catch(Exception ex) {
                    
                    ex.printStackTrace();
                    
                }
                
            }
            
            
        });
        
        superior.add(comboTablas);
        
        add(superior, BorderLayout.NORTH);
        
    }
    
    private JComboBox comboTablas;
    
    private DatabaseMetaData datos;
    
    private ResultSet rs;
    
    private Connection cn;
    
    private Statement st;
    
    private ModeloTabla modelo;
    
}

class ModeloTabla extends AbstractTableModel {
    
    public ModeloTabla(ResultSet rs) {
        
        this.rs = rs;
        
        try {
        
            rsmd = rs.getMetaData();
        
        } catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
    }

    @Override
    public int getRowCount() {
        
        try {
        
            rs.last();
        
            return rs.getRow();
        
        } catch(Exception e) {
            
            e.printStackTrace();
            
            return 0;
            
        }
        
    }

    @Override
    public int getColumnCount() {
        
        try {
        
            return rsmd.getColumnCount();
        
        } catch(Exception e) {
            
            e.printStackTrace();
            
            return 0;
            
        }
        
    }

    @Override
    public Object getValueAt(int i, int i1) {
        
        try {
            
            rs.absolute(i + 1);
            
            return rs.getObject(i1 + 1);
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
            return null;
            
        }
        
    }
    
    public String getColumnName(int c) {
        
        try {
            
            return rsmd.getColumnName(c + 1);
            
        } catch(Exception e) {
            
            e.printStackTrace();
            
            return null;
            
        }
        
    }
    
    private ResultSet rs;
    
    private ResultSetMetaData rsmd;
    
}
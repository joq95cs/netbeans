package a6_t2_castellanosjoqsan_cruzalberto;

import mi_arraylist.*;

import java.sql.*;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class Lamina extends JPanel {
    
    public Lamina() throws SQLException {
        
        setLayout(new BorderLayout());
        
        JPanel laminaCentro = new JPanel();
        
        laminaCentro.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        
        JLabel etiqueta1 = new JLabel("ID");
        
        c.weightx = 1;
        
        c.weighty = 1;
        
        c.gridwidth = 1;
        
        c.gridheight = 1;
        
        c.gridx = 0;
        
        c.gridy = 0;
        
        laminaCentro.add(etiqueta1, c);
        
        spinner1 = new JSpinner(new SpinnerNumberModel(1, 1, 999, 1));
        
        c.gridx = 1;
        
        laminaCentro.add(spinner1, c);
        
        JLabel etiqueta2 = new JLabel("Nombre");
        
        c.gridx = 0;
        
        c.gridy = 1;
        
        laminaCentro.add(etiqueta2, c);
        
        campo1 = new JTextField(10);
        
        c.gridx = 1;
        
        laminaCentro.add(campo1, c);
        
        JLabel etiqueta3 = new JLabel("Descripción");
        
        c.gridx = 0;
        
        c.gridy = 2;
        
        laminaCentro.add(etiqueta3, c);
        
        campo2 = new JTextField(10);
        
        c.gridx = 1;
        
        laminaCentro.add(campo2, c);
        
        JLabel etiqueta4 = new JLabel("Existencia");
        
        c.gridx = 0;
        
        c.gridy = 3;
        
        laminaCentro.add(etiqueta4, c);
        
        spinner2 = new JSpinner(new SpinnerNumberModel(0, 0, 9999, 1));
        
        c.gridx = 1;
        
        laminaCentro.add(spinner2, c);
        
        JLabel etiqueta5 = new JLabel("Precio");
        
        c.gridx = 0;
        
        c.gridy = 4;
        
        laminaCentro.add(etiqueta5, c);
        
        spinner3 = new JSpinner(new SpinnerNumberModel(1, 1, 9999, 1));
        
        c.gridx = 1;
        
        laminaCentro.add(spinner3, c);
        
        JLabel etiqueta6 = new JLabel("Categoría");
        
        c.gridx = 0;
        
        c.gridy = 5;
        
        laminaCentro.add(etiqueta6, c);
        
        campo3 = new JTextField(10);
        
        c.gridx = 1;
        
        laminaCentro.add(campo3, c);
        
        add(laminaCentro, BorderLayout.CENTER);
        
        JPanel laminaSur = new JPanel();
        
        laminaSur.setLayout(new GridBagLayout());
        
        boton1 = new JButton("Insertar");
        
        Oyente o = new Oyente();
        
        boton1.addMouseListener(o);
        
        c.gridx = 0;
        
        c.gridy = 0;
        
        laminaSur.add(boton1, c);
        
        boton2 = new JButton("Actualizar");
        
        boton2.addMouseListener(o);
        
        c.gridx = 1;
        
        laminaSur.add(boton2, c);
        
        boton3 = new JButton("Eliminar");
        
        boton3.addMouseListener(o);
        
        c.gridx = 2;
        
        laminaSur.add(boton3, c);
        
        boton4 = new JButton("Consultar");
        
        boton4.addMouseListener(o);
        
        c.gridx = 3;
        
        laminaSur.add(boton4, c);
        
        boton5 = new JButton("Generar archivo");
        
        boton5.addMouseListener(o);
        
        c.gridx = 4;
        
        laminaSur.add(boton5, c);
        
        boton6 = new JButton("Limpiar");
        
        boton6.addMouseListener(o);
        
        c.gridx = 5;
        
        laminaSur.add(boton6, c);
        
        add(laminaSur, BorderLayout.SOUTH);
        
        r = new Registros_Joqsan_Alberto();
        
    }
    
    public Mi_ArrayList<String> getDatos() {
        
        Mi_ArrayList<String> datos = new Mi_ArrayList();
        
        datos.add(String.valueOf(spinner1.getValue()));
        
        datos.add(campo1.getText());
        
        datos.add(campo2.getText());
        
        datos.add(String.valueOf(spinner2.getValue()));
        
        datos.add(String.valueOf(spinner3.getValue()));
        
        datos.add(campo3.getText());
        
        return datos;
        
    }
    
    public Mi_ArrayList<JTextField> getCampos() {
        
        Mi_ArrayList<JTextField> campos = new Mi_ArrayList<JTextField>();
        
        campos.add(campo1);
        
        campos.add(campo2);
        
        campos.add(campo3);
        
        return campos;
        
    }
    
    public Mi_ArrayList getSpinners() {
        
        Mi_ArrayList<JSpinner> spinners = new Mi_ArrayList<JSpinner>();
        
        spinners.add(spinner1);
        
        spinners.add(spinner2);
        
        spinners.add(spinner3);
        
        return spinners;
        
    }
    
    public void cerrarConexion() throws SQLException {
        
        r.cerrarConexion();
        
    }
    
    private JSpinner spinner1, spinner2, spinner3;
    
    private JTextField campo1, campo2, campo3;
    
    private JButton boton1, boton2, boton3, boton4, boton5, boton6;
    
    private Registros_Joqsan_Alberto r;
    
    private class Oyente extends MouseAdapter {
        
        public void mouseClicked(MouseEvent e) {
            
            try {
            
                if(e.getSource() == boton1) {

                    r.altas(getDatos());

                } else if(e.getSource() == boton2) {
                    
                    r.modificaciones(getCampos(), getSpinners(), getDatos());

                } else if(e.getSource() == boton3) {
                    
                    r.bajas();

                } else if(e.getSource() == boton4) {
                    
                    r.consultas();

                } else if(e.getSource() == boton5) {
                    
                    r.generarArchivo();
                    
                } else {
                    
                    campo1.setText("");
                    
                    campo2.setText("");
                    
                    campo3.setText("");
                    
                    spinner1.setValue(1);
                    
                    spinner2.setValue(0);
                    
                    spinner3.setValue(1);
                    
                }
                
            } catch(Exception ex) {
                
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
                
            }
            
        }
        
    }
    
}
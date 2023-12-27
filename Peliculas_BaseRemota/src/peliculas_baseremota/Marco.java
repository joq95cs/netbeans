
package peliculas_baseremota;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utilidades.*;
import java.sql.*;
import java.util.*;

public class Marco extends JFrame {
    
    public Marco() {
        
        Utilidades.crearMarco(this, "Películas: Base de datos remota", 500, 350, EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 350));
        add(new Lamina());
        
        conexion = new Conexion();
    }
    
    private class Lamina extends JPanel {
        
        public Lamina() {
            
            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            
            c.weightx = 1;
            c.weighty = 1;
            c.anchor = GridBagConstraints.WEST;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.insets = new Insets(0, 15, 0, 15);
            c.gridx = 0;
            c.gridy = 0;
            add(new JLabel("ID"), c);
            
            c.gridx = 1;
            campoID = new JTextField(33);
            campoID.setEditable(false);
            add(campoID, c);
            
            c.gridx = 0;
            c.gridy = 1;
            add(new JLabel("Nombre"), c);
            
            c.gridx = 1;
            campoNombre = new JTextField();
            add(campoNombre, c);
            
            c.gridx = 0;
            c.gridy = 2;
            add(new JLabel("Año"), c);
            
            c.gridx = 1;
            campoAgno = new JTextField();
            add(campoAgno, c);
            
            c.gridx = 0;
            c.gridy = 3;
            add(new JLabel("Género"), c);
            
            c.gridx = 1;
            campoGenero = new JTextField();
            add(campoGenero, c);
            
            c.gridx = 0;
            c.gridy = 4;
            add(new JLabel("País"), c);
            
            c.gridx = 1;
            campoPais = new JTextField();
            add(campoPais, c);
            
            c.gridx = 0;
            c.gridy = 5;
            add(new JLabel("Estudio"), c);
            
            c.gridx = 1;
            campoEstudio = new JTextField();
            add(campoEstudio, c);
            
            c.gridx = 0;
            c.gridy = 6;
            c.gridwidth = 2;
            JPanel panelBotones = new JPanel();
            panelBotones.setLayout(new GridBagLayout());
            add(panelBotones, c);
            
            c = new GridBagConstraints();
            c.weightx = 1;
            c.anchor = GridBagConstraints.WEST;
            c.gridx = 0;
            c.gridy = 0;
            btnInsertar = new JButton("Insertar");
            panelBotones.add(btnInsertar, c);
            
            c.gridx = 1;
            c.anchor = GridBagConstraints.CENTER;
            btnBuscar = new JButton("Buscar");
            panelBotones.add(btnBuscar, c);
            
            c.gridx = 2;
            btnActualizar = new JButton("Actualizar");
            panelBotones.add(btnActualizar, c);
            
            c.gridx = 3;
            btnEliminar = new JButton("Eliminar");
            panelBotones.add(btnEliminar, c);
            
            c.gridx = 4;
            btnVer = new JButton("Ver todo");
            panelBotones.add(btnVer, c);
            
            c.gridx = 5;
            c.anchor = GridBagConstraints.EAST;
            btnLimpiar = new JButton("Limpiar");
            panelBotones.add(btnLimpiar, c);
            
            Oyente o = new Oyente();
            btnInsertar.addActionListener(o);
            btnBuscar.addActionListener(o);
            btnActualizar.addActionListener(o);
            btnEliminar.addActionListener(o);
            btnVer.addActionListener(o);
            btnLimpiar.addActionListener(o);
        }
    }
    
    private class Oyente implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            
            try {
            
                if(e.getSource().equals(btnInsertar)) {
                    
                    conexion.insertar(campoNombre.getText(), Integer.parseInt(campoAgno.getText()), campoGenero.getText(), campoPais.getText(), campoEstudio.getText());
                    campoID.setText("");
                    campoNombre.setText("");
                    campoAgno.setText("");
                    campoGenero.setText("");
                    campoPais.setText("");
                    campoEstudio.setText("");
                    
                } else if(e.getSource().equals(btnBuscar)) {
                    
                    ResultSet rs = conexion.buscar(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID a buscar", "Buscar", JOptionPane.QUESTION_MESSAGE)));
                    campoID.setText(rs.getString(1));
                    campoNombre.setText(rs.getString(2));
                    campoAgno.setText(new StringTokenizer(rs.getString(3), "-").nextToken());
                    campoGenero.setText(rs.getString(4));
                    campoPais.setText(rs.getString(5));
                    campoEstudio.setText(rs.getString(6));
                    
                } else if(e.getSource().equals(btnActualizar)) {
                    
                    conexion.actualizar(Integer.parseInt(campoID.getText()), campoNombre.getText(), Integer.parseInt(campoAgno.getText()), campoGenero.getText(), campoPais.getText(), campoEstudio.getText());
                    
                } else if(e.getSource().equals(btnEliminar)) {

                    conexion.eliminar(Integer.parseInt(campoID.getText()));
                    campoID.setText("");
                    campoNombre.setText("");
                    campoAgno.setText("");
                    campoGenero.setText("");
                    campoPais.setText("");
                    campoEstudio.setText("");
                   
                } else if(e.getSource().equals(btnVer)) {
                    
                    new MarcoVer(conexion.ver()).setVisible(true);
                    
                } else {
                    
                    campoID.setText("");
                    campoNombre.setText("");
                    campoAgno.setText("");
                    campoGenero.setText("");
                    campoPais.setText("");
                    campoEstudio.setText("");
                }
                
            } catch(Exception ex) {
                
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }
    }
    
    private JTextField campoID, campoNombre, campoAgno, campoGenero, campoPais, campoEstudio;
    private JButton btnInsertar, btnBuscar, btnActualizar, btnEliminar, btnVer, btnLimpiar;
    private Conexion conexion;
}
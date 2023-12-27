package castellanos_cruz;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class Panel extends JPanel {
    
    public Panel() {
        
        try {
            
            setLayout(new BorderLayout());
            
            JMenuBar barraMenu = new JMenuBar();
            
            mPrincipal = new JMenu("Principal");
            
            miCrear1 = new JMenuItem("Crear");
            
            miAbrir1 = new JMenuItem("Abrir");
            
            miSalir = new JMenuItem("Salir");
            
            mPrincipal.add(miCrear1);
            
            mPrincipal.add(miAbrir1);
            
            mPrincipal.add(miSalir);
            
            mPrincipal.insertSeparator(2);
            
            barraMenu.add(mPrincipal);
            
            mTabla = new JMenu("Tabla");
            
            miCrear2 = new JMenuItem("Crear");
            
            miAbrir2 = new JMenuItem("Abrir");
            
            miExaminar = new JMenuItem("Examinar");
            
            miEliminar1 = new JMenuItem("Eliminar");
            
            miVaciar = new JMenuItem("Vaciar");
            
            miRegresar1 = new JMenuItem("Regresar");
            
            mTabla.add(miCrear2);
            
            mTabla.add(miAbrir2);
            
            mTabla.add(miExaminar);
            
            mTabla.add(miEliminar1);
            
            mTabla.add(miVaciar);
            
            mTabla.add(miRegresar1);
            
            mTabla.insertSeparator(5);
            
            mTabla.setEnabled(false);
            
            barraMenu.add(mTabla);
            
            mDatos = new JMenu("Datos");
            
            miAgregar = new JMenuItem("Agregar");
            
            miModificar = new JMenuItem("Modificar");
            
            miEliminar2 = new JMenuItem("Eliminar");
            
            miBuscar = new JMenuItem("Buscar");
            
            miRegresar2 = new JMenuItem("Regresar");
            
            mDatos.add(miAgregar);
            
            mDatos.add(miModificar);
            
            mDatos.add(miEliminar2);
            
            mDatos.add(miBuscar);
            
            mDatos.add(miRegresar2);
            
            mDatos.insertSeparator(4);
            
            mDatos.setEnabled(false);
            
            barraMenu.add(mDatos);
            
            comboBox = new JComboBox();
            
            etiqueta1 = new JLabel("");
            
            etiqueta1.setVisible(false);
            
            etiqueta2 = new JLabel("");
            
            etiqueta2.setVisible(false);
            
            JPanel panelSur = new JPanel();
            
            panelSur.setLayout(new GridBagLayout());
            
            GridBagConstraints c = new GridBagConstraints();
            
            c.gridx = 0;
            
            c.gridy = 0;
            
            panelSur.add(etiqueta1, c);
            
            panelSur.add(comboBox, c);
            
            c.gridy = 1;
            
            panelSur.add(etiqueta2, c);
            
            add(barraMenu, BorderLayout.NORTH);
            
            add(panelSur, BorderLayout.SOUTH);
            
            Oyente1 o = new Oyente1();
            
            miCrear1.addActionListener(o);
            
            miAbrir1.addActionListener(o);
            
            miSalir.addActionListener(o);
            
            miCrear2.addActionListener(o);
            
            miAbrir2.addActionListener(o);
            
            miExaminar.addActionListener(o);
            
            miEliminar1.addActionListener(o);
            
            miVaciar.addActionListener(o);
            
            miRegresar1.addActionListener(o);
            
            miAgregar.addActionListener(o);
            
            miModificar.addActionListener(o);
            
            miEliminar2.addActionListener(o);
            
            miBuscar.addActionListener(o);
            
            miRegresar2.addActionListener(o);
            
            Metodos.a.verificacionInicial(comboBox);
            
            comboBox.addActionListener(new Oyente2());
            
            abrir = true;
            
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    
    private JMenu mPrincipal, mTabla, mDatos;
    
    private JMenuItem miCrear1, miAbrir1, miSalir, miCrear2, miAbrir2, miExaminar, miEliminar1, miVaciar, miRegresar1, miAgregar, miModificar, miEliminar2, miBuscar, miRegresar2;
    
    private JComboBox comboBox;
    
    private JLabel etiqueta1, etiqueta2;
    
    private Boolean abrir;
    
    private class Oyente1 implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                
                if(e.getSource() == miCrear1) {
                    
                    abrir = false;
                
                    Metodos.p.crear(comboBox);
               
                } else if(e.getSource() == miAbrir1) {
                
                    Metodos.p.abrir(mPrincipal, mTabla, 1, etiqueta1, comboBox);
                
                } else if(e.getSource() == miSalir) {
                
                    Metodos.p.salir();
                
                } else if(e.getSource() == miCrear2) {
                    
                    Metodos.t.crear();
                    
                } else if(e.getSource() == miAbrir2) {
                    
                    Metodos.t.abrir(mDatos, mTabla, etiqueta2);
                    
                } else if(e.getSource() == miExaminar) {
                    
                    Metodos.t.examinar();
                    
                } else if(e.getSource() == miEliminar1) {
                    
                    Metodos.t.eliminar();
                    
                } else if(e.getSource() == miVaciar) {
                    
                    Metodos.t.vaciar();
                    
                } else if(e.getSource() == miRegresar1) {
                    
                    Metodos.t.regresar(mPrincipal, mTabla, etiqueta1, comboBox);
                    
                } else if(e.getSource() == miAgregar) {
                    
                    Metodos.d.agregar();
                    
                } else if(e.getSource() == miModificar) {
                    
                    Metodos.d.modificar();
                    
                } else if(e.getSource() == miEliminar2) {
                    
                    Metodos.d.eliminar();
                    
                } else if(e.getSource() == miBuscar) {
                    
                    Metodos.d.buscar();
                    
                }else {
                    
                    Metodos.d.regresar(mTabla, mDatos, etiqueta2);
                    
                }
                  
            } catch(Exception ex) {
                
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                
            } finally {
                
                abrir = true;
                
            }
            
        }
        
    }
    
    private class Oyente2 implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                
                if(abrir) {
                
                    Metodos.p.abrir(mPrincipal, mTabla, 2, etiqueta1, comboBox);
                
                }
                
            } catch(Exception ex) {
                
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
        
    }
    
}
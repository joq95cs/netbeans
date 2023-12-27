package a1_t4_castellanosjoqsan;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.io.*;

import java.util.*;

public class Lamina extends JPanel {
    
    public Lamina() {
        
        setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        
        c.weightx = 1;
        
        c.weighty = 1;
        
        c.gridwidth = 1;
        
        c.gridheight = 1;
        
        c.gridx = 0;
        
        c.gridy = 0;
        
        etID = new JLabel("ID (entero)");
        
        add(etID, c);
        
        c.gridx = 1;
        
        ctID = new JTextField(10);
        
        add(ctID, c);
        
        c.gridx = 0;
        
        c.gridy = 1;
        
        etNombre = new JLabel("Nombre (texto)");
        
        add(etNombre, c);
        
        c.gridx = 1;
        
        ctNombre = new JTextField(10);
        
        add(ctNombre, c);
        
        c.gridx = 0;
        
        c.gridy = 2;
        
        etDescripcion = new JLabel("Descripción (texto)");
        
        add(etDescripcion, c);
        
        c.gridx = 1;
        
        ctDescripcion = new JTextField(10);
        
        add(ctDescripcion, c);
        
        c.gridx = 0;
        
        c.gridy = 3;
        
        etExistencia = new JLabel("Existencia (entero)");
        
        add(etExistencia, c);
        
        c.gridx = 1;
        
        ctExistencia = new JTextField(10);
        
        add(ctExistencia, c);
        
        c.gridx = 0;
        
        c.gridy = 4;
        
        etPrecio = new JLabel("Precio (doble)");
        
        add(etPrecio, c);
        
        c.gridx = 1;
        
        ctPrecio = new JTextField(10);
        
        add(ctPrecio, c);
        
        c.gridx = 0;
        
        c.gridy = 5;
        
        etCategoria = new JLabel("Categoría (texto)");
        
        add(etCategoria, c);
        
        c.gridx = 1;
        
        ctCategoria = new JTextField(10);
        
        add(ctCategoria, c);
        
        c.gridx = 0;
        
        c.gridy = 6;
        
        Accion a1 = new Accion("Guardar (ctrl + G)", "Agregar un nuevo registro");
        
        btGuardar = new JButton(a1);
        
        add(btGuardar, c);
        
        c.gridx = 1;
        
        Accion a2 = new Accion("Buscar (ctrl + B)", "Buscar y mostrar un registro");
        
        btBuscar = new JButton(a2);
        
        add(btBuscar, c);
        
        ctID.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ctrl G"), "CG");
        
        ctID.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ctrl B"), "CB");
        
        ctID.getActionMap().put("CG", a1);
        
        ctID.getActionMap().put("CB", a2);
        
        ctNombre.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ctrl G"), "CG");
        
        ctNombre.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ctrl B"), "CB");
        
        ctNombre.getActionMap().put("CG", a1);
        
        ctNombre.getActionMap().put("CB", a2);
        
        ctDescripcion.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ctrl G"), "CG");
        
        ctDescripcion.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ctrl B"), "CB");
        
        ctDescripcion.getActionMap().put("CG", a1);
        
        ctDescripcion.getActionMap().put("CB", a2);
        
        ctExistencia.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ctrl G"), "CG");
        
        ctExistencia.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ctrl B"), "CB");
        
        ctExistencia.getActionMap().put("CG", a1);
        
        ctExistencia.getActionMap().put("CB", a2);
        
        ctPrecio.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ctrl G"), "CG");
        
        ctPrecio.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ctrl B"), "CB");
        
        ctPrecio.getActionMap().put("CG", a1);
        
        ctPrecio.getActionMap().put("CB", a2);
        
        ctCategoria.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ctrl G"), "CG");
        
        ctCategoria.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ctrl B"), "CB");
        
        ctCategoria.getActionMap().put("CG", a1);
        
        ctCategoria.getActionMap().put("CB", a2);
        
        btGuardar.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ctrl G"), "CG");
        
        btGuardar.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ctrl B"), "CB");
        
        btGuardar.getActionMap().put("CG", a1);
        
        btGuardar.getActionMap().put("CB", a2);
        
        btBuscar.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ctrl G"), "CG");
        
        btBuscar.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ctrl B"), "CB");
        
        btBuscar.getActionMap().put("CG", a1);
        
        btBuscar.getActionMap().put("CB", a2);
        
    }
    
    private JLabel etID, etNombre, etDescripcion, etExistencia, etPrecio, etCategoria;
    
    public JTextField ctID, ctNombre, ctDescripcion, ctExistencia, ctPrecio, ctCategoria;
    
    public JButton btGuardar, btBuscar;
    
}
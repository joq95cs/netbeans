package a5_t1_castellanosjoqsan;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

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
        
        Oyente o = new Oyente();
        
        btGuardar = new JButton("Guardar");
        
        btGuardar.addActionListener(o);
        
        add(btGuardar, c);
        
        c.gridx = 1;
        
        btBuscar = new JButton("Buscar");
        
        btBuscar.addActionListener(o);
        
        add(btBuscar, c);
        
    }
    
    private class Oyente implements ActionListener {
    
        public void actionPerformed(ActionEvent e) {
            
            try {
                
                if(e.getSource() == btGuardar) {
                    
                    Videojuego vd = new Videojuego();
                    
                    if(ctID.getText().equals("") || ctNombre.getText().equals("") || ctDescripcion.getText().equals("") || ctExistencia.getText().equals("") || ctPrecio.getText().equals("") || ctCategoria.getText().equals("")) {
                        
                        throw new CampoVacio();
                        
                    }
                    
                    if(Integer.parseInt(ctID.getText())<0 || Integer.parseInt(ctExistencia.getText())<0 || Double.parseDouble(ctPrecio.getText())<0){
                        
                        throw new ValorNegativo();
                        
                    }
                
                    vd.setInformacionVideojuego(Integer.parseInt(ctID.getText()), ctNombre.getText(), ctDescripcion.getText(), Integer.parseInt(ctExistencia.getText()), Double.parseDouble(ctPrecio.getText()), ctCategoria.getText());
                
                    Registros.setVideojuego(vd);
                
                    JOptionPane.showMessageDialog(null, "Videojuego añadido al registro", "Añadiendo videojuego", JOptionPane.INFORMATION_MESSAGE);
                
                } else {
                
                    if(Registros.registroVacio()) {
                    
                        throw new RegistroVacio();
                    
                    } else {
                
                        int noID = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese número de videojuego", "Buscar", JOptionPane.INFORMATION_MESSAGE));
                        
                        if(Registros.videojuegoExistente(noID)) {
                        
                            JOptionPane.showMessageDialog(null, Registros.getInformacionFinal(noID), "Información encontrada", JOptionPane.INFORMATION_MESSAGE);
                
                        } else {
                            
                            throw new ElementoNoEncontrado();
                            
                        }
                        
                    }
                    
                }
                
            } catch(Exception exc) {
                
                JOptionPane.showMessageDialog(null, "Error de tipo: " + exc.getClass().getName() + "\nMotivo: " + exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
    
    }
    
    private JLabel etID, etNombre, etDescripcion, etExistencia, etPrecio, etCategoria;
    
    private JTextField ctID, ctNombre, ctDescripcion, ctExistencia, ctPrecio, ctCategoria;
    
    private JButton btGuardar, btBuscar;
    
}

class CampoVacio extends Exception {
    
    public CampoVacio() {
        
        super("Campo(s) vacío(s)");
        
    }
    
}

class RegistroVacio extends Exception {
    
    public RegistroVacio() {
        
        super("Registro vacío");
        
    }
    
}

class ValorNegativo extends Exception {
    
    public ValorNegativo() {
        
        super("Valor negativo ingresado");
        
    }
    
}

class ElementoNoEncontrado extends Exception {
    
    public ElementoNoEncontrado() {
        
        super("Videojuego no encontrado");
        
    }
    
}
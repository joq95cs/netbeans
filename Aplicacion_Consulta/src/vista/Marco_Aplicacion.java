package vista;

import javax.swing.*;

import java.awt.*;

import controlador.*;

public class Marco_Aplicacion extends JFrame {

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
        
        botonConsulta.addActionListener(new ControladorConsulta(this));
        
        JPanel inferior = new JPanel();
        
        inferior.add(botonConsulta);

        add(inferior, BorderLayout.SOUTH);
        
        addWindowListener(new ControladorCargaMenus(this));
        
    }
    
    public JComboBox secciones;

    public JComboBox paises;

    public JTextArea resultado;
    
}
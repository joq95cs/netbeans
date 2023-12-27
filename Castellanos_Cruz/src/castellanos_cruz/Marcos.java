package castellanos_cruz;

import java.util.*;

import java.awt.*;

import java.awt.event.*;

import java.io.*;

import javax.swing.*;

import javax.swing.table.*;

public class Marcos {
    
    public static class Marco extends JFrame {
    
        public Marco() {
        
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
            setTitle("SGBD");
        
            setBounds(anchoPantalla/4, altoPantalla/4, anchoPantalla/2, altoPantalla/2);
        
            add(new Panel());
            
            addWindowListener(new WindowAdapter() {
                
                public void windowClosing(WindowEvent e) {
                    
                    if(JOptionPane.showConfirmDialog(null, "¿Desea cerrar el SGBD?", "Saliendo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        
                        System.exit(0);
                        
                    }
                    
                }
                
            });
        
        }
    
    }
    
    public static class MarcoFormulario1 extends JFrame {
        
        public MarcoFormulario1() {
            
            setBounds(3*anchoPantalla/8, 3*altoPantalla/7, anchoPantalla/4, altoPantalla/7);
            
            setTitle("Nueva tabla");
            
            setResizable(false);
            
            JPanel panelCentro = new JPanel();
            
            panelCentro.setLayout(new GridLayout(2, 1));
            
            JPanel panel1 = new JPanel();
            
            panel1.setLayout(new GridLayout(1, 2));
            
            panel1.add(new JLabel("Nombre de la tabla"));
            
            campo1 = new JTextField();
            
            panel1.add(campo1);
            
            panelCentro.add(panel1);
            
            JPanel panel2 = new JPanel();
            
            panel2.setLayout(new GridLayout(1, 2));
            
            panel2.add(new JLabel("No. campos"));
            
            campo2 = new JTextField();
            
            panel2.add(campo2);
            
            panelCentro.add(panel2);
            
            add(panelCentro, BorderLayout.CENTER);
            
            JPanel panelSur = new JPanel();
            
            boton1 = new JButton("Aceptar");
            
            boton1.addActionListener(o);
            
            panelSur.add(boton1);
            
            boton2 = new JButton("Cancelar");
            
            boton2.addActionListener(o);
            
            panelSur.add(boton2);
            
            add(panelSur, BorderLayout.SOUTH);
            
        }
        
    }
    
    public static class MarcoFormulario2 extends JFrame {
        
        public MarcoFormulario2() {
            
            setBounds(anchoPantalla/4, altoPantalla/4, anchoPantalla/2, altoPantalla/2);
            
            setTitle("Tabla " + campo1.getText());
            
            JPanel panelNorte = new JPanel();
            
            panelNorte.setLayout(new GridLayout(1, 4));
            
            panelNorte.add(new JLabel("Campo"));
            
            panelNorte.add(new JLabel("Nombre"));
            
            panelNorte.add(new JLabel("Tipo"));
            
            panelNorte.add(new JLabel("Tamaño"));
            
            add(panelNorte, BorderLayout.NORTH);
            
            JPanel panelCentro = new JPanel();
            
            int n = Integer.parseInt(campo2.getText());
            
            panelCentro.setLayout(new GridLayout(n, 4));

            JLabel[] etiquetas = new JLabel[n];
            
            campos1 = new JTextField[n];
            
            combos = new JComboBox[n];
            
            campos2 = new JTextField[n];
            
            for(int i=0; i<n; i++) {
                
                etiquetas[i] = new JLabel("Campo " + (i+1));
                
                panelCentro.add(etiquetas[i]);
                
                campos1[i] = new JTextField();
                
                panelCentro.add(campos1[i]);
                
                combos[i] = new JComboBox();
                
                combos[i].addItem("int");
                
                combos[i].addItem("varchar");
                
                panelCentro.add(combos[i]);
                
                campos2[i] = new JTextField();
                
                campos2[i].setVisible(false);
                
                panelCentro.add(campos2[i]);
                
                combos[i].addActionListener(new Oyente2(i));
                
                if(i == 0) {
                    
                    combos[i].setEnabled(false);
                    
                }
                
            }
            
            add(panelCentro, BorderLayout.CENTER);
            
            JPanel panelSur = new JPanel();
            
            boton3 = new JButton("Aceptar");
            
            boton3.addActionListener(o);
            
            panelSur.add(boton3);
            
            boton4 = new JButton("Cancelar");
            
            boton4.addActionListener(o);
            
            panelSur.add(boton4);
            
            add(panelSur, BorderLayout.SOUTH);
            
        }
        
    }
    
    public static class MarcoExaminar extends JFrame {
        
        public MarcoExaminar(String nombre, File baseAbierta) throws Exception {
            
            setBounds(anchoPantalla/4, altoPantalla/4, anchoPantalla/2, altoPantalla/2);
            
            setTitle("Tabla: " + nombre);
            
            FileReader lector1 = new FileReader(new File(baseAbierta, nombre + ".tbl"));
            
            BufferedReader lector2 = new BufferedReader(lector1);
            
            String cadena = lector2.readLine();
            
            StringTokenizer st = new StringTokenizer(cadena, "|");
            
            DefaultTableModel modelo = new DefaultTableModel();
            
            while(st.hasMoreTokens()) {
                
                modelo.addColumn(st.nextToken());
                
                st.nextToken();
                
            }
            
            st = new StringTokenizer(cadena, "|");
            
            Vector campos = new Vector(1, 1);
            
            while(st.hasMoreTokens()) {
                
                campos.addElement(st.nextToken());
                
                st.nextToken();
                
            }
            
            modelo.addRow(campos);
            
            if(new File(baseAbierta, nombre + ".dat").exists()) {
                
                lector1 = new FileReader(new File(baseAbierta, nombre + ".dat"));
                
                lector2 = new BufferedReader(lector1);
                
                while(lector2.ready()) {
                    
                    st = new StringTokenizer(lector2.readLine(), "|");
                    
                    Vector registro = new Vector(1, 1);
                    
                    while(st.hasMoreTokens()) {
                        
                        registro.add(st.nextToken());
                        
                    }
                    
                    modelo.addRow(registro);
                    
                }
                
            }
            
            lector2.close();
            
            lector1.close();
            
            add(new JTable(modelo));
            
        }
        
    }
    
    public static class MarcoAgregar extends JFrame {
        
        public MarcoAgregar(String nombre) {
            
            setBounds(anchoPantalla/4, altoPantalla/4, anchoPantalla/2, altoPantalla/2);
            
            setTitle("Nuevo registro en: " + nombre);
            
            JPanel panelNorte = new JPanel();
            
            panelNorte.setLayout(new GridLayout(1, 2));
            
            panelNorte.add(new JLabel("Campo"));
            
            panelNorte.add(new JLabel("Valor"));
            
            add(panelNorte, BorderLayout.NORTH);
            
            JPanel panelCentro = new JPanel();
            
            panelCentro.setLayout(new GridLayout(Listas.lista1.getLongitud(), 2));
            
            campos3 = new JTextField[Listas.lista1.getLongitud()];
            
            longitudes1 = new int[campos3.length];
            
            tipos1 = new String[campos3.length];
            
            int i = 0;
            
            for(Listas.NodoCampos n=Listas.lista1.inicio; n!=null; n=n.siguiente) {
                
                panelCentro.add(new JLabel(n.getNombre()));
                
                campos3[i] = new JTextField();
                
                if(i == 0) {
                    
                    campos3[i].setText("" + Listas.clavePrimaria);
                    
                    campos3[i].setEditable(false);
                    
                }
                
                panelCentro.add(campos3[i]);
                
                longitudes1[i] = n.getLongitud();
                
                tipos1[i] = n.getTipo();
                
                i ++;
                
            }
            
            add(panelCentro, BorderLayout.CENTER);
            
            JPanel panelSur = new JPanel();
            
            boton5 = new JButton("Guardar");
            
            boton5.addActionListener(o);
            
            panelSur.add(boton5);
            
            boton6 = new JButton("Cancelar");
            
            boton6.addActionListener(o);
            
            panelSur.add(boton6);
            
            add(panelSur, BorderLayout.SOUTH);
            
        }
        
    }
    
    public static class MarcoModificar extends JFrame {
        
        public MarcoModificar(String nombre, String clave) {
            
            setBounds(anchoPantalla/4, altoPantalla/4, anchoPantalla/2, altoPantalla/2);
            
            setTitle("Modificar registro en: " + nombre);
            
            JPanel panelNorte = new JPanel();
            
            panelNorte.setLayout(new GridLayout(1, 2));
            
            panelNorte.add(new JLabel("Campo"));
            
            panelNorte.add(new JLabel("Valor"));
            
            add(panelNorte, BorderLayout.NORTH);
            
            JPanel panelCentro = new JPanel();
            
            panelCentro.setLayout(new GridLayout(Listas.lista1.getLongitud(), 2));
            
            campos4 = new JTextField[Listas.lista1.getLongitud()];
            
            Listas.NodoDatos m = null;
            
            for(m=Listas.lista2.inicio; m!=null; m=m.abajo) {
                
                if(m.getDato().equals(clave)) {
                    
                    break;
                    
                }
                
            }
            
            longitudes2 = new int[campos4.length];
            
            tipos2 = new String[campos4.length];
            
            int i = 0;
            
            for(Listas.NodoCampos n=Listas.lista1.inicio; n!=null; n=n.siguiente) {
                
                panelCentro.add(new JLabel(n.getNombre()));
                
                campos4[i] = new JTextField(m.getDato());
                
                if(i == 0) {
                    
                    campos4[i].setEditable(false);
                    
                }
                
                panelCentro.add(campos4[i]);
                
                m = m.siguiente;
                
                longitudes2[i] = n.getLongitud();
                
                tipos2[i] = n.getTipo();
                
                i ++;
                
            }
            
            add(panelCentro, BorderLayout.CENTER);
            
            JPanel panelSur = new JPanel();
            
            boton7 = new JButton("Guardar");
            
            boton7.addActionListener(o);
            
            panelSur.add(boton7);
            
            boton8 = new JButton("Cancelar");
            
            boton8.addActionListener(o);
            
            panelSur.add(boton8);
            
            add(panelSur, BorderLayout.SOUTH);
            
        } 
        
    }
    
    public static class MarcoBuscar extends JFrame {
        
        public MarcoBuscar(String nombre, String clave) {
            
            setBounds(anchoPantalla/4, altoPantalla/4, anchoPantalla/2, altoPantalla/2);
            
            setTitle("Mostrar registro en: " + nombre);
            
            JPanel panelNorte = new JPanel();
            
            panelNorte.setLayout(new GridLayout(1, 2));
            
            panelNorte.add(new JLabel("Campo"));
            
            panelNorte.add(new JLabel("Valor"));
            
            add(panelNorte, BorderLayout.NORTH);
            
            JPanel panelCentro = new JPanel();
            
            panelCentro.setLayout(new GridLayout(Listas.lista1.getLongitud(), 2));
            
            campos5 = new JTextField[Listas.lista1.getLongitud()];
            
            Listas.NodoDatos m = null;
            
            for(m=Listas.lista2.inicio; m!=null; m=m.abajo) {
                
                if(m.getDato().equals(clave)) {
                    
                    break;
                    
                }
                
            }
            
            int i = 0;
            
            for(Listas.NodoCampos n=Listas.lista1.inicio; n!=null; n=n.siguiente) {
                
                panelCentro.add(new JLabel(n.getNombre()));
                
                campos5[i] = new JTextField(m.getDato());
                
                campos5[i].setEditable(false);
                
                panelCentro.add(campos5[i]);
                
                m = m.siguiente;
                
                i ++;
                
            }
            
            add(panelCentro, BorderLayout.CENTER);
            
        }
        
    }
    
    public static class Oyente1 implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
            
                if(e.getSource() == boton1) {
                    
                    mf1.setVisible(false);
                    
                    if(campo1.getText().equals("")) {
                        
                        throw new Excepciones.NombreTablaVacio();
                        
                    }
                    
                    if(Metodos.t.tablaEncontrada(campo1.getText())) {
                        
                        throw new Excepciones.TablaExistente();
                        
                    }

                    mf2 = new MarcoFormulario2();

                    mf2.setVisible(true);

                } else if(e.getSource() == boton2) {

                    mf1.setVisible(false);

                } else if(e.getSource() == boton3) {
                    
                    for(int i=0; i<campos1.length; i++) {
                        
                        if(campos1[i].getText().isEmpty()) {
                            
                            throw new Excepciones.NombreCampoVacio();
                            
                        }
                        
                        if(campos2[i].isVisible()) {
                            
                            if(Integer.parseInt(campos2[i].getText()) <= 0) {
                                
                                throw new Excepciones.LongitudCampoNoValida();
                                
                            }
                            
                        }
                        
                    }
                    
                    mf2.setVisible(false);
                    
                    Metodos.t.crearTabla(campo1, campo2, campos1, campos2, combos);

                } else if(e.getSource() == boton4) {

                    mf2.setVisible(false);

                } else if(e.getSource() == boton5) {
                    
                    Metodos.d.agregarRegistro(campos3, longitudes1, tipos1, 1);
                    
                    ma.setVisible(false);
                    
                } else if(e.getSource() == boton6) {
                    
                    ma.setVisible(false);
                    
                } else if(e.getSource() == boton7) {
                    
                    Metodos.d.modificarRegistro(campos4, longitudes2, tipos2);
                    
                    mm.setVisible(false);
                    
                } else {
                    
                    mm.setVisible(false);
                    
                }
                
            } catch(Exception ex) {
                
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
        
    }
    
    public static class Oyente2 implements ActionListener {
        
        public Oyente2(int i) {
            
            this.i = i;
            
        }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(combos[i].getSelectedIndex() == 1) {
                
                campos2[i].setVisible(true);
                
            } else {
                
                campos2[i].setVisible(false);
                
            }
            
        }
        
        private int i;
        
    }
    
    public static Marco m;
    
    public static MarcoFormulario1 mf1;
    
    public static MarcoFormulario2 mf2;
    
    public static MarcoExaminar me;
    
    public static MarcoAgregar ma;
    
    public static MarcoModificar mm;
    
    public static MarcoBuscar mb;
    
    private static JTextField campo1, campo2;
    
    private static JComboBox[] combos;
    
    private static JTextField[] campos1, campos2, campos3, campos4, campos5;
    
    private static int[] longitudes1, longitudes2;
    
    private static String[] tipos1, tipos2;
    
    private static JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8;
    
    private static Oyente1 o = new Oyente1();
    
    private static int anchoPantalla = Toolkit.getDefaultToolkit().getScreenSize().width;
    
    private static int altoPantalla = Toolkit.getDefaultToolkit().getScreenSize().height;
    
}
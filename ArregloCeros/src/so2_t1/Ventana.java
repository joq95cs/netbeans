package so2_t1;

import java.awt.*;

import javax.swing.*;

public class Ventana extends javax.swing.JFrame {

    public Ventana() {
        
        initComponents();
        
        array = new JTextField[10][5]; //Iniciación del arreglo de objetos con 10 filas y 5 columnas
        
        for(int i=0; i<10; i++) { //Ciclos anidados para recorrer el arreglo
            
            for(int j=0; j<5; j++) {
                
                array[i][j] = new JTextField(); //Se inicia la posición del arreglo
                
                array[i][j].setEditable(false); //Se indica que cada JTextField será no editable
                
                array[i][j].setBackground(Color.WHITE); //Se indica que los JTextField serán blancos
                
                jPanel4.add(array[i][j]); //Se agrega cada objeto del arreglo al jPanel4
                
            }
            
        }
        
        filas = new JTextField[10];
        
        for(int i=0; i<10; i++) {
            
            filas[i] = new JTextField(5); //Se inicia el JTextField y se le da un tamaño de 5
            
            filas[i].setEditable(false); //Se indica que los JTextField no serán editables
            
            filas[i].setBackground(Color.YELLOW); //Se le pone color amarillo a los JTextField
            
            jPanel1.add(filas[i]); //Se agregan los JTextField al jPanel1
            
        }
        
        columnas = new JTextField[5];
        
        for(int i=0; i<5; i++) {
            
            columnas[i] = new JTextField(); //Se inicia el JTextField y se le da un tamaño de 5
            
            columnas[i].setEditable(false); //Se indica que los JTextField no serán editables
            
            columnas[i].setBackground(Color.CYAN); //Se le pone color CYAN a los JTextField
            
            jPanel5.add(columnas[i]); //Se agregan los JTextField al jPanel2
            
        }
        
        JTextField vacio = new JTextField(5); //Usado para rellenar el ultimo espacio y quede simetrico
        
        vacio.setVisible(true);
        
        vacio.setEditable(false);
        
        vacio.setBackground(getBackground());
        
        jPanel2.add(vacio, BorderLayout.EAST);
        
        met = new Metodos(); //Variable que se usará para llamar los métodos
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(10, 1));
        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.GridLayout(1, 5));
        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jButton1.setText("LLENAR ARREGLO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setPreferredSize(new java.awt.Dimension(500, 350));
        jPanel4.setLayout(new java.awt.GridLayout(10, 5));
        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        met.llenarArreglo(array); //Se llama al método y se le pasa el arreglo
        
        met.contar(array, filas, columnas); //Se llama al método para contar los 0
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private JTextField[][] array; //Declaración de arreglo bidimensional
    
    private JTextField[] filas; //Arreglo que contiene los JTextField para indicar los 0 de las filas
    
    private JTextField[] columnas; //Arreglo que contiene los JTextField para indicar los 0 de las columnas
    
    private Metodos met;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
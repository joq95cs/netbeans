package analizadorlexico;

import javax.swing.*;

import java.awt.*;

import java.io.*;

import jflex.*;

public class Frame extends javax.swing.JFrame {

    public Frame () {
        
        initComponents();
        
        setSize(500, 350);
        
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        setLocation(w/2 - getWidth()/2, h/2 - getHeight()/2);
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador Léxico");

        jLabel1.setText("Ruta");
        jPanel1.add(jLabel1);

        jTextField1.setText("C:/Users/joqle/Desktop/Codigo.txt");
        jPanel1.add(jTextField1);

        jButton1.setText("Analizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            
            BufferedReader br = new BufferedReader(new FileReader(new File(jTextField1.getText())));
            
            Lexer lexer = new Lexer(br);
            
            while(true) {
                
                Cadena cadena = lexer.nextToken();
                
                if(cadena == null) {
                    
                    jTextArea1.append("FIN");
                    
                    break;
                    
                }
                
                jTextArea1.append(cadena.getDatos() + "\n\n");
                
            }
            
            br.close();
            
        } catch(IOException e) {}
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                
                while(true) {
                    
                    String opcion = JOptionPane.showInputDialog(null, "1) Generar\n2) Ejecutar\n3) Salir", "Elija una opción", JOptionPane.QUESTION_MESSAGE);
                      
                    if(opcion == null) {
                        
                        break;
                        
                    } else if(opcion.equals("1")) {
                        
                        Main.generate(new File("src/analizadorlexico/Lexer.flex"));
                        
                        break;
                        
                    } else if(opcion.equals("2")) {
                        
                        new Frame().setVisible(true);
                        
                        break;
                        
                    } else if(opcion.equals("3")) {
                        
                        break;
                        
                    } else {
                        
                        JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                    
                }
                
            }
            
        });
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
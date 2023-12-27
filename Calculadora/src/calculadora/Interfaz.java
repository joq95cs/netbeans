package calculadora;

import java.awt.Toolkit;
import javax.swing.*;

public class Interfaz extends javax.swing.JPanel {

    public Interfaz() throws Exception {
        
        initComponents();
        
        f = new Funcionalidad(tf_entrada);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tf_entrada = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        btMas = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        bt4 = new javax.swing.JButton();
        bt5 = new javax.swing.JButton();
        bt6 = new javax.swing.JButton();
        btMen = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        bt7 = new javax.swing.JButton();
        bt8 = new javax.swing.JButton();
        bt9 = new javax.swing.JButton();
        btMul = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btC = new javax.swing.JButton();
        bt0 = new javax.swing.JButton();
        btIgu = new javax.swing.JButton();
        btDiv = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(5, 0));

        jPanel1.setLayout(new java.awt.GridBagLayout());

        tf_entrada.setEditable(false);
        tf_entrada.setBackground(java.awt.Color.white);
        tf_entrada.setText("0");
        tf_entrada.setPreferredSize(new java.awt.Dimension(335, 50));
        jPanel1.add(tf_entrada, new java.awt.GridBagConstraints());

        add(jPanel1);

        bt1.setBackground(java.awt.Color.white);
        bt1.setText("1");
        bt1.setPreferredSize(new java.awt.Dimension(80, 80));
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        jPanel2.add(bt1);

        bt2.setBackground(java.awt.Color.white);
        bt2.setText("2");
        bt2.setPreferredSize(new java.awt.Dimension(80, 80));
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        jPanel2.add(bt2);

        bt3.setBackground(java.awt.Color.white);
        bt3.setText("3");
        bt3.setPreferredSize(new java.awt.Dimension(80, 80));
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        jPanel2.add(bt3);

        btMas.setBackground(java.awt.Color.white);
        btMas.setText("+");
        btMas.setPreferredSize(new java.awt.Dimension(80, 80));
        btMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMasActionPerformed(evt);
            }
        });
        jPanel2.add(btMas);

        add(jPanel2);

        bt4.setBackground(java.awt.Color.white);
        bt4.setText("4");
        bt4.setPreferredSize(new java.awt.Dimension(80, 80));
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });
        jPanel3.add(bt4);

        bt5.setBackground(java.awt.Color.white);
        bt5.setText("5");
        bt5.setPreferredSize(new java.awt.Dimension(80, 80));
        bt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt5ActionPerformed(evt);
            }
        });
        jPanel3.add(bt5);

        bt6.setBackground(java.awt.Color.white);
        bt6.setText("6");
        bt6.setPreferredSize(new java.awt.Dimension(80, 80));
        bt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt6ActionPerformed(evt);
            }
        });
        jPanel3.add(bt6);

        btMen.setBackground(java.awt.Color.white);
        btMen.setText("-");
        btMen.setPreferredSize(new java.awt.Dimension(80, 80));
        btMen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenActionPerformed(evt);
            }
        });
        jPanel3.add(btMen);

        add(jPanel3);

        bt7.setBackground(java.awt.Color.white);
        bt7.setText("7");
        bt7.setPreferredSize(new java.awt.Dimension(80, 80));
        bt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt7ActionPerformed(evt);
            }
        });
        jPanel4.add(bt7);

        bt8.setBackground(java.awt.Color.white);
        bt8.setText("8");
        bt8.setPreferredSize(new java.awt.Dimension(80, 80));
        bt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt8ActionPerformed(evt);
            }
        });
        jPanel4.add(bt8);

        bt9.setBackground(java.awt.Color.white);
        bt9.setText("9");
        bt9.setPreferredSize(new java.awt.Dimension(80, 80));
        bt9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt9ActionPerformed(evt);
            }
        });
        jPanel4.add(bt9);

        btMul.setBackground(java.awt.Color.white);
        btMul.setText("*");
        btMul.setPreferredSize(new java.awt.Dimension(80, 80));
        btMul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMulActionPerformed(evt);
            }
        });
        jPanel4.add(btMul);

        add(jPanel4);

        btC.setBackground(java.awt.Color.white);
        btC.setText("C");
        btC.setPreferredSize(new java.awt.Dimension(80, 80));
        btC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCActionPerformed(evt);
            }
        });
        jPanel5.add(btC);

        bt0.setBackground(java.awt.Color.white);
        bt0.setText("0");
        bt0.setPreferredSize(new java.awt.Dimension(80, 80));
        bt0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt0ActionPerformed(evt);
            }
        });
        jPanel5.add(bt0);

        btIgu.setBackground(java.awt.Color.white);
        btIgu.setText("=");
        btIgu.setPreferredSize(new java.awt.Dimension(80, 80));
        btIgu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIguActionPerformed(evt);
            }
        });
        jPanel5.add(btIgu);

        btDiv.setBackground(java.awt.Color.white);
        btDiv.setText("/");
        btDiv.setPreferredSize(new java.awt.Dimension(80, 80));
        btDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDivActionPerformed(evt);
            }
        });
        jPanel5.add(btDiv);

        add(jPanel5);
    }// </editor-fold>//GEN-END:initComponents

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed

        try {
            f.escribirNumero("1");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_bt1ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed

        try {
            f.escribirNumero("2");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed

        try {
            f.escribirNumero("3");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_bt3ActionPerformed

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed

        try {
            f.escribirNumero("4");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_bt4ActionPerformed

    private void bt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt5ActionPerformed

        try {
            f.escribirNumero("5");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_bt5ActionPerformed

    private void bt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt6ActionPerformed

        try {
            f.escribirNumero("6");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_bt6ActionPerformed

    private void bt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt7ActionPerformed

        try {
            f.escribirNumero("7");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_bt7ActionPerformed

    private void bt8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt8ActionPerformed

        try {
            f.escribirNumero("8");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_bt8ActionPerformed

    private void bt9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt9ActionPerformed

        try {
            f.escribirNumero("9");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_bt9ActionPerformed

    private void bt0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt0ActionPerformed

        try {
            f.escribirNumero("0");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_bt0ActionPerformed

    private void btMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMasActionPerformed

        try {
            f.operacion("+");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btMasActionPerformed

    private void btMenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenActionPerformed

        try {
            f.operacion("-");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btMenActionPerformed

    private void btMulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMulActionPerformed

        try {
            f.operacion("*");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btMulActionPerformed

    private void btDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDivActionPerformed

        try {
            f.operacion("/");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btDivActionPerformed

    private void btIguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIguActionPerformed

        try {
            f.resultado();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btIguActionPerformed

    private void btCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCActionPerformed

        try {
            f.limpiar();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btCActionPerformed

    private Funcionalidad f;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt0;
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JButton bt5;
    private javax.swing.JButton bt6;
    private javax.swing.JButton bt7;
    private javax.swing.JButton bt8;
    private javax.swing.JButton bt9;
    private javax.swing.JButton btC;
    private javax.swing.JButton btDiv;
    private javax.swing.JButton btIgu;
    private javax.swing.JButton btMas;
    private javax.swing.JButton btMen;
    private javax.swing.JButton btMul;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField tf_entrada;
    // End of variables declaration//GEN-END:variables
    
    public static class Marco extends JFrame {
        
        public Marco() throws Exception {
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Establecemos que el programa termine al cerrar la ventana
            setTitle("Calculadora");
            
            //Fijamos las dimensiones de la ventana
            
            //setSize(356, 442);
            setSize(370, 500);
            setResizable(false);
            
            int w = Toolkit.getDefaultToolkit().getScreenSize().width,
                h = Toolkit.getDefaultToolkit().getScreenSize().height;
            
            setLocation(w/2 - getWidth()/2, h/2 - getHeight()/2);
            
            add(new Interfaz());
        }
    }
}

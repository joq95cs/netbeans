package a7_t1_castellanosjoqsan;

import javax.swing.JOptionPane;

public class Marco extends javax.swing.JFrame {

    public Marco() {
        
        c = 1;
        
        initComponents();
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Boletos");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1) 00 - 05", "2) 06 - 15", "3) 16 - 30", "4) 31 - 59", "5) 60 - 99" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jLabel1.setText("Edad");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("Detalles de la compra");

        jLabel3.setText("Cantidad");

        jTextField1.setText("1");

        jButton1.setText("Comprar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cambiar precio del boleto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField1)))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(jList1.getSelectedValue() == "1) 00 - 05") {
            
            JOptionPane.showMessageDialog(null, "Entrada denegada a menores de 5 años", "Error", JOptionPane.ERROR_MESSAGE);
            
        } else if(jList1.getSelectedValue() == "2) 06 - 15") {
                
            jTextArea1.setText(jTextArea1.getText() + "COMPRA " + c + "\n\nCantidad: " + Integer.parseInt(jTextField1.getText()) + "\nPrecio del boleto: " + A7_T1_CastellanosJoqsan.getPrecioBoleto() + "\nDescuento (25%): " + A7_T1_CastellanosJoqsan.getDescuento(25) + "\nTotal: " + A7_T1_CastellanosJoqsan.getTotal(25, Integer.parseInt(jTextField1.getText())) + "\n\n");
            
            c ++;
            
        } else if(jList1.getSelectedValue() == "3) 16 - 30") {
            
            jTextArea1.setText(jTextArea1.getText() + "COMPRA " + c + "\n\nCantidad: " + Integer.parseInt(jTextField1.getText()) + "\nPrecio del boleto: " + A7_T1_CastellanosJoqsan.getPrecioBoleto() + "\nDescuento (10%): " + A7_T1_CastellanosJoqsan.getDescuento(10) + "\nTotal: " + A7_T1_CastellanosJoqsan.getTotal(10, Integer.parseInt(jTextField1.getText())) + "\n\n");
            
            c ++;
            
        } else if(jList1.getSelectedValue() == "4) 31 - 59") {
            
            jTextArea1.setText(jTextArea1.getText() + "COMPRA " + c + "\n\nCantidad: " + Integer.parseInt(jTextField1.getText()) + "\nPrecio del boleto: " + A7_T1_CastellanosJoqsan.getPrecioBoleto() + "\nDescuento (5%): " + A7_T1_CastellanosJoqsan.getDescuento(5) + "\nTotal: " + A7_T1_CastellanosJoqsan.getTotal(5, Integer.parseInt(jTextField1.getText())) + "\n\n");
            
            c ++;
            
        } else {
            
            jTextArea1.setText(jTextArea1.getText() + "Compra " + c + "\n\nCantidad: " + Integer.parseInt(jTextField1.getText()) + "\nPrecio del boleto: " + A7_T1_CastellanosJoqsan.getPrecioBoleto() + "\nDescuento (25%): " + A7_T1_CastellanosJoqsan.getDescuento(25) + "\nTotal: " + A7_T1_CastellanosJoqsan.getTotal(25, Integer.parseInt(jTextField1.getText())) + "\n\n");
            
            c ++;
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        A7_T1_CastellanosJoqsan.setPrecioBoleto();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                
                new Marco().setVisible(true);
                
            }
            
        });
        
    }
    
    private static int c;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
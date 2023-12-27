
package carrera;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class AthleticRaceInterface extends javax.swing.JPanel {

    public AthleticRaceInterface() {
        
        x = 0;
        
        initComponents();
        
        //Dar evento a los botones
        
        EventoClick click = new EventoClick();
        bt_iniciar.addActionListener(click);
        bt_registrar.addActionListener(click);
        bt_reiniciar.addActionListener(click);
        bt_terminar.addActionListener(click);
        
        corredores = new Runner[5]; //Se instancia el arreglo
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf_entrada = new javax.swing.JTextField();
        bt_registrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_corredores = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_resultados = new javax.swing.JTextArea();
        bt_iniciar = new javax.swing.JButton();
        bt_reiniciar = new javax.swing.JButton();
        bt_terminar = new javax.swing.JButton();
        lb_timer = new javax.swing.JLabel();

        setBackground(new Color(204, 226, 245));

        jLabel1.setText("Registrar corredor ");

        bt_registrar.setBackground(java.awt.Color.gray);
        bt_registrar.setForeground(java.awt.Color.white);
        bt_registrar.setText("Registrar");

        jLabel2.setText("Corredores registrados");

        ta_corredores.setEditable(false);
        ta_corredores.setColumns(20);
        ta_corredores.setRows(5);
        jScrollPane2.setViewportView(ta_corredores);

        jLabel3.setText("Resultados");

        ta_resultados.setEditable(false);
        ta_resultados.setColumns(20);
        ta_resultados.setRows(5);
        jScrollPane1.setViewportView(ta_resultados);

        bt_iniciar.setBackground(java.awt.Color.gray);
        bt_iniciar.setForeground(java.awt.Color.white);
        bt_iniciar.setText("Iniciar");

        bt_reiniciar.setBackground(java.awt.Color.gray);
        bt_reiniciar.setForeground(java.awt.Color.white);
        bt_reiniciar.setText("Reiniciar");
        bt_reiniciar.setEnabled(false);

        bt_terminar.setBackground(java.awt.Color.gray);
        bt_terminar.setForeground(java.awt.Color.white);
        bt_terminar.setText("Terminar");

        lb_timer.setText("Cronómetro 00:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tf_entrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_registrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_iniciar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_reiniciar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_terminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_timer)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_registrar))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lb_timer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_iniciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_reiniciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_terminar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void registrar(String nombre) {
        
        if(x == 5) {
            
            tf_entrada.setText("");
            JOptionPane.showMessageDialog(null, "Carrera llena", "Error", 0);
            return;
        }
        
        if(nombre.isEmpty() || nombre.isBlank()) {
            
            tf_entrada.setText("");
            JOptionPane.showMessageDialog(null, "Nombre vacío", "Error", 0); //Mensaje de error
            return;
        }
        
        //A partir de aquí se validaron las dos restricciones
        
        corredores[x] = new Runner(tf_entrada.getText());   
        JOptionPane.showMessageDialog(null, "No: " + (x+1) + "\nNombre: " + corredores[x].getName() + "\nVelocidad: " + corredores[x].getSpeed(), "Corredor registrado", JOptionPane.INFORMATION_MESSAGE);
        
        
        //Mostrar en text area
        
        ta_corredores.append("" + (x+1) + ". " + corredores[x].getName() + "\n");
        x++; //Incrementar contador
        tf_entrada.setText("");
    }
    
    private void iniciar() {
        
        if(x < 5) {
            
            JOptionPane.showMessageDialog(null, "Corredores faltantes", "Error", 0);
            return;
            
        }
        
        ThreadRunner[] hilos = new ThreadRunner[5];
        
        for(int i=0; i<5; i++) {
            
            hilos[i] = new ThreadRunner(corredores[i].getName(), corredores[i].getSpeed(), ta_resultados);

        }
        
        Arrays.sort(hilos);
        hilos[0].setIniciarTimer(); //Primero inicia el timer
        hilos[4].setDetenerTimer(); //Último detiene el timer
        
        for(ThreadRunner e: hilos) { //Se inicia la carrera
            
            e.start();
        }
        
    }
    
    private void reiniciar() {
        
        tf_entrada.setText("");
        ta_corredores.setText("");
        ta_resultados.setText("");
        corredores = new Runner[5];
        x = 0;
        
        lb_timer.setText("Cronómetro 00:00");
        bt_iniciar.setEnabled(true);
        bt_reiniciar.setEnabled(false);
        ThreadRunner.reiniciarC();
    }
    
    private void terminar() {
        
        System.exit(0);
    }
    
    private Runner[] corredores; //Se crea el arreglo
    private int x; //Contador para el arreglo
    
    private class EventoClick implements ActionListener { //Clase para el evento al hacer clic en los botones
        
        public void actionPerformed(ActionEvent evt) {
            
            if(evt.getSource().equals(bt_registrar)) { //if para identificar el botón presionado
                
                registrar(tf_entrada.getText());
                
            } else if(evt.getSource().equals(bt_iniciar)) {
                
                iniciar();
                
            } else if(evt.getSource().equals(bt_reiniciar)) {
                
                reiniciar();
                
            } else {
                
                terminar();
                
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton bt_iniciar;
    private javax.swing.JButton bt_registrar;
    private static javax.swing.JButton bt_reiniciar;
    private javax.swing.JButton bt_terminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JLabel lb_timer;
    private javax.swing.JTextArea ta_corredores;
    private javax.swing.JTextArea ta_resultados;
    private javax.swing.JTextField tf_entrada;
    // End of variables declaration//GEN-END:variables

    private static Timer timer = null; //Timer para el cronómetro
    
    public static void iniciarTimer() {
        
        timer = new Timer(1000, new ActionListener() {
            
            int segundos = 1;
            
            public void actionPerformed(ActionEvent e) {
                
                if(segundos < 10) {
                    
                    lb_timer.setText("Cronómetro 00:0" + segundos);
                    
                } else {
                    
                    lb_timer.setText("Cronómetro 00:" + segundos);
                } 
                
                segundos++;
            }
        });
        
        timer.start();
    }
    
    public static void detenerTimer() {
        
        timer.stop();
    }
    
    public static void activarReiniciar() {
        
        bt_reiniciar.setEnabled(true);
        bt_iniciar.setEnabled(false);
    }
    
    public static class Marco extends JFrame {
        
        public Marco() {
            
            setSize(500, 420); //Fijamos el tamaño de la ventana
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("Carrera atlética");
            
            int w = Toolkit.getDefaultToolkit().getScreenSize().width;
            int h = Toolkit.getDefaultToolkit().getScreenSize().height;
            
            setLocation(w/2 - getWidth()/2, h/2 - getHeight()/2);
            
            add(new AthleticRaceInterface());
        }
    }
}

package carrera;

import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ThreadRunner extends Thread implements Comparable<ThreadRunner> {
    
    public ThreadRunner(String name, int speed, JTextArea ta_resultados) {
        
        this.name = name;
        this.speed = speed;
        this.ta_resultados = ta_resultados;
        
        iniciarTimer = false;
        detenerTimer = false;
    }
    
    public void run() {
        
        if(iniciarTimer) AthleticRaceInterface.iniciarTimer();
        
        try {
            
            Thread.sleep(speed * 1000);
        } catch (InterruptedException ex) {
            
            ex.printStackTrace();
        }
        
        ta_resultados.append(c + ". " + name + " - Tiempo: " + speed + " segundos\n");
        c++;
        
        if(detenerTimer) {
            
            try {
                
                Thread.sleep(1000); //1 segundo de ajuste en el timer por la utilización de hilos
            } catch (InterruptedException ex) {
                
                ex.printStackTrace();
            }
            
            AthleticRaceInterface.detenerTimer();
            JOptionPane.showMessageDialog(null, new StringTokenizer(ta_resultados.getText(), "\n").nextToken() + "\n\n" + "Duración de la carrera: " + speed + " segundos", "Carrera terminada", JOptionPane.WARNING_MESSAGE);
            AthleticRaceInterface.activarReiniciar();
        }
    }
    
    public int compareTo(ThreadRunner otro) {
        
        if(this.speed < otro.getSpeed()) {
            
            return -1;
            
        } else if(this.speed > otro.getSpeed()) {
            
            return 1;
            
        }
        
        return 0;
    }
    
    public int getSpeed() {
        
        return speed;
    }
    
    public void setDetenerTimer() {
        
        detenerTimer = true;
    }
    
    public void setIniciarTimer() {
        
        iniciarTimer = true;
    }
    
    public static void reiniciarC() {
        
        c = 1;
    }
    
    private String name;
    private int speed;
    private JTextArea ta_resultados;
    
    private boolean iniciarTimer;
    private boolean detenerTimer;
    
    private static int c = 1;
}

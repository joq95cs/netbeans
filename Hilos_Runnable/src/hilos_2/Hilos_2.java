package hilos_2;

import java.util.concurrent.*;

public class Hilos_2 {
    
    public static void main(String[] args) {
        
        Marco m = new Marco();
        
        m.setVisible(true);
        
        Tarea1 t1 = new Tarea1();
        
        Tarea2 t2 = new Tarea2();
        
        ExecutorService ejecutor = Executors.newCachedThreadPool();
        
        ejecutor.submit(t1);
        
        ejecutor.submit(t2);
        
    }
    
}

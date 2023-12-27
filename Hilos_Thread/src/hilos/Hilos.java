package hilos;

public class Hilos {

    public static void main(String[] args) {
        
        Marco m = new Marco();
        
        m.setVisible(true);
        
        Hilo1 h1 = new Hilo1();
        
        Hilo2 h2 = new Hilo2();
        
        h1.start();
        
        h2.start();
        
    }
    
}

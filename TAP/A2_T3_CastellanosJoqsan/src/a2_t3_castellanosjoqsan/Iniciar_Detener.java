package a2_t3_castellanosjoqsan;

public class Iniciar_Detener {
    
    public static void iniciarHilos() {
        
        h1 = new Hilo1();
        
        h1.start();
        
        h2 = new Hilo2();
        
        h2.start();
        
        h3 = new Hilo3();
        
        h3.start();
        
        System.out.println("Hilos iniciados");
        
        System.out.println();
        
        Lamina.bt1.setEnabled(false);
        
        Lamina.bt2.setEnabled(true);
        
    }
    
    public static void detenerHilos() {
        
        h1.stop();
        
        h2.stop();
        
        h3.stop();
        
        System.out.println("Hilos detenidos");
        
        System.out.println();
        
        Lamina.bt1.setEnabled(true);
        
        Lamina.bt2.setEnabled(false);
        
    }
    
    public static double n1;
    
    public static double n2;
    
    public static boolean listo;
    
    private static Hilo1 h1;
    
    private static Hilo2 h2;
    
    private static Hilo3 h3;
    
}
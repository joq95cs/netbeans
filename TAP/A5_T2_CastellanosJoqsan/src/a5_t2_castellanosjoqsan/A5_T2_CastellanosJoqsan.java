package a5_t2_castellanosjoqsan;

public class A5_T2_CastellanosJoqsan {

    public static void main(String[] args) {
        
        new Thread() {
            
            public void run() {
                
                Metodos.m.setVisible(true);
                
            }
            
        }.start();
        
    }
    
}
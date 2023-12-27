package hilosoperaciones;

public class HilosOperaciones {

    public static void main(String[] args) {

        Ventana v = new Ventana();
        v.setVisible(true);
        
        Thread hSum = new Thread(new Suma());
        Thread hRes = new Thread(new Resta());
        Thread hMul = new Thread(new Multiplicacion());
        Thread hDiv = new Thread(new Division());
        
        hSum.start();
        hRes.start();
        hMul.start();
        hDiv.start();
        
    }
    
}

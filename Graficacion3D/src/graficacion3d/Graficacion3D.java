package graficacion3d;

public class Graficacion3D {

    public static void main(String[] args) {
        
        Marco m = new Marco();
        
        Panel p = new Panel();

        m.add(p);

        m.setVisible(true);

        p.iniciarPG();
            
    }
    
}

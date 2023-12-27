package calculadora;

public class Main {

    public static void main(String[] args) {
        
        try {
            new Interfaz.Marco().setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
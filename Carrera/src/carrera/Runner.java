
package carrera;

public class Runner { //Clase encapsulada
    
    public Runner(String name) {
        
        this.name = name;
        speed = (int)Math.round(Math.random() * 30);
    }
    
    public String getName() {
        
        return name;
    }
    
    public int getSpeed() {
        
        return speed;
    }
    
    private String name; //Campos encapsulados
    private int speed;
}
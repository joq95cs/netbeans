package obtenervectorresultante;

public class Vertice {
    
    public Vertice(double x, double y, double z) {
        
        this.x = x;
        
        this.y = y;
        
        this.z = z;
        
    }
    
    public static void iniciarMatrizRotacion() {
        
        matrizRotacion = new double[3][3];
        
        matrizRotacion[0][0] = 0; //x
        
        matrizRotacion[0][1] = -1; //y
        
        matrizRotacion[0][2] = 0; //z
        
        matrizRotacion[1][0] = 1; //x
        
        matrizRotacion[1][1] = 0; //y
        
        matrizRotacion[1][2] = 0; //z
        
        matrizRotacion[2][0] = 0; //x
        
        matrizRotacion[2][1] = 0; //y
        
        matrizRotacion[2][2] = 1; //z
        
    }
    
    public static void iniciarMatrizTraslacion(double tx, double ty) {
        
        matrizTraslacion = new double[3][3];
        
        matrizTraslacion[0][0] = 1; //x
        
        matrizTraslacion[0][1] = 0; //y
        
        matrizTraslacion[0][2] = 0; //z
        
        matrizTraslacion[1][0] = 0; //x
        
        matrizTraslacion[1][1] = 1; //y
        
        matrizTraslacion[1][2] = 0; //z
        
        matrizTraslacion[2][0] = tx; //x
        
        matrizTraslacion[2][1] = ty; //y
        
        matrizTraslacion[2][2] = 1; //z
        
    }
    
    public static void iniciarMatrizEscalado(double sx, double sy) {
        
        matrizEscalado = new double[3][3];
        
        matrizEscalado[0][0] = sx; //x
        
        matrizEscalado[0][1] = 0; //y
        
        matrizEscalado[0][2] = 0; //z
        
        matrizEscalado[1][0] = 0; //x
        
        matrizEscalado[1][1] = sy; //y
        
        matrizEscalado[1][2] = 0; //z
        
        matrizEscalado[2][0] = 0; //x
        
        matrizEscalado[2][1] = 0; //y
        
        matrizEscalado[2][2] = 1; //z
        
    }
    
    public static double[][] getMatrizRotacion() {
        
        return matrizRotacion;
        
    }
    
    public static double[][] getMatrizTraslacion() {
        
        return matrizTraslacion;
        
    }
    
    public static double[][] getMatrizEscalado() {
        
        return matrizEscalado;
        
    }
    
    public double getX() {
        
        return x;
        
    }
    
    public double getY() {
        
        return y;
        
    }
    
    public double getZ() {
        
        return z;
        
    }
    
    private double x, y, z;
    
    private static double[][] matrizRotacion, matrizTraslacion, matrizEscalado;
    
}

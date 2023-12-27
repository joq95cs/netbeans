package mexbank;

public class CuentaBase {
    
    public CuentaBase(double montoApertura) {
        
        saldo = montoApertura;
        
    }
    
    public double montoActual() {
        
        return saldo;
        
    }
    
    public void depositar(double cantidad) {
        
        saldo += cantidad;
        
    }
    
    protected double saldo;
    
}

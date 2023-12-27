package mexbank;

public class CuentaAhorro extends CuentaBase {
    
    public CuentaAhorro(double montoApertura) {
        
        super(montoApertura);
        
    }
    
    public void invertir(double cantidad) {
        
        saldo += cantidad*0.1;
        
    }
    
}

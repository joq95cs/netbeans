package mexbank;

public class TarjetaDebito extends CuentaBase {
    
    public TarjetaDebito(double montoApertura) {
        
        super(montoApertura);
        
    }
    
    public void retirar(double cantidad) {
        
        saldo -= cantidad;
        
    }
    
}

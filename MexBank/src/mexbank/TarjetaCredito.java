package mexbank;

public class TarjetaCredito extends CuentaBase {
    
    public TarjetaCredito(double montoAperura) {
        
        super(montoAperura*-1); //Al multiplicar por -1, el saldo de la tarje de crédito queda en negativo
        
        intereses = 0;
        
    }
    
    public void sumaInteres(double cantidad) {
        
        saldo += cantidad + cantidad*0.15;
        
        
    }
    
    public void depositar(double cantidad) {
        
        saldo -= cantidad;
        
    }
    
    private double intereses;    
}

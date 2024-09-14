package a7_t1_castellanosjoqsan;

import javax.swing.JOptionPane;

public class A7_T1_CastellanosJoqsan {

    public static void main(String[] args) {
        
        setPrecioBoleto();
        
        new Marco().show();
        
    }
    
    public static double getPrecioBoleto() {
        
        return precioBoleto;
        
    }
    
    public static double getDescuento(int d) {
        
        return precioBoleto * d/100;
        
    }
    
    public static double getTotal(int d, int c) {
        
        return (precioBoleto - getDescuento(d)) * c;
        
    }
    
    public static void setPrecioBoleto() {
        
        precioBoleto = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese precio del boleto", "Registro de precio", JOptionPane.QUESTION_MESSAGE));
        
    }
    
    private static double precioBoleto;
    
}
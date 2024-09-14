package a3_t2_castellanosjoqsan;

import libreriacastellanos.*;

public class Metodos {
    
    public static void combo(int i) {
        
        switch (i) {
            
            case 0:
                
                m.getEtiquetas()[0].setVisible(false);
                
                m.getEtiquetas()[0].setText("No. límite");
                
                m.getCampos()[0].setVisible(false);
                
                m.getEtiquetas()[1].setVisible(true);
                
                m.getCampos()[1].setVisible(true);
                
                break;
                
            case 1:
                
                m.getEtiquetas()[0].setVisible(true);
                
                m.getEtiquetas()[0].setText("No. límite");
                
                m.getCampos()[0].setVisible(true);
                
                m.getEtiquetas()[1].setVisible(false);
                
                m.getCampos()[1].setVisible(false);
                
                break;
                
            case 2:
                
                m.getEtiquetas()[0].setVisible(true);
                
                m.getEtiquetas()[0].setText("Valor x");
                
                m.getCampos()[0].setVisible(true);
                
                m.getEtiquetas()[1].setVisible(true);
                
                m.getCampos()[1].setVisible(true);
                
                break;
                
            default:
                
                m.getEtiquetas()[0].setVisible(true);
                
                m.getEtiquetas()[0].setText("Número");
                
                m.getCampos()[0].setVisible(true);
                
                m.getEtiquetas()[1].setVisible(false);
                
                m.getCampos()[1].setVisible(false);
                
                break;
                
        }
        
    }
    
    public static void boton(int i) throws SeriesException {
        
        switch(i) {
            
            case 0:
                
                m.getArea().setText(lc.getSerieFibonacci(Double.parseDouble(m.getCampos()[1].getText())));
                
                break;
                
            case 1:
                
                m.getArea().setText(lc.getNumerosPrimos(Double.parseDouble(m.getCampos()[0].getText())));
                
                break;
                
            case 2:
                
                m.getArea().setText(lc.getAproximacionSeno(Double.parseDouble(m.getCampos()[0].getText()), Double.parseDouble(m.getCampos()[1].getText())));
            
                break;
                
            case 3:
                
                m.getArea().setText(lc.getFactorial(Double.parseDouble(m.getCampos()[0].getText())));
                
        }
        
    }
    
    public static void setMarco(Marco m) {
        
        Metodos.m = m;
        
    }
    
    private static Marco m;
    
    private static LibreriaCastellanos lc = new LibreriaCastellanos();
    
}
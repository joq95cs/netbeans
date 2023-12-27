package analizadorlexico;

public class Cadena {
    
    public Cadena(int numero, String token, String lexema, int linea, int columna) {
        
        this.numero = numero;
        
        this.token = token;
        
        this.lexema = lexema;
        
        this.linea = linea;
        
        this.columna = columna;
        
    }
    
    public String getDatos() {
        
        return "Número: " + numero + "\nToken: " + token + "\nLexema: " + lexema + "\nLínea: " + linea + "\nColumna: " +  columna;
        
    }
    
    private String token, lexema;
    
    private int numero, linea, columna;
    
}
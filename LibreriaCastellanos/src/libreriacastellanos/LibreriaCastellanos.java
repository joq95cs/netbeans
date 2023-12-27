package libreriacastellanos;

public class LibreriaCastellanos {
    
    public String getSerieFibonacci(double n) throws SeriesException {
        
        n = Math.round(n);
        
        if(n == 1) {
            
            return "1";
            
        } else if(n > 1) {
            
            double a = 0;
        
            double b = 1;
        
            double c = 0;
        
            String serie = "" + (a + b);
            
            for(double i = 1; i < n; i ++) {
                
                c = a + b;
                
                serie += ", " + c;
                
                a = b;
                
                b = c;
                
            }
            
            return serie;
            
        }
        
        throw new SeriesException("Número de iteraciones no válido");
        
    }
    
    public String getNumerosPrimos(double n) throws SeriesException {
        
        n = Math.round(n);
        
        if(n == 1) {
            
            return "1";
            
        } else if(n > 1) {
            
            boolean primo = true;
            
            String serie = "1";
                
            for(double i = 3; i < n; i ++) {
            
                for(double j = 2; j < (i - 1); j ++) {
                
                    if(i % j == 0) {
                        
                        primo = false;
                    
                    }
                
                }
                
                if(primo) {
                    
                    serie += ", " +  i;
                    
                }
                
                primo = true;
            
            }
            
            return serie;
            
        }
        
        throw new SeriesException("Número límite no válido");
        
    }
    
    public String getFactorial(double n) throws SeriesException {
        
        n = Math.round(n);
        
        if(n == 0) {
            
            return "0! = 1";
            
        } else if(n == 1) {
            
            return "1! = 1";
            
        } else if(n > 1) {
            
            String serie = "" + n + "!: " + "1 x 2";
            
            for(double i = 3; i <= n; i ++) {
                
                serie += " x " + i;
                
            }
            
            serie += " = " + factorial(n);
            
            return serie;
            
        }
        
        throw new SeriesException("Número no válido");
    
    }
    
    public String getAproximacionSeno(double x, double n) throws SeriesException {
        
        n = Math.round(n);
        
        if(n > 0) {
            
            if(n == 1) {
                
                return "sen(x) = " + x;
                
            }
            
            double i = 1, a = 0;

            char signo = 'a';

            String serie = "sen(x) =";

            for(double j = 0; j < n; j ++) {

                if(signo == 'a') {

                    a += Math.pow(x, i) / factorial(i);

                    if(j != 0) {

                        serie += " +";

                    }

                    serie += " " + Math.pow(x, i) / factorial(i);

                } else {

                    a -= Math.pow(x, i) / factorial(i);

                    serie += " - " + Math.pow(x, i) / factorial(i);

                }

                i += 2;

                if(signo == 'a') {

                    signo = 'b';

                } else {

                    signo = 'a';

                }

            }

            serie += " = " + a;

            return serie;
            
        }
        
        throw new SeriesException("Número de iteraciones no válido");
        
    }
    
    private double factorial(double n) throws SeriesException {
        
        n = Math.round(n);
        
        if(n == 0) {
            
            return 1;
            
        } else if(n == 1) {
            
            return 1;
            
        } else if(n > 1) {
            
            double f = 2;
            
            for(double i = 3; i <= n; i ++) {
                
                f *= i;
                
            }
            
            return f;
            
        }
        
        throw new SeriesException("Número no válido");
        
    }
    
}
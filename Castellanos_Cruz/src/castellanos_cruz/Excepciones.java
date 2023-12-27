package castellanos_cruz;

public class Excepciones {
    
    public static class BaseExistente extends Exception {
        
        public BaseExistente() {
            
            super("Base de datos ya existente");
            
        }
        
    }
    
    public static class BaseNoExistente extends Exception {
        
        public BaseNoExistente() {
            
            super("Base de datos no existente");
            
        }
        
    }
    
    public static class NombreBaseVacio extends Exception {
        
        public NombreBaseVacio() {
            
            super("Nombre de la base de datos vacío");
            
        }
        
    }
    
    public static class RegistroBasesVacio extends Exception {
        
        public RegistroBasesVacio() {
            
            super("Registro de bases de datos vacío");
            
        }
        
    }
    
    public static class NombreTablaVacio extends Exception {
        
        public NombreTablaVacio() {
            
            super("Nombre de la tabla vacío");
            
        }
        
    }
    
    public static class TablaExistente extends Exception {
        
        public TablaExistente() {
            
            super("Tabla ya existente");
            
        }
        
    }
    
    public static class TablaNoExistente extends Exception {
        
        public TablaNoExistente() {
            
            super("Tabla no existente");
            
        }
        
    }
    
    public static class BaseVacia extends Exception {
        
        public BaseVacia() {
            
            super("Base de datos vacía");
            
        }
        
    }
    
    public static class NombreCampoVacio extends Exception {
        
        public NombreCampoVacio() {
            
            super("Nombre del campo vacío");
            
        }
        
    }
    
    public static class TablaVacia extends Exception {
        
        public TablaVacia() {
            
            super("Tabla vacía");
            
        }
        
    }
    
    public static class RegistroNoExistente extends Exception {
        
        public RegistroNoExistente() {
            
            super("Registro no existente");
            
        }
        
    }
    
    public static class ClaveVacia extends Exception {
        
        public ClaveVacia() {
            
            super("Clave vacía");
            
        }
        
    }
    
    public static class LongitudValorNoValida extends Exception {
        
        public LongitudValorNoValida() {
            
            super("Longitud del valor no válida");
            
        }
        
    }
    
    public static class LongitudCampoNoValida extends Exception {
        
        public LongitudCampoNoValida() {
            
            super("Longitud del campo no válida");
            
        }
        
    }
    
    public static class ValorCampoVacio extends Exception {
        
        public ValorCampoVacio() {
            
            super("Valor del campo vacío");
            
        }
        
    }
    
}
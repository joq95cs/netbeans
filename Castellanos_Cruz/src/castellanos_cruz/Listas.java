package castellanos_cruz;

public class Listas {
    
    public static class ListaCampos {
        
        public ListaCampos() {
            
            inicio = fin = null;
            
        }
        
        public void agregarNodo(String nombre, String tipo, int longitud) {
            
            if(listaVacia()) {
                
                inicio = fin = new NodoCampos(nombre, tipo, longitud);
                
            } else {
                
                NodoCampos nodo = new NodoCampos(nombre, tipo, longitud);
                
                fin.siguiente = nodo;
                
                fin = nodo;
                
            }
            
        }
        
        public int getLongitud() {
            
            int i = 0;
            
            for(NodoCampos nc=inicio; nc!=null; nc=nc.siguiente) {
                
                i ++;
                
            }
            
            return i;
            
        }
        
        private boolean listaVacia() {
            
            return inicio == null;
            
        }
        
        public NodoCampos inicio, fin;
        
    }
    
    public static class NodoCampos {
        
        public NodoCampos(String nombre, String tipo, int longitud) {
            
            this.nombre = nombre;
            
            this.tipo = tipo;
            
            this.longitud = longitud;
            
            siguiente = null;
            
            abajo = null;
            
        }
        
        public void setSiguiente(NodoCampos siguiente) {
            
            this.siguiente = siguiente;
            
        }
        
        public void setAbajo(NodoDatos abajo) {
            
            this.abajo = abajo;
            
        }
        
        public String getNombre() {
            
            return nombre;
            
        }
        
        public String getTipo() {
            
            return tipo;
            
        }
        
        public int getLongitud() {
            
            return longitud;
            
        }
        
        public NodoCampos siguiente;
        
        public NodoDatos abajo;
        
        private String nombre, tipo;
        
        private int longitud;
        
    }
    
    public static class ListaDatos {
        
        public ListaDatos() {
            
            inicio = fin = temporal1 = temporal2 = null;
            
        }
        
        public void agregarNodo(String dato) {
            
            if(listaVacia()) {
                
                inicio = fin = new NodoDatos(dato);
                
            } else {
                
                NodoDatos nodo = new NodoDatos(dato);
                
                fin.siguiente = nodo;
                
                fin = nodo;
                
            }
            
        }
        
        public void nuevaFila(String dato) {
            
            fin = temporal2 = new NodoDatos(dato);
            
        }
        
        public int getLongitud() {
            
            int i = 0;
            
            for(NodoDatos n=inicio; n!=null; n=n.siguiente) {
                
                i ++;
                
            }
            
            return i;
            
        }
        
        private boolean listaVacia() {
            
            return inicio == null;
            
        }
        
        public NodoDatos inicio, fin, temporal1, temporal2;
        
    }
    
    public static class NodoDatos {
        
        public NodoDatos(String dato) {
            
            this.dato = dato;
            
            siguiente = abajo = null;
            
        }
        
        public void setDato(String dato) {
            
            this.dato = dato;
            
        }
        
        public String getDato() {
            
            return dato;
            
        }
        
        public NodoDatos siguiente, abajo;
        
        private String dato;
        
    }
    
    public static void reiniciarClave() {
        
        clavePrimaria = 1;
        
    }
    
    public static void recargarClave() {
        
        for(NodoDatos n=lista2.inicio; n!=null; n=n.abajo) {
            
            if(n.abajo == null) {
                
                clavePrimaria = Integer.parseInt(n.getDato()) + 1;
                
            }
            
        }
        
    }
    
    public static ListaCampos lista1;
    
    public static ListaDatos lista2;
    
    public static int clavePrimaria = 1;
    
}
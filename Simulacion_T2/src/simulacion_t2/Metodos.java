package simulacion_t2;

import javax.swing.*;

import javax.swing.table.*;

public class Metodos {
    
    public JTable cuadradosMedios(int n, int n0) throws Exception {
        
        if(n0 < 0) {
            
            throw new Exception("n0 no es positivo");
            
        }
        
        int e = (n0 + "").length();
        
        if(e % 2 != 0) {
            
            throw new Exception("e no es par");
            
        }
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("i");
        
        modelo.addColumn("Número cuadrado");
        
        modelo.addColumn("ni");
        
        modelo.addColumn("ri");
        
        long ni = n0;
        
        for(int i=1; i<=n; i++) {
            
            String cuadrado = ((long)Math.pow(ni, 2)) + "";
            
            if(cuadrado.length() != 2 * e) {
                
                int c = 2 * e - cuadrado.length();
                
                String aux = "";
                
                for(int j=0; j<c; j++) {
                    
                    aux += "0";
                    
                }
                
                aux += cuadrado;
                
                cuadrado = aux;
                
            }
            
            ni = Long.parseLong(cuadrado.substring(e/2, e/2+e));
            
            double ri = ni / Math.pow(10, e);
            
            String[] fila = new String[4];
            
            fila[0] = i + "";
            
            fila[1] = cuadrado;
            
            fila[2] = ni + "";
            
            fila[3] = ri + "";
            
            modelo.addRow(fila);
            
        }
        
        return new JTable(modelo);
        
    }
    
    public JTable aditivo(int n) throws Exception {
        
        int k = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese k", "Método: Aditivo", JOptionPane.QUESTION_MESSAGE));
        
        if(k < 10) {
            
            throw new Exception("k no es mayor o igual a 10");
            
        }
        
        int n0 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese n0", "Método: Cuadrados medios", JOptionPane.QUESTION_MESSAGE));
        
        int e = (n0 + "").length();
        
        if(e < 3) {
            
            throw new Exception("e no es mayor o igual a 3");
            
        }
        
        JTable tabla = cuadradosMedios(k, n0);
        
        long[] numeros = new long[k];
        
        for(int i=0; i<k; i++) {
            
            numeros[i] = Long.parseLong((String)tabla.getValueAt(i, 2));
            
        }
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("i");
        
        modelo.addColumn("Suma");
        
        modelo.addColumn("ni");
        
        modelo.addColumn("ri");
        
        long ni = 0;
        
        int p = 1;
        
        for(int i=1; i<=n; i++) {
            
            String suma = "";
            
            if(i == 1) {
                
                suma = numeros[numeros.length-1] + " + " + numeros[0] + " = " + (numeros[numeros.length-1] + numeros[0]);
                
                ni = numeros[numeros.length-1] +  numeros[0];
                
            } else {
                
                suma = ni + " + " + numeros[p] + " = " + (ni + numeros[p]);
                
                String aux = (ni + numeros[p]) + "";
                
                if(aux.length() > e) {
                    
                    ni = Long.parseLong(aux.substring(aux.length() - e));
                    
                } else {
                    
                    ni = ni + numeros[p];
                    
                }
                
                p ++;
                
                if(p == numeros.length) {
                    
                    p = 0;
                    
                }
                
            }
            
            double ri = ni / Math.pow(10, e);
            
            String[] fila = new String[4];
            
            fila[0] = i + "";
            
            fila[1] = suma;
            
            fila[2] = ni + "";
            
            fila[3] = ri + "";
            
            modelo.addRow(fila);
            
        }
        
        return new JTable(modelo);
        
    }
    
    public JTable mixto(int n, int n0) throws Exception {
        
        if(n0 < 0) {
            
            throw new Exception("n0 no es positivo");
            
        }
        
        int e = (n0 + "").length();
        
        if(e < 3) {
            
            throw new Exception("e no es mayor o igual a 3");
            
        }
        
        int c = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese c", "Método: Mixto", JOptionPane.QUESTION_MESSAGE));
        
        if(c < 0) {
            
            throw new Exception("c no es positivo");
            
        }
        
        if(c % 2 == 0) {
            
            throw new Exception("c no es impar");
            
        }
        
        if((c + "").length() > e) {
            
            throw new Exception("Longitud de c no es menor o igual a e");
            
        }
        
        int l = (int)Math.round(Math.sqrt(Math.pow(10, 3)) + 1);
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("i");
        
        modelo.addColumn("(ni-1)l + c");
        
        modelo.addColumn("ni");
        
        modelo.addColumn("ri");
        
        long ni = n0;
        
        for(int i=1; i<=n; i++) {
            
            String[] fila = new String[4];
            
            fila[0] = i + "";
            
            fila[1] = ni + "(" + l + ") + " + c + " = " + (ni * l + c);
            
            String aux = ((long)(ni * l + c)) + "";
            
            if(aux.length() > e) {
                
                ni = Integer.parseInt(aux.substring(aux.length() - e));
                
            } else {
                
                ni = Integer.parseInt(aux);
                
            }
            
            double ri = ni / Math.pow(10, e);
            
            fila[2] = ni + "";
            
            fila[3] = ri + "";
            
            modelo.addRow(fila);
            
        }
        
        return new JTable(modelo);
        
    }
    
    public JTable combinado(int n) throws Exception {
        
        int metodo = Integer.parseInt(JOptionPane.showInputDialog(null, "1) Cuadrados medios\n2) Aditivo\n3) Mixto", "Elija un método para generar tabla", JOptionPane.QUESTION_MESSAGE));
        
        if(metodo != 1 && metodo != 2 && metodo != 3) {
            
            throw new Exception("Opción no válida");
            
        }
        
        int k = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese k", "Método: Combinado", JOptionPane.QUESTION_MESSAGE));
        
        
        if(k < 10) {
            
            throw new Exception("k no es mayor o igual a 10");
            
        }
        
        JTable tabla = null;
        
        switch(metodo) {
            
            case 1:
                
                int n0 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese n0", "Método: Cuadrados medios", JOptionPane.QUESTION_MESSAGE));
                
                if((n0 + "").length() < 3) {
                    
                    throw new Exception("e no es mayor o igual a 3");
                    
                }
                
                tabla = cuadradosMedios(k+n+50, n0);
                
                break;
                
            case 2:
                
                tabla = aditivo(k+n+50);
                
                break;
                
            default:
                
                n0 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese n0", "Método: Mixto", JOptionPane.QUESTION_MESSAGE));
                
                tabla = mixto(k+n+50, n0);
                
        }
        
        long[] numeros = new long[k], repuestos = new long[50], aleatorios = new long[n];
        
        for(int i=0; i<k; i++) {
                    
            numeros[i] = Long.parseLong(tabla.getValueAt(i, 2).toString());
                    
        }
        
        for(int i=0; i<n; i++) {
            
            aleatorios[i] = Long.parseLong(tabla.getValueAt(i+k, 2).toString());
            
        }
        
        for(int i=0; i<50; i++) {
            
            repuestos[i] = Long.parseLong(tabla.getValueAt(i+k+n, 2).toString());
            
        }
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("i");
        
        modelo.addColumn("j = (int)(rnd * (k-1) + 15)");
        
        modelo.addColumn("ni");
        
        modelo.addColumn("ri");
        
        int x = 0, y = 0;
        
        for(int i=1; i<=n; i++) {
            
            double rnd = aleatorios[x] / Math.pow(10, (aleatorios[x] + "").length());
            
            x ++;
            
            int j = (int)(rnd * (k-1) + 1.5);
            
            long ni = numeros[j-1];
            
            numeros[j-1] = repuestos[y];
            
            y ++;
            
            double ri = ni / Math.pow(10, (ni + "").length());
            
            String[] fila = new String[4];
            
            fila[0] = i + "";
            
            fila[1] = rnd + "(" + (k-1) + ")" + " + " + 1.5 + " = " + j;
            
            fila[2] = ni + "";
            
            fila[3] = ri + "";
            
            modelo.addRow(fila);
            
        }
        
        return new JTable(modelo);
        
    }
    
}
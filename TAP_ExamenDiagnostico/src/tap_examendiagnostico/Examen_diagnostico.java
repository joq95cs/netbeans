package tap_examendiagnostico;

import javax.swing.*;

public class Examen_diagnostico {
	
	public static void main(String[] args) {
		
		OperacionesMatematicas objetoOM = new OperacionesMatematicas();
		
		int opcion = Integer.parseInt(JOptionPane.showInputDialog("1) Suma\n2) Resta\n3) Multiplicación\n4) División\n5) Potencia"));
		
		switch(opcion) {
		
		case 1:
			
			JOptionPane.showMessageDialog(null, "Suma: " + objetoOM.sumarN(Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de números a sumar"))));
			
			break;
			
		case 2:
			
			JOptionPane.showMessageDialog(null, "Resta: " + objetoOM.restarN(Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de números a restar"))));
		
			break;
			
		case 3:
			
			JOptionPane.showMessageDialog(null, "Multiplicación: " + objetoOM.multiplicar5(Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de números a multiplicar"))));
			
			break;
			
		case 4:
			
			JOptionPane.showMessageDialog(null, "División: " + objetoOM.dividir2(Double.parseDouble(JOptionPane.showInputDialog("Ingrese numerador")), Double.parseDouble(JOptionPane.showInputDialog("Ingrese denominador"))));
			
			break;
			
		case 5:
			
			JOptionPane.showMessageDialog(null, "Potencia: " + objetoOM.potencia(Double.parseDouble(JOptionPane.showInputDialog("Ingrese base")), Double.parseDouble(JOptionPane.showInputDialog("Ingrese exponente"))));
			
		}
		
		
	}

}

class OperacionesMatematicas {
	
	public double sumarN(int posiciones) {
		
		double[] numeros = fijarArreglos(posiciones);
		
		double suma = numeros[0];
		
		for(int i=1; i<numeros.length; i++) {
			
			suma += numeros[i];
			
		}
		
		return suma;
		
	}
	
	public double restarN(int posiciones) {
		
		double[] numeros = fijarArreglos(posiciones);
		
		double resta = numeros[0];
		
		for(int i=1; i<numeros.length; i++) {
			
			resta -= numeros[i];
			
		}
		
		return resta;
		
	}
	
	public Double multiplicar5(int posiciones)  {
		
		if(posiciones <= 5) {
			
			double[] numeros = fijarArreglos(posiciones);
			
			double multiplicacion = numeros[0];
			
			for(int i=1; i<numeros.length; i++) {
				
				multiplicacion *= numeros[i];
				
			}
			
			return multiplicacion;
			
		} else {
			
			return null;
		}
		
	}
	
	public Double dividir2(double n1, double n2) {
		
		if(n2 != 0) {
			
			double division = n1/n2;
			
			return division;
			
		} else {
			
			return null;
			
		}
		
	}
	
	public double potencia(double b, double e) {
		
		if(e >= 0) {
			
			if(e == 0) {
				
				return 1;
				
			} else {
				
				return b * potencia(b, e-1);
				
			}
			
		}
		
		return b;
		
	}
	
	private double[] fijarArreglos(int posiciones) {
		
		double[] arreglo = new double[posiciones];
		
		for(int i=0; i<arreglo.length; i++) {
			
			arreglo[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese valor " + (i+1)));
			
		}
		
		return arreglo;
		
	}
	
}

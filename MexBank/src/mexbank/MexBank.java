package mexbank;

import javax.swing.JOptionPane;

public class MexBank {

    public static void main(String[] args) {
        
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Abrir cuenta\n2. Salir", "MexBank", JOptionPane.QUESTION_MESSAGE));
        
        switch(opcion) {
            
            case 1:
                
                int opcion2 = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Tarjeta de crédito\n2. Tarjeta de débito\n3. Cuenta de ahorro\n4. Salir", "MexBank", JOptionPane.QUESTION_MESSAGE));
                
                switch(opcion2) {
                    
                    case 1: 
                        
                        int monto = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el monto de apertura", "MexBank", JOptionPane.QUESTION_MESSAGE));
                        TarjetaCredito tc = new TarjetaCredito(monto);
                        
                        int opciontc = 0;
                        
                        do {
                        
                            opciontc = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Consultar saldo\n2. Sumar interés\n3. Hacer abono\n4. Salir", "MexBank", JOptionPane.QUESTION_MESSAGE));

                            switch(opciontc) {

                                case 1:

                                    JOptionPane.showMessageDialog(null, "Saldo actual: "+tc.montoActual(), "MexBank", JOptionPane.INFORMATION_MESSAGE);
                                    break;

                                case 2:

                                    tc.sumaInteres(Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto", "MexBank", JOptionPane.QUESTION_MESSAGE)));
                                    JOptionPane.showMessageDialog(null, "Saldo actual: "+tc.montoActual(), "MexBank", JOptionPane.INFORMATION_MESSAGE);
                                    break;

                                case 3:

                                    tc.depositar(Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto", "MexBank", JOptionPane.QUESTION_MESSAGE)));
                                    JOptionPane.showMessageDialog(null, "Saldo actual: "+tc.montoActual(), "MexBank", JOptionPane.INFORMATION_MESSAGE);
                                    break;

                            }

                            
                        } while(opciontc != 4);
                        
                        break;
                        
                    case 2:
                        
                        int monto2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el monto de apertura", "MexBank", JOptionPane.QUESTION_MESSAGE));
                        TarjetaDebito td = new TarjetaDebito(monto2);
                        
                        int opciontd = 0;
                        
                        do {
                        
                            opciontd = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Consultar saldo\n2. Retirar\n3. Depositar\n4. Salir", "MexBank", JOptionPane.QUESTION_MESSAGE));

                            switch(opciontd) {

                                case 1:

                                    JOptionPane.showMessageDialog(null, "Saldo actual: "+td.montoActual(), "MexBank", JOptionPane.INFORMATION_MESSAGE);
                                    break;

                                case 2:

                                    td.retirar(Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto", "MexBank", JOptionPane.QUESTION_MESSAGE)));
                                    JOptionPane.showMessageDialog(null, "Saldo actual: "+td.montoActual(), "MexBank", JOptionPane.INFORMATION_MESSAGE);
                                    break;

                                case 3:

                                    td.depositar(Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto", "MexBank", JOptionPane.QUESTION_MESSAGE)));
                                    JOptionPane.showMessageDialog(null, "Saldo actual: "+td.montoActual(), "MexBank", JOptionPane.INFORMATION_MESSAGE);
                                    break;

                            }
                            
                        } while(opciontd != 4);
                        
                        break;
                        
                    case 3:
                        
                        int monto3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el monto de apertura", "MexBank", JOptionPane.QUESTION_MESSAGE));
                        CuentaAhorro ca = new CuentaAhorro(monto3);
                        
                        int opcionca = 0;
                        
                        do {
                        
                            opciontd = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Consultar saldo\n2. Invertir\n3. Depositar\n4. Salir", "MexBank", JOptionPane.QUESTION_MESSAGE));

                            switch(opciontd) {

                                case 1:

                                    JOptionPane.showMessageDialog(null, "Saldo actual: "+ca.montoActual(), "MexBank", JOptionPane.INFORMATION_MESSAGE);
                                    break;

                                case 2:

                                    ca.invertir(Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto", "MexBank", JOptionPane.QUESTION_MESSAGE)));
                                    JOptionPane.showMessageDialog(null, "Saldo actual: "+ca.montoActual(), "MexBank", JOptionPane.INFORMATION_MESSAGE);
                                    break;

                                case 3:

                                    ca.depositar(Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto", "MexBank", JOptionPane.QUESTION_MESSAGE)));
                                    JOptionPane.showMessageDialog(null, "Saldo actual: "+ca.montoActual(), "MexBank", JOptionPane.INFORMATION_MESSAGE);
                                    break;

                            }
                            
                        } while(opciontd != 4);
                        
                        break;
                    }
                
                 break;
                 
            case 4:
                
                break;
                 
            case 2:
                
                break;
            
        }
        
    }
    
}

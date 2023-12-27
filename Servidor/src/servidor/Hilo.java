package servidor;

import javax.swing.*;

import java.net.*;

import java.io.*;

public class Hilo extends Thread {
    
    public Hilo() {
        
        recurso = 0;
        
    }
    
    public void run() {
        
        try {
            
            ServerSocket server = new ServerSocket(9999);
            
            while(true) {
                
                Socket socket = server.accept();
                
                if(socket.isConnected()) {
                    
                    DataInputStream flujo_entrada = new DataInputStream(socket.getInputStream());
                    
                    DataOutputStream flujo_salida = new DataOutputStream(socket.getOutputStream());
                    
                    recurso = 1;
                    
                    flujo_salida.writeUTF("Procesando");
                    
                    String mensaje = flujo_entrada.readUTF();
                    
                    Lamina.at.append("Cliente solicita recurso");
                    
                    Lamina.at.append("\nMensaje: " + mensaje);
                    
                    Lamina.at.append("\nRecurso: " + recurso);
                    
                    Lamina.at.append("\nProcesando, recurso bloqueado");
                    
                    Thread.sleep(5000);
                    
                    recurso = 0;
                    
                    Lamina.at.append("\nTerminado, recurso desbloqueado");
                    
                    Lamina.at.append("\nRecurso: " + recurso + "\n\n");
                    
                    flujo_salida.writeUTF("Terminado");
                    
                    flujo_salida.close();
                    
                    flujo_entrada.close();
                    
                }
                
                socket.close();
                
            }
            
        } catch(Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            
        }
        
    }
    
    private int recurso;
    
}

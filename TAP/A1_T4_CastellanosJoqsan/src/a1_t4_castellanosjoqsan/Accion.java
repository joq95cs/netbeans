package a1_t4_castellanosjoqsan;

import javax.swing.*;

import java.awt.event.*;

import java.util.*;

import java.io.*;

class Accion extends AbstractAction {
        
    public Accion(String n, String d) {
        
        putValue(Action.NAME, n);
        
        putValue(Action.SHORT_DESCRIPTION, d);
            
        carpeta = new File("src/Registro/");
            
        iniciarArchivos();
            
    }
    
    public void actionPerformed(ActionEvent e) {
            
        try {
                
            if(getValue(Action.NAME).equals("Guardar (ctrl + G)")) {
                    
                Videojuego vd = new Videojuego();
                    
                if(A1_T4_CastellanosJoqsan.m.l.ctID.getText().equals("") || A1_T4_CastellanosJoqsan.m.l.ctNombre.getText().equals("") || A1_T4_CastellanosJoqsan.m.l.ctDescripcion.getText().equals("") || A1_T4_CastellanosJoqsan.m.l.ctExistencia.getText().equals("") || A1_T4_CastellanosJoqsan.m.l.ctPrecio.getText().equals("") || A1_T4_CastellanosJoqsan.m.l.ctCategoria.getText().equals("")) {
                        
                    throw new CampoVacio();
                        
                }
                    
                if(Integer.parseInt(A1_T4_CastellanosJoqsan.m.l.ctID.getText())<0 || Integer.parseInt(A1_T4_CastellanosJoqsan.m.l.ctExistencia.getText())<0 || Double.parseDouble(A1_T4_CastellanosJoqsan.m.l.ctPrecio.getText())<0){
                        
                    throw new ValorNegativo();
                        
                }
                
                vd.setInformacionVideojuego(Integer.parseInt(A1_T4_CastellanosJoqsan.m.l.ctID.getText()), A1_T4_CastellanosJoqsan.m.l.ctNombre.getText(), A1_T4_CastellanosJoqsan.m.l.ctDescripcion.getText(), Integer.parseInt(A1_T4_CastellanosJoqsan.m.l.ctExistencia.getText()), Double.parseDouble(A1_T4_CastellanosJoqsan.m.l.ctPrecio.getText()), A1_T4_CastellanosJoqsan.m.l.ctCategoria.getText());
                    
                if(!videojuegoExistente(vd.getNoID())) {

                    if(!carpeta.exists()) {

                        carpeta.mkdir();

                    }

                    File archivo = new File(carpeta, "Videojuego" + vd.getNoID() + ".txt");

                        if(!archivo.exists()) {

                            archivo.createNewFile();

                        }

                    FileWriter escritor1 = new FileWriter(archivo);

                    BufferedWriter escritor2 = new BufferedWriter(escritor1);

                    escritor2.write("No. ID: " + vd.getInformacionVideojuego().get(0));

                    escritor2.newLine();

                    escritor2.write("Nombre: " + vd.getInformacionVideojuego().get(1));

                    escritor2.newLine();

                    escritor2.write("Descripción: " + vd.getInformacionVideojuego().get(2));

                    escritor2.newLine();

                    escritor2.write("Existencia: " + vd.getInformacionVideojuego().get(3));

                    escritor2.newLine();

                    escritor2.write("Precio: " + vd.getInformacionVideojuego().get(4));

                    escritor2.newLine();

                    escritor2.write("Categoría: " + vd.getInformacionVideojuego().get(5));

                    escritor2.close();
                    
                    escritor1.close();

                    JOptionPane.showMessageDialog(null, "Videojuego añadido al registro", "Añadiendo videojuego", JOptionPane.INFORMATION_MESSAGE);
                        
                } else {
                        
                    throw new NoIDExistente();
                        
                }
                        
            } else {
                
                if(registroVacio()) {
                    
                    throw new RegistroVacio();
                    
                } else {
                
                    int noID = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese número de videojuego", "Buscar", JOptionPane.INFORMATION_MESSAGE));
                        
                    if(videojuegoExistente(noID)) {
                        
                        JOptionPane.showMessageDialog(null, getInformacionFinal(noID), "Información encontrada", JOptionPane.INFORMATION_MESSAGE);
                
                    } else {
                            
                        throw new ElementoNoEncontrado();
                            
                    }
                        
                }
                    
            }
                
        } catch(Exception exc) {
                
            JOptionPane.showMessageDialog(null, "Error de tipo: " + exc.getClass().getName() + "\nMotivo: " + exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                
        }
            
    }
        
    public boolean registroVacio() {
        
        iniciarArchivos();
        
        return archivos.isEmpty();
            
    }
        
    public boolean videojuegoExistente(int noID) {
        
        iniciarArchivos();
            
        for(int i=0; i<archivos.size(); i++) {
                
            if(archivos.get(i).getName().equals("Videojuego" + noID + ".txt")) {
                    
                return true;
                    
            }
            
        }
            
        return false;
            
    }
        
    public String getInformacionFinal(int noID) {
            
        for(int i=0; i<archivos.size(); i++) {
                
            if(archivos.get(i).getName().equals("Videojuego" + noID + ".txt")) {
                    
                try {
                        
                    FileReader lector = new FileReader(archivos.get(i));
                        
                    String informacion = "";
                        
                    int codigo = lector.read();
                        
                    while(codigo != -1) {
                            
                        informacion += (char)codigo;
                            
                        codigo = lector.read();
                            
                    }
                        
                    lector.close();
                        
                    return informacion;
                        
                } catch(IOException e) {}
                    
            }
                
        }
            
        return null;
            
    }
        
    public void iniciarArchivos() {
            
        archivos = new ArrayList<File>();
            
        for(int i=0; i<carpeta.listFiles().length; i++) {
                
            archivos.add(carpeta.listFiles()[i]);
                
        }
            
    }
        
    private ArrayList<File> archivos;
        
    private File carpeta;
    
    private class CampoVacio extends Exception {
    
        public CampoVacio() {

            super("Campo(s) vacío(s)");

        }
    
    }

    private class RegistroVacio extends Exception {

        public RegistroVacio() {

            super("Registro vacío");

        }

    }

    private class ValorNegativo extends Exception {

        public ValorNegativo() {

            super("Valor negativo ingresado");

        }

    }

    private class ElementoNoEncontrado extends Exception {

        public ElementoNoEncontrado() {

            super("Videojuego no encontrado");

        }

    }

    private class NoIDExistente extends Exception {

        public NoIDExistente() {

            super("El no. de ID ya existe");

        }

    }
    
}
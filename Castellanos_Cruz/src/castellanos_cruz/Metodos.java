package castellanos_cruz;

import java.io.*;

import java.util.*;

import javax.swing.*;

public class Metodos {
    
    public static class Principal {
        
        public void crear(JComboBox comboBox) throws Exception {
                    
            String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre de la nueva base de datos", "Nueva base de datos", JOptionPane.QUESTION_MESSAGE);
            
            if(nombre.isEmpty()) {
                
                throw new Excepciones.NombreBaseVacio();
                
            }
            
            File[] carpetas = carpetaFDB.listFiles();
            
            for(int i=0; i<carpetas.length; i++) {
                
                if(!carpetas[i].getName().equals("bases.db")) {
                    
                    if(nombre.equals(carpetas[i].getName())) {
                        
                        throw new Excepciones.BaseExistente();
                        
                    }
                    
                }
                
            }

            FileWriter escritor1 = new FileWriter(archivoBases, true);

            BufferedWriter escritor2 = new BufferedWriter(escritor1);

            FileReader lector1 = new FileReader(archivoBases);

            if(lector1.read() != -1) {

                escritor2.newLine();

            }

            lector1.close();

            escritor2.write("[BASE]" + nombre + ".db");

            escritor2.close();

            escritor1.close();

            File carpetaBase = new File(carpetaFDB, nombre);
                
            File archivoTablas = new File(carpetaBase, "tablas.tbls");
                
            carpetaBase.mkdir();
                
            archivoTablas.createNewFile();
                    
            comboBox.addItem(nombre);
            
            JOptionPane.showMessageDialog(null, "Base de datos creada con éxito", "Base de datos creada", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        public void abrir(JMenu mPrincipal, JMenu mTabla, int f, JLabel etiqueta1, JComboBox comboBox) throws Exception {
            
            if(carpetaFDBVacia()) {
                
                throw new Excepciones.RegistroBasesVacio();
                
            }
            
            String nombre = comboBox.getSelectedItem().toString();
            
            if(f == 1) {
                
                nombre = JOptionPane.showInputDialog(null, "Ingrese nombre de la base de datos a abrir", "Abrir base de datos", JOptionPane.QUESTION_MESSAGE);
                
                if(!baseEncontrada(nombre)) {
                    
                    throw new Excepciones.BaseNoExistente();
                    
                }
                
            }
            
            mPrincipal.setEnabled(false);
                
            mTabla.setEnabled(true);
            
            comboBox.setVisible(false);
            
            etiqueta1.setText("Base de datos actual: " + nombre);
            
            etiqueta1.setVisible(true);
            
            baseAbierta = new File(carpetaFDB, nombre);
            
            JOptionPane.showMessageDialog(null, "Base de datos abierta con éxito", "Base de datos abierta", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        public void salir() {
            
            if(JOptionPane.showConfirmDialog(null, "¿Desea cerrar el SGBD?", "Saliendo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        
                System.exit(0);
                        
            }
            
        }
        
        private boolean baseEncontrada(String nombre) throws Exception {

            if(nombre.equals("") || nombre==null) {
                
                throw new Excepciones.NombreBaseVacio();
                
            }
                
            File[] carpetas = carpetaFDB.listFiles();

            for(int i=0; i<carpetas.length; i++) {

                if(!carpetas[i].getName().equals("bases.db")) {

                    if(nombre.equals(carpetas[i].getName())) {

                        FileReader lector1 = new FileReader(archivoBases);

                        BufferedReader lector2 = new BufferedReader(lector1); 

                        String linea = "";

                        nombre = "[BASE]" + nombre + ".db";

                        while(linea != null) {

                            linea = lector2.readLine();

                            if(nombre.equals(linea)) {

                                return true;

                            }

                        }

                        lector2.close();

                        lector1.close();

                    }

                }

            }
            
            return false;
            
        }
        
        private boolean carpetaFDBVacia() {
            
            File[] carpetas = carpetaFDB.listFiles();
            
            for(int i=0; i<carpetas.length; i++) {
                
                if(!carpetas[i].getName().equals("bases.db")) {
                    
                    return false;
                    
                }
                
            }
            
            return true;
            
        }
        
    }
    
    public static class Tabla {
        
        public void crear() {
            
            Marcos.mf1 = new Marcos.MarcoFormulario1();
            
            Marcos.mf1.setVisible(true);
            
        }
        
        public void abrir(JMenu mDatos, JMenu mTabla, JLabel etiqueta2) throws Exception {
            
            if(baseVacia()) {
                
                throw new Excepciones.BaseVacia();
                
            }
            
            String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre de la tabla a abrir", "Abrir tabla", JOptionPane.QUESTION_MESSAGE);
            
            if(nombre.isEmpty()) {
                
                throw new Excepciones.NombreTablaVacio();
                
            }
            
            if(!tablaEncontrada(nombre)) {
                
                throw new Excepciones.TablaNoExistente();
                
            }
            
            mDatos.setEnabled(true);
            
            mTabla.setEnabled(false);
            
            etiqueta2.setText("Tabla actual: " + nombre);
            
            etiqueta2.setVisible(true);
            
            tablaAbierta = new File(baseAbierta, nombre + ".dat");
            
            d.crearListas(nombre);
            
            JOptionPane.showMessageDialog(null, "Tabla abierta con éxito", "Tabla abierta", JOptionPane.INFORMATION_MESSAGE);
           
        }
        
        public void examinar() throws Exception {
            
            if(baseVacia()) {
                
                throw new Excepciones.BaseVacia();
                
            }
            
            String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre de la tabla a examinar", "Examinar tabla", JOptionPane.QUESTION_MESSAGE);
            
            if(nombre.isEmpty()) {
                
                throw new Excepciones.NombreTablaVacio();
                
            }
            
            if(!tablaEncontrada(nombre)) {
                
                throw new Excepciones.TablaNoExistente();
                
            }
            
            Marcos.me = new Marcos.MarcoExaminar(nombre, baseAbierta);
            
            Marcos.me.setVisible(true);
            
        }
        
        public void eliminar() throws Exception {
            
            if(baseVacia()) {
                
                throw new Excepciones.BaseVacia();
                
            }
            
            String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre de la tabla a eliminar", "Eliminar tabla", JOptionPane.QUESTION_MESSAGE);
            
            if(nombre.isEmpty()) {
                
                throw new Excepciones.NombreTablaVacio();
                
            }
            
            if(!tablaEncontrada(nombre)) {
                
                throw new Excepciones.TablaNoExistente();
                
            }
            
            new File(baseAbierta, nombre + ".tbl").delete();
            
            if(new File(baseAbierta, nombre + ".dat").exists()) {
                
                new File(baseAbierta, nombre + ".dat").delete();
                
            }
            
            recargarArchivo(baseAbierta);
            
            JOptionPane.showMessageDialog(null, "Tabla eliminada con éxito", "Tabla eliminada", JOptionPane.INFORMATION_MESSAGE);
              
        }
        
        public void vaciar() throws Exception {
            
            if(baseVacia()) {
                
                throw new Excepciones.BaseVacia();
                
            }
            
            String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre de la tabla a vaciar", "Vaciar tabla", JOptionPane.QUESTION_MESSAGE);
            
            if(nombre.isEmpty()) {
                
                throw new Excepciones.NombreTablaVacio();
                
            }
            
            if(!tablaEncontrada(nombre)) {
                
                throw new Excepciones.TablaNoExistente();
                
            }
            
            if(!new File(baseAbierta, nombre + ".dat").exists()) {
                
                throw new Excepciones.TablaVacia();
                
            }
            
            FileReader lector1 = new FileReader(new File(baseAbierta, nombre + ".dat"));
            
            BufferedReader lector2 = new BufferedReader(lector1);
            
            String linea = lector2.readLine();
            
            lector2.close();
            
            lector1.close();
            
            if(linea == null) {
                
                throw new Excepciones.TablaVacia();
                
            }
            
            new File(baseAbierta, nombre + ".dat").delete();
            
            new File(baseAbierta, nombre + ".dat").createNewFile();
            
            FileReader lector3 = new FileReader(new File(baseAbierta, nombre + ".tbl"));
            
            BufferedReader lector4 = new BufferedReader(lector3);
            
            String campos = lector4.readLine();
            
            lector4.close();
            
            lector3.close();
            
            FileWriter escritor1 = new FileWriter(new File(baseAbierta, nombre + ".tbl"));
            
            BufferedWriter escritor2 = new BufferedWriter(escritor1);
            
            escritor2.write(campos);
            
            escritor2.close();
            
            escritor1.close();
            
            JOptionPane.showMessageDialog(null, "Tabla vaciada con éxito", "Tabla vaciada", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        public void regresar(JMenu mPrincipal, JMenu mTabla, JLabel etiqueta1, JComboBox comboBox) {
            
            mPrincipal.setEnabled(true);
            
            mTabla.setEnabled(false);
            
            etiqueta1.setVisible(false);
            
            comboBox.setVisible(true);
            
        }
        
        public void crearTabla(JTextField campo1, JTextField campo2, JTextField[] campos1, JTextField[] campos2, JComboBox[] combos) throws Exception {
            
            FileWriter escritor1 = new FileWriter(new File(baseAbierta, campo1.getText() + ".tbl"));
            
            for(int i=0; i<Integer.parseInt(campo2.getText()); i++) {
                
                if(i != 0) {
                    
                    escritor1.write("|");
                    
                }
                
                escritor1.write(campos1[i].getText() + "|" + (String)combos[i].getSelectedItem());
                
                if(combos[i].getSelectedIndex() == 1) {
                    
                    escritor1.write("(" + Integer.parseInt(campos2[i].getText()) + ")");
                    
                }
                
            }
            
            escritor1.close();
            
            FileWriter escritor2 = new FileWriter(new File(baseAbierta, "tablas.tbls"), true);
            
            BufferedWriter escritor3 = new BufferedWriter(escritor2);
            
            escritor3.write("[TABLA]" + campo1.getText() + ".tbl");
            
            escritor3.newLine();
            
            escritor3.close();
            
            escritor2.close();
            
            JOptionPane.showMessageDialog(null, "Tabla creada con éxito", "Tabla creada", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        public boolean tablaEncontrada(String nombre) throws Exception {
            
            FileReader lector1 = new FileReader(new File(baseAbierta, "tablas.tbls"));
            
            BufferedReader lector2 = new BufferedReader(lector1);
            
            while(lector2.ready()) {
                
                if(lector2.readLine().equals("[TABLA]" + nombre + ".tbl")) {
                    
                    return true; 
                    
                }
                
            }
            
            lector2.close();
            
            lector1.close();
            
            return false;
            
        }
        
        private void recargarArchivo(File carpetaBase) throws Exception {
            
            FileWriter escritor1 = new FileWriter(new File(carpetaBase, "tablas.tbls"));
            
            BufferedWriter escritor2 = new BufferedWriter(escritor1);
            
            File[] archivos = carpetaBase.listFiles();
            
            for(int i=0; i<archivos.length; i++) {
                
                if(!archivos[i].getName().equals("tablas.tbls") && !archivos[i].getName().contains(".dat")) {
                    
                    escritor2.write("[TABLA]" + archivos[i].getName());
                    
                    escritor2.newLine();
                    
                }
                
            }
            
            escritor2.close();
            
            escritor1.close();
            
        }
        
        private boolean baseVacia() {
            
            File[] archivos = baseAbierta.listFiles();
            
            for(int i=0; i<archivos.length; i++) {
                
                if(!archivos[i].getName().equals("tablas.tbls") && !archivos[i].getName().contains(".dat")) {
                    
                    return false;
                    
                }
                
            }
            
            return true;
            
        }
        
    }
    
    public static class Datos {
        
        public void agregar() {
            
            String nt = "";
            
            for(int i=0; i<tablaAbierta.getName().length(); i++) {
                
                if(tablaAbierta.getName().charAt(i) == '.') {
                    
                    break;
                    
                }
                
                nt += tablaAbierta.getName().charAt(i);
                
            }
            
            Marcos.ma = new Marcos.MarcoAgregar(nt);
            
            Marcos.ma.setVisible(true);
            
        }
        
        public void agregarRegistro(JTextField[] campos3, int[] longitudes1, String[] tipos1, int x) throws Exception {
            
            if(longitudes1!=null && tipos1!=null) {
            
                for(int i=0; i<longitudes1.length; i++) {
                    
                    if(campos3[i].getText().isEmpty()) {
                        
                        throw new Excepciones.ValorCampoVacio();
                        
                    }

                    if(!valorValido(tipos1[i], longitudes1[i], campos3[i].getText())) {

                        throw new Excepciones.LongitudValorNoValida();

                    }

                }
                
            }
            
            if(Listas.clavePrimaria == 1) {
                
                for(int i=0; i<campos3.length; i++) {
                    
                    Listas.lista2.agregarNodo(campos3[i].getText());
                    
                    if(i == 0) {
                        
                        Listas.lista2.temporal1 = Listas.lista2.inicio;
                        
                    }
                    
                }
                
                Listas.NodoDatos m = Listas.lista2.inicio;
                
                for(Listas.NodoCampos n=Listas.lista1.inicio; n!=null; n=n.siguiente) {
                    
                    n.abajo = m;
                    
                    m = m.siguiente;
                    
                }
                
            } else {
                
                for(int i=0; i<campos3.length; i++) {
                    
                    if(i == 0) {
                        
                        Listas.lista2.nuevaFila(campos3[i].getText());
                        
                    } else {
                        
                        Listas.lista2.agregarNodo(campos3[i].getText());
                        
                    }
                    
                }
                
                Listas.NodoDatos m = Listas.lista2.temporal2;
                
                for(Listas.NodoDatos n=Listas.lista2.temporal1; n!= null; n=n.siguiente) {
                    
                    n.abajo = m;
                    
                    m = m.siguiente;
                    
                }
                
                Listas.lista2.temporal1 = Listas.lista2.temporal2;
                
            }
            
            String nt = "";
            
            for(int i=0; i<tablaAbierta.getName().length(); i++) {
                
                if(tablaAbierta.getName().charAt(i) == '.') {
                    
                    break;
                    
                }
                
                nt += tablaAbierta.getName().charAt(i);
                
            }
            
            FileReader lector1 = new FileReader(new File(baseAbierta, nt + ".tbl"));
            
            BufferedReader lector2 = new BufferedReader(lector1);
            
            String campos = lector2.readLine();
            
            lector2.close();
            
            lector1.close();
            
            FileWriter escritor1 = new FileWriter(new File(baseAbierta, nt + ".tbl"));
            
            BufferedWriter escritor2 = new BufferedWriter(escritor1);
            
            escritor2.write(campos);
            
            escritor2.newLine();
            
            escritor2.write(Listas.lista1.inicio.getNombre() + "->" + Listas.clavePrimaria);
            
            escritor2.close();
            
            escritor1.close();
            
            Listas.recargarClave();
            
            if(x == 1) {
                
                JOptionPane.showMessageDialog(null, "Registro añadido con éxito", "Registro añadido", JOptionPane.INFORMATION_MESSAGE);
                
            }
            
        }
        
        public void modificar() throws Exception {
            
            if(tablaVacia()) {
                
                throw new Excepciones.TablaVacia();
                
            }
            
            String clave = JOptionPane.showInputDialog(null, "Ingrese clave de registro", "Modificar registro", JOptionPane.QUESTION_MESSAGE);
            
            Integer.parseInt(clave);
            
            if(clave.isEmpty()) {
                
                throw new Excepciones.ClaveVacia();
                
            }
            
            if(!registroEncontrado(clave)) {
                
                throw new Excepciones.RegistroNoExistente();
                
            }
            
            String nt = "";
            
            for(int i=0; i<tablaAbierta.getName().length(); i++) {
                
                if(tablaAbierta.getName().charAt(i) == '.') {
                    
                    break;
                    
                }
                
                nt += tablaAbierta.getName().charAt(i);
                
            }
            
            Marcos.mm = new Marcos.MarcoModificar(nt, clave);
            
            Marcos.mm.setVisible(true);
            
        }
        
        public void modificarRegistro(JTextField[] campos4, int[] longitudes2, String[] tipos2) throws Exception {
            
            for(int i=0; i<longitudes2.length; i++) {
                
                if(campos4[i].getText().isEmpty()) {
                        
                    throw new Excepciones.ValorCampoVacio();
                        
                }
                
                if(!valorValido(tipos2[i], longitudes2[i], campos4[i].getText())) {
                    
                    throw new Excepciones.LongitudValorNoValida();
                    
                }
                
            }
            
            for(Listas.NodoDatos n=Listas.lista2.inicio; n!=null; n=n.abajo) {
                
                if(n.getDato().equals(campos4[0].getText())) {
                    
                    Listas.NodoDatos m = n.siguiente;
                    
                    for(int i=1; i<campos4.length; i++) {
                        
                        m.setDato(campos4[i].getText());
                        
                        m = m.siguiente;
                        
                    }
                    
                }
                
            }
            
            JOptionPane.showMessageDialog(null, "Registro modificado con éxito", "Registro modificado", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        public void eliminar() throws Exception {
            
            if(tablaVacia()) {
                
                throw new Excepciones.TablaVacia();
                
            }
            
            String clave = JOptionPane.showInputDialog(null, "Ingrese clave de registro", "Eliminar registro", JOptionPane.QUESTION_MESSAGE);
            
            Integer.parseInt(clave);
            
            if(clave.isEmpty()) {
                
                throw new Excepciones.ClaveVacia();
                
            }
            
            if(!registroEncontrado(clave)) {
                
                throw new Excepciones.RegistroNoExistente();
                
            }
            
            if(clave.equals("1")) {
                
                Listas.NodoDatos m = Listas.lista2.inicio;
                
                Listas.lista2.inicio = Listas.lista2.inicio.abajo;
                
                for(Listas.NodoDatos n=m; n!=null; n=n.siguiente) {
                    
                    n.abajo = null;
                    
                }
                
            } else {
            
                for(Listas.NodoDatos n=Listas.lista2.inicio; n!=null; n=n.abajo) {

                    if(n.abajo.getDato().equals(clave)) {

                        for(Listas.NodoDatos m=n; m!=null; m=m.siguiente) {

                            m.abajo = m.abajo.abajo;

                        }

                        break;

                    }

                }
                
            }
            
            Listas.recargarClave();
            
            JOptionPane.showMessageDialog(null, "Registro eliminado con éxito", "Registro eliminado", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        public void buscar() throws Exception {
            
            if(tablaVacia()) {
                
                throw new Excepciones.TablaVacia();
                
            }
            
            String clave = JOptionPane.showInputDialog(null, "Ingrese clave de registro", "Buscar registro", JOptionPane.QUESTION_MESSAGE);
            
            Integer.parseInt(clave);
            
            if(clave.isEmpty()) {
                
                throw new Excepciones.ClaveVacia();
                
            }
            
            if(!registroEncontrado(clave)) {
                
                throw new Excepciones.RegistroNoExistente();
                
            }
            
            String nt = "";
            
            for(int i=0; i<tablaAbierta.getName().length(); i++) {
                
                if(tablaAbierta.getName().charAt(i) == '.') {
                    
                    break;
                    
                }
                
                nt += tablaAbierta.getName().charAt(i);
                
            }
            
            Marcos.mb = new Marcos.MarcoBuscar(nt, clave);
            
            Marcos.mb.setVisible(true);
            
        }
        
        public void regresar(JMenu mTabla, JMenu mDatos, JLabel etiqueta2) throws Exception {
            
            guardarLista();
            
            Listas.reiniciarClave();
            
            mTabla.setEnabled(true);
            
            mDatos.setEnabled(false);
            
            etiqueta2.setVisible(false);
            
        }
        
        public void crearListas(String nombre) throws Exception {
            
            Listas.lista1 = new Listas.ListaCampos();
            
            FileReader lector1 = new FileReader(new File(baseAbierta, nombre + ".tbl"));
            
            BufferedReader lector2 = new BufferedReader(lector1);
            
            StringTokenizer st = new StringTokenizer(lector2.readLine(), "|");
            
            while(st.hasMoreTokens()) {
                
                String nom = st.nextToken(), tip = st.nextToken();
                
                int lon = 0;
                
                if(tip.charAt(0) == 'v') {
                    
                    StringTokenizer st1 = new StringTokenizer(tip, "(");
                    
                    tip = st1.nextToken();
                    
                    StringTokenizer st2 = new StringTokenizer(st1.nextToken(), ")");
                    
                    lon = Integer.parseInt(st2.nextToken());
                    
                }
                
                Listas.lista1.agregarNodo(nom, tip, lon);
                
            }
            
            Listas.lista2 = new Listas.ListaDatos();
            
            if(tablaAbierta.exists()) {
                
                lector1 = new FileReader(new File(baseAbierta, nombre + ".dat"));
                
                lector2 = new BufferedReader(lector1);
                
                while(lector2.ready()) {
                    
                    String linea = lector2.readLine();
                    
                    st = new StringTokenizer(linea, "|");
                    
                    int i = 0;
                    
                    while(st.hasMoreTokens()) {
                        
                        i ++;
                        
                        st.nextToken();
                        
                    }
                    
                    st = new StringTokenizer(linea, "|");
                    
                    JTextField[] campos = new JTextField[i];
                    
                    int j = 0;
                    
                    while(st.hasMoreTokens()) {
                        
                        campos[j] = new JTextField(st.nextToken());
                        
                        j ++;
                        
                    }
                    
                    agregarRegistro(campos, null, null, 2);
                    
                }
                
            }
            
            lector2.close();
            
            lector1.close();
            
        }
        
        public boolean valorValido(String tipo, int longitud, String valor) throws Exception {
            
            if(tipo.equals("int")) {
                
                Integer.parseInt(valor);
                
                return true;
                
            }
            
            return valor.length() <= longitud;
            
        }
        
        private void guardarLista() throws Exception {
            
            FileWriter escritor1 = new FileWriter(tablaAbierta);
            
            BufferedWriter escritor2 = new BufferedWriter(escritor1);
            
            for(Listas.NodoDatos m=Listas.lista2.inicio; m!=null; m=m.abajo) {
                
                for(Listas.NodoDatos n=m; n!=null; n=n.siguiente) {
                    
                    escritor2.write(n.getDato() + "|");
                    
                }
                
                escritor2.newLine();
                
            }
            
            escritor2.close();
            
            escritor1.close();
            
        }
        
        private boolean registroEncontrado(String clave) {
            
            for(Listas.NodoDatos n=Listas.lista2.inicio; n!=null; n=n.abajo) {
                
                if(n.getDato().equals(clave)) {
                    
                    return true;
                    
                }
                
            }
            
            return false;
            
        }
        
        private boolean tablaVacia() {
            
            return Listas.lista2.inicio == null;
            
        }
        
    }
    
    public static class Arranque {
        
        public void verificacionInicial(JComboBox comboBox) throws Exception {
            
            File[] carpetas = null;

            if(!carpetaFDB.exists()) {

                carpetaFDB.mkdir();

            } else {

                carpetas = carpetaFDB.listFiles();

            }
                
            if(!archivoBases.exists()) {
                    
                archivoBases.createNewFile();
                    
            }
                
            if(carpetas != null) {
                    
                FileWriter escritor1 = new FileWriter(archivoBases);
                
                BufferedWriter escritor2 = new BufferedWriter(escritor1);
                    
                for(int i=0; i<carpetas.length; i++) {
                        
                    if(!carpetas[i].getName().equals("bases.db")) {
                            
                        if(i > 0) {
                            
                            escritor2.newLine();
                            
                        }   
                        
                        escritor2.write("[BASE]" + carpetas[i].getName() + ".db");
                            
                        comboBox.addItem(carpetas[i].getName());
                        
                        t.recargarArchivo(carpetas[i]);
                            
                    }
                        
                }
                    
                escritor2.close();
                    
                escritor1.close();
                    
            }
            
        }
        
    }
    
    public static Principal p = new Principal();
    
    public static Tabla t = new Tabla();
    
    public static Datos d = new Datos();
    
    public static Arranque a = new Arranque();
    
    private static File baseAbierta;
    
    private static File tablaAbierta;
    
    private static File carpetaFDB = new File("C:/FDB/");
    
    private static File archivoBases = new File(carpetaFDB, "bases.db");
    
}
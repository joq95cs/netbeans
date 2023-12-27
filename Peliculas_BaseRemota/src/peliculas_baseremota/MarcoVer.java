
package peliculas_baseremota;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import utilidades.*;
import java.sql.*;

public class MarcoVer extends JFrame {
    
    public MarcoVer(ResultSet rs) throws Exception {
        
        this.rs = rs;
        Utilidades.crearMarco(this, "Tabla: Películas", 850, 350, DISPOSE_ON_CLOSE);
        add(new LaminaVer());
    }
    
    private class LaminaVer extends JPanel {
        
        public LaminaVer() throws Exception {
            
            setLayout(new BorderLayout());
            
            DefaultTableModel modelo = new DefaultTableModel() {
                
                public boolean isCellEditable(int row, int column) {
                    
                    return false;
                    
                }
                
            };
            
            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Año");
            modelo.addColumn("Género");
            modelo.addColumn("País");
            modelo.addColumn("Estudio");
            modelo.addColumn("Fecha de registro");
            
            while(rs.next()) {
                
                String[] fila = new String[7];
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                fila[6] = rs.getString(7);
                modelo.addRow(fila);
            }
            
            add(new JScrollPane(new JTable(modelo)));
            
            JPanel laminaSur = new JPanel();
            btn = new JButton("Refrescar");
            laminaSur.add(btn);
            add(laminaSur, BorderLayout.SOUTH);
        } 
    }
   
    private ResultSet rs;
    private JButton btn;
}
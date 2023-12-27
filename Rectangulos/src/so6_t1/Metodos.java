package so6_t1;

import javax.swing.*;

import java.awt.*;

public class Metodos {
    
    public Metodos() {
        
        colores = new Color[5];
        
        colores[0] = Color.BLUE;
        
        colores[1] = Color.RED;
        
        colores[2] = Color.PINK;
        
        colores[3] = Color.GREEN;
        
        colores[4] = Color.YELLOW;
        
        iniciarContadores();
        
    }
    
    public void pintarCuadro(JTextField cuadros) {
        
        cuadros.setBackground(colores[(int)Math.round((Math.random()*4))]);
        
    }
    
    public void contar(JTextField cuadro) {
            
        if(cuadro.getBackground().equals(Color.BLUE)) {

            azules ++;

        } else if(cuadro.getBackground().equals(Color.RED)) {

            rojos ++;

        } else if(cuadro.getBackground().equals(Color.PINK)) {

            rosas ++;

        } else if(cuadro.getBackground().equals(Color.GREEN)) {

            verdes ++;

        } else if(cuadro.getBackground().equals(Color.YELLOW)) {

            amarillos ++;

        }
        
    }
    
    public void mostrarColores(JTextField jTextField2, JTextField jTextField3, JTextField jTextField4, JTextField jTextField5, JTextField jTextField6) {
        
        jTextField2.setText(String.valueOf(azules));
        
        jTextField3.setText(String.valueOf(rojos));
        
        jTextField4.setText(String.valueOf(rosas));
        
        jTextField5.setText(String.valueOf(verdes));
        
        jTextField6.setText(String.valueOf(amarillos));
        
        iniciarContadores();
        
    }
    
    private void iniciarContadores() {
        
        azules = 0;
        
        rojos = 0;
        
        rosas = 0;
        
        verdes = 0;
        
        amarillos = 0;
        
    }
    
    private Color[] colores;
    
    private int azules;
        
    private int rojos;
        
    private int rosas;
        
    private int verdes;
        
    private int amarillos;
    
}
package a2_t2_castellanosjoqsan;

import javax.swing.*;

import java.awt.*;

public class Lamina extends JPanel {
    
    public Lamina(Marco m) {
        
        this.m = m;
        
        setLayout(new BorderLayout());
        
        JPanel laminaNorte = new JPanel();
        
        laminaNorte.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        combo = new JComboBox();
        
        combo.addItem("Longitud");
        
        combo.addItem("Busqueda");
        
        combo.addItem("Comparación");
        
        combo.addItem("Mayúsculas");
        
        combo.addItem("Minúsculas");
        
        Oyente o = new Oyente(this);
        
        combo.addActionListener(o);
        
        laminaNorte.add(combo);
        
        add(laminaNorte, BorderLayout.NORTH);
        
        JPanel laminaCentro = new JPanel();
        
        laminaCentro.setLayout(new GridLayout(2, 1));
        
        lamina1 = new JPanel();
        
        lamina1.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        laminaCentro.add(lamina1);
        
        lamina2 = new JPanel();
        
        lamina2.setLayout(new BorderLayout());
        
        laminaCentro.add(lamina2);
        
        add(laminaCentro, BorderLayout.CENTER);
        
        boton = new JButton("Ejecutar");
        
        boton.addActionListener(o);
        
        campo1 = new JTextField(15);
        
        campo2 = new JTextField(15);
        
        campo3 = new JTextField();
        
        campo3.setEditable(false);
        
        campo3.setBackground(Color.CYAN);
        
        campo3.setHorizontalAlignment(SwingConstants.CENTER);
        
    }
    
    public JComboBox<String> getCombo() {
        
        return combo;
        
    }
    
    public JButton getBoton() {
        
        return boton;
        
    }
    
    public JTextField getCampo1() {
        
        return campo1;
        
    }
    
    public JTextField getCampo2() {
        
        return campo2;
        
    }
    
    public JTextField getCampo3() {
        
        return campo3;
        
    }
    
    public JPanel getLamina1() {
        
        return lamina1;
        
    }
    
    public JPanel getLamina2() {
        
        return lamina2;
        
    }
    
    public void recargarMarco() {
        
        SwingUtilities.updateComponentTreeUI(m);
        
    }
    
    private JComboBox<String> combo;
    
    private JButton boton;
    
    private JTextField campo1, campo2, campo3;
    
    private JPanel lamina1, lamina2;
    
    private Marco m;
    
}
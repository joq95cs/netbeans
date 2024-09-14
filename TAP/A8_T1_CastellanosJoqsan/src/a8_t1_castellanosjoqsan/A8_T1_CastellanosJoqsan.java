package a8_t1_castellanosjoqsan;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class A8_T1_CastellanosJoqsan {

    public static void main(String[] args) {
        
        new Marco().setVisible(true);
        
    }
    
}

class Marco extends JFrame {
    
    public Marco() {
        
        int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
        
        int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        setBounds(ancho/3, alto/3, ancho/3, alto/3);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle("Comisión");
        
        Lamina l = new Lamina();
        
        add(l);
        
    }
    
    private class Lamina extends JPanel {
    
        public Lamina() {
        
            setLayout(new GridLayout(3, 1));
        
            JPanel lamina1 = new JPanel();
        
            etSueldo = new JLabel("Sueldo base (mensual)");
        
            lamina1.add(etSueldo);
        
            ctSueldo = new JTextField(7);
        
            lamina1.add(ctSueldo);
            
            JTextField ctInfo = new JTextField("Presione Enter o ctrl+C");
            
            ctInfo.setEditable(false);
            
            ctInfo.setBackground(Color.yellow);
            
            ctInfo.setFocusable(false);
        
            lamina1.add(ctInfo);
        
            add(lamina1);
            
            JPanel lamina2 = new JPanel();
            
            etVenta1 = new JLabel("Venta 1");
            
            lamina2.add(etVenta1);
            
            ctVenta1 = new JTextField(7);
            
            lamina2.add(ctVenta1);
            
            add(lamina2);
            
            etVenta2 = new JLabel("Venta 2");
            
            lamina2.add(etVenta2);
            
            ctVenta2 = new JTextField(7);
            
            lamina2.add(ctVenta2);
            
            etVenta3 = new JLabel("Venta 3");
            
            lamina2.add(etVenta3);
            
            ctVenta3 = new JTextField(7);
            
            lamina2.add(ctVenta3);
        
            JPanel lamina3 = new JPanel();
        
            etComision = new JLabel("Total por comisiones");
        
            lamina3.add(etComision);
        
            ctComision = new JTextField(7);
        
            ctComision.setEditable(false);
            
            ctComision.setFocusable(false);
        
            lamina3.add(ctComision);
        
            etTotal = new JLabel("Total ganado");
        
            lamina3.add(etTotal);
        
            ctTotal = new JTextField(7);
        
            ctTotal.setEditable(false);
            
            ctTotal.setFocusable(false);
        
            lamina3.add(ctTotal);
        
            add(lamina3);
            
            Accion a = new Accion();
            
            ctSueldo.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ctrl C"), "CA");
            
            ctSueldo.getActionMap().put("CA", a);
            
            ctVenta1.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ctrl C"), "CA");
            
            ctVenta1.getActionMap().put("CA", a);
            
            ctVenta2.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ctrl C"), "CA");
            
            ctVenta2.getActionMap().put("CA", a);
            
            ctVenta3.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ctrl C"), "CA");
            
            ctVenta3.getActionMap().put("CA", a);
            
            OyenteTeclado ot = new OyenteTeclado();
            
            ctSueldo.addKeyListener(ot);
            
            ctVenta1.addKeyListener(ot);
            
            ctVenta2.addKeyListener(ot);
            
            ctVenta3.addKeyListener(ot);
        
        }
        
        public void calcular() {
            
            ctComision.setText("" + (Double.parseDouble(ctVenta1.getText())*0.1 + Double.parseDouble(ctVenta2.getText())*0.1 + Double.parseDouble(ctVenta3.getText())*0.1));
            
            ctTotal.setText("" + (Double.parseDouble(ctSueldo.getText()) + Double.parseDouble(ctComision.getText())));
            
        }
    
        private JLabel etSueldo, etComision, etTotal, etVenta1, etVenta2, etVenta3;
    
        private JTextField ctSueldo, ctComision, ctTotal, ctVenta1, ctVenta2, ctVenta3;
    
        private JButton btCalcular;
        
        private class Accion extends AbstractAction {
            
            public void actionPerformed(ActionEvent e) {
                
                calcular();
                
            }
            
        }
        
        private class OyenteTeclado extends KeyAdapter {
            
            public void keyPressed(KeyEvent e) {
                
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    
                    calcular();
                    
                }
                
            }
            
        }
    
    }
    
}

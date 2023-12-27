package calculadora_hilos;

import javax.swing.*;

import java.awt.*;

public class Lamina extends JPanel {
    
    public Lamina() {
        
        setLayout(new BorderLayout()); 
        
        add(new Lamina1(), BorderLayout.NORTH);
        
        add(new Lamina2(), BorderLayout.CENTER);
        
        new Hilo().start();

        
    }
    
    private class Lamina1 extends JPanel {
        
        public Lamina1() {
            
            setBackground(Color.green);
        
            add(new JLabel("Número 1"));
        
            n1 = new JTextField(5);
            
            add(n1);
        
            add(new JLabel("Número 2"));
        
            n2 = new JTextField(5);
            add(n2);
            
        }
        
    }
    
    private class Lamina2 extends JPanel {
        
        public Lamina2() {
            
            setBackground(Color.cyan);
            
            setLayout(new GridBagLayout());
            
            GridBagConstraints c = new GridBagConstraints();
            
            c.gridwidth = 1;
            
            c.gridheight = 1;
            
            c.weightx = 1;
            
            c.weighty = 1;
            
            c.gridy = 0;
            
            c.gridx = 0;
            
            add(new JLabel("Suma"), c);
            
            c.gridx = 1;
            
            ct1 = new JTextField(7);
            
            ct1.setEditable(false);
            
            add(ct1, c);
            
            c.gridx = 2;
            
            add(new JLabel("Resta"), c);
            
            c.gridx = 3;
            
            ct2 = new JTextField(7);
            
            ct2.setEditable(false);
            
            add(ct2, c);
            
            c.gridx = 0;
            
            c.gridy = 1;
            
            add(new JLabel("Multiplicación"), c);
            
            c.gridx = 1;
            
            ct3 = new JTextField(7);
            
            ct3.setEditable(false);
            
            add(ct3, c);
            
            c.gridx = 2;
            
            add(new JLabel("División"), c);
            
            c.gridx = 3;
            
            ct4 = new JTextField(7);
            
            ct4.setEditable(false);
            
            add(ct4, c);
            
        }
        
    }
    
    private class Hilo extends Thread {
    
        public void run() {

            while(true) {

                try  {

                    if(!n1.getText().isEmpty()) {

                        if(!n2.getText().isEmpty()) {

                            double num1 = Double.parseDouble(n1.getText());

                            double num2 = Double.parseDouble(n2.getText());

                            ct1.setText("" + (num1+num2));

                            ct2.setText("" + (num1-num2));

                            ct3.setText("" + (num1*num2));

                            ct4.setText("" + (num1/num2));

                        } else {

                            continue;

                        }

                    } else {

                        continue;

                    }

                    Thread.sleep(50);

                } catch(Exception e) {}

            }

        }
    
    }

    private JTextField ct1, ct2, ct3, ct4, n1, n2;
    
}
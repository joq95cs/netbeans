package deposito_retiro;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class Graficos {
    
    public static class Marco extends JFrame {
        
        public Marco() {
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            setTitle("Depositos y retiros");
            
            setResizable(false);
            
            add(new Lamina());
            
            int w = Toolkit.getDefaultToolkit().getScreenSize().width;
            
            int h = Toolkit.getDefaultToolkit().getScreenSize().height;
            
            setBounds(w/3, h/3, w/3, h/3);
            
        }
    
    }
    
    public static class Lamina extends JPanel {
        
        public Lamina() {
            
            setLayout(new GridLayout(2, 1));
            
            JPanel ls = new JPanel();
            
            ls.setLayout(new GridLayout(2, 1));
            
            JPanel l1 = new JPanel();
            
            l1.setBackground(Color.yellow);
            
            l1.add(new JLabel("Cantidad"));
            
            ct1 = new JTextField(7);
            
            l1.add(ct1);
            
            l1.add(new JLabel("Fondos disponibles"));
            
            ct2 = new JTextField(7);
            
            ct2.setText(String.valueOf(0.0));
            
            ct2.setEditable(false);
            
            l1.add(ct2);
            
            ls.add(l1);
            
            JPanel l2 = new JPanel();
            
            l2.setBackground(Color.green);
            
            bt1 = new JButton("Depositar");
            
            l2.add(bt1);
            
            bt2 = new JButton("Retirar");
            
            l2.add(bt2);
            
            ls.add(l2);
            
            add(ls);
            
            JPanel li = new JPanel();
            
            li.setLayout(new BorderLayout());
            
            at = new JTextArea();
            
            at.setBackground(Color.WHITE);
            
            at.setEditable(false);
            
            li.add(new JScrollPane(at));
            
            add(li);
            
            Monitor m = new Monitor(ct1, ct2, bt2, at);
            
            Hilos.Deposito d = new Hilos.Deposito(m);
            
            Hilos.Retiro r = new Hilos.Retiro(m);
            
            d.iniciarHilo();
            
            r.iniciarHilo();
            
            at.setText("Hilos en ejecución\n");
            
            bt1.addActionListener(new ActionListener() {
                
                public void actionPerformed(ActionEvent e) {
                    
                    m.setDepositar(true);
                    
                }
                
            });
            
            bt2.addActionListener(new ActionListener() {
                
                public void actionPerformed(ActionEvent e) {
                    
                    m.setRetirar(true);
                    
                }
                
            });
            
        }
        
        private final JTextField ct1, ct2;
        
        private final JButton bt1, bt2;
        
        private final JTextArea at;
        
    }
    
}
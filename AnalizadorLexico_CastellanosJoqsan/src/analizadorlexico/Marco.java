package analizadorlexico;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.io.*;

public class Marco extends JFrame {
    
    public Marco() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle("Analizador léxico");
        
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        setBounds(w/4, h/4, w/2, h/2);
        
        add(new Lamina1(), BorderLayout.NORTH);
        
        add(new Lamina2(), BorderLayout.CENTER);
        
    }
    
    private JTextField ct;
    
    private JTextArea at;
    
    private JButton bt;
    
    private class Lamina1 extends JPanel {
        
        public Lamina1() {
            
            add(new JLabel("Línea"));
            
            ct = new JTextField(25);
            
            add(ct);
            
            bt = new JButton("Analizar");
            
            bt.addActionListener(new Oyente());
            
            add(bt);
            
        }
        
    }
    
    private class Lamina2 extends JPanel {
        
        public Lamina2() {
            
            setLayout(new GridLayout());
            
            at = new JTextArea();
            
            at.setEditable(false);
            
            add(new JScrollPane(at));
            
        }
        
    }
    
    private class Oyente implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            
            try {
            
                BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/analizadorlexico/Texto.txt")));
                
                bw.write(ct.getText());
                
                bw.close();
                
                BufferedReader br = new BufferedReader(new FileReader(new File("src/analizadorlexico/Texto.txt")));
                
                Lexer lex = new Lexer(br);
                
                String res = "";
                
                while(true) {
                    
                    Token tok = lex.yylex();
                    
                    if(tok == null) {
                        
                        res += "FIN";
                        
                        at.setText(res);
                        
                        return;
                        
                    }
                    
                    switch(tok) {
                        
                        case ERROR:
                            
                            res += "ERROR\n";
                            
                            break;
                            
                        case IDENTIFICADOR: case ENTERO:
                            
                            res += "TOKEN: " + tok + "; LEXEMA: " + lex.lexema + "\n";
                            
                            break;
                            
                        default:
                            
                            res += "TOKEN: " + tok + "; LEXEMA: " + lex.yytext() + "\n";
                        
                    }
                    
                }
                
            } catch(IOException ex) {
                
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
                
            }
                
        }
        
    }
    
}
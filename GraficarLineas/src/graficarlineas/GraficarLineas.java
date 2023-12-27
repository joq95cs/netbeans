package graficarlineas;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.awt.geom.*;

public class GraficarLineas {

    public static void main(String[] args) {
		
	new MarcoA2().setVisible(true);

    }

}

class MarcoA2 extends JFrame {
	
    public MarcoA2() {
		
        int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
        int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
        setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        setTitle("Graficación de lineas");
		
        add(new LaminaA2());
		
    }
	
}

class LaminaA2 extends JPanel {
	
    public LaminaA2() {
		
	setLayout(new BorderLayout());
		
	laminaCentro = new JPanel();
		
	laminaCentro.setBackground(Color.WHITE);
		
	add(laminaCentro, BorderLayout.CENTER);
		
	JPanel laminaEste = new JPanel();
		
	laminaEste.setLayout(new GridBagLayout());
		
	GridBagConstraints c = new GridBagConstraints();
		
	c.gridwidth = 1;
		
	c.gridheight = 1;
		
	c.weightx = 1;
		
	c.weighty = 1;
		
	c.gridx = 0;
		
	c.gridy = 0;
		
	JLabel etiquetaX1 = new JLabel("X1");
		
	laminaEste.add(etiquetaX1, c);
		
	c.gridx = 1;
		
	campoX1 = new JTextField(4);
		
	laminaEste.add(campoX1, c);
		
	c.gridx = 0;
		
	c.gridy = 1;
		
	JLabel etiquetaY1 = new JLabel("Y1");
		
	laminaEste.add(etiquetaY1, c);
		
	c.gridx = 1;
		
	campoY1 = new JTextField(4);
		
	laminaEste.add(campoY1, c);
		
	c.gridx = 0;
		
	c.gridy = 2;
		
	JLabel etiquetaX2 = new JLabel("X2");
		
	laminaEste.add(etiquetaX2, c);
		
	c.gridx = 1;
		
	campoX2 = new JTextField(4);
		
	laminaEste.add(campoX2, c);
		
	c.gridx = 0;
		
	c.gridy = 3;
		
	JLabel etiquetaY2 = new JLabel("Y2");
		
	laminaEste.add(etiquetaY2, c);
		
	c.gridx = 1;
		
	campoY2 = new JTextField(4);
		
	laminaEste.add(campoY2, c);
		
	c.gridwidth = 2;
		
	c.gridx = 0;
		
	c.gridy = 4;
		
	botonGraficar = new JButton("Graficar");
		
	botonGraficar.addMouseListener(new MouseAdapter() {
			
            public void mouseClicked(MouseEvent e) {
				
		Graphics g1 = laminaCentro.getGraphics();
				
		Graphics2D g2 = (Graphics2D)g1;
				
		g2.setColor(Color.GREEN);
				
		g2.draw(new Line2D.Double(Double.parseDouble(campoX1.getText()), Double.parseDouble(campoY1.getText()), Double.parseDouble(campoX2.getText()), Double.parseDouble(campoY2.getText())));
				
            }
			
	});
		
	laminaEste.add(botonGraficar, c);
		
	add(laminaEste, BorderLayout.EAST);
		
    }
	
    private JPanel laminaCentro;
	
    private JTextField campoX1, campoX2, campoY1, campoY2;
	
    private JButton botonGraficar;
	
}
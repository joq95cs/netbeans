package helicoptero_2;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import javax.imageio.*;

import java.io.*;

public class Panel extends JPanel {
    
    public Panel(int ancho, int alto) {
            
        setLayout(null);

        setBounds(0, 0, ancho, alto);

        setBackground(Color.cyan);

        setFocusable(true);

        h = new JPanel() {

            public void paintComponent(Graphics g) {

                super.paintComponent(g);

                setBackground(Color.cyan);

                try {

                    g.drawImage(ImageIO.read(new File("src/helicoptero/helicoptero.png")), 0, 0, getWidth(), getHeight(), null);

                } catch(IOException e) {

                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);

                }

            }

        };

        h.setBounds(0, getHeight()-120, 120, 120);

        h.setFocusable(false);

        add(h);

        addKeyListener(new Oyente());

        mover = new HiloMover(h, ancho, alto);

        mover.start();
            
    }
        
    private JPanel h;

    private HiloMover mover;
        
    private class Oyente extends KeyAdapter {

        public void keyPressed(KeyEvent e) {

            switch(e.getKeyCode()) {

                case KeyEvent.VK_UP:

                    mover.arriba();

                    break;

                case KeyEvent.VK_DOWN:

                    mover.abajo();

                    break;

                case KeyEvent.VK_RIGHT:

                    mover.derecha();

                    break;

                case KeyEvent.VK_LEFT:

                    mover.izquierda();

            }

        }

    }
        
}
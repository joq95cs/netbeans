package globoaerostatico;

import javax.swing.*;

import java.awt.*;

public class Hilos {
    
    public static class HGlobo extends Thread {
    
        public void run() {
                
            try {
                
                while(true) {

                    moverGlobo();
                
                }

            } catch(InterruptedException e) {}
            
        }
        
        private void moverGlobo() throws InterruptedException {
            
            String[] direcciones = {"N", "S", "E", "O", "NE", "SE", "SO", "NO"};
                    
            String direccion = direcciones[(int)Math.round(Math.random()*7)];
                    
            JPanel globo = Graficos.Lamina.globo;
                    
            int pixeles = 20, retardo = 100;
            
            int w = Toolkit.getDefaultToolkit().getScreenSize().width,
                    h = Toolkit.getDefaultToolkit().getScreenSize().height;
                    
            switch(direccion) {
                        
                case "N":
                            
                    if((globo.getY()-(5*pixeles)) < ((532/10)+5)) {
                        
                        moverGlobo();
                        
                        return;
                        
                    }

                    globo.setLocation(globo.getX(), globo.getY()-pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX(), globo.getY()-pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX(), globo.getY()-pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX(), globo.getY()-pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX(), globo.getY()-pixeles);

                    break;
                            
                case "S":
                    
                    if((globo.getY()+(5*pixeles)) > h/2) {
                        
                        moverGlobo();
                        
                        return;
                        
                    }

                    globo.setLocation(globo.getX(), globo.getY()+pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX(), globo.getY()+pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX(), globo.getY()+pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX(), globo.getY()+pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX(), globo.getY()+pixeles);

                    break;

                case "E":
                    
                    if((globo.getX()+(5*pixeles)) > w) {
                        
                        moverGlobo();
                        
                        return;
                        
                    }
                            
                    globo.setLocation(globo.getX()+pixeles, globo.getY());

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()+pixeles, globo.getY());

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()+pixeles, globo.getY());

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()+pixeles, globo.getY());

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()+pixeles, globo.getY());

                    break;

                case "O":

                    if((globo.getX()-(5*pixeles)) < 0) {
                        
                        moverGlobo();
                        
                        return;
                        
                    }
                    
                    globo.setLocation(globo.getX()-pixeles, globo.getY());

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()-pixeles, globo.getY());

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()-pixeles, globo.getY());

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()-pixeles, globo.getY());

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()-pixeles, globo.getY());

                    break;

                case "NE":
                    
                    if((globo.getX()+(5*pixeles)) > w || (globo.getY()-(5*pixeles)) < ((532/10)+5)) {
                        
                        moverGlobo();
                        
                        return;
                        
                    }

                    globo.setLocation(globo.getX()+pixeles, globo.getY()-pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()+pixeles, globo.getY()-pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()+pixeles, globo.getY()-pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()+pixeles, globo.getY()-pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()+pixeles, globo.getY()-pixeles);

                    break;

                case "SE":
                    
                    if((globo.getX()+(5*pixeles)) > w || (globo.getY()+(5*pixeles)) > h/2) {
                        
                        moverGlobo();
                        
                        return;
                        
                    }

                    globo.setLocation(globo.getX()+pixeles, globo.getY()+pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()+pixeles, globo.getY()+pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()+pixeles, globo.getY()+pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()+pixeles, globo.getY()+pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()+pixeles, globo.getY()+pixeles);

                    break;

                case "SO":
                    
                    if((globo.getX()-(5*pixeles)) < 0 || (globo.getY()+(5*pixeles)) > h/2) {
                        
                        moverGlobo();
                        
                        return;
                        
                    }

                    globo.setLocation(globo.getX()-pixeles, globo.getY()+pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()-pixeles, globo.getY()+pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()-pixeles, globo.getY()+pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()-pixeles, globo.getY()+pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()-pixeles, globo.getY()+pixeles);

                    break;

                default:
                    
                    if((globo.getX()-(5*pixeles)) < 0 || (globo.getY()-(5*pixeles)) < ((532/10)+5)) {
                        
                        moverGlobo();
                        
                        return;
                        
                    }

                    globo.setLocation(globo.getX()-pixeles, globo.getY()-pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()-pixeles, globo.getY()-pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()-pixeles, globo.getY()-pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()-pixeles, globo.getY()-pixeles);

                    Graficos.l.repaint();

                    Thread.sleep(retardo);

                    globo.setLocation(globo.getX()-pixeles, globo.getY()-pixeles);

            }
            
            Thread.sleep(retardo);
            
        }
        
    }
    
    public static class HCarros extends Thread {
        
        public void run() {
                
            while(true) {
                
                if(HCohetes.disponible) {
                    
                    moverCarro();
                    
                }
                
                try {

                    Thread.sleep(Math.round((Math.random()*5)+2)*1000);
                    
                } catch(InterruptedException e) {}

            }
            
        }
        
        private void moverCarro() {
            
            new Thread() {

                public void run() {

                    String[] carros = new String[15];

                    for(int i=0; i<15; i++) {

                        carros[i] = "src/globoaerostatico/carro" + (i+1) + ".png";

                    }

                    int x = (int)Math.round(Math.random()*14);

                    JPanel carro = new JPanel() {

                        public void paintComponent(Graphics g) {

                            super.paintComponent(g);

                            setBackground(new Color(12, 183, 242));

                            g.drawImage(Toolkit.getDefaultToolkit().getImage(carros[x]), 0, 0, this.getWidth(), this.getHeight(), null);

                        }

                    };

                    int w = Toolkit.getDefaultToolkit().getScreenSize().width,
                            h = Toolkit.getDefaultToolkit().getScreenSize().height;

                    carro.setBounds((-640/4)-15, (h-(320/4))-70, 640/4, 320/4);

                    Graficos.l.add(carro);

                    while(true) {

                        carro.setLocation(carro.getX()+7, carro.getY());
                        
                        disponible = carro.getX() > ((360/4)+30);

                        if(carro.getX() > ((w+640/4)+15)) {

                            break;

                        }

                        try {

                            Thread.sleep(20);

                        } catch(InterruptedException e) {}

                    }

                }

            }.start();

        }
        
        public static boolean disponible = false; 
        
    }
    
    public static class HHelicopteros extends Thread {
        
        public void run() {
                
            while(true) {

                moverHelicoptero();
                
                try {

                    Thread.sleep(Math.round((Math.random()*7)+2)*1000);
                    
                } catch(InterruptedException e) {}
                
            }
            
        }

        private void moverHelicoptero() {
            
            new Thread() {
                
                public void run() {
                    
                    String[] helicopteros = new String[10];
            
                    for(int i=0; i<10; i++) {
                
                        helicopteros[i] = "src/globoaerostatico/helicoptero" + (i+1) + ".png";
                
                    }
                    
                    int x = (int)Math.round(Math.random()*9);
                    
                    JPanel helicoptero = new JPanel() {
                        
                        public void paintComponent(Graphics g) {
                            
                            super.paintComponent(g);
                            
                            setBackground(new Color(12, 183, 242));
                            
                            g.drawImage(Toolkit.getDefaultToolkit().getImage(helicopteros[x]), 0, 0, this.getWidth(), this.getHeight(), null);
                            
                        }
                        
                    };
                    
                    int w = Toolkit.getDefaultToolkit().getScreenSize().width,
                            h = Toolkit.getDefaultToolkit().getScreenSize().height;
                    
                    helicoptero.setBounds((w+(960/10))+15, 5, 960/10, 532/10);
                    
                    Graficos.l.add(helicoptero);
                    
                    while(true) {
                        
                        helicoptero.setLocation(helicoptero.getX()-7, helicoptero.getY());
                        
                        if(helicoptero.getX() < (-30-(960/10))) {
                                
                            break;

                        }
                        
                        try {
                            
                            Thread.sleep(20);
                            
                        } catch(InterruptedException e) {}
                        
                    }
                    
                }
                
            }.start();
            
        }
        
    }
    
    public static class HCohetes extends Thread {
        
        public void run() {
            
            while(true) {
                
                if(HCarros.disponible) {
                    
                    moverCohete();
                    
                }
                
                try {

                    Thread.sleep(Math.round((Math.random()*7)+5)*1000);
                    
                } catch(InterruptedException e) {}
                
            }
            
        }
        
        private void moverCohete() {
            
            new Thread() {
                
                public void run() {
                    
                    String[] cohetes = new String[5];
            
                    for(int i=0; i<5; i++) {
                        
                        cohetes[i] = "src/globoaerostatico/cohete" + (i+1) + ".png";
                
                    }
                    
                    int x = (int)Math.round(Math.random()*4);
                    
                    JPanel cohete = new JPanel() {
                        
                        public void paintComponent(Graphics g) {
                            
                            super.paintComponent(g);
                            
                            setBackground(new Color(12, 183, 242));
                            
                            g.drawImage(Toolkit.getDefaultToolkit().getImage(cohetes[x]), 0, 0, this.getWidth(), this.getHeight(), null);
                            
                        }
                        
                    };
                    
                    int w = Toolkit.getDefaultToolkit().getScreenSize().width,
                            h = Toolkit.getDefaultToolkit().getScreenSize().height;
                    
                    cohete.setBounds(15, (h+(768/4))+15, 360/4, 768/4);
                    
                    Graficos.l.add(cohete);
                    
                    while(true) {
                        
                        cohete.setLocation(cohete.getX(), cohete.getY()-10);
                        
                        disponible = (cohete.getY()+(768/4)) < ((320/4)+85);
                        
                        if(cohete.getY() < ((-768/4)-15)) {
                                
                            break;
                                
                        }
                        
                        try {
                            
                            Thread.sleep(10);
                            
                        } catch(InterruptedException e) {}
                        
                    }
                    
                }
                
            }.start();
            
        }
        
        public static boolean disponible = true;
        
    }
    
    public static HGlobo hg = new HGlobo();
    
    public static HCarros hc = new HCarros();
    
    public static HCohetes hs = new HCohetes();
    
    public static HHelicopteros hh = new HHelicopteros();
    
}
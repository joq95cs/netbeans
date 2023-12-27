package filechooser;

import javax.swing.*;

import javax.swing.filechooser.*;

public class FileChooser {

    public static void main(String[] args) {
        
        Marco m = new Marco();
        
        m.setVisible(true);
        
        JFileChooser chooser = new JFileChooser();
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
        
        chooser.setFileFilter(filter);
        
        int returnVal = chooser.showOpenDialog(m);
        
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            
            System.out.println("You chose to open this file: " +
            chooser.getSelectedFile().getAbsolutePath());
            
        }
        
    }
    
}

class Marco extends JFrame {
    
    public Marco() {
        
        setSize(300, 300);
        
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}

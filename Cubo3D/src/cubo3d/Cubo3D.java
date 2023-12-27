package cubo3d;

import com.sun.j3d.utils.universe.*;

import com.sun.j3d.utils.geometry.*;

import javax.media.j3d.*;

public class Cubo3D {
    
    public Cubo3D() {
        
        SimpleUniverse su = new SimpleUniverse();
        
        BranchGroup bg = new BranchGroup();
        
        bg.addChild(new ColorCube(0.3));
        
        su.getViewingPlatform().setNominalViewingTransform();
        
        su.addBranchGraph(bg);
        
    }

    public static void main(String[] args) {
        
        System.setProperty("sun.awt.noerasebackground", "true");
        
        new Cubo3D();

    }
    
}
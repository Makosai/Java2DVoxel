/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java2dvoxel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel; // temp

/**
 *
 * @author Kristopher Ali
 */
public class Sprite {
    private ImageIcon img;
    private JLabel obj;
    
    public Sprite() {
        
    }
    
    public Sprite(String newImg) {
        setSprite(newImg);
    }
    
    /**
     * Sets the ImageIcon of this Sprite object.
     * @param newImg The image file path and extension
     */
    public final void setSprite(String newImg) {
        try {
            File file = new File(newImg);
            BufferedImage image = ImageIO.read(file);
            img = new ImageIcon(image);
            obj = new JLabel(img);
            //Java2DVoxel.renderer.add(obj);
            //Java2DVoxel.renderer.pack();
            //System.out.println("DEBUG: Added " + file.getPath() + " to the JFrame.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Returns the obj variable.
     * @return The JLabel if the ImageIcon.
     */
    public final JLabel getObj() {
        return obj;
    }
    
    /**
     * Returns the img variable.
     * @return The image of this Sprite object.
     */
    public final ImageIcon getSprite() {
        return img;
    }
}

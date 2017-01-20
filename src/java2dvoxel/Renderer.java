/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dvoxel;
import java.util.ArrayList;
import java.awt.*;

//import input.InputHandler;
import java.awt.event.KeyEvent;

import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import java.awt.Graphics2D;

/**
 * Renders the current map.
 * @author Kristopher Ali
 */
public class Renderer extends JFrame {
    public ArrayList<Map> maps = new ArrayList<>();
    public GameObject player = new GameObject();
    
    public int x = 0;
    
    // Configurations
    int windowWidth = 500, windowHeight = 500;
    final boolean RESIZABLE = true;
    Insets insets;
    //InputHandler input;
    BufferedImage backBuffer;
    
    /**
     *
     */
    public Renderer() {
        initialize();
    }
    
    final void initialize() {
        setTitle("Vox Engine");
        setSize(windowWidth, windowHeight);
        setResizable(RESIZABLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        insets = getInsets();
        setSize(insets.left + windowWidth + insets.right, insets.top + windowHeight + insets.bottom);
        
        backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
        //input = new InputHandler(this);
    }
    
    void draw() {
        Graphics g = getGraphics();
        Graphics bbg = backBuffer.getGraphics();
        
        bbg.setColor(Color.WHITE);
        bbg.fillRect(0, 0, windowWidth, windowHeight);
        
        bbg.setColor(Color.BLACK);
        bbg.drawOval(x, 10, 20, 20);
        
        g.drawImage(backBuffer, insets.left, insets.top, this);
    }
    
    /**
     * Adds an object to the map and applies a render layer.
     * @param x The x-coordinate of the object.
     * @param y The y-coordinate of the object.
     * @param map The map to store this object on.
     * @param layer The layer in which to draw this object.
     */
    public void add(int x, int y, int map, int layer) {
        
    }
    
    /**
     * Adds a GUI to the screen.
     * @param x The x-coordinate of the GUI.
     * @param y The y-coordinate of the GUI.
     * @param layer The layer in which to draw this GUI.
     */
    public void addGui(int x, int y, int layer) {
        
    }
}

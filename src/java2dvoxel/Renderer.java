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
    public static ArrayList<Map> maps = new ArrayList<>();
    public static GameObject player = new GameObject();
    public static Player controller = new Player();
    public static Camera cam = new Camera(player);
    
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
        setFocusable(true);
        
        insets = getInsets();
        setSize(insets.left + windowWidth + insets.right, insets.top + windowHeight + insets.bottom);
        
        backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
        //input = new InputHandler(this);
        addKeyListener(Java2DVoxel.keymapping);
    }
    
    void draw() {
        Graphics g = getGraphics();
        Graphics bbg = backBuffer.getGraphics();
        
        bbg.setColor(Color.BLACK);
        bbg.fillRect(0, 0, windowWidth, windowHeight);
        
        if(maps.size() > 0) {
            Map map = maps.get(0);
            for(Tile[] x : map.data) {
                for(Tile y : x) {
                    if(y != null && y.data.size() > 0) {
                        y.data.get(0).draw();
                        System.out.println("drew");
                    }
                }
            }
        }
        
        //bbg.drawOval(cam.x, cam.y, 32, 32);
        controller.draw();
        
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
    
    /**
     * Generates a randomized map.
     * TODO: Make it random.
     * @param xSize How large the map is on the x-axis.
     * @param ySize How large the map is on the y-axis.
     */
    public final void generateMap(int xSize, int ySize) {
        Map newMap = new Map(xSize, ySize);
        
        Tile newTile1 = new Tile();
        GameObject newGo1 = new GameObject(new Sprite("rsc/tile.png"));
        newTile1.data.add(newGo1);
        
        newMap.data[0][0] = newTile1;
        
        maps.add(newMap);
    }
}

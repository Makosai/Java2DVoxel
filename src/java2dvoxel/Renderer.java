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
    public static Player player = new Player(new Sprite("rsc/mob.png"));
    public static Camera cam = new Camera(player);
    
    // Configurations
    final int globalSize = Constants.WORLD_SIZE * ((Constants.VIEW_SIZE * 4) + 1);
    int windowWidth = globalSize, windowHeight = globalSize;
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
        addKeyListener(Java2DVoxel.keymapping);
        addMouseListener(Java2DVoxel.keymapping);
    }
    
    void draw() {
        Graphics g = getGraphics();
        Graphics bbg = backBuffer.getGraphics();
        
        bbg.setColor(Color.GREEN);
        bbg.fillRect(0, 0, windowWidth, windowHeight);
        
        if(maps.size() > 0) {
            Map map = maps.get(0);
            for(Tile[] x : map.data) {
                for(Tile y : x) {
                    if(y != null && y.data.size() > 0) {
                        y.data.get(0).draw();
                        //System.out.println("drew");
                    }
                }
            }
        }

        player.draw();
        
        g.drawImage(backBuffer, insets.left, insets.top, this);
    }
    
    /**
     * Adds an object to the map and applies a render layer.
     * @param x The x-coordinate of the object.
     * @param y The y-coordinate of the object.
     * @param map The map to store this object on.
     * @param layer The layer in which to draw this object.
     */
    public void add(int x, int y, int map, boolean density, String img) {
        Tile tile = maps.get(map).data[x][y];
        if(tile == null) tile = new Tile();
        GameObject gO = new GameObject(x, y, new Sprite("rsc/" + img));
        tile.data.add(gO);
        
        maps.get(map).data[x][y] = tile;
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
        maps.add(new Map(xSize, ySize));
        
        add(0, 0, 0, false, "tile.png");
        add(5, 5, 0, true, "block.png");
    }
}

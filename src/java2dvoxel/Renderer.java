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

import java2dvoxel.Essentials;

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
        gO.density = density;
        tile.data.add(gO);
        
        maps.get(map).data[x][y] = tile;
    }
    
    public void add(int x, int y, Map map, boolean density, String img) {
        Tile tile = map.data[x][y];
        if(tile == null) tile = new Tile();
        GameObject gO = new GameObject(x, y, new Sprite("rsc/" + img));
        gO.density = density;
        tile.data.add(gO);
        
        map.data[x][y] = tile;
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
        add(3, 7, 0, true, "block.png");
        
        Map map = maps.get(0);
        Room testRoom = createRoom(map, map.sizeX / 2, map.sizeY / 2, Essentials.rand(3, 15), Essentials.rand(3, 15));
        player.move(testRoom.xCenter, testRoom.yCenter);
        // next room should be 16 tiles away from the previous room and all other rooms
        // since they're all square, you can do this by scanning in a straight line
        // in 4 different directions to check for any existing tiles in the map
        /*
        TODO: The real map generation should meet the following requirements:
        - Creates rooms
        - Rooms have a min/max x/y size
        - Rooms have a min/max margin size
        - Paths connect rooms
        - 1 or more openings in a random side (except corners)
        
        Here's how you can go about generating it:
        - Create a rectangular / square room at 0,0
        - Set the size of the map to this room + the margin of that room
        - Create another room and move it to the right of the previous room
        - Repeat this process until it hits the max map size
        - The last room must not make the map bigger than the max map size
        and must match the min / max room size
        - Move to the next row and repeat the process again, left to right.
        - This time, make sure the position and size of it doesn't conflict
        with the previous row (calculations required).
        - Once every row is filled, connect them with corridors.
        - If possible, make the corridors winding and have variating sizes.
        */
    }
    
    /**
     * Creates a room.
     * @param map The map to create the room in.
     * @param xCenter The x-location to start in the map.
     * @param yCenter The y-location to start in the map.
     * @param xSize The horizontal size from the center (inclusive).
     * @param ySize The vertical size from the center (inclusive),
     * @return The room's saved data.
     */
    public Room createRoom(Map map, int xCenter, int yCenter, int xSize, int ySize) {
        // Store the room's data.
        Room room = new Room();
        room.map = map;
        room.xCenter = xCenter;
        room.yCenter = yCenter;
        room.xSize = xSize;
        room.ySize = ySize;
        
        //Fill Center
        for(int x = xCenter - xSize + 1; x < xCenter + xSize; x++) {
            for(int y = yCenter - ySize + 1; y < yCenter + ySize; y++) {
                add(x, y, map, false, "tile.png");
            }
        }
        
        //Top (corners inclusive)
        for(int x = xCenter - xSize; x <= xCenter + xSize; x++) {
            add(x, yCenter - ySize, map, true, "block.png");
        }
        
        //Bottom (corners inclusive)
        for(int x = xCenter - xSize; x <= xCenter + xSize; x++) {
            add(x, yCenter + ySize, map, true, "block.png");
        }
        
        //Left (corners exclusive)
        for(int y = yCenter - ySize + 1; y < yCenter + ySize; y++) {
            add(xCenter + xSize, y, map, true, "block.png");
        }
        
        //Right (corners exclusive)
        for(int y = yCenter - ySize + 1; y < yCenter + ySize; y++) {
            add(xCenter - xSize, y, map, true, "block.png");
        }
        
        return room;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dvoxel;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics2D;

/**
 * Renders the current map.
 * @author Kristopher Ali
 */
public class Renderer extends JPanel {
    public ArrayList<Map> maps = new ArrayList<>();
    
    /**
     *
     */
    public Renderer() {
        
    }
    
    public void paint(Graphics2D g) {
        
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

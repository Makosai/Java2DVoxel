/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java2dvoxel;

import java.awt.Dimension;
import java.awt.Image;

/**
 * Data on a specific object; such as sprite, name, and location.
 * @author Kristopher Ali
 */
public class GameObject {
    public int x = 0, y = 0;
    public Sprite sprite;
    
    public GameObject() {
        
    }
    
    public GameObject(Sprite newSprite) {
        sprite = newSprite;
    }
    
    Renderer renderer = Java2DVoxel.renderer;
    public void draw() {
        boolean eyed = false; // temporary, indicates that this object is being watched by the camera so center it.
        Dimension dim = renderer.getSize();
        Image img = sprite.getSprite().getImage();
        int drawX = (dim.width / 2) - (img.getWidth(renderer) / 2) - 8, drawY = (dim.width / 2) - (img.getHeight(renderer) / 2) - 8;
        if(!eyed) {
            drawX = (x * Constants.WORLD_SIZE) - (renderer.cam.x * Constants.WORLD_SIZE); //renderer.player.x * Constants.WORLD_SIZE;
            drawY = (y * Constants.WORLD_SIZE) - (renderer.cam.y * Constants.WORLD_SIZE); //Renderer.player.y * Constants.WORLD_SIZE;
        }
        renderer.backBuffer.getGraphics().drawImage(
                img,
                drawX,
                drawY,
                renderer
        );
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java2dvoxel;
import java.awt.Dimension;
import java.awt.Image;
import java2dvoxel.Enums.Directions;

/**
 *
 * @author Kristopher Ali
 */
public class Player {
    Renderer renderer = Java2DVoxel.renderer;
    Sprite sprite = new Sprite("rsc/mob.png");
    
    public void changePos(int x, int y) {
        if(x != 0) {
            renderer.player.x += x;
            if(renderer.player.x > renderer.maps.get(renderer.player.z).sizeX) {
                //renderer.player.x = renderer.maps.get(renderer.player.z).sizeX;
            }
            if(renderer.player.x < 0) {
                //renderer.player.x = 0;
            }
            renderer.cam.x = renderer.player.x;
        }
        
        if(y != 0) {
            renderer.player.y += y;
            if(renderer.player.y > renderer.maps.get(renderer.player.z).sizeY) {
                //renderer.player.y = renderer.maps.get(renderer.player.z).sizeY;
            }
            if(renderer.player.y < 0) {
                //renderer.player.y = 0;
            }
            renderer.cam.y = renderer.player.y;
        }
    }
    
    public void wrapPlayer() {
        
    }
    
    public void move(int x, int y) {
        
    }
    
    /**
     * Steps the user 1 tile in a direction.
     * @param dir The direction to step the user in.
     */
    public void step(Directions dir) {
        switch(dir) {
            case NORTH:
                changePos(0, -1);
                break;
            case SOUTH:
                changePos(0, 1);
                break;
            case EAST:
                changePos(1, 0);
                break;
            case WEST:
                changePos(-1, 0);
                break;
        }
    }
    
    public void draw() {
        if(renderer == null) {renderer = Java2DVoxel.renderer; return;} // Just renew the renderer. This should be fixed in the future (more neat).
        
        boolean eyed = true; // temporary, indicates that this object is being watched by the camera so center it.
        Dimension dim = renderer.getSize();
        Image img = sprite.getSprite().getImage();
        int drawX = (dim.width / 2) - (img.getWidth(renderer) / 2) - 8, drawY = (dim.width / 2) - (img.getHeight(renderer) / 2) - 8;
        if(!eyed) {
            drawX = (renderer.player.x * Constants.WORLD_SIZE) - (renderer.cam.x * Constants.WORLD_SIZE); //renderer.player.x * Constants.WORLD_SIZE;
            drawY = (renderer.player.y * Constants.WORLD_SIZE) - (renderer.cam.y * Constants.WORLD_SIZE); //Renderer.player.y * Constants.WORLD_SIZE;
        }
        renderer.backBuffer.getGraphics().drawImage(
                img,
                drawX,
                drawY,
                renderer
        );
    }
}

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
public class Player extends GameObject {
    boolean eyed = true;

    Player(Sprite newSprite) {
        super(newSprite);
    }
    
    public void changePos(int x, int y) {
        if(x != 0) {
            this.x += x;
            if(this.x > renderer.maps.get(this.z).sizeX) {
                //this.x = renderer.maps.get(this.z).sizeX;
            }
            if(this.x < 0) {
                this.x = 0;
            }
            renderer.cam.x = this.x;
        }
        
        if(y != 0) {
            this.y += y;
            if(this.y > renderer.maps.get(this.z).sizeY) {
                //this.y = renderer.maps.get(this.z).sizeY;
            }
            if(this.y < 0) {
                this.y = 0;
            }
            renderer.cam.y = this.y;
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
}

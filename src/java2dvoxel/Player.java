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
    public boolean eyed = true;
    public boolean density = true;

    Player(Sprite newSprite) {
        super(newSprite);
    }
    
    public void changePos(int x, int y) {
        Map map = renderer.maps.get(this.z);
        
        if(x != 0) {
            this.x += x;
            if(this.x > map.sizeX) {
                this.x = map.sizeX;
            }
            if(this.x < 0) {
                this.x = 0;
            }
            
            renderer.cam.x = this.x;
        }
        
        if(y != 0) {
            this.y += y;
            if(this.y > map.sizeY) {
                this.y = map.sizeY;
            }
            if(this.y < 0) {
                this.y = 0;
            }

            renderer.cam.y = this.y;
        }
        
        // If they are dense, make them collidable.
        // If they are not dense, allow them to go through other dense objects.
        // As well as other non-dense objects.
        if(density) {
            for(GameObject gO : map.data[this.x][this.y].data) {
                if(gO.density) {
                    this.x -= x;
                    this.y -= y;
                    break;
                }
            }
            
            renderer.cam.x = this.x;
            renderer.cam.y = this.y;
        }
        
    }
    
    public void wrapPlayer() {
        
    }
    
    /**
     * Moves the player to a location forcefully.
     * @param x
     * @param y 
     */
    public void move(int x, int y) {
        changePos(x - this.x, y - this.y);
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

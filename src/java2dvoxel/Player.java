/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java2dvoxel;
import java2dvoxel.Enums.Directions;

/**
 *
 * @author Kristopher Ali
 */
public class Player {
    Renderer renderer = Java2DVoxel.renderer;
    Sprite sprite = new Sprite("rsc/block.png");
    
    public void changePos(int x, int y) {
        if(x != 0) {
            renderer.player.x += x;
            renderer.cam.x = renderer.player.x;
        }
        
        if(y != 0) {
            renderer.player.y += y;
            renderer.cam.y = renderer.player.y;
        }
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
        else System.out.println(2);
        renderer.backBuffer.getGraphics().drawImage(sprite.getSprite().getImage(), renderer.player.x * Constants.WORLD_SIZE, renderer.player.y * Constants.WORLD_SIZE, renderer);
    }
}

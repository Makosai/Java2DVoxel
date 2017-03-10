/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dvoxel;
import java.io.File;
import java2dvoxel.Enums.Directions;

/**
 *
 * @author Kristopher Ali
 */
public class Java2DVoxel {

    // Variables
    public static Engine engine;
    public static boolean isRunning;
    
    // Objects
    public static Keymapping keymapping = new Keymapping();
    public static Renderer renderer = new Renderer();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //System.out.println(new File("").getAbsolutePath());
        isRunning = true;
        engine = new Engine();
    }
    
    // Handles ticks, rendering, and timers
    public static class Engine {
        
        // Variables
        public byte fps = 0;
        public long lastFps = 0;
        public int fpsCap = 60;
        public long lastTime = System.nanoTime(), currentTime = 0, optimalTime = 1000000000 / fpsCap;
        private java.util.Timer timer;
        
        /**
         * Engine core; starts a timer to loop the engine.
         */
        public Engine() {
            timer = new java.util.Timer();
            timer.schedule(new EngineLoop(), 0, (lastTime - System.nanoTime() + optimalTime) / 1000000);
        
            renderer.generateMap(100,100);
        }
        
        /**
         * Contains the engine's loop.
         */
        public class EngineLoop extends java.util.TimerTask {            
            public void run() {
                long now = System.nanoTime();
                long elapsedTime = now - lastTime; 
                lastTime = now;
                double delta = elapsedTime / ((double)optimalTime);

                //FPS Counter
                lastFps += elapsedTime;
                fps++;

                if(lastFps >= 1000000000) {
                    System.out.println("FPS: " + fps);
                    lastFps = 0;
                    fps = 0;
                }
                
                update(delta);
                render();
                
                if(!isRunning) {
                    timer.cancel();
                }
            }
        }
    
        /**
         * Update the engine logic
         * @param delta Current delta time.
         */
        public void update(double delta) {
            // Jpanel for ui and buttons
        }
        
        /**
         * Render to the screen (may be moved to the Renderer class.)
         */
        public void render() {
            // render 2d dynamic list where layers are represented by an object's index in the list
            // [x][y] = ObjectList. So each x and y coord contains data
            // Idea: http://gamedev.stackexchange.com/questions/35829/drawing-graphics-in-java-game
            
            renderer.draw();
        }
    }

}

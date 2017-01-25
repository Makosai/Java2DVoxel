/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java2dvoxel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java2dvoxel.Enums.Directions;

/**
 *
 * @author Kristopher Ali
 */
public class Keymapping extends JFrame implements KeyListener, ActionListener {
    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar() + " has been typed.");
        char key = e.getKeyChar();
        switch(key) {
            // Movement
            case 'w':
                Java2DVoxel.renderer.controller.step(Directions.NORTH);
                break;
            case 'W':
                Java2DVoxel.renderer.controller.step(Directions.NORTH);
                break;
                
            case 'a':
                Java2DVoxel.renderer.controller.step(Directions.WEST);
                break;
            case 'A':
                Java2DVoxel.renderer.controller.step(Directions.WEST);
                break;
                
            case 's':
                Java2DVoxel.renderer.controller.step(Directions.SOUTH);
                break;
            case 'S':
                Java2DVoxel.renderer.controller.step(Directions.SOUTH);
                break;
                
            case 'd':
                Java2DVoxel.renderer.controller.step(Directions.EAST);
                break;
            case 'D':
                Java2DVoxel.renderer.controller.step(Directions.EAST);
                break;
        }
        
    }

    /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar() + " has been pressed.");
        Java2DVoxel.renderer.controller.move(1, 1);
    }

    /** Handle the key released event from the text field. */
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyChar() + " has been released.");
        Java2DVoxel.renderer.controller.move(1, 1);
    }

    /** Handle the button click. */
    public void actionPerformed(ActionEvent e) {
        //Clear the text components.
        //displayArea.setText("");
        //typingArea.setText("");

        //Return the focus to the typing area.
        //typingArea.requestFocusInWindow();
    }
}
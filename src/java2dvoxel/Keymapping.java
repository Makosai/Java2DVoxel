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
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import java2dvoxel.Enums.Directions;

/**
 *
 * @author Kristopher Ali
 */
public class Keymapping extends JFrame implements MouseListener, KeyListener, ActionListener {
    // Set of currently pressed keys
    private final Set<Character> charPressed = new HashSet<Character>();
    private final Set<Integer> codePressed = new HashSet<Integer>();
    
    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar() + " has been typed.");
    }

    /** Handle the key pressed event from the text field. */
    public synchronized void keyPressed(KeyEvent e) {
        charPressed.add(e.getKeyChar());
        
        for(Character key : charPressed) {
            switch(key) {
                // Movement
                case 'w':
                    Java2DVoxel.renderer.player.step(Directions.NORTH);
                    break;
                case 'W':
                    Java2DVoxel.renderer.player.step(Directions.NORTH);
                    break;

                case 'a':
                    Java2DVoxel.renderer.player.step(Directions.WEST);
                    break;
                case 'A':
                    Java2DVoxel.renderer.player.step(Directions.WEST);
                    break;

                case 's':
                    Java2DVoxel.renderer.player.step(Directions.SOUTH);
                    break;
                case 'S':
                    Java2DVoxel.renderer.player.step(Directions.SOUTH);

                case 'd':
                    Java2DVoxel.renderer.player.step(Directions.EAST);
                    break;
                case 'D':
                    Java2DVoxel.renderer.player.step(Directions.EAST);
                    break;
                
                default:
                    System.out.println(e.getKeyCode());
                    charPressed.remove(e.getKeyChar());
                    codePressed.add(e.getKeyCode());
                    break;
            }
        }
        
        for(Integer key : codePressed) {
            switch(key) {
                case KeyEvent.VK_UP:
                    Java2DVoxel.renderer.player.step(Directions.NORTH);
                    break;

                case KeyEvent.VK_LEFT:
                    Java2DVoxel.renderer.player.step(Directions.WEST);
                    break;

                case KeyEvent.VK_DOWN:
                    Java2DVoxel.renderer.player.step(Directions.SOUTH);
                    break;

                case KeyEvent.VK_RIGHT:
                    Java2DVoxel.renderer.player.step(Directions.EAST);
                    break;

                default:
                    codePressed.remove(e.getKeyCode());
                    break;
            }
        }
        
        System.out.println(e.getKeyChar() + " has been pressed.");
    }

    /** Handle the key released event from the text field. */
    public synchronized void keyReleased(KeyEvent e) {
        if(charPressed.contains(e.getKeyChar())) {
            charPressed.remove(e.getKeyChar());
        }
        
        if(codePressed.contains(e.getKeyCode())) {
            codePressed.remove(e.getKeyCode());
        }

        System.out.println(e.getKeyChar() + " has been released.");
    }

    /** Handle the button click. */
    public void actionPerformed(ActionEvent e) {
        //Clear the text components.
        //displayArea.setText("");
        //typingArea.setText("");

        //Return the focus to the typing area.
        //typingArea.requestFocusInWindow();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked.");
        e.getXOnScreen();
        e.getYOnScreen(); // Use these and multiply by Constants.WORLD_SIZE to determine what tile they clicked.
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
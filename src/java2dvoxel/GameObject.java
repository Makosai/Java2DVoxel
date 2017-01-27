/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java2dvoxel;

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
}

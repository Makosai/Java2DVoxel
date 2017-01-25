/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java2dvoxel;

/**
 *
 * @author Kristopher Ali
 */
public class Camera {
    public GameObject follow;
    public int x, y;
    
    public Camera(GameObject mob) {
        follow = mob;
    }
}

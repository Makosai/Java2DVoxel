/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java2dvoxel;

import java.util.Random;

/**
 *
 * @author Kristopher Ali
 */
public class Essentials {
    public static int rand(int min, int max) {
        if (min >= max)
                throw new IllegalArgumentException("max must be greater than min");
        
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}

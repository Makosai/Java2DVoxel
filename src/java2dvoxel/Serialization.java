/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java2dvoxel;
import java.io.*;
import java.util.ArrayList;
import java2dvoxel.Enums.DataTypes;

/**
 *
 * @author Kristopher Ali
 */
public class Serialization {
    /**
     * Saves data to a .dat file.
     * @param data Takes a DataType enum.
     */
    public void Save(DataTypes data) {
        switch(data) {
            case MAP:
                try {
                    FileOutputStream fos = new FileOutputStream("data/Map.dat");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(Java2DVoxel.renderer.maps);
                    oos.close();
                    fos.close();
                } catch (Exception e) {

                }
                break;
        }
    }
    
    /**
     * Loads data from a .dat file.
     * @param data Takes a DataType enum.
     */
    public void Load(DataTypes data) {
        switch(data) {
            case MAP:
                try {
                    FileInputStream fis = new FileInputStream("data/Map.dat");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Java2DVoxel.renderer.maps = (ArrayList<Map>) ois.readObject();
                    ois.close();
                    fis.close();
                } catch (Exception e) {

                }
                break;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Toys4U.GameOfLifeWorld;

import Toys4U.Infrastructure.Generator;

/**
 *
 * @author Charles Korthout
 */
public class HabitatFactory { 
    public static Habitat create(int worldid, int habitatid,int rows, int columns, Generator generator) {
        Habitat habitat = new Habitat(worldid, habitatid, rows, columns);
        /**
         * TODO
         * 
         * [0..i..rows]
         *      [0..j..columns] 
         *          habitat.put( ParticleFactory.create(new Location(row,column)))
         * 
         */
        return habitat;
    }

}

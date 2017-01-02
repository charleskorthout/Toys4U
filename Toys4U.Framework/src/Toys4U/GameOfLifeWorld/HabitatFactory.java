/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Toys4U.GameOfLifeWorld;

import Toys4U.Infrastructure.Generator;
import Toys4U.Network.AddressImpl;
import Toys4U.Particles.Collections.ParticleCollection;

/**
 *
 * @author Charles Korthout
 */
public class HabitatFactory { 
    public static Habitat create(int worldid, int habitatId, int rows, int columns, int landSurface) {
        Habitat habitat = new Habitat(worldid, habitatId, rows, columns);

        System.out.println("DEBUG: filling habitat with objects..");

        int mapSize = rows*columns;
        for (int cnt = 0; cnt < mapSize; cnt++) {

            int x = cnt%rows;
            int y = cnt/rows;
            AddressImpl adress = new AddressImpl(worldid, habitatId, x, y);
            habitat.put(adress, new ParticleCollection());
        }
        System.out.println("DEBUG: created new habitat with " + mapSize + " addresses.");

        RandomGenerator randomGenerator = new RandomGenerator(landSurface, rows, columns);
        habitat.generate(randomGenerator.generate());

        return habitat;
    }

}

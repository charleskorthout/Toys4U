/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Toys4U.GameOfLifeWorld;

import Toys4U.Infrastructure.Generator;
import Toys4U.Network.AddressImpl;
import Toys4U.Particles.Collections.ParticleCollection;
import Toys4U.Particles.Particle;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Charles Korthout
 */
public class HabitatFactory { 
    public static Habitat create(int worldid, int habitatId, int rows, int columns, int landSurface) {
        Habitat habitat = new Habitat(worldid, habitatId, rows, columns);

        System.out.println("DEBUG: filling habitat with objects..");

        RandomGenerator mapGenerator = new RandomGenerator(landSurface, rows, columns);
        ArrayList<Particle> particlesMap = mapGenerator.generate();
        Iterator<Particle> particleIterator = particlesMap.iterator();

        int mapSize = rows*columns;
        for (int cnt = 0; cnt < mapSize; cnt++) {

            int x = cnt%rows;
            int y = cnt/rows;
            AddressImpl adress = new AddressImpl(worldid, habitatId, x, y);

            ParticleCollection particleCollection = new ParticleCollection();
            particleCollection.add(particleIterator.next());
            habitat.put(adress, particleCollection);
        }
        System.out.println("DEBUG: created new habitat with " + mapSize + " addresses.");


        return habitat;
    }

}

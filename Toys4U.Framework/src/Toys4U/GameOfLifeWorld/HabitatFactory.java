/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Toys4U.GameOfLifeWorld;

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
    public static Habitat create(int worldid, int habitatId, HabitatGenerator rGenerator) {

        Habitat habitat = new Habitat(worldid, habitatId, rGenerator.getRows(), rGenerator.getColumns());

        System.out.println("DEBUG: filling habitat with objects..");

        ArrayList<Particle> particlesMap = rGenerator.generate();
        Iterator<Particle> particleIterator = particlesMap.iterator();

        int mapSize = rGenerator.getRows() * rGenerator.getColumns();
        for (int cnt = 0; cnt < mapSize; cnt++) {

            int x = cnt % rGenerator.getColumns();
            int y = cnt / rGenerator.getRows();
            AddressImpl adress = new AddressImpl(worldid, habitatId, x, y);

            ParticleCollection particleCollection = new ParticleCollection();
            particleCollection.add(particleIterator.next());
            habitat.put(adress, particleCollection);
        }

        System.out.println("DEBUG: created new habitat with " + mapSize + " addresses.");
        return habitat;
    }

}

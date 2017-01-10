package Toys4U.GameOfLifeWorld;


import Toys4U.Infrastructure.Generator;
import Toys4U.Particles.Particle;
import com.sun.xml.internal.bind.v2.util.QNameMap;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class ProportionalHabitatGenerator implements HabitatGenerator {
    HashMap<Particle,Double> weights;

    public ProportionalHabitatGenerator(HashMap<Particle,Double> weights, int rows, int columns) {
        this.weights = weights;
    }

    /**
     * Create a weighted or propotional partical selection
     * @param weights the map with particle / weights
     * @param random the random generator
     * @param <Particle> the particle
     * @return
     */
    private <Particle> Particle getWeightedRandom(HashMap<Particle,Double> weights, Random random) {
        return weights
                .entrySet()
                .stream()
                .map(e -> new AbstractMap.SimpleEntry<Particle,Double>(e.getKey(),-Math.log(random.nextDouble()) / e.getValue()))
                .min((e0,e1)-> e0.getValue().compareTo(e1.getValue()))
                .orElseThrow(IllegalArgumentException::new).getKey();
    }


    @Override
    public ArrayList<Particle> generate(){
        throw new NotImplementedException();
    };

    public int getLandSurface(){
        throw new NotImplementedException();
    };
    public int getRows(){
        throw new NotImplementedException();
    };
    public int getColumns(){
        throw new NotImplementedException();
    };
    public int getTotalCells(){
        throw new NotImplementedException();
    };
}
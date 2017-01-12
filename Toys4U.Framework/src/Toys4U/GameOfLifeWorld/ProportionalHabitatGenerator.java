package Toys4U.GameOfLifeWorld;


import Toys4U.Network.AddressImpl;
import Toys4U.Network.CellImpl;
import Toys4U.Particles.Collections.ParticleCollection;
import Toys4U.Particles.Particle;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class ProportionalHabitatGenerator implements HabitatGenerator {
    private final HashMap<Particle,Double> weights;
    private final int habitatid;
    private final int worldid;
    private final int rows;
    private final int columns;
    private final Random random;

    public ProportionalHabitatGenerator(HashMap<Particle,Double> weights,int worldid, int habitatid, int rows, int columns, Random random) {
        this.weights = weights;
        this.worldid = worldid;
        this.habitatid = habitatid;
        this.columns = columns;
        this.rows=rows;
        this.random = random;
    }

    /**
     * Create a weighted or propotional partical selection
     * @param <Particle> the particle
     * @return
     */
    private <Particle> Particle getWeightedRandomParticle() {
        return weights
                .entrySet()
                .stream()
                .map(e -> new AbstractMap.SimpleEntry<Particle,Double>((Particle)e.getKey(),-Math.log(random.nextDouble()) / e.getValue()))
                .min((e0,e1)-> e0.getValue().compareTo(e1.getValue()))
                .orElseThrow(IllegalArgumentException::new).getKey();

    }

    /**
     * Create a list of particles based on the weighted proportions
     * @return the list of particles
     */
    /*
    @Override
    public ArrayList<Particle> generate(){
        ArrayList<Particle> randomMap = new ArrayList<>();
        int cellsCount = this.rows*this.columns;
        for (int counter = 0; counter < cellsCount; counter++) {
            randomMap.add(getWeightedRandomParticle());
        }
        return randomMap;
    };
    */

    /**
     * Habitat generation
     * @return the generated habitat
     */
    public Habitat generate() {
        Habitat habitat = new Habitat(worldid, habitatid, rows, columns);
        for (int x =0 ; x < rows ; x++){
            for (int y = 0; y < columns; y++) {
                AddressImpl address = new AddressImpl(worldid, habitatid, x, y);
                CellImpl cell = new CellImpl(address);
                ParticleCollection particles = cell.getParticles();
                particles.add(getWeightedRandomParticle());
                cell.setParticles(particles);
                habitat.put(cell);
            }
        }
        return habitat;
    }
    public int getLandSurface(){
        throw new NotImplementedException();
    }

    @Override
    public int getWorldId() {
        return worldid;
    }

    @Override
    public int getHabitatId() {
        return habitatid;
    }

    public int getRows(){
        return rows;
    }
    public int getColumns(){
        return columns;
    };
    public int getTotalCells(){
        return rows*columns;
    };
}
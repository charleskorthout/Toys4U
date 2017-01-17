package Toys4U.GameOfLifeWorld;


import Toys4U.Network.AddressImpl;
import Toys4U.Network.CellImpl;
import Toys4U.Particles.*;
import Toys4U.Particles.Collections.ParticleCollection;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;


public class ProportionalHabitatGenerator implements HabitatGenerator {
    private final HashMap<String, Double> weights;
    private final int habitatid;
    private final int worldid;
    private final int rows;
    private final int columns;
    private final Random random;
    private List<Particle> randomParticles;

    public ProportionalHabitatGenerator(HashMap<String, Double> weights, int worldid, int habitatid, int rows, int columns, Random random) {
        this.weights = weights;
        this.worldid = worldid;
        this.habitatid = habitatid;
        this.columns = columns;
        this.rows = rows;
        this.random = random;
        this.randomParticles = new ArrayList<>();
        this.generateWeightedParticle();
    }

    /**
     * Create a weighted or propotional partical selection
     * TODO: omzetten naar factory    private Particle getWeightedRandomParticle() {

     if (newParticle instanceof Carnivore) {
            return new CarnivoreImpl();
     } else if (newParticle instanceof Herbivore) {
            return new CarnivoreImpl();
        } else if (newParticle instanceof OmnivoreImpl) {
            return new CarnivoreImpl();
        } else if (newParticle instanceof Water) {
            return new Water();
        } else if (newParticle instanceof Plant) {
            return new PlantImpl();
        } else if (newParticle instanceof Obstacle) {
            return new Obstacle();
        } else {
            return new Land();
        }

    }
     * @return
     */


    public void generateWeightedParticle() {
        int totalCells = this.rows * this.columns;
        for (Map.Entry<String, Double> entry : this.weights.entrySet()) {
            for (int counter = 0; counter < ((totalCells / 100) * (entry.getValue() * 100)); counter++) {
                if (entry.getKey().equals("Obstacle")) {
                    this.randomParticles.add(new Obstacle());
                } else if (entry.getKey().equals("Plant")) {
                    this.randomParticles.add(new PlantImpl());
                } else if (entry.getKey().equals("OmnivoreImpl")) {
                    this.randomParticles.add(new OmnivoreImpl());
                } else if (entry.getKey().equals("CarnivoreImpl")) {
                    this.randomParticles.add(new CarnivoreImpl());
                } else if (entry.getKey().equals("HerbivoreImpl")) {
                    this.randomParticles.add(new HerbivoreImpl());
                } else if (entry.getKey().equals("Land")) {
                    this.randomParticles.add(new Land());
                } else {
                    this.randomParticles.add(new Water());
                }
            }
        }
        Collections.shuffle(this.randomParticles);
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
        generateWeightedParticle();
        Habitat habitat = new Habitat(worldid, habitatid, rows, columns);
        int partCounter = 0;
        for (int x =0 ; x < rows ; x++){
            for (int y = 0; y < columns; y++) {
                AddressImpl address = new AddressImpl(worldid, habitatid, x, y);
                CellImpl cell = new CellImpl(address);
                ParticleCollection particles = cell.getParticles();
                this.randomParticles.get(partCounter).setAddress(address);
                particles.add(this.randomParticles.get(partCounter));
                cell.setParticles(particles);
                habitat.put(cell);
                partCounter++;
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
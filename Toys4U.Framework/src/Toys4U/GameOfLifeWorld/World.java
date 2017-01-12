package Toys4U.GameOfLifeWorld;

import Toys4U.Infrastructure.AggregationHandler;
import Toys4U.Particles.ParticleColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class World {

    long MAX_SIMULATIONS = Long.MAX_VALUE;
    int MAX_RUNS = 100;
    WorldProperties properties;
    private List<Habitat> habitats;
    private final int rows;
    private final int columns;

    //private int landSurface = 40; //TODO static omzetten naar GUI
    private final HabitatGenerator generator;

    private int worldId;

    public World(int worldId, int rows, int columns, HabitatGenerator generator) {
        this.worldId = worldId;
        this.habitats = new ArrayList<>();
        this.rows=rows;
        this.columns=columns;
        this.generator = generator;
    }

    public void add() {
        // TODO - implement World.add
        //throw new UnsupportedOperationException();
        habitats.add(generator.generate());
    }

    public ParticleColor[] getHabitatMap(int habitatId) {
        System.out.println(this.habitats.size());
        System.out.println(this.habitats.get(habitatId).getMap().length);
        return this.habitats.get(habitatId).getMap();
    }
}
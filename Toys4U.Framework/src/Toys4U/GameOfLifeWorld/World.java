package Toys4U.GameOfLifeWorld;

import Toys4U.Infrastructure.AggregationHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class World {

    long MAX_SIMULATIONS = Long.MAX_VALUE;
    int MAX_RUNS = 100;
    WorldProperties properties;
    private List<Habitat> habitats;

    private int landSurface = 40; //TODO static omzetten naar GUI

    private int worldId;

    public World(int worldId) {
        this.worldId = worldId;
        this.habitats = new ArrayList<>();
    }

    public void add(int rows, int column) {
        // TODO - implement World.add
        //throw new UnsupportedOperationException();

        Habitat newHabitat = HabitatFactory.create(this.worldId, this.habitats.size(), rows, column, landSurface);
        this.habitats.add(newHabitat);
    }

}
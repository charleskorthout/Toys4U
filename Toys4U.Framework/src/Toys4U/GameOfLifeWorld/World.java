package Toys4U.GameOfLifeWorld;

import Toys4U.Infrastructure.AggregationHandler;
import Toys4U.Particles.ParticleColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;


public class World {

    private static int defaultHabitatInterval = 1000;
    private final int rows;
    private final int columns;
    //private int landSurface = 40; //TODO static omzetten naar GUI
    private final HabitatGenerator generator;
    long MAX_SIMULATIONS = Long.MAX_VALUE;
    int MAX_RUNS = 100;
    WorldProperties properties;
    private HashMap<Integer, Habitat> habitats;
    private HashMap<Integer, Timer> habitThreads;
    private int worldId;

    public World(int worldId, int rows, int columns, HabitatGenerator generator) {
        this.worldId = worldId;
        this.habitats = new HashMap<>();
        this.rows=rows;
        this.columns=columns;
        this.generator = generator;
        this.habitThreads = new HashMap();
    }

    public void add() {
        habitats.put(this.habitats.size(), generator.generate());
        startHabitat(this.habitats.size() - 1);
    }

    public ParticleColor[] getHabitatMap(int habitatId) {
        return this.habitats.get(habitatId).getMap();
    }

    public void startHabitat(int habitatId) {
        if (this.habitats.containsKey(habitatId)) {
            this.habitThreads.put(habitatId, new Timer());
            this.habitThreads.get(habitatId).schedule(new Scheduler(this.habitats.get(habitatId)), 0, defaultHabitatInterval);
        }
    }

    public void setThreadInterval(int millis) {

    }

    public void pauseHabitat(int habitatId) {

    }
}
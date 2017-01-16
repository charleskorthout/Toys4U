package Toys4U.GameOfLifeWorld;

import Toys4U.Particles.ParticleColor;
import Toys4U.View.GameOfLife;
import java.util.HashMap;
import java.util.Timer;


public class World {
    private final int rows;
    private final int columns;
    private final HabitatGenerator generator;
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

    public void add(GameOfLife GUI) {
        habitats.put(this.habitats.size(), generator.generate());
        habitats.get(this.habitats.size() - 1).addObserver(GUI);

    }

    public ParticleColor[] getHabitatMap(int habitatId) {
        return this.habitats.get(habitatId).getMap();
    }

    public void startHabitat(int habitatId, int millis) {
        if (this.habitats.containsKey(habitatId)) {
            this.habitThreads.put(habitatId, new Timer());
            this.habitThreads.get(habitatId).schedule(new Scheduler(this.habitats.get(habitatId)), 0, millis);
        }
    }

    public void setThreadInterval(int habitatId, int millis) {
        pauseHabitat(habitatId);
        startHabitat(habitatId, millis);
    }

    public void pauseHabitat(int habitatId) {
        if (this.habitats.containsKey(habitatId)) {
            this.habitThreads.get(habitatId).cancel();
            this.habitThreads.remove(habitatId);
        }
    }
}
package Toys4U.GameOfLifeWorld;

import Toys4U.Infrastructure.AggregationHandler;
import Toys4U.Particles.ParticleColor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;


public class World {

    long MAX_SIMULATIONS = Long.MAX_VALUE;
    int MAX_RUNS = 100;
    WorldProperties properties;
    private HashMap<Integer, Habitat> habitats;
    private List<Timer> habitThreads;

    private int landSurface = 20; //TODO static omzetten naar GUI
    private int defaultHabitatInterval = 1000;

    private int worldId;

    public World(int worldId) {
        this.worldId = worldId;
        this.habitats = new HashMap<>();
        this.habitThreads = new ArrayList<>();
    }

    public int add(int rows, int column) {
        // Aanmaken van nieuwe land en generen van omgeving
        Habitat newHabitat = HabitatFactory.create(this.worldId, this.habitats.size(), rows, column, landSurface);

        // Land toevoegen aan lijst en landId terug geven naar GUI
        this.habitats.put(this.habitats.size(), newHabitat);
        return (this.habitats.size() - 1);
    }

    public ParticleColor[] getHabitatMap(int habitatId) {
        return this.habitats.get(habitatId).getMap();
    }

    public void startHabitat(int habitatId) {
        if (this.habitats.containsKey(habitatId)) {
            this.habitThreads.add(habitatId, new Timer());
            this.habitThreads.get(habitatId).schedule(new Scheduler(this.habitats.get(habitatId)), 0, defaultHabitatInterval);
        }
    }

    public void setThreadInterval(int millis) {

    }

    public void pauseHabitat(int habitatId) {

    }
}
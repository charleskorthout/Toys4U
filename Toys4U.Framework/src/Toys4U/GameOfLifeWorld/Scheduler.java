package Toys4U.GameOfLifeWorld;

import java.util.TimerTask;

public class Scheduler extends TimerTask {
    private Habitat habitat;

    public Scheduler(Habitat habitat) {
        this.habitat = habitat;
    }

    public void run() {
        this.habitat.tester();
    }

}
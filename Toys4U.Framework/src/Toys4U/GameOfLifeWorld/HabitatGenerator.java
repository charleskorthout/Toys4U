package Toys4U.GameOfLifeWorld;

import Toys4U.Particles.Particle;

import java.util.ArrayList;

/**
 * Created by charles korthout on 1/10/2017.
 */
public interface HabitatGenerator {
    Habitat generate();
    //ArrayList<Particle> generate();
    public int getWorldId();
    public int getHabitatId();
    public int getRows();
    public int getColumns();
    public int getTotalCells();
}

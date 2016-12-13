package Toys4U.Model;

import Toys4U.Infrastructure.GranularDirection;

public class Land extends Particle {

    /**
     * Default Constructor
     */
    public Land(int row, int column) {
        super(row,column);
        this.color = ParticleColor.White;
    }
}
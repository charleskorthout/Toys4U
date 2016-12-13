package Toys4U.Model;


import Toys4U.Infrastructure.Digestion;
import Toys4U.Infrastructure.EnergeticParticle;


public abstract class Plant extends Particle implements Digestion, EnergeticParticle {

    protected double energy;
    /**
     * Default constructor to set particle color
     */
    protected Plant(int row, int column) {
        super(row,column);
        this.color = ParticleColor.Green;
    }
    /**
     * All plants are for now considered eatable
     * @return true
     */
    @Override
    public boolean isEatable() {
        return true; 
    }    
        
}
package Toys4U.Particles;


import Toys4U.Infrastructure.Digestion;
import Toys4U.Infrastructure.EnergeticParticle;


public abstract class Plant extends Particle implements Digestion, EnergeticParticle {

    protected double energy;
    /**
     * Default constructor to set particle color
     */
    protected Plant() {
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
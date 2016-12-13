package Toys4U.Model;


import Toys4U.Infrastructure.Eatable;
import Toys4U.Infrastructure.Digestion;
import Toys4U.Model.Particle;
import java.util.List;


public abstract class Plant extends Particle implements Digestion {

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
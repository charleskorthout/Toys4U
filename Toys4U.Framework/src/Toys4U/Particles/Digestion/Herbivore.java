package Toys4U.Particles.Digestion;


import Toys4U.Particles.Animal;
import Toys4U.Particles.ParticleColor;

public abstract class Herbivore extends Animal {
    
    /**
     * Protected constructor for Herbivore to set the default color.
     */
    protected Herbivore() {
        super();
        this.color = ParticleColor.Brown;
    }
}
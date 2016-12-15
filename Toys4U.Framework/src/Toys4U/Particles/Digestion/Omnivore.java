package Toys4U.Particles.Digestion;


import Toys4U.Infrastructure.Digestion;
import Toys4U.Particles.Animal;
import Toys4U.Particles.ParticleColor;

public abstract class Omnivore extends Animal {
    
    /**
     * Protected constructor for Omnivore to set the default color.
     */
    public Omnivore() {
        super();
        this.color = ParticleColor.Yellow;
    }
}
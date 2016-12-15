package Toys4U.Particles.Digestion;

import Toys4U.Particles.Animal;
import Toys4U.Particles.ParticleColor;

public abstract class Carnivore extends Animal {
    
    /**
     * Protected constructor for Carnivore to set the default color.
     */
    protected Carnivore() {
        super();
        this.color = ParticleColor.Red;
    }
}
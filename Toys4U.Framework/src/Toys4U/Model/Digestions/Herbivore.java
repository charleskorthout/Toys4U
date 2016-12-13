package Toys4U.Model.Digestions;


import Toys4U.Infrastructure.Digestion;
import Toys4U.Model.Animal;
import Toys4U.Model.ParticleColor;

public abstract class Herbivore extends Animal implements Digestion {
    
    /**
     * Protected constructor for Herbivore to set the default color.
     */
    protected Herbivore() {
        this.color = ParticleColor.Brown;
    }
}
package Toys4U.Model.Digestions;


import Toys4U.Infrastructure.Digestion;
import Toys4U.Model.Animal;
import Toys4U.Model.ParticleColor;

public abstract class Omnivore extends Animal implements Digestion {
    
    /**
     * Protected constructor for Omnivore to set the default color.
     */
    public Omnivore() {
        this.color = ParticleColor.Yellow;
    }
}
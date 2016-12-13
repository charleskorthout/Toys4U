package Toys4U.Model.Digestions;


import Toys4U.Infrastructure.Digestion;
import Toys4U.Model.Animal;
import Toys4U.Model.ParticleColor;

public abstract class Omnivore extends Animal {
    
    /**
     * Protected constructor for Omnivore to set the default color.
     */
    public Omnivore(int row, int column) {
        super(row,column);
        this.color = ParticleColor.Yellow;
    }
}
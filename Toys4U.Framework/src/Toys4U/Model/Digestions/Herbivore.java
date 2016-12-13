package Toys4U.Model.Digestions;


import Toys4U.Infrastructure.Digestion;
import Toys4U.Model.Animal;
import Toys4U.Model.ParticleColor;

public abstract class Herbivore extends Animal {
    
    /**
     * Protected constructor for Herbivore to set the default color.
     */
    protected Herbivore(int row, int column) {
        super(row,column);
        this.color = ParticleColor.Brown;
    }
}
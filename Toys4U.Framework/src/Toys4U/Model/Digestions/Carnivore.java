package Toys4U.Model.Digestions;

import Toys4U.Model.Animal;
import Toys4U.Model.ParticleColor;

public abstract class Carnivore extends Animal {
    
    /**
     * Protected constructor for Carnivore to set the default color.
     */
    protected Carnivore(int row, int column) {
        super(row,column);
        this.color = ParticleColor.Red;
    }
}
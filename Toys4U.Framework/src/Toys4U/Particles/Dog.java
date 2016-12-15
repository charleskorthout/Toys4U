package Toys4U.Particles;


import Toys4U.Particles.Digestion.Carnivore;
import Toys4U.Infrastructure.Eatable;
import Toys4U.Infrastructure.Walk;
import Toys4U.Particles.Collections.DietCollection;
import java.util.List;

public class Dog extends Carnivore {

    public Dog() {
        super();
    }    
    /**
     * A dog is eatable; at least in China they do
     * @return 
     */
    @Override
    public boolean isEatable() {
        return true; 
    }

    /** 
     * Defines the diet of a dog.
     * @return A list with all items a dog can eat
     */
    @Override
    public DietCollection digestion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public void setMovement() {
        super.movement = new Walk(4);
    }

    @Override
    public void setEngergyLevel(double energy) {
        this.energy = energy;
    }

}
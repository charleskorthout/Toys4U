package Toys4U.Model;


import Toys4U.Model.Digestions.Carnivore;
import Toys4U.Infrastructure.Eatable;
import Toys4U.Infrastructure.Walk;
import java.util.List;

public class Dog extends Carnivore {

    public Dog(int row, int column) {
        super(row,column);
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
    public List<Eatable> digestion() {
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
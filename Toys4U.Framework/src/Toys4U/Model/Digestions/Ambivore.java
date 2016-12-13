package Toys4U.Model.Digestions;


import Toys4U.Infrastructure.Eatable;
import java.util.List;

/** An Ambivore is a subset of a Herbivore and only eats grass or 
 * broad leaf plants 
 * @author Charles Korthout
 */
public abstract class Ambivore extends Herbivore {

    /**
     * An Ambivore is a special kind of Herbivore and only eats grass or
     * broad leaf plants
     * @return A list of plants
     */
    @Override
    public List<Eatable> digestion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
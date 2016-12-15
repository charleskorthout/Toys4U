package Toys4U.Particles.Digestion;


import Toys4U.Particles.Collections.DietCollection;

/** An Ambivore is a subset of a Herbivore and only eats grass or 
 * broad leaf plants 
 * @author Charles Korthout
 */
public abstract class Ambivore extends Herbivore {

    protected Ambivore() {
        super();
    }
    /**
     * An Ambivore is a special kind of Herbivore and only eats grass or
     * broad leaf plants
     * @return A list of plants
     */
    @Override
    public DietCollection digestion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
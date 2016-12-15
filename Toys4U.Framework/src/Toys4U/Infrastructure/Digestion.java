package Toys4U.Infrastructure;


import Toys4U.Particles.Collections.DietCollection;

public interface Digestion {

    /**
     * The list with all diets that can be consumed
     * @return the list with particles that can be consumed by this particle
     */
	DietCollection digestion();

}
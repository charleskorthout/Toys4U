package Toys4U.GameOfLifeWorld;

import Toys4U.Infrastructure.AggregationHandler;


public class World {

        long MAX_SIMULATIONS =  Long.MAX_VALUE;
        int MAX_RUNS = 100;
        WorldProperties properties;
        
        
	/**
	 * Adds a new habitat to the world with a handler to count, sum and average to particles.
	 * @param habitat the habitat to add
         * @param aggregate, aggregates the updates, sum, count and average
         * @param overflow The overflow manager to handle occasions where particles leave the board.
	 */
	public void add(int habitat, AggregationHandler aggregate, OverflowHandler overflow) {
		// TODO - implement World.add
		throw new UnsupportedOperationException();
	}

}
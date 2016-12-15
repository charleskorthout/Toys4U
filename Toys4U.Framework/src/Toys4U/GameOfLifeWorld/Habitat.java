package Toys4U.GameOfLifeWorld;

import Toys4U.Infrastructure.Address;
import Toys4U.Infrastructure.Generator;
import Toys4U.Particles.Collections.ParticleCollection;
import Toys4U.Particles.Particle;
import java.util.HashMap;

public class Habitat {
    
        private int rows;   
        private int columns;
        private HashMap<Address, ParticleCollection> particles;
        
        /**
         * Constructs an empty habitat with specified number of rows and columns
         * @param rows
         * @param columns 
         */
        public Habitat(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
            particles = new HashMap();
        }

        public int getRows() {
            return rows;
        }

        public int getColumns() {
            return columns;
        }
	/**
	 * 
	 * @param particle
	 */
	public void put(Address address, Particle particle) {
                ParticleCollection values = new ParticleCollection();
                if (particles.containsKey(address)) {
                    values = particles.get(address);
                    values.add(particle);
                    particles.replace(address, values);
                }
                else {
                    values.add(particle);
                    particles.put(address, values);
                }
	}

	/**
	 * Removes a specific particle from the habitat.
	 * @param particle
	 */
	public void remove(Address address, Particle particle) {
		ParticleCollection values = new ParticleCollection();
                if (particles.containsKey(address)) {
                    values = particles.get(address);
                    values.remove(particle);
                    particles.replace(address, values);
                }                
	}

	public void isValid() {
		// TODO - implement Habitat.isValid
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param rule
	 */
	public void generate(Generator generator) {
		// TODO - implement Habitat.generate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param scheduler
	 */
	public void schedule(int scheduler) {
		// TODO - implement Habitat.schedule
		throw new UnsupportedOperationException();
	}

}
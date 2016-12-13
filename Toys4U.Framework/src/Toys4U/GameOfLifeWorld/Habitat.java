package Toys4U.GameOfLifeWorld;

import Toys4U.Infrastructure.Generator;
import Toys4U.Model.Location;
import Toys4U.Model.Particle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Habitat {
    
        private int rows;   
        private int columns;
        private HashMap<Location, List<Particle>> particles;
        
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
	public void put(Particle particle) {
                Location location = particle.getLocation();
                List<Particle> values = new ArrayList();
                if (particles.containsKey(location)) {
                    values = particles.get(location);
                    values.add(particle);
                    particles.replace(location, values);
                }
                else {
                    values.add(particle);
                    particles.put(particle.getLocation(), values);
                }
	}

	/**
	 * Removes a specific particle from the habitat.
	 * @param particle
	 */
	public void remove(Particle particle) {
		Location location = particle.getLocation();
                List<Particle> values = new ArrayList();
                if (particles.containsKey(location)) {
                    values = particles.get(location);
                    values.remove(particle);
                    particles.replace(location, values);
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
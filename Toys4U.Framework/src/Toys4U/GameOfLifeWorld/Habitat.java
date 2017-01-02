package Toys4U.GameOfLifeWorld;

import Toys4U.Network.Address;
import Toys4U.Infrastructure.Generator;
import Toys4U.Network.AddressImpl;
import Toys4U.Network.Cell;
import Toys4U.Network.NetworkComponent;
import Toys4U.Particles.Collections.ParticleCollection;
import Toys4U.Particles.Particle;
import Toys4U.Particles.ParticleColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Habitat implements NetworkComponent{
    
        private int rows;   
        private int columns;
        private int worldid;
        private int habitatid; 
        private HashMap<AddressImpl, ParticleCollection> cells;
        
        /**
         * Constructs an empty habitat with specified number of rows and columns
         * @param rows
         * @param columns 
         */
        public Habitat(int worldid, int habitatid, int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
            this.habitatid = habitatid;
            this.worldid = worldid;
            cells = new HashMap<>();
        }

        public Address getAddress(){
            return new AddressImpl(worldid, habitatid,0,0);
        }
        public int getRows() {
            return rows;
        }

        public int getColumns() {
            return columns;
        }
	/**
	 * 
	 * @param address
	 */
	public void put(AddressImpl address, ParticleCollection particleCollection) {
                cells.put(address, particleCollection);
	}

	/**
	 * Removes a specific particle from the habitat.
	 * @param address
	 */
	public void remove(AddressImpl address) {
		cells.remove(address);   
	}

        /**
         * retrieves a cell based on it's address
         * @param address
         * @return 
         */
        public ParticleCollection get(AddressImpl address) {
            if (this.cells.containsKey(address)){
                return this.cells.get(address);
            }
            else {
                // TODO - implement cell creation
		throw new UnsupportedOperationException();
            }
        }
        
        
	public void isValid() {
		// TODO - implement Habitat.isValid
		throw new UnsupportedOperationException();
	}

    public ParticleColor[] getMap() {
        ParticleColor[] map = new ParticleColor[this.rows * this.columns];

        for (Map.Entry<AddressImpl, ParticleCollection> entry : this.cells.entrySet()) {

            int location = ((entry.getKey().getX() * this.rows) + entry.getKey().getY());
            map[location] = entry.getValue().getParticleColor();
        }

        return map;
    }
}
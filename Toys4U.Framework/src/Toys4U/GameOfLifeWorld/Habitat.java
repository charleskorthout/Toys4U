package Toys4U.GameOfLifeWorld;

import Toys4U.Network.Address;
import Toys4U.Infrastructure.Generator;
import Toys4U.Network.AddressImpl;
import Toys4U.Network.Cell;
import Toys4U.Network.NetworkComponent;
import java.util.HashMap;

public class Habitat implements NetworkComponent{
    
        private int rows;   
        private int columns;
        private int worldid;
        private int habitatid; 
        private HashMap<Address, Cell> cells;
        
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
            cells = new HashMap();
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
	 * @param particle
	 */
	public void put(Address address, Cell cell) {
                cells.put(address, cell);
	}

	/**
	 * Removes a specific particle from the habitat.
	 * @param particle
	 */
	public void remove(Address address) {
		cells.remove(address);   
	}

        /**
         * retrieves a cell based on it's address
         * @param address
         * @return 
         */
        public Cell get(Address address) {
            if (cells.containsKey(address)){
                return cells.get(address);
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
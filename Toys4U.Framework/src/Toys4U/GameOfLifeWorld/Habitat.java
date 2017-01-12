package Toys4U.GameOfLifeWorld;

import Toys4U.Network.Address;
import Toys4U.Network.AddressImpl;
import Toys4U.Network.Cell;
import Toys4U.Network.CellImpl;
import Toys4U.Particles.Animal;
import Toys4U.Particles.Collections.ParticleCollection;
import Toys4U.Particles.ParticleColor;

import java.util.*;

public class Habitat implements Observer {

    private int rows;
        private int columns;
    // World (parent) id
    private int worldid;
    // Id if this habitat
    private int habitatid;
    // All registered cells addresses pointing to the particles on it
    private HashMap<Address, Cell> cells;


    /**
     * Construct an empty habitat with specified number of rows and columns
     * @param worldid
     * @param habitatId
         * @param rows
         * @param columns 
         */
    public Habitat(int worldid, int habitatId, int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
        this.habitatid = habitatId;
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
     * create a new cell with a possibility to store particles
     *
     * @param address
     */
    public void put(Cell cell) {
                cells.put(cell.getAddress(), cell);
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
         * @return ParticleCollection
         */
        public ParticleCollection get(AddressImpl address) {
            if (this.cells.containsKey(address)){
                return (this.cells.get(address)).getParticles();
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
     * This function takes the cell hashmap and iterate trough it
     * to create a array of partice colors. The array starts from
     * x=0 y=0 and iterates from column to the next row. This map
     * is used for drawing the current map of the habitat
     * instance.
     *
     * @return map
     */
    public ParticleColor[] getMap() {
        // Create return map to fill
        ParticleColor[] map = new ParticleColor[this.rows * this.columns];

        //Iterate trought hashmap and fill the array with the particle colors
        for (Map.Entry<Address, Cell> entry : this.cells.entrySet()) {

            int location = ((entry.getKey().getX() * this.rows) + entry.getKey().getY());
            map[location] = entry.getValue().getParticles().getParticleColor();
        }

        return map;
    }

    /**
     * Get the map with all cells
     * @return the map with all cells
     */
    public HashMap<Address, Cell> getCells() {
        HashMap<Address, Cell> map = new HashMap();
        for (Map.Entry<Address, Cell> entry : this.cells.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
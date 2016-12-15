package Toys4U.Particles;
import Toys4U.Infrastructure.AdjancencyLocation;
import java.util.List;

public class Location implements AdjancencyLocation {
    
    private int row;
    private int column;
    
    /**
     * constructor with row and column numbers
     * @param row The row number
     * @param column The column number
     */
    public Location(int row, int column){
        this.row = row;
        this.column=column;
    }

    /**
     * Retrieves the column number from the cell location
     * @return the row number
     */
    public int getRow() {
            return row;
    }

    /**
     * Retrieves the column number from the cell location
     * @return The column number
     */
    public int getColumn() {
            return column;
    }
    
    @Override
    public List<Location> getAdjancentLocations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	
}
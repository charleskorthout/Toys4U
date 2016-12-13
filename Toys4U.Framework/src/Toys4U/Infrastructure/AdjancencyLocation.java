package Toys4U.Infrastructure;

import Toys4U.Model.Location;
import java.util.List;

public interface AdjancencyLocation {

	/**
	 * 
	 * @param direction
	 */
	List<Location> getAdjancentLocations();

}
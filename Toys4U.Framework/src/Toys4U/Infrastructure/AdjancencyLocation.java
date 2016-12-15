package Toys4U.Infrastructure;

import Toys4U.Particles.Location;
import java.util.List;

public interface AdjancencyLocation {

	/**
	 * 
	 * @param direction
	 */
	List<Location> getAdjancentLocations();

}
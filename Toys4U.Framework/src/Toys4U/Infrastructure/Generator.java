package Toys4U.Infrastructure;

import Toys4U.Model.Location;
import Toys4U.Model.Particle;

public interface Generator {

	Particle generate(Location loc);

}
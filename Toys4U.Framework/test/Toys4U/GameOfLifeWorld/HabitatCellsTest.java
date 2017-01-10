package Toys4U.GameOfLifeWorld;

import Toys4U.Network.AddressImpl;
import Toys4U.Particles.Collections.ParticleCollection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by charl on 1/10/2017.
 */
public class HabitatCellsTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }


    private HashMap<AddressImpl, ParticleCollection> getAddressParticleCollectionHashMap() {
        RandomHabitatGenerator generator = new RandomHabitatGenerator(90, 40,40);
        Habitat habitat = HabitatFactory.create(1,1,  generator);
        return habitat.getCells();
    }

    /**
     * Test if all entries in the cells have a non empty particle list
     *
     */
    @Test
    public void All_cells_must_have_at_least_one_particle()  {
        HashMap<AddressImpl, ParticleCollection> cells = getAddressParticleCollectionHashMap();
        boolean expected = true;
        boolean actual = cells.entrySet().stream().filter(x -> (x.getValue()).isEmpty() == true).count() == 0;
        assertEquals(expected, actual);
    }


    /**
     * Test if all entries in the cells have at least a water or a land particle
     */
    @Test
    public void All_cells_must_have_at_least_one_water_particle_or_a_land_particle() {
        HashMap<AddressImpl, ParticleCollection> cells = getAddressParticleCollectionHashMap();
        boolean expected = false;
        boolean actual = cells.entrySet().stream().filter(x -> (!(x.getValue()).containsWater() && !(x.getValue()).containsLand())).count() > 0;
        assertEquals(expected, actual);
    }

    /**
     * Test that the generation of water / land ratio is within an acceptable limits
     */
    @Test
    public void Check_that_the_ratio_of_land_and_water_is_within_expected_limits() {
        double epsilon = 0.05; // 5% bandwith
        HashMap<AddressImpl, ParticleCollection> cells = getAddressParticleCollectionHashMap();
        double expectedmin = 40.0*40.0*(90.0/100.0)*(1.0 - epsilon);
        double expectedmax = 40.0*40.0*(90.0/100.0)*(1.0 + epsilon);
        long land = cells.entrySet().stream().filter(x -> ((x.getValue()).containsLand())).count() ;
        System.out.print("land" + land);
        System.out.print("min : " + expectedmin);
        System.out.print("max: " + expectedmax);
        boolean actual = (land > expectedmin) && (land < expectedmax);
        assertEquals(true,actual);
    }
}
package Toys4U.GameOfLifeWorld;

import Toys4U.Network.Address;
import Toys4U.Network.AddressImpl;
import Toys4U.Network.Cell;
import Toys4U.Network.CellImpl;
import Toys4U.Particles.Collections.ParticleCollection;
import Toys4U.Particles.Particle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by charl on 1/10/2017.
 */
public class HabitatCellsTest {
    private final int WORLDID = 0;
    private final int HABITATID = 0;
    private final int ROWS = 1000;
    private final int COLUMNS = 1000;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }


    private HashMap<Address, Cell> getAddressParticleCollectionHashMap() {
        RandomHabitatGenerator generator = new RandomHabitatGenerator(WORLDID, HABITATID,ROWS, COLUMNS);
        Habitat habitat = HabitatFactory.create(generator);
        return habitat.getCells();
    }

    /**
     * Test if all entries in the cells have a non empty particle list
     *
     */
    @Test
    public void All_cells_must_have_at_least_one_particle()  {
        HashMap<Address, Cell> cells = getAddressParticleCollectionHashMap();
        boolean expected = true;
        boolean actual = cells.entrySet().stream().filter(x -> (x.getValue()).getParticles().isEmpty() == true).count() == 0;
        assertEquals(expected, actual);
    }


    /**
     * Test that the generation of water / land ratio is within an acceptable limits
     */
    @Test
    public void Check_that_the_ratio_of_proportions_is_within_expected_limits() {
        double epsilon = 0.1; // 10% bandwith
        HashMap<Particle, Double> proportions = RandomHabitatGenerator.getRandomProportions();
        HashMap<Address, Cell> cells = getAddressParticleCollectionHashMap();
        for (Particle p : proportions.keySet()) {
            double expectedmin = 1.0*ROWS*COLUMNS*proportions.get(p)*(1.0 - epsilon);
            double expectedmax = 1.0*ROWS*COLUMNS*proportions.get(p)*(1.0 + epsilon);
            long sum = 0;
            for (Map.Entry entry : cells.entrySet()) {
                long total = 0;
                try {
                    total = (Long) ((CellImpl) entry.getValue()).getParticles().countBy().get(p);
                }
                catch (Exception e) {}
                sum = sum + total;
            }
            System.out.println("expected min: " + expectedmin);
            System.out.println("expected max: " + expectedmax);
            System.out.println("actual: " + sum);
            boolean actual = (sum > expectedmin) && (sum < expectedmax);
            assertEquals(true,actual);
        }

    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Toys4U.Particles;

import Toys4U.GameOfLifeWorld.Habitat;
import Toys4U.GameOfLifeWorld.HabitatFactory;
import Toys4U.GameOfLifeWorld.RandomGenerator;
import Toys4U.Network.AddressImpl;
import Toys4U.Particles.Collections.ParticleCollection;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.util.HashMap;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.After;
import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author charl
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({})
public class HabitatTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void All_cells_must_have_at_least_one_particle() {
        RandomGenerator generator = new RandomGenerator(90, 400,400);
        Habitat habitat = HabitatFactory.create(1,1,  generator);
        HashMap<AddressImpl, ParticleCollection> cells = habitat.getCells();
        boolean expected = true;
        boolean actual = cells.entrySet().stream().filter(x -> (x.getValue()).isEmpty() == true).count() == 0;
        assertEquals(expected, actual);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Toys4U.Particles;

import Toys4U.GameOfLifeWorld.Habitat;
import Toys4U.GameOfLifeWorld.HabitatFactory;
import Toys4U.GameOfLifeWorld.RandomGenerator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

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

    public void ParticlecollectionTest() {
        Habitat habitat = HabitatFactory.create(1,1, 400, 400, new RandomGenerator());
    }
}

package Toys4U.Particles;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by charl on 1/12/2017.
 */
public class PlantTest {
    private Plant createPlant() {
        PlantImpl plant = new PlantImpl();
        return plant;
    }


    @Test
    public void A_initialized_plant_has_zero_energy() throws Exception {
        Plant plant = createPlant();
        double expected = 0.0;
        double actual = plant.energy;
        double epsilon = 0.05;
        assertEquals(expected, actual, epsilon);
    }

    @Test
    public void A_plant_gets_a_single_energy_unit_at_each_cycle() throws Exception {
        Plant plant = createPlant();
        plant.process(1);
        double expected = 1.0;
        double actual = plant.energy;
        double epsilon = 0.05;
        assertEquals(expected, actual,epsilon);
    }

}
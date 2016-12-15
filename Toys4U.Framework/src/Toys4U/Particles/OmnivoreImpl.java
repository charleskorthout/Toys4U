/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Toys4U.Particles;

import Toys4U.Particles.Digestion.Omnivore;
import Toys4U.Infrastructure.Walk;
import Toys4U.Infrastructure.Eatable;
import Toys4U.Particles.Collections.DietCollection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charles Korthout
 */
public class OmnivoreImpl extends Omnivore {

    static int MAX_NUMBER_LEGS = 10;
    @Override
    public DietCollection digestion() {
        DietCollection preys = new DietCollection();
        preys.add(this);
        return preys;
    }

    /**
     * Create a walking animal with 1 till 10 legs.
     */
    @Override
    public void setMovement() {
        this.movement = new Walk((int) Math.random()*MAX_NUMBER_LEGS + 1);
    }

    /**
     * Sets the energy level for this Omnivore implementation
     * @param energy The energy level
     */
    @Override
    public void setEngergyLevel(double energy) {
        this.energy = energy;
    }
}

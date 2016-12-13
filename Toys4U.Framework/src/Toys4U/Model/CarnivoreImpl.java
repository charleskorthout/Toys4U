/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Toys4U.Model;

import Toys4U.Model.Digestions.Carnivore;
import Toys4U.Infrastructure.Walk;
import Toys4U.Infrastructure.Eatable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charles Korthout
 */
public class CarnivoreImpl extends Carnivore {

    
    static int MAX_NUMBER_LEGS = 10;
    
    protected CarnivoreImpl(int row, int column) {
        super(row,column);
    }
    
    @Override
    public List<Eatable> digestion() {
        List<Eatable> preys = new ArrayList();
        preys.add(this);
        preys.add(new HerbivoreImpl(0,0));
        return preys;
    }

    /**
     * Create a walking animal with 1 till 10 legs.
     */
    @Override
    public void setMovement() {
        this.movement = new Walk((int) Math.random()*MAX_NUMBER_LEGS + 1);
    }
    
    @Override
    public void setEngergyLevel(double energy) {
        this.energy = energy;
    }


}

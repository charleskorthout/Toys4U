/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Toys4U.Model;

import Toys4U.Infrastructure.Eatable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charles Korthout
 */
public class PlantImpl extends Plant {

    @Override
    public List<Eatable> digestion() {
        return new ArrayList<Eatable>();
    }

}

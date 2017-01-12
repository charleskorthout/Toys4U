/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Toys4U.GameOfLifeWorld;

import Toys4U.Network.AddressImpl;
import Toys4U.Particles.Collections.ParticleCollection;
import Toys4U.Particles.Particle;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Charles Korthout
 */
public class HabitatFactory {
    public static Habitat create(HabitatGenerator rGenerator) {
        return rGenerator.generate();
    }
}

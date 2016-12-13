/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Toys4U.GameOfLifeWorld;

import Toys4U.Model.Particle;
import Toys4U.Infrastructure.Generator;
import Toys4U.Model.Location;

/**
 *
 * @author Charles Korthout
 */
/**
 * Generate a particle based on the generation 
 * @author charl
 */
public class ParticleFactory {
    static Particle create(Location loc, Generator generator) {
         return generator.generate(loc);        
    }
}
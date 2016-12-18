/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Toys4U.GameOfLifeWorld;

import Toys4U.Particles.Particle;
import Toys4U.Infrastructure.Generator;
import Toys4U.Particles.Location;

/**
 *
 * @author Charles Korthout
 */
/**
 * Generate a particle based on the generation algoritm
 * @author Charles Korthout
 */
public class ParticleFactory {
    static Particle create(Generator generator) {
         return generator.generate();        
    }
}

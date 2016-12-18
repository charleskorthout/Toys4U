/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Toys4U.Network;

import Toys4U.Infrastructure.VelocityVector;
import Toys4U.Particles.Particle;

/**
 *
 * @author Charles Korthout
 */
public interface Router {
    /**
     * routes a Particle from one location to another based on the velocity vector.
     * The routing will stop if the particle hits an obstacle on the next cell or 
     * when it tries to cross water, but is not willing to swim
     * 
     * If it crosses border of the habitat or world the resulting vector and the last
     * location point before it leaves the place is added to the routing result and the
     * procedure is passed to another router
     * @param particle The particle to transfer
     * @param source The cell where it start the travel
     * @param from The last visited address 
     * @param v The velocity and direction of the travel.
     * @return The result of the route
     */
    void route(Particle particle, Cell source, Cell from, VelocityVector v, RoutingResult result);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Toys4U.Routing;

import Toys4U.Infrastructure.Address;
import Toys4U.Infrastructure.VelocityVector;
import Toys4U.Particles.Particle;

/**
 *
 * @author Charles Korthout
 */
public final class RoutingResult {

    static class Success {
        static Particle particle;
        static Address from;
        static Address to;
        public Success(Particle particle, Address from, Address to) {
            this.particle = particle;
            this.from = from;
            this.to = to;
        }
        
        public static Particle getParticle() {
            return particle;
        }
        
        public static Address getFrom() {
            return from;
        }
        
        public static Address getTo() {
            return to;
        }
    }
    
    static class Overflow {
        static Particle particle;
        static Address from;
        static double lastX;
        static double lastY;
        static VelocityVector deltaV;
        
        /**
         * An overflow has occurred ( we are crossing the borders of the habitat and have to route to a different
         * habitat or world. The result will contain the particle we would like to transfer, the location where we started,
         * the location before we try to leave the habitat. (It is possible that at the new habitat we hit an obstacle or water
         * so the last possible location would be the address at the current habitat) 
         * 
         * We also report the exact point on the x and y coordinate system as the angle so we do not lose precision. The last parameter 
         * @param particle The particle to transfer
         * @param from The original location of the particle
         * @param lastAddress the last Address on the board
         * @param lastX The last x-position before we crossed the board
         * @param lastY The last y-position before we left the board
         * @param deltaV The remaining delta of the VelocityVector
         */
        public Overflow(Particle particle, Address from, Address lastAddress, double lastX, double lastY, VelocityVector deltaV) {
            this.particle = particle;
            this.from = from;
            this.lastX = lastX;
            this.lastY = lastY;
            this.deltaV = deltaV;
        }
        
        public static Particle getParticle() {
            return particle;
        }
        
        public static Address getFrom() {
            return from;
        }
        
        public static double getLastX() {
            return lastX;
        }
        
        public static double getLastY() {
            return lastY;
        }
        
        public static VelocityVector getDeltaV() {
            return deltaV;
        }
    }
}

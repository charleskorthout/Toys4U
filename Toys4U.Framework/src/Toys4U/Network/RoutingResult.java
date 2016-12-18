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
public final class RoutingResult {

    static class SteadyGoing {
        static Particle particle;
        static Cell from;
        static Cell to;
        static int distance;
        public SteadyGoing(Particle particle, Cell from, Cell to, int distance) {
            this.particle = particle;
            this.from = from;
            this.to = to;
        }
        
        public static Particle getParticle() {
            return particle;
        }
        
        public static Cell getFrom() {
            return from;
        }
        
        public static Cell getTo() {
            return to;
        }
        
        public int getDistance(){
            return distance;
        }
    }    
    
    static class Success {
        static Particle particle;
        static Cell from;
        static Cell to;
        static int distance;
        public Success(Particle particle, Cell from, Cell to, int distance) {
            this.particle = particle;
            this.from = from;
            this.to = to;
        }
        
        public static Particle getParticle() {
            return particle;
        }
        
        public static Cell getFrom() {
            return from;
        }
        
        public static Cell getTo() {
            return to;
        }
        
        public int getDistance(){
            return distance;
        }
    }    
    
    static class CollitionAtNextStep {
        static Particle particle;
        static Cell from;
        static Cell to;
        static int distance;
        public CollitionAtNextStep(Particle particle, Cell from, Cell to, int distance) {
            this.particle = particle;
            this.from = from;
            this.to = to;
        }
        
        public static Particle getParticle() {
            return particle;
        }
        
        public static Cell getFrom() {
            return from;
        }
        
        public static Cell getTo() {
            return to;
        }
        
        public int getDistance(){
            return distance;
        }
    } 
    
    static class WaterAtNextStep {
        static Particle particle;
        static Cell from;
        static Cell to;
        static int distance;
        public WaterAtNextStep(Particle particle, Cell from, Cell to, int distance) {
            this.particle = particle;
            this.from = from;
            this.to = to;
        }
        
        public static Particle getParticle() {
            return particle;
        }
        
        public static Cell getFrom() {
            return from;
        }
        
        public static Cell getTo() {
            return to;
        }
        
        public int getDistance(){
            return distance;
        }
    }    
}

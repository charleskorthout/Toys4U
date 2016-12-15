/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Toys4U.Infrastructure;

/**
 *
 * @author Charles Korthout
 */
public class VelocityVector {
    double velocity;
    GranularDirection direction;
    public VelocityVector(double velocity, GranularDirection direction) {
        this.velocity = velocity;
        this.direction = direction;
    }
    
    /**
     * Retrieves the velocity
     * @return the velocity
     */
    public double getVelocity() {
        return velocity;        
    }
    
    /**
     * Retrieves the angular direction
     * @return the direction in degrees
     */
    public GranularDirection getDirection() {
        return direction;
    }
}

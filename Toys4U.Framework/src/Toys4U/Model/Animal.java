package Toys4U.Model;

import Toys4U.Infrastructure.Digestion;
import Toys4U.Infrastructure.EnergeticParticle;
import Toys4U.Infrastructure.GranularDirection;
import Toys4U.Infrastructure.MovingParticle;

public abstract class Animal extends Particle implements Digestion, MovingParticle, EnergeticParticle {

    protected MovingParticle movement;
    protected Location location;
    private double weight;
    private double stamina;
    protected double energy;
    private double velocity;
    private GranularDirection direction;
    
    protected Animal(int row, int column)  {
        super(row,column);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getStamina() {
        return stamina;
    }

    public void setStamina(double stamina) {
        this.stamina = stamina;
    }

    public double getEnergyLevel() {
        return energy;
    }

    public void setEnergyLevel(double energy) {
        this.energy = energy;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public GranularDirection getDirection() {
        return direction;
    }

    public void setDirection(GranularDirection direction) {
        this.direction = direction;
    }
    /**
     * Returns if the Animal is eatable
     * @return true We assume that all animals can be eaten
     */
    @Override
    public boolean isEatable() {
        return true;
    }
    
    /**
     * Sets the way this animal moves. Possible options are walk, swim or fly
     */
    public abstract void setMovement();
    
    /**
     * Returns the way the animal moves, this can be walking (dog, cow, horse), sliding (snake) or flying (bird)
     * @return 
     */
    public MovingParticle getMovement() {
        return movement;
    }
    
    
    @Override
    public void move(GranularDirection direction, Double velocity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
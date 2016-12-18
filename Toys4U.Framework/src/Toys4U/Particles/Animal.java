package Toys4U.Particles;

import Toys4U.Infrastructure.Digestion;
import Toys4U.Infrastructure.EnergeticParticle;
import Toys4U.Infrastructure.MovingParticle;
import Toys4U.Infrastructure.VelocityVector;

public abstract class Animal extends Particle implements Digestion, MovingParticle, EnergeticParticle {

    
    protected MovingParticle movement;
    private double weight;
    private double stamina;
    protected double energy;
    protected double strength; //TODO How to initiate!!!
    private VelocityVector velocity;
    private double swimlevel = Toys4U.Particles.Services.Constants.SWIM_LEVEL;
    private double movelevel = Toys4U.Particles.Services.Constants.MOVE_LEVEL;
    private double horniness = Toys4U.Particles.Services.Constants.HORNINESS_LEVEL;
    
    public double getSwimlevel() {
        return swimlevel;
    }

    public void setSwimlevel(double swimlevel) {
        this.swimlevel = swimlevel;
    }

    public double getMovelevel() {
        return movelevel;
    }

    public void setMovelevel(double movelevel) {
        this.movelevel = movelevel;
    }
    
    
    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
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

    // Implement Moving Particle
    /**
     * Get the velocity and direction of this particle
     * @return the vector for velocity and direction
     */
    public VelocityVector getVelocityVector() {
        return movement.getVelocityVector();
    }

    /**
     * Set the velocity vector for speed and direction
     * @param velocity The velocity vector for this particle
     */
    public void setVelocityVector(VelocityVector velocity) {
        this.velocity = velocity;
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
    
    /**
     * Animals will only move if the have sufficient energy
     * @return true if they have sufficient energy false otherwise
     */
    public boolean willMove() {
        return energy > (stamina * movelevel); 
    };
    
    /**
     * The animal is willing to swim when the energy level drops below the predefined level.
     * @return 
     */
    public boolean willSwim() {
        return energy < (stamina * swimlevel); 
    };
    
    /**
     * Animals are only willing to pare and get children if the have sufficient energy
     * @return true if they have sufficient energy, false otherwise
     */
    public boolean willBreed() {
        return energy > (stamina * horniness);
    }
    
}
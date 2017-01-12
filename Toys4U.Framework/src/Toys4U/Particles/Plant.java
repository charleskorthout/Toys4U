package Toys4U.Particles;


import Toys4U.Infrastructure.Digestion;
import Toys4U.Infrastructure.EnergeticParticle;


public abstract class Plant extends Particle implements Digestion, EnergeticParticle {

    protected double energy;
    private long lastDeathTick = 0;
    private int deathCount = 0;
    private boolean dormant = false;

    // when a plant has been eaten and has no energy left it dies for 100 cycles.

    /**
     * Default constructor to set particle color
     */
    protected Plant() {
        this.color = ParticleColor.Green;
    }
    /**
     * All plants are for now considered eatable
     * @return true
     */
    @Override
    public boolean isEatable() {
        return true; 
    }

    /**
     *
     * @param currentTick the cycle id
     */
    public void process(long currentTick) {
        energy += 1.0;
        if (!dormant) {
            if (energy < 1.0) {
                energy = 0.0;
                deathCount++;
                if (deathCount >= 10) {
                    lastDeathTick = currentTick; // register the time when we start sleeping
                    dormant = true;
                }
            }
        }
        else { // we are asleep
            if (currentTick - lastDeathTick > 100) {
                dormant = false; // we awake from a long sleep
            }
            else energy -= 1.0;
         }
    }

    /**
     * Consume energy from the plant
     * @param energy the amount of energy taken
     * @param currentTick the cycle tick of this run
     */
    public void consume(double energy, long currentTick) {
        if (this.energy > energy ) {
            this.energy -= energy;
        }
        else {
            this.energy = 0.0;
        }
        process(currentTick);
    }


        
}
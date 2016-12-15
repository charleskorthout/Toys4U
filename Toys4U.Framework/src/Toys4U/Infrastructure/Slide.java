package Toys4U.Infrastructure;


import Toys4U.Infrastructure.MovingParticle;

public final class Slide implements MovingParticle {
    VelocityVector velocity;
    
    public Slide() {
        
    }

    @Override
    public void setVelocityVector(VelocityVector velocity) {
        this.velocity = velocity;
    }

    @Override
    public VelocityVector getVelocityVector() {
        return velocity;
    }
    
}
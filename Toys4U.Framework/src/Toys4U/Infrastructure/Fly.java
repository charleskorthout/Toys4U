package Toys4U.Infrastructure;


import Toys4U.Infrastructure.MovingParticle;

public final class Fly implements MovingParticle{

    VelocityVector velocity;
    public Fly() {
        
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
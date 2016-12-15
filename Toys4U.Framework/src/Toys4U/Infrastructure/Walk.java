package Toys4U.Infrastructure;


import Toys4U.Infrastructure.MovingParticle;

public final class Walk implements MovingParticle{

    int legs;
    VelocityVector velocity;
        
    public Walk(int legs) {
        this.legs = legs;
    }
    /**
     * Defines how many legs this animal has to walk
     * @return the number of legs from the animal
     */	      
    public int getLegs(){
        return legs;
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
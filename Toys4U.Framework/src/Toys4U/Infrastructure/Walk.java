package Toys4U.Infrastructure;


import Toys4U.Infrastructure.MovingParticle;

public final class Walk implements MovingParticle{

    int legs;
        
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
    public void move(GranularDirection direction, Double velocity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
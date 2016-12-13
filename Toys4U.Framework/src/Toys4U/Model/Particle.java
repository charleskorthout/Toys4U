package Toys4U.Model;
import Toys4U.Infrastructure.*;

public abstract class Particle implements Eatable, State, Revertable, Persistable {
    
    protected ParticleColor color = ParticleColor.White;
    protected Location location; 
    
    protected Particle(int row, int column) {
        location = new Location(row,column);
    }
    
    /**
     * Return the default particle color
     * @return 
     */
    public ParticleColor getColor() {
        return this.color;
    }

    /**
     * Retrieves the location from the particle.
     * @return the location
     */
    public Location getLocation() {
        return location;
    }
    
    @Override
    public boolean isEatable(){
        return false;
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void current() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void redo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	

}
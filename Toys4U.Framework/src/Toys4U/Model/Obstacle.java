package Toys4U.Model;

public class Obstacle extends Particle {
    
    public Obstacle(int row, int column) {
        super(row, column);
        this.color = ParticleColor.Black;
    }
}
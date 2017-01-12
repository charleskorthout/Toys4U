package Toys4U.Network;

import Toys4U.Infrastructure.Direction;
import Toys4U.Network.Collections.CellNeighborCollection;
import Toys4U.Particles.Collections.ParticleCollection;
import Toys4U.Particles.Land;


import java.util.HashMap;

/**
 * Created by charl on 1/11/2017.
 */
public class CellImpl implements Cell {
    private final Address address;
    private ParticleCollection particles;
    private final HashMap<Direction,Cell> neighbors;
    private boolean initialized = false;
    private CellStatus status = CellStatus.PreInitialized;

    /**
     * Simple Cell
     * @param address
     */
    public CellImpl(Address address) {
        this.address = address;
        this.neighbors = new CellNeighborCollection();
        this.particles = new ParticleCollection();
        particles.add(new Land());
    }
    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public HashMap<Direction,Cell> getNeighbors() throws StateNotSupportedException{
        // neighbors are not set before initialization
        if (status==CellStatus.PreInitialized)
            throw new StateNotSupportedException();
        else return neighbors;
    }

    @Override
    public ParticleCollection getParticles() {
        return particles;
    }

    @Override
    public void setParticles(ParticleCollection particles) {
        this.particles = particles;
    }

    @Override
    public CellStatus getStatus() {
        return status;
    }

    @Override
    public void Process(long cycle) {
        status = CellStatus.Processing;
        // TODO create body
        status = CellStatus.Processed;
    }

    @Override
    public void Surpass(long cycle) {
        status = CellStatus.Surpassing;
        //TODO create Body
        status = CellStatus.Surpassed;
    }

    /**
     * Add a neighbor to the cell
     * @param direction The direction where we can find the neighbor
     * @param neighbor The neighbor cell
     */
    public void addNeighbor(Direction direction, Cell neighbor) {
        neighbors.put(direction, neighbor);
        initialized = isInitialized();
        if (initialized) {
            status = CellStatus.Initialized;
        }
    }

    private boolean isInitialized() {
        return neighbors
                .entrySet()
                .stream()
                .filter(x -> ((x.getValue()) instanceof UnknownNeighbor))
                .count() == 0;

    }

    // Empty class for initialization of Neighbors
    private final class UnknownNeighbor implements Cell {

        @Override
        public Address getAddress() {
            return null;
        }

        @Override
        public HashMap<Direction,Cell> getNeighbors() {
            return null;
        }

        @Override
        public ParticleCollection getParticles() {
            return null;
        }

        @Override
        public void setParticles(ParticleCollection particles) {

        }

        @Override
        public CellStatus getStatus() {
            return null;
        }

        @Override
        public void Process(long cycle) {

        }

        @Override
        public void Surpass(long cycle) {

        }
    }
}

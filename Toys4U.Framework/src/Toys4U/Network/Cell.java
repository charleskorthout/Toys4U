/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Toys4U.Network;

import Toys4U.Infrastructure.Direction;
import Toys4U.Network.Collections.CellNeighborCollection;
import Toys4U.Particles.Collections.ParticleCollection;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Charles Korthout
 */
public interface Cell extends NetworkComponent, Serializable{
    HashMap<Direction,Cell> getNeighbors() throws StateNotSupportedException;
    ParticleCollection getParticles();
    void setParticles(ParticleCollection particles);
    CellStatus getStatus();
    void Process(long cycle);
    void Surpass(long cycle);
}

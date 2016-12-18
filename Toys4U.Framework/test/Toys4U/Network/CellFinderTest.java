/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Toys4U.Network;

import Toys4U.GameOfLifeWorld.Habitat;
import Toys4U.Infrastructure.Direction;
import Toys4U.Network.Collections.CellNeighborCollection;
import Toys4U.Particles.Collections.ParticleCollection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author charl
 */
public class CellFinderTest {
    
    public CellFinderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    

    
    /**
    *
    * @author Charles Korthout
    */
   public class TestCell implements Cell{
       AddressImpl address;
       CellNeighborCollection neighbors;
       /**
        * Returns an empty cell
        * @param worldId
        * @param habitatid
        * @param x
        * @param y 
        */
       public TestCell(int worldId, int habitatid, int x, int y) {
            address = new AddressImpl(worldId, habitatid, x,y);
            neighbors = new CellNeighborCollection();
       }

       /**
        * Get the neighbors of this cell
        * @return the neighbors of this cell
        */
       @Override
       public CellNeighborCollection getNeighbors() {
           return neighbors;
       }

       /**
        * Set the neighbors of this cell
        * @param neighbors the cell that are connected the this cell
        */
       public void setNeighbors(CellNeighborCollection neighbors) {
           this.neighbors = neighbors;
       }
       /**
        * Get the neighbor at the specified direction
        * @param d The direction where to locate the neighbor
        * @return The cell at the direction
        */
       public Cell getNeighbor(Direction d) {
           return (Cell) neighbors.get(d);
       }

       /**
        * get the list of particles in this cell
        * @return the list of particles in this cell
        */
       @Override
       public ParticleCollection getParticles() {
           return new ParticleCollection();
       }

       /**
        * Get the address of this cell
        * @return the address of this cell
        */
       @Override
       public Address getAddress() {
           return address;
       }

   }
}

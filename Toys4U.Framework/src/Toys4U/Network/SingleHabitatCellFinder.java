/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Toys4U.Network;

import Toys4U.GameOfLifeWorld.Habitat;
import Toys4U.Infrastructure.Direction;

/**
 *
 * @author Charles Korthout
 */
public class SingleHabitatCellFinder {
        private Habitat habitat;
        public SingleHabitatCellFinder(Habitat habitat) {
            this.habitat = habitat;
        }
        
        public NetworkComponent findNeighbor(NetworkComponent component, Direction direction) {
            // if (component.getClass() == Cell.class) {
                Cell cell = ((Cell) component);
                int worldid = cell.getAddress().getWorldId();
                int habitatid = cell.getAddress().getHabitatId();
                int x;
                int y;
                switch (direction)
                {
                    case NORTH      : x = cell.getAddress().getX(); 
                                      y = cell.getAddress().getY() + 1 ; 
                                      break;
                    case NORTHEAST  : x = cell.getAddress().getX() + 1 ; 
                                      y = cell.getAddress().getY() + 1 ; 
                                      break; 
                    case EAST       : x = cell.getAddress().getX()+ 1; 
                                      y = cell.getAddress().getY() ; 
                                      break;  
                    case SOUTHEAST  : x = cell.getAddress().getX() + 1 ; 
                                      y = cell.getAddress().getY() - 1 ; 
                                      break; 
                    case SOUTH      : x = cell.getAddress().getX(); 
                                      y = cell.getAddress().getY() - 1 ; 
                                      break;
                    case SOUTHWEST  : x = cell.getAddress().getX() - 1; 
                                      y = cell.getAddress().getY() - 1 ; 
                                      break;
                    case WEST       : x = cell.getAddress().getX() - 1; 
                                      y = cell.getAddress().getY() ; 
                                      break;  
                    default         : x = cell.getAddress().getX() - 1; 
                                      y = cell.getAddress().getY() + 1 ; 
                                      break;
                } 
                x = x % habitat.getColumns(); // wrap around x if needed
                y = y % habitat.getRows(); // wrap around y if needed
                //return habitat.get(new AddressImpl(worldid,habitatid, x , y));
                return null;
            }
        
                
        /**
         * Return the network component that manages this 
         * @param component The component to search for 
         * @return 
         */
        /*public NetworkComponent whoHas(NetworkComponent component) {
            //TODO incorrect if worldid and habitat are equal than return habitat, otherwise move up...
            return habitat;
        }*/
}

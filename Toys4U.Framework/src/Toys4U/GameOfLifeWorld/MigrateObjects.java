/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Toys4U.GameOfLifeWorld;

/**
 *
 * @author Charles Korthout
 * The overflow manager has the responsibility to handle all occurences where particles leave 
 * the habitat and need to be replaced on the same or different habitats of worlds
 */
public interface MigrateObjects {
    void handle();
    
}

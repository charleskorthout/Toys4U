/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Toys4U.Network;

/**
 *
 * @author Charles Korthout
 */
public class AddressImpl implements Address{
    int worldid;
    int habitatid;
    int x; 
    int y;
    
    public AddressImpl(int worldid, int habitatid, int x, int y) {
        this.worldid = worldid;
        this.habitatid = habitatid;
        this.x = x;
        this.y=y;
    }
    
    @Override
    public int getWorldId() {
        return worldid;
    }

    @Override
    public int getHabitatId() {
        return habitatid;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
    
}

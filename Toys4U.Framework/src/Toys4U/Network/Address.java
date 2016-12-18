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
public interface Address {
    int getWorldId();
    int getHabitatId();
    int getX();
    int getY();
}

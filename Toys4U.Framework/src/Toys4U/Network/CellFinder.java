/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Toys4U.Network;

import Toys4U.Infrastructure.Direction;
import Toys4U.Network.Collections.NetworkComponentCollection;

/**
 *
 * @author Charles Korthout
 */
public interface CellFinder {
    NetworkComponent findNeighbor(NetworkComponent component, Direction direction);
    NetworkComponent whoHas(NetworkComponent component);
}

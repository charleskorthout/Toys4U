/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Toys4U.Network.Collections;

import Toys4U.Infrastructure.Direction;
import Toys4U.Network.Cell;
import java.util.HashMap;

/**
 *
 * @author Charles Korthout
 */
public class CellNeighborCollection<D extends Direction, C extends Cell> extends HashMap<D,C> {}

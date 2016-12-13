/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Toys4U.View;

import Toys4U.Model.ParticleColor;
import javafx.scene.paint.Color;

/**
 *
 * @author Charles Korthout
 */
public class ColorConvertor { 
    public static Color fromParticleColor(ParticleColor color) {
        switch (color) {
            case Black :return Color.BLACK; 
            case Blue : return Color.BLUE;
            case Brown : return Color.BROWN;
            case Green : return Color.GREEN;
            case Red : return Color.RED;           
            case Yellow : return Color.YELLOW;
            default :  return Color.WHITE;            
        }      
    }
}

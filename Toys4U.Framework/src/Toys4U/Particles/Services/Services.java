/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Toys4U.Particles.Services;

import Toys4U.Infrastructure.MovingParticle;
import Toys4U.Infrastructure.Walk;
import Toys4U.Particles.Animal;

/**
 *
 * @author Charles Korthout
 */
public class Services {
      
      /**
       * Calculate the maximum velocity for this animal
       * @param a The animal to do the calculation for
       * @return the Maximum velocity for this animal
       */
      public static double MaxVelocity(Animal a) {
          MovingParticle m = a.getMovement();
          if (m.getClass() == Walk.class) {
              int legs = ((Walk) m).getLegs();
              if (legs == 5) legs = Toys4U.Particles.Services.Constants.OPTIMAL_LEGS; // otherwise we get a divide error
              return (1/(Math.abs(5-legs)) * (1 / Math.max(a.getWeight(), Toys4U.Particles.Services.Constants.EPSILON))); 
          }
          else return Toys4U.Particles.Services.Constants.NON_WALKING_MAX; 
      }
      
      /**
       * Calculate the weight of the animal. The weight of the animal is the number of 
       * legs times 10 + the difference in energy and strength it the latter is greater
       * than 10
       * @param a The animal
       * @return the weight estimate of the animal
       */
      public static double calculateWeight(Animal a) {
          MovingParticle m = a.getMovement();
          if (m.getClass() == Walk.class) {
              int legs = ((Walk) m).getLegs();
              if (a.getEnergyLevel() - a.getStrength() <= 0) {
                return legs * Toys4U.Particles.Services.Constants.LEGS_MULTIFICATION_FACTOR;
              }
              else return legs*Toys4U.Particles.Services.Constants.LEGS_MULTIFICATION_FACTOR + (a.getEnergyLevel() - a.getStrength());
          }
          else return Toys4U.Particles.Services.Constants.EPSILON;
      }
      
      /**
       * Get the hunger level of an animal
       * @param a The animal
       * @return the hunger level of the animal
       */
      public static double hunger(Animal a) {
          return a.getStamina() - a.getEnergyLevel();
      }
}

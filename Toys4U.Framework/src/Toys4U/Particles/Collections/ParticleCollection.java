/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Toys4U.Particles.Collections;

import Toys4U.Particles.*;
import Toys4U.Particles.Digestion.Carnivore;
import Toys4U.Particles.Digestion.Herbivore;
import Toys4U.Particles.Digestion.Omnivore;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Charles Korthout
 */
public class ParticleCollection<P extends Particle> extends ArrayList<P> {

    /**
     * Group by and count the items
     * @return a map with particles and occurences
     */
    public Map<P, Long> countBy() {
        return this
                .stream()
                .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting()));
    }


    /**
     * Count the number of elements in the collection
     * @return
     */
    public long countPlant() {return this.stream().filter(p -> p instanceof Plant).count(); }
    public long countOmnivore() {return this.stream().filter(p -> p instanceof Omnivore).count(); }
    public long countCarnivore() {return this.stream().filter(p -> p instanceof Carnivore).count(); }
    public long countHerbivore() {return this.stream().filter(p -> p instanceof Herbivore).count(); }
    public long countWater() {return this.stream().filter(p -> p instanceof Water).count(); }
    public long countObstacle() {return this.stream().filter(p -> p instanceof Obstacle).count(); }

    /**
     * Checks if the collection of particles contains water
     *
     * @return true if there is water in the collection, false otherwise
     */
    public boolean containsWater() {
        return this.stream().anyMatch(p -> p.getClass() == Water.class);
    }

    ;


    /**
     * Checks if the collections contains an obstacle
     *
     * @return true if it has an obstacle, false otherwise
     */
    public boolean containsObstacle() {
        return this.stream().anyMatch(p -> p.getClass() == Obstacle.class);
    }

    ;

    /**
     * Scans the list for particles that can be routed to different locations
     *
     * @return The list with animals that have sufficient energy to move.
     */
    public Stream<P> movableParticals() {
        return this.stream().filter(p -> p.getClass() == Animal.class && ((Animal) p).willMove());
    }

    /**
     * Get the color of the last added particle on the list, if no particles exist anymore
     * return white
     *
     * @return particle color if particle exists otherwise white
     */
    public ParticleColor getParticleColor() {
        Optional<P> last = this.stream().reduce((first, second) -> second);
        if (last.isPresent()) {
            return last.get().getColor();
        } else return ParticleColor.White;
    }

    /**
     * Remove the dead animals (animals with 0 energy level from the collection)
     *
     * @param pc collection of particles
     * @return the list excluding animals without any energy level
     */
    public ParticleCollection removeDeadParticles(ParticleCollection pc) {
        Stream<P> cleanlist = pc.stream().filter(p -> (p.getClass() != Animal.class) || (p.getClass() == Animal.class && ((Animal) p).getEnergyLevel() > 0));
        ParticleCollection pcnew = new ParticleCollection();
        cleanlist.forEach(pcnew::add);
        return pcnew;
    }
}

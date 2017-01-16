package Toys4U.GameOfLifeWorld;


import Toys4U.Network.AddressImpl;
import Toys4U.Network.CellImpl;
import Toys4U.Particles.*;
import Toys4U.Particles.Collections.ParticleCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;


public class RandomHabitatGenerator implements HabitatGenerator {
    private final int worldid;
    private final int habitatid;
    private int rows;
    private int columns;
    private int totalCells;

    public RandomHabitatGenerator( int worldid, int habitatid, int rows, int columns) {

        this.totalCells = (rows*columns);
        // Land/Water ratio naar hoeveelheid cells
        // this.landSurface = (totalCells/100)*landSurface;
        // Dit zelfde voor de water
        this.worldid = worldid;
        this.habitatid = habitatid;
        this.rows = rows;
        this.columns = columns;
    }

    public static HashMap<Particle, Double> getRandomProportions() {
        HashMap < Particle, Double > weights = new HashMap();
        double[] values = new double[6];
        double sum = 0.0;
        for(int i = 0; i< 6;i++)
        {
            values[i] = Math.random();
            sum = sum + values[i];
        }
        weights.put(new PlantImpl(),values[0]/sum);
        weights.put(new Water(),values[1]/sum);
        weights.put(new OmnivoreImpl(),values[2]/sum);
        weights.put(new CarnivoreImpl(),values[3]/sum);
        weights.put(new HerbivoreImpl(),values[4]/sum);
        weights.put(new Obstacle(),values[5]/sum);
        return weights;
    }

    private Habitat createRandom(int worldid, int habitatid, int rows, int columns) {
        HashMap<Particle, Double> weights = getRandomProportions();
        ProportionalHabitatGenerator generator = new ProportionalHabitatGenerator(weights, worldid, habitatid, rows, columns, new Random());
        return generator.generate();
    }

    public Habitat generate() {
        return createRandom(worldid,habitatid,rows, columns);
    }

    /*
    public ArrayList<Particle> generate() {
        // Vullen van particels in arraylist
        // Hierbij word de ingestelde percentage gehanteerd van de land/water verhouding.
        ArrayList<Particle> randomMap = new ArrayList<>();
        int cellsCount = this.rows*this.columns;
        for (int counter = 0; counter < cellsCount; counter++) {
            if (landSurface > 0) {
                randomMap.add(new Land());
                landSurface--;
            } else {
                randomMap.add(new Water());
            }
        }

        // Random volgorde verplaatsen van alle items.
        long seed = System.nanoTime();
        Collections.shuffle(randomMap, new Random(seed));

        return centerObjects2D(randomMap);
    }
    */

    /**
    * Functie voor het genereren van eilanden.
    * @param randomMap  Lijst met random particles van water/land
    * @return finalMap Lijst met eiland
     * */
    private ArrayList<Particle> centerObjects2D(ArrayList<Particle> randomMap) {
        ArrayList<Particle> finalMap = new ArrayList<>();

        // Toevoegen van middenpunt in map als niet beschikbaar
        int rowMap = this.rows;
        int colMap = this.columns;

        if (rowMap % 2 != 0) {
            rowMap += 1;
        }
        if (colMap % 2 != 0) {
            colMap += 1;
        }

        Particle[][] objectMap = new Particle[rowMap][colMap];

        for (int cellCounter = 0; cellCounter < this.totalCells; cellCounter++) {
            int a = cellCounter/this.rows;
            int b = cellCounter-(a*this.rows);
            objectMap[a][b] = randomMap.get(cellCounter);
        }

        // Terug zetten van 2d map naar array
        for (Particle[] row : objectMap
                ) {
            for (int column = 0; column < this.columns; column++) {
                finalMap.add(row[column]);
            }
        }

        return finalMap;
    }


    @Override
    public int getWorldId() {
        return worldid;
    }

    @Override
    public int getHabitatId() {
        return habitatid;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getTotalCells() {
        return totalCells;
    }
}
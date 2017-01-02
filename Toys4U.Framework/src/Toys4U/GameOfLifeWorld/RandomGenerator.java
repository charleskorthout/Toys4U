package Toys4U.GameOfLifeWorld;


import Toys4U.Particles.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class RandomGenerator {
    private int landSurface;
    private int rows;
    private int columns;
    private int totalCells;

    public  RandomGenerator(int landSurface, int rows, int columns){
        this.totalCells = (rows*columns);
        // Land/Water ratio naar hoeveelheid cells
        this.landSurface = (totalCells/100)*landSurface;
        // Dit zelfde voor de water
        this.rows = rows;
        this.columns = columns;
    }

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

        // TODO eilandje bouwen


        // Terug zetten van 2d map naar array
        for (Particle[] row : objectMap
                ) {
            for (int column = 0; column < this.columns; column++) {
                finalMap.add(row[column]);
            }
        }

        return finalMap;
    }

}
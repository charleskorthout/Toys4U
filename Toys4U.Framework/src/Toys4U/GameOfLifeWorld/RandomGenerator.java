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

    public RandomGenerator(int landSurface, int rows, int columns) {
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

        centerObjects(objectMap);
        moveStarPointsToMiddle(objectMap);
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

    private void moveBordersObjects(Particle[][] objectMap) {

        for (int c = 0; c < this.columns / 4; c++) {
            for (int moveUpCols = 0; moveUpCols < this.columns - 2; moveUpCols++) {
                for (int moveUpRows = 0; moveUpRows < 20; moveUpRows++) {
                    Particle swap = objectMap[moveUpCols][moveUpRows];

                    objectMap[moveUpCols][moveUpRows] = objectMap[moveUpCols + 1][moveUpRows];
                    objectMap[moveUpCols + 1][moveUpRows] = swap;
                }
            }

        }
    }

    private void centerObjects(Particle[][] objectMap) {
        // Hoe vaak moet de complete iteratie voordoen (if around = 0 then move pos random richting)
        for (int roundCounter = 0; roundCounter < 10; roundCounter++) {
            int lineUp = 0;
            int lineDown = this.rows - 1;
            int lineLeft = 0;
            int lineRight = this.columns - 1;

            // Hoeveel stappen zit er in een iteratie
            for (int stepCounter = (this.rows / 2) - 1; stepCounter > 0; stepCounter--) {

                // Push top to middle
                for (int col = 0; col < this.columns; col++) {
                    if (objectMap[col][lineUp + 1].getColor() == ParticleColor.Blue) {
                        if (objectMap[col][lineUp].getColor() == ParticleColor.White) {
                            Particle swap = objectMap[col][lineUp + 1];
                            objectMap[col][lineUp + 1] = objectMap[col][lineUp];
                            objectMap[col][lineUp] = swap;
                        }
                    }
                }

                // push down to middle
                for (int col = 0; col < this.columns; col++) {
                    if (objectMap[col][lineDown - 1].getColor() == ParticleColor.Blue) {
                        if (objectMap[col][lineDown].getColor() == ParticleColor.White) {
                            Particle swap = objectMap[col][lineDown - 1];
                            objectMap[col][lineDown - 1] = objectMap[col][lineDown];
                            objectMap[col][lineDown] = swap;
                        }
                    }
                }

                // push right to middle
                for (int row = 0; row < this.rows; row++) {
                    if (objectMap[lineRight - 1][row].getColor() == ParticleColor.Blue) {
                        if (objectMap[lineRight][row].getColor() == ParticleColor.White) {
                            Particle swap = objectMap[lineRight - 1][row];
                            objectMap[lineRight - 1][row] = objectMap[lineRight][row];
                            objectMap[lineRight][row] = swap;
                        }
                    }
                }

                // push left to middle
                for (int row = 0; row < this.rows; row++) {
                    if (objectMap[lineLeft + 1][row].getColor() == ParticleColor.Blue) {
                        if (objectMap[lineLeft][row].getColor() == ParticleColor.White) {
                            Particle swap = objectMap[lineLeft + 1][row];
                            objectMap[lineLeft + 1][row] = objectMap[lineLeft][row];
                            objectMap[lineLeft][row] = swap;
                        }
                    }
                }
                // Eentje row/column incrementen
                lineUp++;
                lineDown--;
                lineLeft++;
                lineRight--;
            }
        }
    }

    private void moveStarPointsToMiddle(Particle[][] objectMap) {
        Random random = new Random();
        // rijen om te verplaatsen

        int cellCountUp = 0;
        int cellCountDown = 0;
        int cellCountRight = 0;
        int cellCountLeft = 0;

        // verwijderen boven
        for (int rowCnt = 0; rowCnt < this.rows / 5; rowCnt++) {
            //itereren horizontaal over lijn

            for (int colCnt = 0; colCnt < this.columns; colCnt++) {
                if (objectMap[colCnt][rowCnt].getColor() == ParticleColor.White) {
                    objectMap[colCnt][rowCnt] = new Water();
                    cellCountUp++;
                }
            }
        }
        // verwijderen onder
        for (int rowCnt = this.rows - 1; rowCnt > this.rows - (this.rows / 5); rowCnt--) {
            for (int colCnt = 0; colCnt < this.columns; colCnt++) {
                if (objectMap[colCnt][rowCnt].getColor() == ParticleColor.White) {
                    objectMap[colCnt][rowCnt] = new Water();
                    cellCountDown++;
                }
            }
        }

        // verwijderen links
        for (int colCnt = 0; colCnt < this.columns / 5; colCnt++) {
            for (int rowCnt = 0; rowCnt < this.rows - 1; rowCnt++) {
                if (objectMap[colCnt][rowCnt].getColor() == ParticleColor.White) {
                    objectMap[colCnt][rowCnt] = new Water();
                    cellCountLeft++;
                }
            }
        }

        // verwijderen links
        for (int colCnt = this.columns - 1; colCnt > this.columns - (this.columns / 5); colCnt--) {
            for (int rowCnt = 0; rowCnt < this.rows - 1; rowCnt++) {
                if (objectMap[colCnt][rowCnt].getColor() == ParticleColor.White) {
                    objectMap[colCnt][rowCnt] = new Water();
                    cellCountRight++;
                }
            }
        }

        Random randNum = new Random();

        while (cellCountUp > 0) {
            int ranNr = randNum.nextInt(this.columns - ((this.columns / 5) * 2)) + this.columns / 5;
            objectMap[ranNr][0] = new Land();
            moveToCenter(objectMap, 0, ranNr, 0);

            cellCountUp--;
        }

    }

    private void swapCell(Particle[][] objectMap, int x1, int y1, int x2, int y2) {
        Particle swap = objectMap[x1][y1];
        objectMap[x1][y1] = objectMap[x2][y2];
        objectMap[x2][y2] = swap;
    }

    private void moveToCenter(Particle[][] objectMap, int x, int y, int direction) {

    }
}
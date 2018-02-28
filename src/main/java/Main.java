package main.java;

import main.java.runners.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {

    public static final String MUSHROOM = "M";
    public static final String TOMATO = "T";

//    public static final Integer ROWS = 6;
//    public static final Integer COLUMNS = 7;
//    public static final Integer L = 1;
//    public static final Integer H = 5;

    public static final Integer ROWS = 200;
    public static final Integer COLUMNS = 250;
    public static final Integer L = 4;
    public static final Integer H = 12;

//    public static final Integer ROWS = 1000;
//    public static final Integer COLUMNS = 1000;
//    public static final Integer L = 6;
//    public static final Integer H = 14;


    public static Cell[][] entirePizza;
    public static List<Slice> slices = new ArrayList<>();

    public static void main(String[] args) throws IOException {
//        entirePizza = readFromFile("../resources/small.in");
        entirePizza = readFromFile("../resources/medium.in");
//        entirePizza = readFromFile("../resources/big.in");

//        processAllCells(Arrays.asList(new Runner1x5(), new Runner5x1(), new Runner2x2()));
        processAllCells(Arrays.asList(new Runner1x12(), new Runner12x1(), new Runner1x11(), new Runner11x1()));
//        processAllCells(Arrays.asList(new Runner1x14(), new Runner14x1(), new Runner1x13(), new Runner13x1(),
//                new Runner1x12(), new Runner12x1(), new Runner2x6(), new Runner6x2(), new Runner3x4(), new Runner4x3()));


        writeToFile();
        System.out.println("END");
    }


    public static void processAllCells(Collection<PizzaRunner> runners){

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                for (PizzaRunner runner : runners) {
                    runner.runAlgorithm(i, j);
                }
            }
        }
    }

    public static void checkAndProcess(Integer r1, Integer c1, Integer r2, Integer c2){
        if (checkCondition(r1, c1, r2, c2)){
            Slice slice = new Slice();
            slice.cells = getCells(r1, c1, r2, c2);
            slice.cells.forEach(cell -> cell.wasUsed = true);
            slice.r1 = r1;
            slice.c1 = c1;
            slice.r2 = r2;
            slice.c2 = c2;
            slices.add(slice);
        }
    }

    public static List<Cell> getCells(Integer r1, Integer c1, Integer r2, Integer c2){
        List<Cell> cells = new ArrayList<>();

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                cells.add(entirePizza[i][j]);
            }
        }
        return cells;
    }

    public static Boolean checkCondition(Integer r1, Integer c1, Integer r2, Integer c2) {

        int cellCount = 0;
        int countT = 0;
        int countM = 0;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (MUSHROOM.equals(entirePizza[i][j].type)) {
                    countM++;
                } else {
                    countT++;
                }
                cellCount++;
                if (cellCount > H) {
                    throw new IllegalStateException("Error in range of given cells");
                }
                if (countM >= L && countT >= L) {
                    return true;
                }

            }
        }
        return false;
    }

    public static String print(Cell[][] pizza) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                builder.append(pizza[i][j]);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public static Cell[][] readFromFile(String fileName) throws IOException {
        File f = new File(fileName);
        Cell[][] entirePizza = new Cell[ROWS][COLUMNS];

        BufferedReader b = new BufferedReader(new FileReader(f));
        String readLine = "";
        System.out.println("Reading file using Buffered Reader");

        int row = 0;
        while ((readLine = b.readLine()) != null) {
            String[] line = readLine.split("");
            for (int column = 0; column < COLUMNS; column++) {
                Cell newCell = new Cell();
                if (MUSHROOM.equals(line[column])) {
                    newCell.type = MUSHROOM;
                } else {
                    newCell.type = TOMATO;
                }
                entirePizza[row][column] = newCell;
            }
            row++;
        }
        return entirePizza;
    }


    private static void writeToFile() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("../resources/medium-out.txt", "UTF-8");
        writer.println(slices.size());
        for (Slice slice : slices) {
            writer.println(slice.r1 + " " + slice.c1 + " " + slice.r2 + " " + slice.c2);
        }
        writer.close();
    }
}

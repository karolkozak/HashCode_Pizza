package main.java.runners;

import main.java.Main;

import static main.java.Main.COLUMNS;
import static main.java.Main.ROWS;

public class Runner4x3 extends AbstractPizzaRunner {


    @Override
    public void runAlgorithm(Integer currentRow, Integer currentColumn) {
        Integer r2 = currentRow + 3;
        Integer c2 = currentColumn + 2;

        if (c2 > COLUMNS - 1 || r2 > ROWS - 1 || !areAllCellsUnused(currentRow, currentColumn, r2, c2)){
            return;
        }
        Main.checkAndProcess(currentRow, currentColumn, r2, c2);
    }
}

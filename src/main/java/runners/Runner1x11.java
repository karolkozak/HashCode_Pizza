package main.java.runners;

import main.java.Main;

import static main.java.Main.COLUMNS;

public class Runner1x11 extends AbstractPizzaRunner {


    @Override
    public void runAlgorithm(Integer currentRow, Integer currentColumn) {
        Integer r2 = currentRow;
        Integer c2 = currentColumn + 10;

        if (c2 > COLUMNS - 1 || !areAllCellsUnused(currentRow, currentColumn, r2, c2)){
            return;
        }
        Main.checkAndProcess(currentRow, currentColumn, r2, c2);
    }
}

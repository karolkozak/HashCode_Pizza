package main.java.runners;

import main.java.Main;

import static main.java.Main.ROWS;

public class Runner11x1 extends AbstractPizzaRunner {


    @Override
    public void runAlgorithm(Integer currentRow, Integer currentColumn) {
        Integer r2 = currentRow + 11;
        Integer c2 = currentColumn;

        if (r2 > ROWS - 1 || !areAllCellsUnused(currentRow, currentColumn, r2, c2)) {
            return;
        }
        Main.checkAndProcess(currentRow, currentColumn, r2, c2);
    }
}

package main.java.runners;

import main.java.Main;

import static main.java.Main.ROWS;

public class Runner5x1 extends AbstractPizzaRunner{


    @Override
    public void runAlgorithm(Integer currentRow, Integer currentColumn) {
        Integer r2 = currentRow + 4;
        Integer c2 = currentColumn;

        if (r2 > ROWS - 1 || !areAllCellsUnused(currentRow, currentColumn, r2, c2)){
            return;
        }
        Main.checkAndProcess(currentRow, currentColumn, r2, c2);
    }
}

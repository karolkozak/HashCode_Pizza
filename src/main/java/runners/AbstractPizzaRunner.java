package main.java.runners;

import main.java.Main;

public abstract class AbstractPizzaRunner implements PizzaRunner {

    protected Boolean areAllCellsUnused(Integer r1, Integer c1, Integer r2, Integer c2){
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (Main.entirePizza[i][j].wasUsed){
                    return false;
                }
            }
        }
        return true;
    }
}

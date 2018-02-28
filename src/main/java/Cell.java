package main.java;

public class Cell {

    // T, M
    public String type;
    public Integer sliceNumber;
    public Boolean wasUsed = false;

    @Override
    public String toString(){
        return type;
    }
}

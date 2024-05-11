package it.viligiardi.pojo;

public class Ship {
    // attributes
    private int dimShip;
    private String symbol;
    private int direction;

    // methods and constructors
    public Ship(int dimShip, String symbol, int direction) {
        this.dimShip = dimShip;
        this.symbol = symbol;
        this.direction = direction;
    }

    public int getDimShip() {
        return dimShip;
    }

    public void setDimShip(int dimShip) {
        this.dimShip = dimShip;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

}

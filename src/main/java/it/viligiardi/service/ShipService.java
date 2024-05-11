package it.viligiardi.service;

import java.util.ArrayList;

import it.viligiardi.pojo.Ship;

public class ShipService {
    // attributes
    private static final int[] dimAllShips = { 4, 3, 3, 3, 2, 2, 2, 1, 1 };
    private static final String[] allSymbol = { "a", "b", "c", "d", "e", "f", "g", "h", "i" };
    // methods and constructors

    public static ArrayList<Ship> createShipsList() {
        ArrayList<Ship> sl = new ArrayList<Ship>(9);
        for (int i = 0; i < sl.size(); i++) {
            Ship s = new Ship(ShipService.dimAllShips[i], ShipService.allSymbol[i], (int) (Math.random() * 2));
            sl.add(s);
        }
        return sl;
    }
}

package it.viligiardi.service;

public class FieldService {
    // attributes
    // methods and constructors
    public static String[][] createMatrix(int dm) {
        String[][] m = new String[dm][dm];
        for (int i = 0; i < dm; i++) {
            for (int j = 0; j < dm; j++) {
                m[i][j] = "a";
            }
        }
        return m;
    }
}

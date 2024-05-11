package it.viligiardi.pojo;

import it.viligiardi.service.FieldService;

public class Field {
    // attributes
    private int dimMatrix;
    private String[][] matrix = FieldService.createMatrix(dimMatrix);

    // methods and constructors
    public Field(int dimMatrix) {
        this.dimMatrix = dimMatrix;
    }

    public int getDimMatrix() {
        return dimMatrix;
    }

    public void setDimMatrix(int dimMatrix) {
        this.dimMatrix = dimMatrix;
    }

    public String[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }

}

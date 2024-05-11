package it.viligiardi.pojo;

import java.util.ArrayList;

import it.viligiardi.service.ShipService;

public class Player {
    // attributes
    private String name;
    private Integer numships;
    private ArrayList<Ship> shipsList = ShipService.createShipsList();
    private Field field;

    // methods and constructors
    public Player(String name, Integer numships, Field field) {
        this.name = name;
        this.numships = numships;
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumships() {
        return numships;
    }

    public void setNumships(Integer numships) {
        this.numships = numships;
    }

    public ArrayList<Ship> getShipsList() {
        return shipsList;
    }

    public void setShipsList(ArrayList<Ship> shipsList) {
        this.shipsList = shipsList;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public void setNickName(String s, int num) {
        if (s == null || s.equals("")) {
            this.name = "GIOCATORE" + num;
        } else {
            this.name = s;
        }
    }
}

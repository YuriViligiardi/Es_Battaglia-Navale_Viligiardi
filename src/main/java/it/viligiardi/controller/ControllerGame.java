package it.viligiardi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import it.viligiardi.pojo.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ControllerGame implements Initializable {
    // attributes
    @FXML
    private GridPane gpPlayerData;
    @FXML
    private GridPane gpP1;
    @FXML
    private GridPane gpP2;
    @FXML
    private Label nameP1;
    @FXML
    private Label nameP2;
    @FXML
    private Label numShipP1;
    @FXML
    private Label numShipP2;
    @FXML
    private Label comment;

    int counter;
    int num;

    // methods and constructors
    @FXML
    public void switchToPrimary() throws IOException {
        App.setRoot("menu");
    }

    // @FXML
    public void view() {
        nameP1.setText(Game.p1.getName());
        nameP2.setText(Game.p2.getName());
        String s = Game.p1.getNumships().toString();
        numShipP1.setText(s);
        String s1 = Game.p2.getNumships().toString();
        numShipP2.setText(s1);
        counter = 1;
    }

    // @FXML
    public void createGridPane(GridPane gp) {

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                Button b = new Button();
                b.setPrefSize(30.0, 30.0);

                if (num % 2 == 0) {
                    b.setOnAction(event -> {
                        // quello che succede al clic
                        selectButton(b);
                    });
                }

                gp.add(b, x, y);
            }
        }
        num++;
    }

    // @FXML
    public void buttonDisable(GridPane gp) {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
            }
        }
    }

    // @FXML
    public void selectButton(Button b) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        num = 1;
        view();
        comment.setText(Game.p1.getName().toUpperCase() + ": Posiziona un simbolo nel campo");
        createGridPane(gpP1);
        createGridPane(gpP2);
    }
}
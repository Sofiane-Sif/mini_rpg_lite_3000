package com.example.rpgjfx.Controllers;

import com.example.rpgjfx.HelloApplication;
import com.isep.rpg.Warrior;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.IOException;

public class FightWindowController {
    @FXML
    public Label teamComposition;

    @FXML
    void lanceHerosChoice(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("enemiesChoice.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        HelloApplication.currentStage.setScene(scene);
        HelloApplication.currentStage.show();
    }

    Warrior warrior = new Warrior("Bobi");
    @FXML
    void afficheComposition(ActionEvent event) {
        teamComposition.setText("Voici la composition de votre équipe " + HerosChoiceController.getHeroName1() + " " +
        HerosChoiceController.getHeroName2() + " " + HerosChoiceController.getHeroName3() + " " + HerosChoiceController.getHeroName4());
    }
}

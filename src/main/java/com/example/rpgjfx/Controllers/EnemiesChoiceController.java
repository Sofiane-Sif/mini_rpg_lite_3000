package com.example.rpgjfx.Controllers;

import com.example.rpgjfx.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class EnemiesChoiceController {

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    void handleMouseEntered1(MouseEvent event) {
        label1.setVisible(true);
    }

    @FXML
    void handleMouseEntered2(MouseEvent event) {
        label2.setVisible(true);
    }

    @FXML
    void handleMouseEntered3(MouseEvent event) {
        label3.setVisible(true);
    }

    @FXML
    void handleMouseEntered4(MouseEvent event) {
        label4.setVisible(true);
    }

    @FXML
    void handleMouseExited1(MouseEvent event) {
        label1.setVisible(false);
    }

    @FXML
    void handleMouseExited2(MouseEvent event) {
        label2.setVisible(false);
    }

    @FXML
    void handleMouseExited3(MouseEvent event) {
        label3.setVisible(false);
    }

    @FXML
    void handleMouseExited4(MouseEvent event) {
        label4.setVisible(false);
    }

    @FXML
    void lanceHerosChoice(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("herosChoice.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        HelloApplication.currentStage.setScene(scene);
        HelloApplication.currentStage.show();
    }

    @FXML
    void lanceFightWindow(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fightWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        HelloApplication.currentStage.setScene(scene);
        HelloApplication.currentStage.show();
    }
}

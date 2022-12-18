package com.example.rpgjfx.Controllers;

import com.example.rpgjfx.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class HelloController {

    @FXML
    public void lanceWin1(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("gameRules.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        HelloApplication.currentStage.setScene(scene);
        HelloApplication.currentStage.show();
    }

    @FXML
    void closeWin1(ActionEvent event) {
        HelloApplication.currentStage.close();
    }

}
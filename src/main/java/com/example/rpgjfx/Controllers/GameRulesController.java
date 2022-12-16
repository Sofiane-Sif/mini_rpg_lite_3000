package com.example.rpgjfx.Controllers;
import com.example.rpgjfx.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

import static com.example.rpgjfx.HelloApplication.currentStage;

public class GameRulesController {

    @FXML
    public void lanceWin2(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("herosChoice.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        currentStage.setScene(scene);
        currentStage.show();
    }

    @FXML
    void lanceHello(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        currentStage.setScene(scene);
        currentStage.show();
    }

}

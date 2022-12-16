package com.example.rpgjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start-view.fxml"));
        currentStage = stage;
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Bienvenue dans Mini RPG Lite 3000©");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Stage currentStage;
}
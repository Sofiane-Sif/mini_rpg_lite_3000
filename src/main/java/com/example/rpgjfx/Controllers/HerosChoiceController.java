package com.example.rpgjfx.Controllers;

import com.example.rpgjfx.HelloApplication;
import com.isep.rpg.Healer;
import com.isep.rpg.Hunter;
import com.isep.rpg.Mage;
import com.isep.rpg.Warrior;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class HerosChoiceController {

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label labelTextArea;


    @FXML
    private Label labelTextArea1;

    @FXML
    private Label labelTextArea2;

    @FXML
    private Label labelTextArea21;

    @FXML
    private TextField textArea;

    @FXML
    private TextField textArea1;

    @FXML
    private TextField textArea2;

    @FXML
    private TextField textArea21;

    @FXML
    void handleMouseEntered1(MouseEvent event) {
        label1.setVisible(true);
    }

    @FXML
    void handleMouseExited1(MouseEvent event) {
        label1.setVisible(false);
    }

    @FXML
    void handleMouseEntered2(MouseEvent event) {
        label2.setVisible(true);
    }

    @FXML
    void handleMouseExited2(MouseEvent event) {
        label2.setVisible(false);
    }

    @FXML
    void handleMouseEntered3(MouseEvent event) {
        label3.setVisible(true);
    }

    @FXML
    void handleMouseExited3(MouseEvent event) {
        label3.setVisible(false);
    }

    @FXML
    void handleMouseEntered4(MouseEvent event) {
        label4.setVisible(true);
    }

    @FXML
    void handleMouseExited4(MouseEvent event) {
        label4.setVisible(false);
    }


    @FXML
    void lanceExplication(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("gameRules.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        HelloApplication.currentStage.setScene(scene);
        HelloApplication.currentStage.show();
    }

    @FXML
    void lanceEnemiesWin(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("enemiesChoice.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        HelloApplication.currentStage.setScene(scene);
        HelloApplication.currentStage.show();
    }

    @FXML
    void inputAreaAppear(MouseEvent event) {
        label1.setVisible(false);
        textArea.setVisible(true);
        labelTextArea.setVisible(true);
    }

    @FXML
    void inputAreaAppear1(MouseEvent event) {
        label2.setVisible(false);
        textArea1.setVisible(true);
        labelTextArea1.setVisible(true);
    }

    @FXML
    void inputAreaAppear2(MouseEvent event) {
        label3.setVisible(false);
        textArea2.setVisible(true);
        labelTextArea2.setVisible(true);
    }

    @FXML
    void inputAreaAppear3(MouseEvent event) {
        label3.setVisible(false);
        textArea21.setVisible(true);
        labelTextArea21.setVisible(true);
    }

    public static Warrior warrior;
    @FXML
    void heroName1(ActionEvent event) {
        textArea.setVisible(false);
        labelTextArea.setVisible(false);
        String warriorName = textArea.getText();
        System.out.println(warriorName);
        warrior = new Warrior(warriorName);
    }

    static Warrior getHeroName1(){
        return warrior;
    }

    public static Hunter hunter;
    @FXML
    void heroName2(ActionEvent event) {
        textArea1.setVisible(false);
        labelTextArea1.setVisible(false);
        String hunterName = textArea1.getText();
        System.out.println(hunterName);
        hunter = new Hunter(hunterName,8);
    }

    static Hunter getHeroName2(){
        return hunter;
    }

    public static Mage mage;
    @FXML
    void heroName3(ActionEvent event) {
        textArea2.setVisible(false);
        labelTextArea2.setVisible(false);
        String mageName = textArea2.getText();
        System.out.println(mageName);
        mage = new Mage(mageName,10);
    }
    static Mage getHeroName3(){
        return mage;
    }

    public static Healer healer;
    @FXML
    void heroName4(ActionEvent event) {
        textArea21.setVisible(false);
        labelTextArea21.setVisible(false);
        String healerName = textArea21.getText();
        System.out.println(healerName);
        healer = new Healer(healerName, 10,3);
    }
    static Healer getHeroName4(){
        return healer;
    }

}

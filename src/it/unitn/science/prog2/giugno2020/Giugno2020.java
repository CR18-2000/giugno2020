/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.giugno2020;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author crist
 */
public class Giugno2020 extends Application {
    
    Griglia g;
    Button abbandona;
    Button sbircia;
    Button test;
    Button random;
    Text testo;
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        random = new Button ("Random");
        EventHandler<ActionEvent> eventHandlerRandom = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            }
        };
        random.addEventHandler(ActionEvent.ACTION, eventHandlerRandom);
        test = new Button ("Test");
        EventHandler<ActionEvent> eventHandlerTest = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                g = new Griglia();
                root.setCenter(g);
                g.attivaCelle();
                random.setDisable(true);
                test.setDisable(true);
                abbandona.setDisable(false);
                sbircia.setDisable(false);
            }
        };
        test.addEventHandler(ActionEvent.ACTION, eventHandlerTest);
        abbandona = new Button ("Abbandona");
        EventHandler<ActionEvent> eventHandlerAbb = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            }
        };
        abbandona.addEventHandler(ActionEvent.ACTION, eventHandlerAbb);
        abbandona.setDisable(true);
        sbircia = new Button ("Sbircia");
        EventHandler<ActionEvent> eventHandlerSbircia = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            }
        };
        sbircia.addEventHandler(ActionEvent.ACTION, eventHandlerSbircia);
        sbircia.setDisable(true);
        Label label = new Label ("  Celle rimaste: ");
        testo = new Text ("71");
        EventHandler<MouseEvent> mouseEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                testo.setText(Integer.toString(g.celleRimaste));
                if (g.celleRimaste==0) {
                    Alert alert = new Alert (AlertType.INFORMATION);
                    alert.setTitle("Caselle finite");
                    alert.setContentText("HAI VINTO :)");
                    alert.showAndWait();
                }
                if (g.reset) {
                    reset();
                    g.resettato();
                }
            }
        };
        root.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent);
        HBox hb = new HBox ();
        hb.getChildren().addAll(random, test, abbandona, sbircia, label, testo);
        root.setCenter(g);
        root.setBottom(hb);
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void reset () {
        g = null;
        random.setDisable(false);
        test.setDisable(false);
        abbandona.setDisable(true);
        sbircia.setDisable(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

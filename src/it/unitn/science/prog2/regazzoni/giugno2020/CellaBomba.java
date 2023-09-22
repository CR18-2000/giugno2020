/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.giugno2020;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author crist
 */
public class CellaBomba extends Cella{
    
    boolean perdita;
    
    CellaBomba () {
        super();
        perdita=false;
    }

    @Override
    public void scoprire() {
        coperta=false;
        Circle circle = new Circle (25, 25, 25);
        circle.setFill(Color.RED);
        circle.setStroke(Color.BLACK);
        this.getChildren().add(circle);
        this.removeEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Cliccata cella bomba");
        alert.setContentText("HAI PERSO :(");
        alert.showAndWait();
        perdita=true;
    }
    
    public void resettato () {
        perdita = false;
    }
    
}

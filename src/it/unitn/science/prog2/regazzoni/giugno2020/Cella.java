/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.giugno2020;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author crist
 */
public abstract class Cella extends StackPane {
    
    EventHandler<MouseEvent> mouseEvent;
    boolean coperta;
    
    Cella () {
        coperta=true;
        this.setWidth(50);
        this.setHeight(50);
        Rectangle rect = new Rectangle (50, 50);
        rect.setFill(Color.BLUE);
        rect.setStroke(Color.BLACK);
        this.getChildren().add(rect);
        mouseEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rect.setFill(Color.YELLOW);
                scoprire();
            }
        };
    }
    
    abstract public void scoprire();
    
    public void attivaCella () {
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.giugno2020;

import java.util.ArrayList;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author crist
 */
public class Griglia extends GridPane {

    int celleRimaste;
    boolean reset;

    Griglia() {
        celleRimaste = 71;
        reset = false;
        ColumnConstraints cc = new ColumnConstraints();
        cc.setPercentWidth(100. / 9);
        this.getColumnConstraints().addAll(cc, cc, cc, cc, cc, cc, cc, cc, cc);
        RowConstraints rc = new RowConstraints();
        rc.setPercentHeight(100. / 9);
        this.getRowConstraints().addAll(rc, rc, rc, rc, rc, rc, rc, rc, rc);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j) {
                    this.add(new CellaBomba(), j, i);
                } else if (i == 0 && j == 8) {
                    this.add(new CellaBomba(), j, i);
                } else {
                    if (i - j == 1 || j - i == 1) {
                        this.add(new CellaInoffensiva(2), j, i);
                    } else if (i - j == 2 || j - i == 2) {
                        this.add(new CellaInoffensiva(1), j, i);
                    } else if (i == 0 && j == 7) {
                        this.add(new CellaInoffensiva(1), j, i);
                    } else if (i == 1 && j == 8) {
                        this.add(new CellaInoffensiva(1), j, i);
                    } else if (i == 1 && j == 7) {
                        this.add(new CellaInoffensiva(1), j, i);
                    } else {
                        this.add(new CellaInoffensiva(0), j, i);
                    }
                }
            }
        }
        EventHandler<MouseEvent> mouseEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                aggiornaCelleRimaste();
            }
        };
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent);
    }

    public void attivaCelle() {
        List list = new ArrayList();
        list = this.getChildren();
        for (Object c : list) {
            ((Cella) c).attivaCella();
        }
    }

    public void aggiornaCelleRimaste() {
        celleRimaste = 71;
        List list = new ArrayList();
        list = this.getChildren();
        for (Object c : list) {
            if (((Cella) c) instanceof CellaInoffensiva) {
                if (((Cella) c).coperta == true) {
                    celleRimaste--;
                }
            } else if (((Cella) c) instanceof CellaBomba) {
                reset = true;
                ((CellaBomba) c).resettato();
            }
        }
    }
    
    public void resettato () {
        reset=false;
    }

}

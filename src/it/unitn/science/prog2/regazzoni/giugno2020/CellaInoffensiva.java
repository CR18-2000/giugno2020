/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.science.prog2.regazzoni.giugno2020;

import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 *
 * @author crist
 */
public class CellaInoffensiva extends Cella{
    
    Text t;
    
    CellaInoffensiva (int bombe) {
        super();
        t = new Text (Integer.toString(bombe));
    }

    @Override
    public void scoprire() {
        coperta=false;
        this.getChildren().add(t);
        this.removeEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent);
    }
    
}

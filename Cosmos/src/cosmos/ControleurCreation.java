/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Marie Cogis David Goncalves
 */
public class ControleurCreation implements ActionListener {
    CreationAstre window;

    public ControleurCreation(CreationAstre window) {
        this.window = window;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        int radio = window.quelRadio(ae);
        switch(radio){
            //ETOILE
            case 0 :
                window.x.setEnabled(true);
                window.y.setEnabled(true);
                window.xLabel.setEnabled(true);
                window.yLabel.setEnabled(true);
                break;
            //SATELLITE
            case 1 :
                window.x.setEnabled(false);
                window.y.setEnabled(false);
                window.xLabel.setEnabled(false);
                window.yLabel.setEnabled(false);
                break;
        }
    }
    
}

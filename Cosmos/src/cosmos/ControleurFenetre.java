/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Marie Cogis David Goncalves
 */
public class ControleurFenetre implements ActionListener {
    private Fenetre window;

    public ControleurFenetre(Fenetre window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       int btn=window.quelItem(ae);
       CreationAstre fen;
       switch(btn){
           //OUVRIR
           case 0 :
               break;
           //ENREGISTRER    
            case 1 :
               break;
            //QUITTER
            case 2 :
               break;
            //CREER ASTRE
            case 3 :
                fen = new CreationAstre(null,"Création Astre",true);
               break;
            //SUPPRIMER ASTRE
            case 4 :
               break;
            
               
                       
        }
    }
    
    
}

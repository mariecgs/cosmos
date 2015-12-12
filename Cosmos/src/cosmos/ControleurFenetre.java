/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Marie Cogis David Goncalves
 */
public class ControleurFenetre implements ActionListener {
    private Fenetre window;
    ArrayList<Etoile> listEtoile;
    
    public ControleurFenetre(Fenetre window, ArrayList<Etoile> listEtoile) {
        this.window = window;
        this.listEtoile = listEtoile;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       int btn=window.quelItem(ae);
       CreationAstre creation;
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
                creation = new CreationAstre(null,"Création Astre",true);
                Astre a=creation.ajoutAstre();
                if(a.getClass()==Etoile.class){ //Etoile
                    listEtoile.add((Etoile) a);
                }else{
                //satelitte 
                }
               break;
            //SUPPRIMER ASTRE
            case 4 :
               break;
            
               
                       
        }
    }
    
    
}

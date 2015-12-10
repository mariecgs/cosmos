/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

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
        int action = window.quelAction(ae);
        switch(action){
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
            //Image
            case 2 :
                JFileChooser chooser = new JFileChooser();//création dun nouveau filechosser
               // chooser.setApproveButtonText(); //intitulé du bouton
                //chooser.setCurrentDirectory(null);
                //chooser.showOpenDialog(null); //affiche la boite de dialogue
                String image="img/";
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){	
                    image = chooser.getSelectedFile().getPath();
                }
                System.out.println(image);
                window.imageLabel.setIcon(new ImageIcon(image));
  	        break;
            //Valider
            case 3 :
                if(window.nom.getText()==null||window.x.getText()==null||window.y.getText()==null){
                    //ERREUR
                }else{
                    window.setVisible(false);
                    //window.dispose();
                }
                break;
            //Annuler
            case 4 :

                break;
        }
       
    }
    
}

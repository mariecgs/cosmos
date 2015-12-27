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
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Marie Cogis David Goncalves
 */
class ControleurSuppression implements ActionListener{
    SuppressionAstre window;
    
    ControleurSuppression(SuppressionAstre window) {
        this.window=window;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int action = window.quelAction(ae);
        switch(action){
            //Valider
            case 0 :
                if (window.tree.getSelectionCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Vous devez choisir un astre.", "Erreur", 0);
                }else{
                    DefaultMutableTreeNode n = (DefaultMutableTreeNode)window.tree.getLastSelectedPathComponent();
                    if(n.getUserObject().getClass()==Etoile.class){ //Etoile
                        Etoile e=(Etoile) n.getUserObject();
                        if(window.liste.contains(e)){
                            window.liste.remove(e);
                        }
                    }else if(n.getUserObject().getClass()==Satellite.class){//Satellite
                        Satellite s=(Satellite) n.getUserObject();
                        s.parent.listSatellite.remove(s);
                        
                    }
                    window.dispose();
                }
                
                break;
            //Annuler
            case 1 :
                window.dispose();
                window.setVisible(false);
                break;
        }
    }
    
}

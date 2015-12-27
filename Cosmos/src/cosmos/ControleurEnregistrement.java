/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Marie Cogis David Goncalves
 */
class ControleurEnregistrement implements ActionListener{
    EnregistrementAstre window;
    
    ControleurEnregistrement(EnregistrementAstre window) {
        this.window=window;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int action = window.quelAction(ae);
        switch(action){
            //Enregistrer
            case 0 :
                if (window.tree.getSelectionCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Vous devez choisir un astre.", "Erreur", 0);
                }else{
                    JFileChooser chooser = new JFileChooser();//création dun nouveau filechosser
                    chooser.setApproveButtonText("Enregistrer"); //intitulé du bouton
                    //chooser.setCurrentDirectory(null);
                    //chooser.showOpenDialog(null); //affiche la boite de dialogue
                    String path="";
                    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){	
                        path = chooser.getSelectedFile().getPath();
                    }
                    try {
                        DefaultMutableTreeNode n = (DefaultMutableTreeNode)window.tree.getLastSelectedPathComponent();
                        Astre a=(Astre) n.getUserObject();
                        FileOutputStream fileOut =new FileOutputStream(path);
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        out.writeObject(a);
                        out.close();
                        fileOut.close();
                    }catch (IOException exception){
                        System.out.println ( "Erreur lors de la lecture : " + exception.getMessage());
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

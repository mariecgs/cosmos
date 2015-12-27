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
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

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
                window.tree.setEnabled(false);
                window.aLabel.setEnabled(false);
                window.a.setEnabled(false);
                window.bLabel.setEnabled(false);
                window.b.setEnabled(false);
                window.pLabel.setEnabled(false);
                window.p.setEnabled(false);
                break;
            //SATELLITE
            case 1 :
                window.x.setEnabled(false);
                window.y.setEnabled(false);
                window.xLabel.setEnabled(false);
                window.yLabel.setEnabled(false);
                window.tree.setEnabled(true);
                window.aLabel.setEnabled(true);
                window.a.setEnabled(true);
                window.bLabel.setEnabled(true);
                window.b.setEnabled(true);
                window.pLabel.setEnabled(true);
                window.p.setEnabled(true);
                
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
                //System.out.println(image);
                window.imageLabel.setIcon(new ImageIcon(image));
                image=image.substring(image.indexOf("img\\")+4);
                window.imagePath="img/"+image;
  	        break;
            //Valider
            case 3 :
                if (window.nom.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Vous devez choisir un nom à votre astre.", "Erreur", 0);
                }else if (window.imageLabel.getIcon() == null){
                    JOptionPane.showMessageDialog(null, "Vous devez choisir un fichier Image.", "Erreur", 0);
                }else if (window.satellite.isSelected()){
                    if (window.tree.getSelectionCount() == 0) {
                        JOptionPane.showMessageDialog(null, "Vous devez choisir un astre référent.", "Erreur", 0);
                    }else{
                        try{
                            DefaultMutableTreeNode n = (DefaultMutableTreeNode)window.tree.getLastSelectedPathComponent();
                            Astre parent = (Astre)n.getUserObject();
                            Satellite nouveau = new Satellite(window.nom.getText(), window.imagePath, Integer.parseInt(window.a.getText()), Integer.parseInt(window.b.getText()), Integer.parseInt(window.p.getText()),parent);
                            parent.listSatellite.add(nouveau);
                            window.dispose();
                        }catch (Exception ex){
                            JOptionPane.showMessageDialog(null, "Les zones de saisies doivent être des nombres." + ex.getMessage(), "Erreur", 0);
                        }
                    }
                }else{
                    try{
                        Etoile etoile = new Etoile(window.nom.getText(), window.imagePath, new Position(Integer.parseInt(window.x.getText()), Integer.parseInt(window.y.getText())));
                        window.liste.add(etoile);
                        window.dispose();
                    }catch (Exception ex){
                      JOptionPane.showMessageDialog(null, "Les zones de saisies doivent être des nombres." + ex.getMessage(), "Erreur", 0);
                    }
                }
                break;
            //Annuler
            case 4 :
                window.dispose();
                window.setVisible(false);
                break;
        }
       
    }
    
}

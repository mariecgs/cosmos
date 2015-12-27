/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.tree.DefaultMutableTreeNode;

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
       SuppressionAstre suppression;
       EnregistrementAstre enregistrement;
       //OuvrirAstre ouvrir;
       switch(btn){
           //OUVRIR
           case 0 :
                //ouvrir = new OuvrirAstre(null,"Ouvrir Astre",true,listEtoile);
                JFileChooser chooser = new JFileChooser();//création dun nouveau filechosser
                chooser.setApproveButtonText("Ouvrir"); //intitulé du bouton
                //chooser.setCurrentDirectory(null);
                //chooser.showOpenDialog(null); //affiche la boite de dialogue
                String path="";
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){	
                    path = chooser.getSelectedFile().getPath();
                }
                try {
                    FileInputStream fileIn = new FileInputStream(path);
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Astre a = (Astre) in.readObject();
                    in.close();
                    fileIn.close();
                    if(a.getClass()==Etoile.class){ //Etoile
                        Etoile e=(Etoile) a;
                        listEtoile.add(e);
                        
                    }else if(a.getClass()==Satellite.class){//Satellite
                        Satellite s=(Satellite) a;
                        s.parent.listSatellite.add(s);
                        
                    }
                    
                }catch (IOException exception){
                    System.out.println ( "Erreur lors de la lecture : " + exception.getMessage());
                } catch (ClassNotFoundException ex) {
           Logger.getLogger(ControleurFenetre.class.getName()).log(Level.SEVERE, null, ex);
       }
                break;
           //ENREGISTRER    
            case 1 :
                enregistrement = new EnregistrementAstre(null,"Enregistrement Astre",true,listEtoile);
                break;
            //QUITTER
            case 2 :
                System.exit(0);
                break;
            //CREER ASTRE
            case 3 :
                creation = new CreationAstre(null,"Création Astre",true,listEtoile);
                /*Astre a=creation.ajoutAstre();
                if(a.getClass()==Etoile.class){ //Etoile
                    listEtoile.add((Etoile) a);
                }else{
                //satelitte 
                }*/
                break;
            //SUPPRIMER ASTRE
            case 4 :
                suppression = new SuppressionAstre(null,"Suppression Astre",true,listEtoile);
                break;
            
               
                       
        }
    }
    
    
}

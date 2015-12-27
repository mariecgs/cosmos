/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmos;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Marie Cogis David Goncalves
 */
class EnregistrementAstre extends JDialog{

     JButton enregister, annuler;
    JFrame parent;
    JTree tree;
    ArrayList<Etoile> liste;
    
    public EnregistrementAstre(JFrame parent, String title, boolean modal, ArrayList<Etoile> liste) {
        super(parent, title, modal);
        this.parent=parent;
        this.setSize(305, 263);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.liste=liste;
        this.initComponent();
    }

    private void initComponent() {
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Choisir l'astre");
        Iterator<Etoile> i = liste.iterator();
        while (i.hasNext()) {
          root.add(((Etoile)i.next()).construitNoeuds());
        }
        this.tree = new JTree(root);
        this.tree.setEnabled(true);
        this.tree.setPreferredSize(new Dimension(295, 200));
        
        JPanel panSatellite= new JPanel();
        panSatellite.setBackground(Color.white);
        panSatellite.setPreferredSize(new Dimension(305, 204));
        panSatellite.setBorder(BorderFactory.createTitledBorder("Séléction de l'astre"));
        panSatellite.add(tree);
        
        //Bouton Enregister Annuler
        enregister = new JButton("Enregister");
        annuler = new JButton("Annuler");
        JPanel panButton= new JPanel();
        panButton.setBackground(Color.white);
        panButton.setPreferredSize(new Dimension(305, 30));
        panButton.add(enregister);
        panButton.add(annuler);
        //Fenetre
       // this.getContentPane().setLayout(new GridLayout(2,1));
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panSatellite,NORTH);
        this.getContentPane().add(panButton,SOUTH);
        
        ControleurEnregistrement control = new ControleurEnregistrement(this);
        enregister.addActionListener(control);
        annuler.addActionListener(control);
        this.setVisible(true);
    }

    int quelAction(ActionEvent ae) {
        if(ae.getSource().equals(enregister)){
            return 0;
        }else if(ae.getSource().equals(annuler)){
            return 1;
        }else{
            return -1;
        }
    }
    
}

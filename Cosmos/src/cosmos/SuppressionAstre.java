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
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Marie Cogis David Goncalves
 */
class SuppressionAstre extends JDialog{
    JButton valider, annuler;
    JFrame parent;
    JTree tree;
    ArrayList<Etoile> liste;
    
    public SuppressionAstre(JFrame parent, String title, boolean modal, ArrayList<Etoile> liste) {
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
        
        //Bouton Valider Annuler
        valider = new JButton("Valider");
        annuler = new JButton("Annuler");
        JPanel panButton= new JPanel();
        panButton.setBackground(Color.white);
        panButton.setPreferredSize(new Dimension(305, 30));
        panButton.add(valider);
        panButton.add(annuler);
        //Fenetre
       // this.getContentPane().setLayout(new GridLayout(2,1));
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panSatellite,NORTH);
        this.getContentPane().add(panButton,SOUTH);
        
        ControleurSuppression control = new ControleurSuppression(this);
        valider.addActionListener(control);
        annuler.addActionListener(control);
        this.setVisible(true);
    }

    int quelAction(ActionEvent ae) {
        if(ae.getSource().equals(valider)){
            return 0;
        }else if(ae.getSource().equals(annuler)){
            return 1;
        }else{
            return -1;
        }
    }
    
}

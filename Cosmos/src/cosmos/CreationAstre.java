/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTree;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Marie Cogis David Goncalves
 */
public class CreationAstre extends JDialog{
    JLabel nomLabel, xLabel, yLabel, aLabel, bLabel, pLabel,imageLabel;
    JRadioButton satellite, etoile;
    JTextField nom, x, y, a, b, p;
    JButton image, valider, annuler;
    JFrame parent;
    JTree tree;
    ArrayList<Etoile> liste;
    
    public CreationAstre(JFrame parent, String title, boolean modal,ArrayList liste){
        super(parent, title, modal);
        this.parent=parent;
        this.setSize(550, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.liste=liste;
        //this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.initComponent();
        
    }
    private void initComponent(){
        //Nom
        nom = new JTextField();
        nom.setPreferredSize(new Dimension(100,25));
        nomLabel = new JLabel("Saisir un nom :");
        nomLabel.setPreferredSize(new Dimension(100,25));
        JPanel panNom= new JPanel();
        panNom.setBackground(Color.white);
        panNom.setPreferredSize(new Dimension(220, 30));
        panNom.setBorder(BorderFactory.createTitledBorder("Nom de l'astre"));
        panNom.add(nomLabel);
        panNom.add(nom);
        
        //Type
        JPanel panType= new JPanel();
        panType.setBackground(Color.white);
        panType.setPreferredSize(new Dimension(220, 30));
        panType.setBorder(BorderFactory.createTitledBorder("Type de l'astre"));
        etoile = new JRadioButton("Etoile");
        satellite = new JRadioButton("Satellite");
        ButtonGroup bg = new ButtonGroup();
        bg.add(etoile);
        bg.add(satellite);
        panType.add(etoile);
        panType.add(satellite);
        
        //Satellite
        aLabel = new JLabel("demi-grand axe : ");
        bLabel = new JLabel("demi-petit axe : ");
        pLabel = new JLabel("periode : ");
        aLabel.setHorizontalAlignment(RIGHT);
        bLabel.setHorizontalAlignment(RIGHT);
        pLabel.setHorizontalAlignment(RIGHT);
        a = new JTextField();
        b = new JTextField();
        p = new JTextField();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Choisir l'astre référent");
        Iterator<Etoile> i = liste.iterator();
        while (i.hasNext()) {
          root.add(((Etoile)i.next()).construitNoeuds());
        }
        this.tree = new JTree(root);
        this.tree.setEnabled(false);
        this.tree.setPreferredSize(new Dimension(200, 200));
        
        JPanel panSatellite= new JPanel();
        panSatellite.setBackground(Color.white);
        panSatellite.setPreferredSize(new Dimension(445, 400));
        panSatellite.setBorder(BorderFactory.createTitledBorder("Satellite"));
        
        panSatellite.add(aLabel);
        panSatellite.add(a);
        panSatellite.add(bLabel);
        panSatellite.add(b);
        panSatellite.add(pLabel);
        panSatellite.add(p);
        panSatellite.add(tree);
        //Etoile
        xLabel = new JLabel("x : ");
        yLabel = new JLabel("y : ");
        xLabel.setHorizontalAlignment(RIGHT);
        yLabel.setHorizontalAlignment(RIGHT);
        x = new JTextField();
        y = new JTextField();
       // xLabel.setPreferredSize(new Dimension(50,25));
       // yLabel.setPreferredSize(new Dimension(50,25));
        x.setPreferredSize(new Dimension(100,25));
        y.setPreferredSize(new Dimension(100,25));
        JPanel panEtoile= new JPanel();
        panEtoile.setBackground(Color.white);
        panEtoile.setPreferredSize(new Dimension(100, 400));
        panEtoile.setBorder(BorderFactory.createTitledBorder("Etoile"));
        panEtoile.setLayout(new GridLayout(2,2));
        panEtoile.add(xLabel);
        panEtoile.add(x);
        panEtoile.add(yLabel);
        panEtoile.add(y);
        x.setEnabled(false);
        y.setEnabled(false);
        xLabel.setEnabled(false);
        yLabel.setEnabled(false);
        //Image 
        imageLabel = new JLabel(new ImageIcon());
        image = new JButton("Fichier Image");
        /*nomLabel = new JLabel("Saisir un nom :");
        nomLabel.setPreferredSize(new Dimension(100,25));*/
        JPanel panImage= new JPanel();
        panImage.setBackground(Color.white);
        panImage.setPreferredSize(new Dimension(220, 30));
        panImage.setBorder(BorderFactory.createTitledBorder("Image de l'astre"));
        panImage.add(imageLabel);
        panImage.add(image);
        
        //Bouton Valider Annuler
        valider = new JButton("Valider");
        annuler = new JButton("Annuler");
        JPanel panButton= new JPanel();
        panButton.setBackground(Color.white);
        panButton.setPreferredSize(new Dimension(220, 30));
        panButton.add(valider);
        panButton.add(annuler);
        //Fenetre
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.setPreferredSize(new Dimension(550,400));
        content.add(panEtoile, BorderLayout.WEST);
        content.add(panSatellite, BorderLayout.EAST);
        this.getContentPane().setLayout(new GridLayout(5,1));
        this.getContentPane().add(panNom);
        this.getContentPane().add(panType);
        this.getContentPane().add(content);
        this.getContentPane().add(panImage);
        this.getContentPane().add(panButton);
        
        ControleurCreation control = new ControleurCreation(this);
        etoile.addActionListener(control);
        satellite.addActionListener(control);
        image.addActionListener(control);
        valider.addActionListener(control);
        annuler.addActionListener(control);
        this.setVisible(true);
        
        
    }

    int quelAction(ActionEvent ae) {
        if(ae.getSource().equals(etoile)){
            return 0;
        }else if(ae.getSource().equals(satellite)){
            return 1;
        }else if(ae.getSource().equals(image)){
            return 2;
        }else if(ae.getSource().equals(valider)){
            return 3;
        }else if(ae.getSource().equals(annuler)){
            return 4;
        }else{
            return -1;
        }
    }

    public Astre ajoutAstre() {
        if(etoile.isSelected()){
            return new Etoile(nom.getText(),"img",new Position( Integer.parseInt(x.getText()), Integer.parseInt(y.getText()) ));
        }else if(satellite.isSelected()){
            return new Satellite("","",0,0,0);
        }else{
            return new Etoile("err","",new Position(0,0));
        }
    }
}

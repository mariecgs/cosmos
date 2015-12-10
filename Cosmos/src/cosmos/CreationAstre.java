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
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;

/**
 *
 * @author Marie Cogis David Goncalves
 */
public class CreationAstre extends JDialog{
    JLabel nomLabel, xLabel, yLabel, aLabel, bLabel, pLabel;
    JRadioButton satellite, etoile;
    JTextField nom, x, y, a, b, p;
    JButton image, valider, annuler;
    
    public CreationAstre(JFrame parent, String title, boolean modal){
        super(parent, title, modal);
        this.setSize(550, 270);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
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
        panNom.setPreferredSize(new Dimension(220, 60));
        panNom.setBorder(BorderFactory.createTitledBorder("Nom de l'astre"));
        panNom.add(nomLabel);
        panNom.add(nom);
        //Type
        JPanel panType= new JPanel();
        panType.setBackground(Color.white);
        panType.setPreferredSize(new Dimension(220, 60));
        panType.setBorder(BorderFactory.createTitledBorder("Type de l'astre"));
        etoile = new JRadioButton("Etoile");
        satellite = new JRadioButton("Satellite");
        ButtonGroup bg = new ButtonGroup();
        bg.add(etoile);
        bg.add(satellite);
        panType.add(etoile);
        panType.add(satellite);
        //Satellite
        JPanel panSatellite= new JPanel();
        panSatellite.setBackground(Color.white);
        panSatellite.setPreferredSize(new Dimension(225, 80));
        panSatellite.setBorder(BorderFactory.createTitledBorder("Satellite"));
        //panSatellite.add(nomLabel);
        //panSatellite.add(nom);
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
        panEtoile.setPreferredSize(new Dimension(225, 80));
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
        //Fenetre
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(panEtoile, BorderLayout.WEST);
        content.add(panSatellite, BorderLayout.EAST);
        this.getContentPane().add(panNom, BorderLayout.NORTH);
        this.getContentPane().add(panType, BorderLayout.CENTER);
        this.getContentPane().add(content, BorderLayout.SOUTH);
        
        ControleurCreation control = new ControleurCreation(this);
        etoile.addActionListener(control);
        satellite.addActionListener(control);
        this.setVisible(true);
        
        
    }

    int quelRadio(ActionEvent ae) {
        JRadioButton radio=(JRadioButton)ae.getSource();
        if(radio==etoile){
            return 0;
        }else if(radio==satellite){
            return 1;
        }else{
            return -1;
        }
    }
}

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
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Marie Cogis David Goncalves
 */
public class Fenetre extends JFrame {
    JPanel panneau;
    JMenuBar menuBar = new JMenuBar();
    JMenu menu1 = new JMenu("Fichier");
    JMenu menu1_2 = new JMenu("Sous ficher");
    JMenu menu2 = new JMenu("Application");
    JMenuItem ouvrir = new JMenuItem("Ouvrir");
    JMenuItem enregistrer = new JMenuItem("Enregistrer");
    JMenuItem quitter = new JMenuItem("Quitter");
    JMenuItem creer = new JMenuItem("Créer un astre");
    JMenuItem supprimer = new JMenuItem("Supprimer un astre");


    public Fenetre() throws IOException {
        
        String fond="img/cosmos.jpg";
        
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Cosmos");
        //this.setVisible(true);
        this.setLayout(new BorderLayout());
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, (int)dimension.getWidth(), (int)dimension.getHeight());
        this.panneau = new BackgroundPanel(ImageIO.read(new File(fond)));
        //this.top.setBackground(Color.yellow);
        this.panneau.setLayout(null); 
        setContentPane(this.panneau);
        this.menu1.add(this.ouvrir);
        this.menu1.add(this.enregistrer);
        this.menu1.add(this.quitter);
        this.menu2.add(this.creer);
        this.menu2.add(this.supprimer);
        this.menuBar.add(this.menu1);
        this.menuBar.add(this.menu2);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
        ControleurFenetre control=new ControleurFenetre(this);
        ouvrir.addActionListener(control);
        enregistrer.addActionListener(control);
        quitter.addActionListener(control);
        creer.addActionListener(control);
        supprimer.addActionListener(control);
        this.setVisible(true);      

        
    }

    int quelItem(ActionEvent ae) {
        JMenuItem item=(JMenuItem)ae.getSource();
        if(item==ouvrir){
            return 0;
        }else if(item==enregistrer){
            return 1;
        }else if(item==quitter){
            return 2;
        }else if(item==creer){
            return 3;
        }else if(item==supprimer){
            return 4;
        }else {
            return -1;
        }
    }
   
}

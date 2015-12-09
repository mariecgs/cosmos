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
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Marie Cogis David Goncalves
 */
public class Fenetre extends JFrame {
    JPanel top;
    JLabel menu;

    public Fenetre() throws IOException {
        //this.setContentPane(new JPanel((LayoutManager) new ImageIcon("fond.png").getImage()));
        add(new JButton("Bouton1"));
        add(new JButton("Bouton2"));
        String fond="img/cosmos.jpg";
        
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Cosmos");
        //this.setVisible(true);
        this.setLayout(new BorderLayout());
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, (int)dimension.getWidth(), (int)dimension.getHeight());
        this.top = new BackgroundPanel(ImageIO.read(new File(fond)));
        //this.top.setBackground(Color.yellow);
        this.top.setLayout(null); 
        setContentPane(this.top);
        this.setVisible(true);
        
    }
 
}

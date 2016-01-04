/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmos;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Marie Cogis David Goncalves
 */
public class BackgroundPanel extends JPanel {
    private Image image;
    private int height;
    private int width;
    ArrayList<Etoile> listEtoile;
  
    /**
     *
     * @param Image image
     * @param int width
     * @param int height
     * @param ArrayList listEtoile
     */
    public BackgroundPanel(Image image,int width,int height,ArrayList listEtoile){
        this.image = image;
        this.height = height;
        this.width = width;
        this.listEtoile = listEtoile;
        setLayout(new BorderLayout());
        repaint();
    }
  
    /**
     *
     * @param JComponent component
     */
    public void add(JComponent component){
        add(component, null);
    }

    
    /**
     *
     * @param Graphics g
     */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if (this.image == null) {
          return;
        }
        g.drawImage(image, 0, 0, width, height, this);
        for(Etoile e : listEtoile){
            e.draw(this,g);
        }
    }
}
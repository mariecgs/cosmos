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
import java.util.Date;
import javax.swing.ImageIcon;
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
     * @param image
     * @param width
     * @param height
     * @param listEtoile
     */
    public BackgroundPanel(Image image,int width,int height,ArrayList listEtoile){
    this.image = image;
    this.height = height;
    this.width = width;
    this.listEtoile = listEtoile;
    setLayout(new BorderLayout());
    repaint();
  }
  
  public void add(JComponent component){
    add(component, null);
  }
  
  @Override
  protected void paintComponent(Graphics g){
    super.paintComponent(g);
    if (this.image == null) {
      return;
    }
    g.drawImage(image, 0, 0, width, height, this);
    
    
    for(Etoile e : listEtoile){
        ImageIcon img=new ImageIcon(e.image);
        img.paintIcon(this, g, e.pos.x-(img.getIconWidth()/2), e.pos.y-(img.getIconHeight()/2));
        for(Satellite s : e.listSatelitte){
            img=new ImageIcon(s.image);
            img.paintIcon(this, g, s.getPosition(e).x-(img.getIconWidth()/2), s.getPosition(e).y-(img.getIconHeight()/2));
        }
    }
  }
}
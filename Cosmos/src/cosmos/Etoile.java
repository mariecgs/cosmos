/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmos;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Marie Cogis David Goncalves
 */
public class Etoile extends Astre {
    Position pos;
    
    public Etoile(String nom, String image, Position pos) {
        super(nom,image);
        this.pos=pos;
    }
    
    @Override
    protected Position getPosition(Astre a){
        return this.pos;
    }

    void draw(BackgroundPanel b,Graphics g) {
        System.out.println("Etoile -> "+this+"  "+this.image);
        ImageIcon img=new ImageIcon(this.image);
        img.paintIcon(b, g, this.pos.x-(img.getIconWidth()/2), this.pos.y-(img.getIconHeight()/2));
        if(listSatellite!=null&& !listSatellite.isEmpty()){
            for(Satellite s : this.listSatellite){
                s.draw(b,g,this);
            }  
        }
    }
}

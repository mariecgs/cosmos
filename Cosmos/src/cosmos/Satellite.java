/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmos;

import java.awt.Graphics;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author Marie Cogis David Goncalves
 */
public class Satellite extends Astre {
    int grandAxe;
    int petitAxe;
    int periodeRotation;
    Astre parent;

    public Satellite(String nom,String image,int grandAxe,int petitAxe,int periodeRotation,Astre parent) { 
        super(nom,image);
        this.grandAxe = grandAxe;
        this.petitAxe = petitAxe;
        this.periodeRotation = periodeRotation;
        this.parent=parent;
    }
    
    /**
     *
     * @param a
     * @return
     */
    @Override
    protected Position getPosition(){
        Position posParent=parent.getPosition();
        
        Position posSatellite = new Position();
        posSatellite.x=(int) ((grandAxe/2) * Math.cos((System.currentTimeMillis() * 3.14 )/periodeRotation) + posParent.x);
        posSatellite.y=(int) ((petitAxe/2) * Math.sin((System.currentTimeMillis() * 3.14 )/periodeRotation) + posParent.y);
        //System.out.println("t : "+System.currentTimeMillis()+" || x = "+posSatellite.x+" || y = "+posSatellite.y);
        return posSatellite;
    }
    
    void draw(BackgroundPanel b, Graphics g, Astre e) {
        ImageIcon img;
        img=new ImageIcon(this.image);
        img.paintIcon(b, g, this.getPosition().x-(img.getIconWidth()/2), this.getPosition().y-(img.getIconHeight()/2));
        if(listSatellite!=null&& !listSatellite.isEmpty()){
            for(Satellite s : this.listSatellite){
                s.draw(b,g,this);
            }  
        }
    }
}
